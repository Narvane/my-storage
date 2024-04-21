package com.narvane.app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public abstract class UpdateMealDTO {

    @Data
    public static class Request implements DTO {

        @NotNull
        private String id;

        private String name;
        private List<Food> foods;

        @Data
        public static class Food {

            @NotNull
            private String id;
            private String name;

            private Integer protein;
            private Integer carbs;
            private Integer fat;

        }

    }

    @Data
    @Builder
    public static class Response implements DTO {

        private String id;

        private String name;
        private Integer protein;
        private Integer carbs;
        private Integer fat;
        private List<Food> foods;

        @Data
        public static class Food {

            private String id;

            private String name;

            private Integer protein;
            private Integer carbs;
            private Integer fat;

        }

    }

}
