package fr.campus.dungeon.characters;

import fr.campus.dungeon.equipments.offense.AttackEquipment;
import fr.campus.dungeon.equipments.defense.DefenseEquipment;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character {
    protected String name;
    protected int healthPoints;
    protected int strength; // min et max : définit la puissance de frappe min et max selon lancé de dés : si force attaquand > agilité defenseur = dégâts sinon rien
    // stamina = min et max : définit le niveau de défense du perso selon lancé de dé
    protected AttackEquipment attackEquipment;
    protected DefenseEquipment defenseEquipment;
    // bag = array taille 3

    protected ArrayList<AttackEquipment> attackList = new ArrayList<AttackEquipment>();
    protected ArrayList<DefenseEquipment> defenseList = new ArrayList<DefenseEquipment>();

    public Character() {
    }

    public Character(String name) {
        this.name = name;
        defineHealthPoints();
        defineStrength();
        defineAttackEquipment();
        defineDefenseEquipment();
    }

    // constructeur de la classe personnage
    public Character(String name, int healthPoints, int strength, AttackEquipment attackEquipment, DefenseEquipment defenseEquipment) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.attackEquipment = attackEquipment;
        this.defenseEquipment = defenseEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Modify you name");
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {this.healthPoints = healthPoints;}

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {this.strength = strength;}

    public abstract void defineHealthPoints();
    public abstract void defineStrength();

    public void defineAttackEquipment() {
        if (attackList.size() > 0) {
            Random random = new Random();
            int randomNumber = random.nextInt(attackList.size());
            this.attackEquipment = attackList.get(randomNumber);
        }
    }

    public void defineDefenseEquipment() {
        if (defenseList.size() > 0) {
            Random random = new Random();
            int randomNumber = random.nextInt(defenseList.size());
            this.defenseEquipment = defenseList.get(randomNumber);
        }
    }

    @Override
    public String toString() {
        return "Character { \n" +
                " name = '" + name + '\'' +
                ",\n healthPoints = " + healthPoints +
                ",\n strengh = " + strength +
                ",\n attackEquipment = " + attackEquipment +
                ",\n defenseEquipment = " + defenseEquipment +
                '}';
    }
}

