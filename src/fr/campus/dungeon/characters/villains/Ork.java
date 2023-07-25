package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.offense.weapons.Mace;
import fr.campus.dungeon.equipments.offense.weapons.ShortSword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ork extends Villain {
    public Ork(String name) {
        super(name);
    }

    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(Arrays.asList(
                new Mace(),
                new ShortSword()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of());
        super.defineDefenseEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 7;
    }
    public void defineStrength() {
        this.strength = 4;
    }
}
