package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.defense.NoDefenseEquipment;
import fr.campus.dungeon.equipments.offense.weapons.Axe;
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
                new Axe()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of(
                new NoDefenseEquipment()
        ));
        super.defineDefenseEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 15;
    }
    public void defineMinStrength() {
        this.minStrength = 5;
    }
    public void defineMaxStrength() {
        this.maxStrength = 12;
    }
    public void defineMinStamina() {
        this.minStamina = 5;
    }
    public void defineMaxStamina() {
        this.maxStamina = 10;
    }
}
