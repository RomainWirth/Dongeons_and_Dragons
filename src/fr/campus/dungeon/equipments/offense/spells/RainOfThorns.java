package fr.campus.dungeon.equipments.offense.spells;

public class RainOfThorns extends Spell {
    public RainOfThorns(){super(1);}

    @Override
    public String toString() {
        return "RainOfThorns {\n" +
                " attackLevel = " + attackLevel +
                '}';
    }
}
