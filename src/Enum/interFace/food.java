package Enum.interFace;

public interface food {
    void eat();

    enum Appetizer implements food {
        SALAD, SOUP, SPRING_ROLLS;

        @Override
        public void eat() {
            System.out.println("appetize-eat");
        }
    }
    enum MainCourse implements food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO;

        @Override
        public void eat() {
            System.out.println("maincourse-eat");
        }
    }
    enum Dessert implements food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;

        @Override
        public void eat() {
            System.out.println("dessert-eat");
        }
    }
    enum Coffee implements food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;

        @Override
        public void eat() {
            System.out.println("coffee-eat");
        }
    }
}
