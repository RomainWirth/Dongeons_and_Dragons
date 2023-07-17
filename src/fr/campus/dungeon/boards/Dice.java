package fr.campus.dungeon.boards;

import java.util.Random;

public class Dice {
//    private final int maxValue = 6;
//    private int faceValue;
//
//    public Dice() {
//        this.faceValue = 1;
//    }
//
//    public Dice(int value) {
//        this.faceValue = value;
//    }

    public static int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
//        return faceValue;
    }

//    public int getFaceValue() {
//        return faceValue;
//    }
//
//    public void setFaceValue(int faceValue) {
//        this.faceValue = faceValue;
//    }

//    @Override
//    public String toString() {
//        return "roll dice value = " + faceValue;
//    }
}
