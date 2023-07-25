package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.NoDefenseEquipment;
import fr.campus.dungeon.equipments.offense.NoAttackEquipment;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Villain {
    public Dragon(String name) {
        super(name);
    }

    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(List.of(
                new NoAttackEquipment()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of(
                new NoDefenseEquipment()
        ));
        super.defineDefenseEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 20;
    }
    public void defineMinStrength() {
        this.minStrength = 5;
    }
    public void defineMaxStrength() {
        this.maxStrength = 15;
    }
    public void defineMinStamina() {
        this.minStamina = 12;
    }
    public void defineMaxStamina() {
        this.maxStamina = 20;
    }
}
