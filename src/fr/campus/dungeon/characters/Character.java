package fr.campus.dungeon.characters;

import fr.campus.dungeon.equipments.AttackEquipment;
import fr.campus.dungeon.equipments.DefenseEquipment;

public class Character {
    private String name;
    private int healthPoints;
    private int strengh;
    private String type;
    private AttackEquipment attackEquipment;
    private DefenseEquipment defenseEquipment;

    public Character() {
    }

    public Character(String name) {
        this.name = name;
    }

    // constructeur de la classe personnage
    public Character(String name, String type) {
        this.name = name;
        this.type = type;
        if(this.type.equals("Warrior")) {
            this.healthPoints = 10;
            this.strengh = 10;
            this.attackEquipment = new AttackEquipment("Weapon", 10, "Narzil");
            this.defenseEquipment = new DefenseEquipment("Shield", 15, "Mighty Shield");
        } else {
            this.healthPoints = 6;
            this.strengh = 15;
            this.attackEquipment = new AttackEquipment("Spell", 8, "Fire Breather");
            this.defenseEquipment = new DefenseEquipment("Potion", 5, "Health Potion");
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

    @Override
    public String toString() {
        return "Character{\n" +
                "name='" + name + '\'' +
                ",\n healthPoints=" + healthPoints +
                ",\n strengh=" + strengh +
                ",\n type='" + type + '\'' +
                ",\n attackEquipment=" + attackEquipment +
                ",\n defenseEquipment=" + defenseEquipment +
                '}';
    }
}

