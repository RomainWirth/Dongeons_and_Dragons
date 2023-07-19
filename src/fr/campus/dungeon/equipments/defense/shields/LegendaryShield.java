package fr.campus.dungeon.equipments.defense.shields;

public class LegendaryShield extends Shield {
    public LegendaryShield(){super(10);}

    @Override
    public String toString() {
        return "LegendaryShield {\n" +
                " defenseLevel = " + defenseLevel +
                '}';
    }
}
