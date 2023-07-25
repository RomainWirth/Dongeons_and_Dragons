package fr.campus.dungeon.characters.villains;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Villain {
    public Dragon(String name) {
        super(name);
    }

    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(List.of());
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of());
        super.defineDefenseEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 50;
    }
    public void defineStrength() {
        this.strength = 6;
    }
}
