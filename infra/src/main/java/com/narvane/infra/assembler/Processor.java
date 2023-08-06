package com.narvane.infra.assembler;

import java.util.function.UnaryOperator;

public interface Processor {

    void doLogic();

    Responser doLogic(Long a);

}
