CREATE TABLE food_entity
(
    id      UUID     NOT NULL,
    name    VARCHAR(255) NULL,
    protein INT          NULL,
    carbs   INT          NULL,
    fat     INT          NULL,
    CONSTRAINT pk_food_entity PRIMARY KEY (id)
);

CREATE TABLE meal_entity
(
    id   UUID NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_meal_entity PRIMARY KEY (id)
);

ALTER TABLE food_entity
    ADD COLUMN meal_id UUID,
    ADD CONSTRAINT fk_meal_entity
        FOREIGN KEY (meal_id) REFERENCES meal_entity(id);