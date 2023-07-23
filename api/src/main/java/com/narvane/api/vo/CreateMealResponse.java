package com.narvane.api.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateMealResponse implements VO {

    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fat;
    private List<Food> foods;

    @Data
    public static class Food {

        private String name;

        private Integer protein;
        private Integer carbs;
        private Integer fat;

    }

}
