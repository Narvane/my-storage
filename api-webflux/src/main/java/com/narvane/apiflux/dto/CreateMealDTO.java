package com.narvane.apiflux.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

public abstract class CreateMealDTO {

    @Data
    public static class Request implements DTO {

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

    @Data
    @Builder
    public static class Response implements DTO {

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

}
