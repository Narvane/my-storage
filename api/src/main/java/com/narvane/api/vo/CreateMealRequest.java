package com.narvane.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class CreateMealRequest implements VO {

    private String uuid;
    private String name;
    private List<Food> foods;

    @Data
    public static class Food {

        private String uuid;
        private String name;

        private Integer protein;
        private Integer carbs;
        private Integer fat;

    }

}
