package com.company;

public enum ProductType {
    FIGHTER{
        @Override
        public String toString() {
            return "FIGHTER";
        }
    },
    ATTACKER{
        @Override
        public String toString() {
            return "ATTACKER";
        }
    },
    BOMBER{
        @Override
        public String toString() {
            return "BOMBER";
        }
    }

    /*
    FIGHTER("FIGHTER");
    ATTACKER("ATTACKER");
    BOMBER("BOMBER");

    private String label;

    MyType(String label) {
        this.label = label;
    }
    public String toString() {
        return label;
    }
    */
}
