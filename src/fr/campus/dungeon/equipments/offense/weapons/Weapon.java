package fr.campus.dungeon.equipments.offense.weapons;

import fr.campus.dungeon.equipments.offense.AttackEquipment;

public abstract class Weapon extends AttackEquipment {
    public Weapon(int attackLevel) {super(attackLevel);}

    @Override
    public String toString() {
        return "Weapon {\n" +
                " attackLevel = " + attackLevel +
                '}';
    }
}
