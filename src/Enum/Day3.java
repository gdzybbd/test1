package Enum;

import Enum.interFace.food;
import Enum.interFace.sport;

public enum Day3 implements food, sport {
    FOOD,
    SPORT;

    @Override
    public void eat() {
        System.out.println("day3-eat");
    }

    @Override
    public void run() {
        System.out.println("day3-sport");
    }
}
