package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.shields.WoodenShield;
import fr.campus.dungeon.equipments.offense.weapons.RustySword;

import java.util.ArrayList;
import java.util.List;

public class Scaven extends Villain {
    public Scaven(String name) {
        super(name);
    }
    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(List.of(
                new RustySword()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of(
                new WoodenShield()
        ));
        super.defineAttackEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 4;
    }
    public void defineStrength() {
        this.strength = 1;
    }
}
