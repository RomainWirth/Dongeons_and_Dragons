package fr.campus.dungeon.equipments.defense.shields;

public class NordicShield extends Shield {
    public NordicShield(){super(3);}

    @Override
    public String toString() {
        return "Nordic Shield {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
