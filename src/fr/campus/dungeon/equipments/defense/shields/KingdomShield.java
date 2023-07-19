package fr.campus.dungeon.equipments.defense.shields;

public class KingdomShield extends Shield{
    public KingdomShield(){super(5);}

    @Override
    public String toString() {
        return "Kingdom Shield {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
