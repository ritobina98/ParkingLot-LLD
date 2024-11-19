package parkingLot.factories;

import parkingLot.models.ParkingSpotStrategyType;
import parkingLot.strategies.NearestSpotAssignmentStrategy;
import parkingLot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingSpotAssignmentFactory {
    public static ParkingSpotAssignmentStrategy getParkingLotStrategy(ParkingSpotStrategyType parkingSpotStrategyType){
        if(parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)){
            return new NearestSpotAssignmentStrategy();
        }
        return null;
    }
}
