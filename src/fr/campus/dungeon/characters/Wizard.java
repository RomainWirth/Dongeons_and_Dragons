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
        this.healthPoints = random.nextInt(6) + 3;
    }
    public void defineStrength() {
        random = new Random();
        this.strength = random.nextInt(15) + 8;
    }
}
