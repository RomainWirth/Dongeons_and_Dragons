package fr.campus.dungeon.characters;

import java.util.Random;

import fr.campus.dungeon.equipments.offense.spells.RainOfThorns;
import fr.campus.dungeon.equipments.defense.magicRobes.ApprenticeRobe;

public class Wizard extends Character{
    private Random random;

    // Constructeurs
    public Wizard (String name) {
        super(name);
        this.attackEquipment = new RainOfThorns();
        this.defenseEquipment = new ApprenticeRobe();
    }

    // Méthodes
    public void defineHealthPoints() {
        random = new Random();
        this.healthPoints = random.nextInt(3) + 3;
    }
    public void defineStrength() {
        random = new Random();
        this.strength = random.nextInt(7) + 8;
    }

    @Override
    public String toString() {
        return "Wizard {" +
                "\n name = '" + name + '\'' +
                ",\n healthPoints = " + healthPoints +
                ",\n strength = " + strength +
                ",\n attackEquipment = " + attackEquipment +
                ",\n defenseEquipment = " + defenseEquipment +
                '}';
    }
}
