package parkingLot.strategies;

import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(ParkingLot parkingLot,Vehicle vehicle);


}
