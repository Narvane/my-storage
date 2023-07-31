package com.narvane.infra.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MealEntity implements AbstractEntity<UUID> {

    @Id
    private UUID id;

    private String name;

    public MealEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
