package fr.campus.dungeon.equipments.offense.weapons;

public class Axe extends Weapon{
    public Axe(){super(7);}

    @Override
    public String toString() {
        return "Axe {\n" +
                " attack level = " + attackLevel +
                '}';
    }
}
