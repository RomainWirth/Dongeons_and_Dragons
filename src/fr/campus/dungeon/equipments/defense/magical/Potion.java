package fr.campus.dungeon.equipments.defense.magical;

import fr.campus.dungeon.equipments.defense.DefenseEquipment;

public abstract class Potion extends DefenseEquipment {
    public Potion(int defenseLevel){super(defenseLevel);}

    @Override
    public String toString() {
        return "Potion {\n" +
                " defenseLevel = " + defenseLevel +
                '}';
    }
}
