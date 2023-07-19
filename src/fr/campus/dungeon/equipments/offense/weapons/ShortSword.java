package fr.campus.dungeon.equipments.offense.weapons;

public class ShortSword extends Weapon {
    public ShortSword () {
        super(5);
    }

    @Override
    public String toString() {
        return "Short Sword {\n" +
                " attack level = " + attackLevel +
                '}';
    }
}
