package fr.campus.dungeon.characters;

import java.util.Random;

import fr.campus.dungeon.equipments.defense.shields.WoodenShield;
import fr.campus.dungeon.equipments.offense.weapons.RustySword;

public class Warrior extends Character {
    // Attributs
    private Random random;

    // Constructeurs
    public Warrior (String name) {
        super(name);
        this.attackEquipment = new RustySword();
        this.defenseEquipment = new WoodenShield();
    }

    // Méthodes
    public void defineHealthPoints() {
        random = new Random();
        this.healthPoints = random.nextInt(5) + 5;
    }
    public void defineStrength() {
        random = new Random();
        this.strength = random.nextInt(5) + 5;
    }

    @Override
    public String toString() {
        return "Warrior {" +
                "\n name = '" + name + '\'' +
                ",\n healthPoints = " + healthPoints +
                ",\n strength = " + strength +
                ",\n attackEquipment = " + attackEquipment +
                ",\n defenseEquipment = " + defenseEquipment +
                '}';
    }
}
