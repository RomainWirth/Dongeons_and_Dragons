package fr.campus.dungeon.characters;

import java.util.Random;

import fr.campus.dungeon.equipments.Shield;
import fr.campus.dungeon.equipments.Sword;
import fr.campus.dungeon.equipments.DefenseEquipment;

public class Warrior extends Character {
    // Attributs
    // name inherit from Character
    private Random random;

    // Constructeurs
    public Warrior (String name) {
        super(name);
        this.attackEquipment = new Sword("Sword", 2);
        this.defenseEquipment = new Shield("Shield", 5);
    }

    // Méthodes
    public void defineHealthPoints() {
        random = new Random();
        this.healthPoints = random.nextInt(10) + 5;
    }
    public void defineStrength() {
        random = new Random();
        this.strength = random.nextInt(10) + 5;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", strength=" + strength +
                ", attackEquipment=" + attackEquipment +
                ", defenseEquipment=" + defenseEquipment +
                '}';
    }
}
