package fr.campus.dungeon.characters;

import fr.campus.dungeon.equipments.defense.magicRobes.NoviceRobe;
import fr.campus.dungeon.equipments.offense.AttackEquipment;
import fr.campus.dungeon.equipments.offense.spells.FireBall;
import fr.campus.dungeon.equipments.offense.spells.LightningBolt;
import fr.campus.dungeon.equipments.offense.spells.RainOfThorns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Sorcerer extends Character {
    // initialisation d'un tableau regroupant tous les équipements magiques d'attaque

    // initialisation d'un tableau regroupant tous les équipements magiques de défense
//    private int [] magicDefenseEquipment;

    public Sorcerer(String name) {
        super(name);
        this.attackEquipment = new FireBall();
        this.defenseEquipment = new NoviceRobe();
    }

    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(Arrays.asList(
                new RainOfThorns(),
                new LightningBolt(),
                new FireBall()
        ));
        super.defineAttackEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 9;
    }
    public void defineStrength() {
        this.strength = 2;
    }
}
