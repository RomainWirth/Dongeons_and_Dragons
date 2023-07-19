package fr.campus.dungeon.equipments.offense.spells;

import fr.campus.dungeon.equipments.offense.AttackEquipment;

public abstract class Spell extends AttackEquipment {
    public Spell(int attackLevel){super(attackLevel);}

    @Override
    public String toString() {
        return "Spell {\n" +
                " attack level = " + attackLevel +
                '}';
    }
}
