package com.github.Dawud354.YoKaiCode;

public class PhysicalMove extends Move {
    public PhysicalMove(String name,String description, int power, int accuracy) {
        super(name,description, power, accuracy, MoveCategory.PHYSICAL);
    }
}
