package fr.campus.dungeon.characters.villains;

import fr.campus.dungeon.equipments.offense.weapons.RustySword;
import fr.campus.dungeon.equipments.offense.weapons.Mace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gobelin extends Villain {
    public Gobelin(String name){
        super(name);
    }
    @Override
    public void defineAttackEquipment() {
        this.attackList = new ArrayList<>(Arrays.asList(
                new RustySword(),
                new Mace()
        ));
        super.defineAttackEquipment();
    }

    @Override
    public void defineDefenseEquipment() {
        this.defenseList = new ArrayList<>(List.of());
        super.defineDefenseEquipment();
    }

    public void defineHealthPoints() {
        this.healthPoints = 6;
    }
    public void defineStrength() {
        this.strength = 1;
    }
}
