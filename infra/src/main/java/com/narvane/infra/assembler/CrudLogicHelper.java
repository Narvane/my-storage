package com.narvane.infra.assembler;

import com.narvane.model.Model;
import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;

import java.util.function.UnaryOperator;

public interface CrudLogicHelper {

    Processor convertToEntity(UnaryOperator<Flux<CorePublisher<Model>>> conversores);

    Ziper convertToEntities();

    Responser doLogic(Processor processor);

    void doLogic();


}
