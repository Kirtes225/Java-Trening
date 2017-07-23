package com.company;

public enum StudentType {
    STATIONARY {
        @Override
        public String toString() {
            return "STATIONARY";
        }
    },
    NONSTATIONARY {
        @Override
        public String toString() {
            return "NONSTATIONARY";
        }
    },
    POSTGRADUATE {
        @Override
        public String toString() {
            return "POSTGRADUATE";
        }
    }
}
