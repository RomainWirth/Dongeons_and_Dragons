package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.shields.WoodenShield;
import fr.campus.dungeon.equipments.offense.weapons.RustySword;

import java.util.ArrayList;
import java.util.List;

public class Skaven extends Villain {
    public Skaven(String name) {
        super(name);
    }
    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(List.of(
                new RustySword()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of(
                new WoodenShield()
        ));
        super.defineDefenseEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 6;
    }
    public void defineMinStrength() {
        this.minStrength = 5;
    }
    public void defineMaxStrength() {
        this.maxStrength = 10;
    }
    public void defineMinStamina() {
        this.minStamina = 3;
    }
    public void defineMaxStamina() {
        this.maxStamina = 6;
    }
}
