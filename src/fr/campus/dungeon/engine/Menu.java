package fr.campus.dungeon.engine;

import fr.campus.dungeon.characters.Character;
import fr.campus.dungeon.boards.BoardGame;

import java.util.Scanner;

public class Menu {
    private final Scanner userInput = new Scanner(System.in);

    public Menu() {

    }

    public String displayMainMenu() {
        System.out.println("WELCOME TO DONGEONS & DRAGONS");
        System.out.println("Main menu, make a choice :\n 1 - New Game,\n 2 - Load Game,\n 3 - Quit");
        return userInput.nextLine();
    }

    // display Game Menu
    public String displayGameMenu(){
        System.out.println("What do you wish to do ?\n 1 - Roll the dice\n 2 - look at my character\n 3 - quit game");
        return userInput.nextLine();
    }

    // Créer un personnage
    public Character createCharacter() {

        System.out.println("Enter character type :\n 1 - Warrior\n or\n 2 - Wizard");
        String characterType = userInput.nextLine();
        if (characterType.equals("1")){
            System.out.println("You chose class : " + characterType + " = warrior");
        } else {
            System.out.println("You chose class : " + characterType + " = wizard");
        }

        System.out.println("Enter your character name");
        String characterName = userInput.nextLine();
        System.out.println("Your character name is : " + characterName);

        Character character = new Character(characterName, characterType);
        System.out.println(character.toString());
        return character;
    }

    // montrer le personnage
    public void displayCharacter(Character character) {
        System.out.println(character.toString());
    }

    // modifier le personnage
    public Character modifyCharacter(Character character) {
        character.setName(userInput.next());
        character.setType(userInput.next());
        return character;
    }

    // Commencer la partie
    public void initBoard() {
        System.out.println("new game loading");
    }

    // Quitter la partie
    public void quitGame() {
        System.out.println("Game over, thanks for playing!");
        // Start new game ?
        // si oui = display Main menu, si non = fin
    }
}
