package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.magicRobes.MageRobe;
import fr.campus.dungeon.equipments.defense.magicRobes.MasterRobe;
import fr.campus.dungeon.equipments.defense.magicRobes.NoviceRobe;
import fr.campus.dungeon.equipments.offense.spells.LightningBolt;
import fr.campus.dungeon.equipments.offense.spells.RainOfThorns;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorcerer extends Villain {

    public Sorcerer(String name) {
        super(name);
    }

    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(Arrays.asList(
                new RainOfThorns(),
                new LightningBolt()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(Arrays.asList(
                new NoviceRobe(),
                new MageRobe(),
                new MasterRobe()
        ));
        super.defineDefenseEquipment();
    }
    public void defineHealthPoints() {this.healthPoints = 8;}
    public void defineMinStrength() {
        this.minStrength = 8;
    }
    public void defineMaxStrength() {
        this.maxStrength = 10;
    }
    public void defineMinStamina() {
        this.minStamina = 1;
    }
    public void defineMaxStamina() {
        this.maxStamina = 2;
    }
}
