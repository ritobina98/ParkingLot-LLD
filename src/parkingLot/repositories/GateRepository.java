package parkingLot.repositories;

import parkingLot.models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    private HashMap<Long, Gate> gates = new HashMap<>();

    public Optional<Gate> findByGateId(Long id){
        return Optional.of(gates.get(id));
    }
}
