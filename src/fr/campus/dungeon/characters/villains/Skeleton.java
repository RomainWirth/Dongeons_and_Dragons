package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.shields.WoodenShield;
import fr.campus.dungeon.equipments.offense.weapons.Mace;
import fr.campus.dungeon.equipments.offense.weapons.RustySword;
import fr.campus.dungeon.equipments.offense.weapons.ShortSword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skeleton extends Villain {
    public Skeleton(String name) {
        super(name);
    }
    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(Arrays.asList(
                new RustySword(),
                new Mace(),
                new ShortSword()
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

    public void defineHealthPoints() {
        this.healthPoints = 10;
    }
    public void defineMinStrength() {
        this.minStrength = 4;
    }
    public void defineMaxStrength() {
        this.maxStrength = 10;
    }
    public void defineMinStamina() {
        this.minStamina = 1;
    }
    public void defineMaxStamina() {
        this.maxStamina = 8;
    }
}
