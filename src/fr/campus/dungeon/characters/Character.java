package fr.campus.dungeon.characters;

import fr.campus.dungeon.equipments.AttackEquipment;

public class Character {
    private String name;
    private int healthPoints;
    private int strengh;
    private String type;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, String type) {
        this.name = name;
        this.type = type;
        if(this.type.equals("Warrior")) {
            this.healthPoints = 10;
            this.strengh = 10;
            AttackEquipment AttackEquipment = new AttackEquipment("Weapon", 10, "Narzil");
        } else {
            this.healthPoints = 6;
            this.strengh = 15;
            AttackEquipment AttackEquipment = new AttackEquipment("Spell", 8, "Fire Breather");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrengh() {
        return strengh;
    }

    public void setStrengh(int strengh) {
        this.strengh = strengh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

