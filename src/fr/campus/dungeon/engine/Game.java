package fr.campus.dungeon.engine;

import fr.campus.dungeon.boards.BoardGame;
import fr.campus.dungeon.characters.Character;
import fr.campus.dungeon.boards.Dice;

public class Game {
    Character myCharacter;
    Menu menu;
    BoardGame board;
    private int characterPosition;

    public Game(Menu menu) {
        this.menu = menu;
        addCharacter();
        addBoard();
        // quit Game
        playGame();
    }

    public void addCharacter() {
        this.myCharacter = menu.createCharacter();
    }

    public void showCharacter() {
        // appelé à n'importe quel moment du jeu
        menu.displayCharacter(this.myCharacter);
    }
    public void updateCharacter() {
        // appelé
    }

    public void addBoard() {
        // création du plateau de jeu
        menu.initBoard();
        this.board = new BoardGame();
    }

    public void playGame() {
        System.out.println("Start game");
        this.characterPosition = 0;
        System.out.println(this.characterPosition);
        String end = "0";
        // choix : lancer le dé ou quitter la partie;
        while(this.characterPosition <= this.board.getBoard().length && !end.equals("1")) {
            // générer un menu utilisateur avec 3 choix
            // récupérer le choix de l'utilisateur : 1 = continuer la partie => roll dice ; 2 = show Character ; 3 = quit game
            String userChoice = menu.displayGameMenu();
            if (userChoice.equals("1")){
                int roll = Dice.roll();
                System.out.println("you rolled : " + roll);
                this.characterPosition = this.characterPosition + roll;
                System.out.println("New position : " + this.characterPosition);
            } else if (userChoice.equals("2")) {
                // montrer le personnage
                menu.displayCharacter(myCharacter);
            } else {
                // continuer ?
                end = menu.gameOver();
                if(end.equals("1")) {
                    System.out.println("Game Over, thanks for playing !");
                } else {
                    System.out.println("New Game Starting");
                    Game game = new Game(menu);
                }
            }
            // si position < taille tableau - 6
        }
    }
}
