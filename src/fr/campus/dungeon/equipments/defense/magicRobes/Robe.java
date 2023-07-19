package fr.campus.dungeon.equipments.defense.magicRobes;

import fr.campus.dungeon.equipments.defense.DefenseEquipment;

public abstract class Robe extends DefenseEquipment {
    public Robe(int defenseLevel){super(defenseLevel);}

    @Override
    public String toString() {
        return "Robe {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
