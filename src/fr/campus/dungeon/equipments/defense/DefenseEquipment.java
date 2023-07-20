package fr.campus.dungeon.equipments.defense;

import fr.campus.dungeon.equipments.Equipment;

public abstract class DefenseEquipment extends Equipment{
//    protected int defenseLevel;

    public DefenseEquipment(int defenseLevel) {
        super(defenseLevel);
    }

//    public int getDefenseLevel() {
//        return defenseLevel;
//    }
//
//    public void setDefenseLevel(int defenseLevel) {
//        this.defenseLevel = defenseLevel;
//    }
//
//    @Override
//    public String toString() {
//        return this.getClass().getSimpleName() + " {\n" +
//                " defense level = " + defenseLevel +
//                '}';
//    }
}
