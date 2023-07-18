package fr.campus.dungeon.characters;

import java.util.Random;
import fr.campus.dungeon.equipments.Spell;
import fr.campus.dungeon.equipments.Potion;

public class Wizard extends Character{
    private Random random;

    // Constructeurs
    public Wizard (String name) {
        super(name);
//        this.attackEquipment = new Spell("Spell", 1);
//        this.defenseEquipment = new Potion("Potion", 1);
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
