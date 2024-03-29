package com.narvane.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    // TODO Redo after infra
    /*@Test
    public void should_count_macros() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        Food bread = new Food(UUID.randomUUID(), "Bread", 5, 20, 12);
        Food lettuce = new Food(UUID.randomUUID(), "Lettuce", 0, 10, 0);
        Food tomato = new Food(UUID.randomUUID(), "Tomato", 0, 20, 0);
        Food steak = new Food(UUID.randomUUID(), "Meat", 25, 0, 10);

        meal.addFoods(bread, lettuce, tomato, steak);

        assertEquals(30, meal.getProtein());
        assertEquals(50, meal.getCarbs());
        assertEquals(22, meal.getFat());
    }

    @Test
    public void should_return_null_if_no_macros_declared() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        assertNull(meal.getProtein());
        assertNull(meal.getCarbs());
        assertNull(meal.getFat());
    }

    @Test
    public void should_discard_null_values() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        Food bread = new Food(UUID.randomUUID(), "Bread", 0, null, null);
        Food lettuce = new Food(UUID.randomUUID(), "Lettuce", null, 0, null);
        Food tomato = new Food(UUID.randomUUID(), "Tomato", null, null, null);
        Food steak = new Food(UUID.randomUUID(), "Meat", null, null, 0);

        meal.addFoods(bread, lettuce, tomato, steak);

        assertEquals(0, meal.getProtein());
        assertEquals(0, meal.getCarbs());
        assertEquals(0, meal.getFat());
    }

    @Test
    public void should_not_add_empty_food() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        meal.addPortion(null);

        assertEquals(0, meal.getPortions().size());
    }

    @Test
    public void should_not_have_an_issue_with_empty_or_partially_empty_food_lists() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        meal.addFoods((Set<Food>) null);
        assertEquals(0, meal.getPortions().size());

        meal.addFoods(null, null);
        assertEquals(0, meal.getPortions().size());

        meal.addFoods(null, new Food("Steak"));
        assertEquals(1, meal.getPortions().size());

        meal.addFoods(null, new Food("Tomato"));
        assertEquals(2, meal.getPortions().size());
    }

    @Test
    public void should_remove_food_by_its_object() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        Food bread = new Food(UUID.randomUUID(), "Bread", 5, 20, 12);
        Food lettuce = new Food(UUID.randomUUID(), "Lettuce", 0, 10, 0);
        Food tomato = new Food(UUID.randomUUID(), "Tomato", 0, 20, 0);
        Food steak = new Food(UUID.randomUUID(), "Meat", 25, 0, 10);

        meal.addFoods(bread, lettuce, tomato, steak);

        meal.removeFood(lettuce);

        assertIterableEquals(meal.getPortions(), Arrays.asList(bread, tomato, steak));
        assertEquals(3, meal.getPortions().size());
    }

    @Test
    public void should_do_nothing_when_remove_not_existent_food() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        Food bread = new Food(UUID.randomUUID(), "Bread", 5, 20, 12);
        Food lettuce = new Food(UUID.randomUUID(), "Lettuce", 0, 10, 0);
        Food tomato = new Food(UUID.randomUUID(), "Tomato", 0, 20, 0);
        Food steak = new Food(UUID.randomUUID(), "Meat", 25, 0, 10);

        meal.addFoods(bread, lettuce, steak);

        meal.removeFood(tomato);

        assertIterableEquals(meal.getPortions(), Arrays.asList(bread, lettuce, steak));
        assertEquals(3, meal.getPortions().size());
    }

    @Test
    public void should_remove_food_if_given_a_new_instance_with_same_id() {
        Meal meal = new Meal(UUID.randomUUID(), "Hamburger");

        UUID meatId = UUID.randomUUID();

        Food bread = new Food(UUID.randomUUID(), "Bread", 5, 20, 12);
        Food steak = new Food(meatId, "Meat", 25, 0, 10);

        meal.addFoods(bread, steak);

        meal.removeFood(new Food(meatId));

        assertIterableEquals(meal.getPortions(), List.of(bread));
        assertEquals(1, meal.getPortions().size());
    }*/

}