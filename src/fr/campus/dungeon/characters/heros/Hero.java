package fr.campus.dungeon.characters.heros;

import fr.campus.dungeon.characters.Character;

public abstract class Hero extends Character {


    int maxHealthPoints;
    public Hero(String name){
        super(name);
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public void updateHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
        if (this.healthPoints > maxHealthPoints) {
            this.healthPoints = maxHealthPoints;
        }
    }
}
