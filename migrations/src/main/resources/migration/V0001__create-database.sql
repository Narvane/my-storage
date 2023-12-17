CREATE TABLE FOOD
(
    id      UUID     NOT NULL,
    name    VARCHAR(255) NULL,
    protein INT          NULL,
    carbs   INT          NULL,
    fat     INT          NULL,
    CONSTRAINT pk_food_entity PRIMARY KEY (id)
);

CREATE TABLE MEAL
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_meal_entity PRIMARY KEY (id)
);

CREATE TABLE MEAL_FOODS
(
    id      UUID     NOT NULL,
    meal_id UUID     NOT NULL,
    food_id UUID     NOT NULL
);

ALTER TABLE MEAL_FOODS
    ADD CONSTRAINT fk_meal
        FOREIGN KEY (meal_id) REFERENCES MEAL(id),
    ADD CONSTRAINT fk_food
        FOREIGN KEY (food_id) REFERENCES FOOD(id);