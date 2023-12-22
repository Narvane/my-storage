package com.narvane.service.storage;

import com.narvane.model.Movement;
import com.narvane.model.Storage;
import com.narvane.repository.StorageRepository;

public class StorageServiceImpl implements StorageService {

    private StorageRepository repository;

    @Override
    public void newInput(Movement movement) {
        Storage storage = repository.find();
        storage.input(movement);
        repository.save(storage);
    }

    @Override
    public void newOutput(Movement movement) {
        Storage storage = repository.find();
        storage.output(movement);
        repository.save(storage);
    }

}
