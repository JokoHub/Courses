package com.joko.tests;

/**
 * Created by User on 16.08.2016.
 */

    class Meal {
        Meal() { System.out.println("com.joko.tests.Meal()"); }
    }

    class Bread {
        Bread() { System.out.println("com.joko.tests.Bread()"); }
    }

    class Cheese {
        Cheese() { System.out.println("com.joko.tests.Cheese()"); }
    }

    class Lettuce {
        Lettuce() { System.out.println("com.joko.tests.Lettuce()"); }
    }

    class Lunch extends Meal {
        Lunch() { System.out.println("com.joko.tests.Lunch()"); }
    }

    class PortableLunch extends Lunch {
        PortableLunch() { System.out.println("com.joko.tests.PortableLunch()");}
    }

    public class Sandwich extends PortableLunch {
        private Bread b = new Bread();
        private Cheese c = new Cheese();
        private Lettuce l = new Lettuce();
        public Sandwich() { System.out.println("com.joko.tests.Sandwich()"); }
        public static void main(String[] args) {
            new Sandwich();
        }
    }

