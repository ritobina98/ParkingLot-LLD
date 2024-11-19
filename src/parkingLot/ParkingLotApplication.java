package parkingLot;

import parkingLot.controllers.TicketController;
import parkingLot.dtos.IssueTicketRequestDto;
import parkingLot.dtos.IssueTicketResponseDto;
import parkingLot.factories.ParkingSpotAssignmentFactory;
import parkingLot.models.ParkingSpotStrategyType;
import parkingLot.models.Ticket;
import parkingLot.repositories.GateRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.services.TicketService;
import parkingLot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy
                = ParkingSpotAssignmentFactory.getParkingLotStrategy(ParkingSpotStrategyType.NEAREST);
        TicketService ticketService = new TicketService(gateRepository,vehicleRepository,parkingSpotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setOperatorId(345L);
        requestDto.setOwnerName("Ritobina");
        requestDto.setVehicleNumber("WB01B1212");

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        Ticket ticket = responseDto.getTicket();
    }
}
