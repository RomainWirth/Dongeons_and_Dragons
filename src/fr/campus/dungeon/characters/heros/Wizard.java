package fr.campus.dungeon.characters.heros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.campus.dungeon.characters.heros.Hero;
import fr.campus.dungeon.equipments.offense.spells.RainOfThorns;
import fr.campus.dungeon.equipments.defense.magicRobes.ApprenticeRobe;

public class Wizard extends Hero {
    private Random random;

    // Constructeurs
    public Wizard (String name) {
        super(name);
    }

    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(List.of(
                new RainOfThorns()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of(
                new ApprenticeRobe()
        ));
        super.defineDefenseEquipment();
    }

    // Méthodes
    public void defineHealthPoints() {
        random = new Random();
        this.healthPoints = random.nextInt(3) + 3;
        this.setMaxHealthPoints(this.healthPoints);
    }
    public void defineMinStrength() {
        this.minStrength = 8;
    }
    public void defineMaxStrength() {
        this.maxStrength = 15;
    }
    public void defineMinStamina() {
        this.minStamina = 3;
    }
    public void defineMaxStamina() {
        this.maxStamina = 6;
    }

    @Override
    public String toString() {
        return "Wizard {" +
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
