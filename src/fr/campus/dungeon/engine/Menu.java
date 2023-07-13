package fr.campus.dungeon.engine;

import fr.campus.dungeon.characters.Character;
import java.util.Scanner;

public class Menu {
    private Scanner userInput = new Scanner(System.in);

    // Créer un personnage
    public Character createCharacter() {

        System.out.println("Enter character type : Warrior or Wizard");
        String characterType = userInput.nextLine();
        System.out.println("You chose class : " + characterType);

        System.out.println("Enter your character name");
        String characterName = userInput.nextLine();
        System.out.println("Your character name is : " + characterName);

        Character character = new Character(characterName, characterType);
        System.out.println(character.toString());
        return character;
    }

    // montrer le personnage
//    public Character getCharacter() {
//
//    };

    // modifier le personnage
//    public Character setCharacter() {};

    // Commencer partie

}
