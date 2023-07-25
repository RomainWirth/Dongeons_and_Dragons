package fr.campus.dungeon.engine;

import fr.campus.dungeon.characters.Character;
import fr.campus.dungeon.characters.heros.Hero;
import fr.campus.dungeon.characters.heros.Warrior;
import fr.campus.dungeon.characters.heros.Wizard;
import fr.campus.dungeon.equipments.Equipment;

import java.util.Scanner;

public class Menu {
    private final Scanner userInput = new Scanner(System.in);

    public Menu() {}

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

    public String displayFightMenu(){
        System.out.println("You encounter an Enemy... what will you do ?\n 1 - fight! \n 2 - fly! you fool!");
        return userInput.nextLine();
    }

    public String displayLootMenu(Equipment equipment) {
        System.out.println("You found new equipment : " + equipment + "\n");
        System.out.println("Do you want to equip ? \n 1 - Yes \n 2 - No");
        String userChoice = userInput.nextLine();
        while (!userChoice.equals("1") && !userChoice.equals("2")) {
            System.out.println("Do you want to equip ? \n 1 - Yes \n 2 - No");
            userChoice = userInput.nextLine();
        }
        return userChoice;
    }

    // Créer un personnage
    public Hero createCharacter() {
        System.out.println("Enter character type :\n Warrior\n or\n Wizard");
        String characterType = userInput.nextLine();
        if (characterType.equals("Warrior")){
            System.out.println("You chose class : Warrior");
            System.out.println("Enter your character name");
            String characterName = userInput.nextLine();
            System.out.println("Your character name is : " + characterName);
            Warrior warrior = new Warrior(characterName);
            System.out.println(warrior.toString());
            return warrior;
        } else {
            System.out.println("You chose class : Wizard");
            System.out.println("Enter your character name");
            String characterName = userInput.nextLine();
            System.out.println("Your character name is : " + characterName);
            Wizard wizard = new Wizard(characterName);
            System.out.println(wizard.toString());
            return wizard;
        }
    }

    // montrer le personnage
    public void displayCharacter(Character character) {
        System.out.println(character.toString());
    }

    // modifier le personnage
    public Hero modifyCharacter(Hero character) {
        return character;
    }

    // Commencer la partie
    public void initBoard() {
        System.out.println("new game loading");
    }

    // Quitter la partie
    public String gameOver() {
        System.out.println("1 - Quit Game / 2 - New Game");
        return userInput.nextLine();
    }
}
