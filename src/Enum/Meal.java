package Enum;

import Enum.interFace.food;

enum Meal {
    COFFEE(food.Coffee.class),
    APPETIZER(food.Appetizer.class),
    MAINCOURSE(food.MainCourse.class),
    DESSERT(food.Dessert.class);

    food[] valuse;

    Meal(Class<? extends food> kind) {
        valuse=kind.getEnumConstants();
    }

    public food[] getValuse() {
        return valuse;
    }
}
