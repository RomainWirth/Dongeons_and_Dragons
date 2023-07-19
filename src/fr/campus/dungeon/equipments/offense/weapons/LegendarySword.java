package fr.campus.dungeon.equipments.offense.weapons;

public class LegendarySword extends Weapon {
    public LegendarySword() {super(10);}

    @Override
    public String toString() {
        return "Legendary Sword {\n" +
                " attack level = " + attackLevel +
                '}';
    }
}
