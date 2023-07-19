package fr.campus.dungeon.equipments.defense.shields;

public class DragonScaleShield extends Shield {
    public DragonScaleShield(){super(15);}

    @Override
    public String toString() {
        return "Dragon Scale Shield {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
