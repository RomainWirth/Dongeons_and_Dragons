package fr.campus.dungeon.characters;

public class Character {
    private String name;
    private int healthPoints;
    private int strengh;

    public Character(String name, int heathPoints, int strengh) {
        this.name = name;
        this.healthPoints = heathPoints;
        this.strengh = strengh;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return healthPoints;
    }
    public void setHealth(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrengh() {
        return strengh;
    }
    public void setStrengh(int strengh) {
        this.strengh = strengh;
    }
}
