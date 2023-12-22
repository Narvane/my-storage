package com.narvane.model;

import java.util.Map;

record History<MT extends MovementType>(Map<MovementType, Movement> movements) {

    void registerMovement(MT movementType, Movement movement) {
        movements.put(movementType, movement);
    }

}