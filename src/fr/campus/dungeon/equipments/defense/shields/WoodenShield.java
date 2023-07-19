package fr.campus.dungeon.equipments.defense.shields;

public class WoodenShield extends Shield {
    public WoodenShield() {super(1);}

    @Override
    public String toString() {
        return "WoodenShield {\n" +
                " defenseLevel = " + defenseLevel +
                '}';
    }
}
