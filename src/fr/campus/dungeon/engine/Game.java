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
        // choix : lancer le dé ou quitter la partie;
        while(this.characterPosition <= this.board.getBoard().length) {
            // si position < taille tableau - 6
            int roll = Dice.roll();
            System.out.println("you rolled : " + roll);
            this.characterPosition = this.characterPosition + roll;
            System.out.println(this.characterPosition);
        }
    }

}
