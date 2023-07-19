package fr.campus.dungeon.equipments.defense.shields;

import fr.campus.dungeon.equipments.defense.DefenseEquipment;

public abstract class Shield extends DefenseEquipment {
    public Shield(int defenseLevel) {super(defenseLevel);}

    @Override
    public String toString() {
        return "Shield {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
