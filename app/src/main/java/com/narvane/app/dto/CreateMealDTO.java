package com.narvane.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public abstract class CreateMealDTO {

    @Data
    public static class Request implements DTO {

        @NotEmpty(message = "meal.name.must.not.be.empty")
        private String name;

        @Valid
        @NotNull(message = "meal.foods.must.not.be.null")
        @NotEmpty(message = "meal.must.contain.at.least.one.food")
        private List<Portion> portions;

        @Data
        public static class Portion {

            private Food food;
            private Integer amount;

        }

        @Data
        public static class Food {

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
        private List<Portion> portions;

        @Data
        public static class Portion {

            private Food food;
            private Integer amount;

        }

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
