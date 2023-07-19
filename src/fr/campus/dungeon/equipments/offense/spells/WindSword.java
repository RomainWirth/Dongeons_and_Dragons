package fr.campus.dungeon.equipments.offense.spells;

public class WindSword extends Spell {
    public WindSword(){super(15);}

    @Override
    public String toString() {
        return "WindSword {\n" +
                " attackLevel = " + attackLevel +
                '}';
    }
}
