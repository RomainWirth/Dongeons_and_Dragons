package fr.campus.dungeon;

import fr.campus.dungeon.engine.Game;
import fr.campus.dungeon.engine.Menu;

public class Main {
    public static void main(String[] args) {
        // création d'une nouvelle partie
        Menu menu = new Menu();
        String userChoice = menu.displayMainMenu();
        // choix 1 : new game => create a character, then create board, etc. => start game
        if (userChoice.trim().equals("1")) {
            Game game = new Game(menu);
        }
        // choix 2 : load game => get character / set character
        else if (userChoice.trim().equals("2")) {
            Game game = new Game(menu);
        }
        // choix 3 : quit game
        else {
            // quit game
            menu.quitGame();
        }
    }
}