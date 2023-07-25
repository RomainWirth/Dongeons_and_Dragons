package fr.campus.dungeon.characters;

import fr.campus.dungeon.equipments.offense.AttackEquipment;
import fr.campus.dungeon.equipments.defense.DefenseEquipment;

import java.util.ArrayList;
import java.util.Random;

public abstract class Character {
    protected String name;
    protected int healthPoints;
    protected int minStrength;
    protected int maxStrength;
    protected int minStamina;
    protected int maxStamina;
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
        defineMinStrength();
        defineMaxStrength();
        defineMinStamina();
        defineMaxStamina();
        defineAttackEquipment();
        defineDefenseEquipment();
    }

    // constructeur de la classe personnage
    public Character(
            String name,
            int healthPoints,
            int minStrength,
            int maxStrength,
            int minStamina,
            int maxStamina,
            AttackEquipment attackEquipment,
            DefenseEquipment defenseEquipment) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.minStrength = minStrength;
        this.maxStrength = maxStrength;
        this.minStamina = minStamina;
        this.maxStamina = maxStamina;
        this.attackEquipment = attackEquipment;
        this.defenseEquipment = defenseEquipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public void setMinStrength(int minStrength) {
        this.minStrength = minStrength;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void setMaxStrength(int maxStrength) {
        this.maxStrength = maxStrength;
    }

    public int getMinStamina() {
        return minStamina;
    }

    public void setMinStamina(int minStamina) {
        this.minStamina = minStamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public ArrayList<AttackEquipment> getAttackList() {
        return attackList;
    }

    public void setAttackList(ArrayList<AttackEquipment> attackList) {
        this.attackList = attackList;
    }

    public ArrayList<DefenseEquipment> getDefenseList() {
        return defenseList;
    }

    public void setDefenseList(ArrayList<DefenseEquipment> defenseList) {
        this.defenseList = defenseList;
    }

    public AttackEquipment getAttackEquipment() {
        return attackEquipment;
    }

    public void setAttackEquipment(AttackEquipment attackEquipment) {
        this.attackEquipment = attackEquipment;
    }

    public DefenseEquipment getDefenseEquipment() {
        return defenseEquipment;
    }

    public void setDefenseEquipment(DefenseEquipment defenseEquipment) {
        this.defenseEquipment = defenseEquipment;
    }

    public abstract void defineHealthPoints();
    public abstract void defineMinStrength();
    public abstract void defineMaxStrength();
    public abstract void defineMinStamina();
    public abstract void defineMaxStamina();

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
                ",\n min strengh = " + minStrength +
                ",\n max strengh = " + maxStrength +
                ",\n min stamina = " + minStamina +
                ",\n min stamina = " + minStamina +
                ",\n attackEquipment = " + attackEquipment +
                ",\n defenseEquipment = " + defenseEquipment +
                '}';
    }
}

