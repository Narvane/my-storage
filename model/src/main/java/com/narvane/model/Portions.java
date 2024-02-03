package com.narvane.model;

import com.narvane.model.interfaces.Model;
import com.narvane.model.interfaces.Portion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class Portions implements Model {

    private final Map<Food, Integer> portions;

    public Portions(Map<Food, Integer> portions) {
        this.portions = portions;
    }

    public Portions() {
        this.portions = new HashMap<>();
    }

    public FoodEntry of(Food foodReference) {
        return new FoodEntry() {
            @Override
            public void increase(Integer increasedAmount) {
                portions.computeIfPresent(foodReference, (food, amount) -> amount + increasedAmount);
            }

            @Override
            public void decrease(Integer decreasedAmount) {
                portions.computeIfPresent(foodReference, (food, amount) -> amount - decreasedAmount);
            }

            @Override
            public Integer update(Integer updatedAmount) {
                portions.put(foodReference, updatedAmount);
                return portions.get(foodReference);
            }

            @Override
            public boolean exist() {
                return portions.containsKey(foodReference);
            }

            @Override
            public void remove() {
                portions.remove(foodReference);
            }

        };
    }

    public void newOf(Food food) {
        this.portions.put(food, 0);
    }

    public boolean isEmpty() {
        return portions.isEmpty();
    }

    public Set<Food> getFoodSet() {
        return portions.keySet();
    }

    public Integer getTotalProtein() {
        return sumNutrientsBy(Food::getProtein);
    }

    public Integer getTotalCarbs() {
        return sumNutrientsBy(Food::getCarbs);
    }

    public Integer getTotalFat() {
        return sumNutrientsBy(Food::getFat);
    }

    public Stream<Portion> stream() {
        return portions.entrySet().stream().map(entry -> new Portion() {
            @Override
            public Food getFood() {
                return entry.getKey();
            }

            @Override
            public Integer getAmount() {
                return entry.getValue();
            }
        });
    }

    private Integer sumNutrientsBy(Function<Food, Integer> macroSupplier) {
        return portions.entrySet().stream()
                .mapToInt(entry -> {
                    Food food = entry.getKey();
                    int quantity = entry.getValue();
                    Integer macroNutrient = macroSupplier.apply(food);
                    return (macroNutrient != null) ? macroNutrient * quantity : 0;
                })
                .sum();
    }

    protected interface FoodEntry {

        void increase(Integer increasedAmount);

        void decrease(Integer decreasedAmount);

        Integer update(Integer updatedAmount);

        boolean exist();

        void remove();

    }

}
