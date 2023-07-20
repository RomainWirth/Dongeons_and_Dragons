package fr.campus.dungeon.equipments.offense;

import fr.campus.dungeon.equipments.Equipment;

public abstract class AttackEquipment extends Equipment {
//    protected int attackLevel;

    // constructeur 
    public AttackEquipment(int attackLevel) {
        super(attackLevel);
    }

//    public int getAttackLevel() {
//        return attackLevel;
//    }
//
//    public void setAttackLevel(int attackLevel) {
//        this.attackLevel = attackLevel;
//    }
//
//    @Override
//    public String toString() {
//        return this.getClass().getSimpleName() + " {\n" +
//                " attack level = " + attackLevel +
//                '}';
//    }
}
