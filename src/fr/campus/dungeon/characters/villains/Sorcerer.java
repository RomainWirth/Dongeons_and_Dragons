package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.magicRobes.MageRobe;
import fr.campus.dungeon.equipments.defense.magicRobes.MasterRobe;
import fr.campus.dungeon.equipments.defense.magicRobes.NoviceRobe;
import fr.campus.dungeon.equipments.offense.spells.LightningBolt;
import fr.campus.dungeon.equipments.offense.spells.RainOfThorns;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorcerer extends Villain {
    // initialisation d'un tableau regroupant tous les équipements magiques d'attaque
    // initialisation d'un tableau regroupant tous les équipements magiques de défense

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
        super.defineAttackEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 9;
    }
    public void defineStrength() {this.strength = 3;}
}
