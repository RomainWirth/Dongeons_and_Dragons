package fr.campus.dungeon.equipments.offense.weapons;

public class Mace extends Weapon {
    public Mace(){super(3);}

    @Override
    public String toString() {
        return "Mace {\n" +
                " attackLevel = " + attackLevel +
                '}';
    }
}
