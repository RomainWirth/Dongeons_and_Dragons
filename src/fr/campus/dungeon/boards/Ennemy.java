package fr.campus.dungeon.boards;

import fr.campus.dungeon.characters.Character;
import fr.campus.dungeon.characters.villains.Villain;
import fr.campus.dungeon.characters.villains.Scaven;
import fr.campus.dungeon.characters.villains.Gobelin;
import fr.campus.dungeon.characters.villains.Skeleton;
import fr.campus.dungeon.characters.villains.Sorcerer;
import fr.campus.dungeon.characters.villains.Ork;
import fr.campus.dungeon.characters.villains.Dragon;

import java.util.Random;

public class Ennemy {


    public Villain generateEnnemy() {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;

    }
}
