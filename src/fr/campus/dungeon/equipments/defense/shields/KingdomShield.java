package fr.campus.dungeon.equipments.defense.shields;

public class KingdomShield extends Shield{
    public KingdomShield(){super(5);}

    @Override
    public String toString() {
        return "KingdomShield {\n" +
                " defenseLevel = " + defenseLevel +
                '}';
    }
}
