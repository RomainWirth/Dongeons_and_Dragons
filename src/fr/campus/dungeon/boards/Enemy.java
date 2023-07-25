package fr.campus.dungeon.boards;

import fr.campus.dungeon.characters.villains.Villain;
import fr.campus.dungeon.characters.villains.Skaven;
import fr.campus.dungeon.characters.villains.Gobelin;
import fr.campus.dungeon.characters.villains.Skeleton;
import fr.campus.dungeon.characters.villains.Ork;
import fr.campus.dungeon.characters.villains.Sorcerer;
import fr.campus.dungeon.characters.villains.Dragon;

import java.util.Random;

public class Enemy {
    //Attributs
    protected Villain villain;
    private int position;

    // Constructeur
    public Enemy(int position) {
        this.position = position;
        this.villain = generateRandomEnemy();
    }

    // Method
    public Villain generateRandomEnemy() {
        Random random = new Random();
        int randomNumber;
        if (position <= 15) {
            return new Skaven("Skaven");
        } else if (position <= 30) {
            randomNumber = random.nextInt(2) + 1;
            switch (randomNumber) {
                case 1 -> {
                    return new Skaven("Skaven");
                }
                case 2 -> {
                    return new Gobelin("Gobelin");
                }
            }
        } else if (position <= 40) {
            randomNumber = random.nextInt(3) + 1;
            switch (randomNumber) {
                case 1 -> {
                    return new Skaven("Skaven");
                }
                case 2 -> {
                    return new Gobelin("Gobelin");
                }
                case 3 -> {
                    return new Skeleton("Skeleton");
                }
            }
        } else if (position > 40 && position <= 50) {
            return new Ork("Ork");
        } else if (position <= 60) {
            randomNumber = random.nextInt(2) + 1;
            switch (randomNumber) {
                case 1 -> {
                    return new Ork("Ork");
                } case 2 -> {
                    return new Sorcerer("Sorcerer");
                }
            }
        } else if (position == 63) {
            return new Dragon("Dragon");
        }
        return null;
    }

    public Villain getVillain() {
        return villain;
    }

    public void setVillain(Villain villain) {
        this.villain = villain;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
