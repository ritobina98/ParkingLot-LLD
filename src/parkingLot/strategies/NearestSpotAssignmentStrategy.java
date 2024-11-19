package parkingLot.strategies;

import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Vehicle;

public class NearestSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy{
    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
