package fr.campus.dungeon;

import fr.campus.dungeon.engine.Game;
import fr.campus.dungeon.engine.Menu;

public class Main {
    public static void main(String[] args) {
        // création d'une nouvelle partie
        Menu menu = new Menu();
        String userMainChoice = menu.displayMainMenu();
        // choix 1 : new game => create a character, then create board, etc. => start game
        if (userMainChoice.trim().equals("1")) {
            Game game = new Game(menu);
        }
        // choix 2 : load game => get character / set character
        else if (userMainChoice.trim().equals("2")) {
            Game game = new Game(menu);
        }
        // choix 3 : quit game
        else {
            // quit game
            String userGameOverChoice = menu.gameOver();
            if(userGameOverChoice.equals("1")) {
                System.out.println("Game Over, thanks for playing !");
            } else {
                System.out.println("New Game Starting");
                Game game = new Game(menu);
            }
        }
    }
}