package parkingLot.services;

import parkingLot.exceptions.GateNotFoundException;
import parkingLot.models.Gate;
import parkingLot.models.ParkingLot;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.repositories.GateRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.strategies.ParkingSpotAssignmentStrategy;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }
    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              Long gateId,
                              Long operatorId) throws GateNotFoundException {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        //Get the gate object
        Optional<Gate> optionalGate = gateRepository.findByGateId(gateId);

        if(optionalGate.isEmpty()){
            throw new GateNotFoundException("Invalid gate id passed");
        }
        Gate gate = optionalGate.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle = null;

        if(optionalVehicle.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle = vehicleRepository.save(vehicle);
        } else{
            vehicle = optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);

        ParkingLot parkingLot = gate.getParkingLot();
        ticket.setParkingSpot(parkingSpotAssignmentStrategy.assignParkingSpot(parkingLot,vehicle));

        return ticket;
    }
}
