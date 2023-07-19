package fr.campus.dungeon.equipments.offense.spells;

public class FireBall extends Spell {
    public FireBall(){super(7);}

    @Override
    public String toString() {
        return "FireBall {\n" +
                " attackLevel = " + attackLevel +
                '}';
    }
}
