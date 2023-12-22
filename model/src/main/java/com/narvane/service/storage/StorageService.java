package com.narvane.service.storage;

import com.narvane.model.Movement;

public interface StorageService {

    void newInput(Movement movement);

    void newOutput(Movement movement);

}
