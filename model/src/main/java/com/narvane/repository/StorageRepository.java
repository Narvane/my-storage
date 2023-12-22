package com.narvane.repository;

import com.narvane.model.Storage;

public interface StorageRepository {

    Storage find();

    Storage save(Storage storage);

}
