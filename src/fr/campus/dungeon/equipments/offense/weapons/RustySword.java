package fr.campus.dungeon.equipments.offense.weapons;

public class RustySword extends Weapon{
    public RustySword(){super(2);}

    @Override
    public String toString() {
        return "Rusty Sword {\n" +
                " attack level = " + attackLevel +
                '}';
    }
}
