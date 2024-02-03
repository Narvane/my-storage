package com.narvane.model.interfaces;

import com.narvane.model.Food;

public interface Portion extends Model {

    Food getFood();

    Integer getAmount();

}
