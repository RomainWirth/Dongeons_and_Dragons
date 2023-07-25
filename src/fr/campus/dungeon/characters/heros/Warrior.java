package fr.campus.dungeon.characters.heros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.campus.dungeon.characters.heros.Hero;
import fr.campus.dungeon.equipments.defense.shields.WoodenShield;
import fr.campus.dungeon.equipments.offense.weapons.RustySword;

public class Warrior extends Hero {

    // Constructeurs
    public Warrior (String name) {
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

    // Méthodes
    public void defineHealthPoints() {
        Random random = new Random();
        this.healthPoints = random.nextInt(5) + 5;
        this.setMaxHealthPoints(this.healthPoints);
    }
    public void defineMinStrength() {
        this.minStrength = 5;
    }
    public void defineMaxStrength() {
        this.maxStrength = 10;
    }
    public void defineMinStamina() {
        this.minStamina = 5;
    }
    public void defineMaxStamina() {
        this.maxStamina = 10;
    }

    @Override
    public String toString() {
        return "Warrior {" +
                "\n name = '" + name + '\'' +
                ",\n healthPoints = " + healthPoints +
                ",\n min strengh = " + minStrength +
                ",\n max strengh = " + maxStrength +
                ",\n min stamina = " + minStamina +
                ",\n max stamina = " + maxStamina +
                ",\n attackEquipment = " + attackEquipment +
                ",\n defenseEquipment = " + defenseEquipment +
                '}';
    }
}
