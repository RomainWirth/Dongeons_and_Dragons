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
        playGame();
    }

    public void addCharacter() {
        this.myCharacter = menu.createCharacter();
    }

    public void showCharacter() {
        menu.displayCharacter(this.myCharacter);
    }
    public void updateCharacter() {
        // appelé
    }

    public void addBoard() {
        // création du plateau de jeu
        menu.initBoard();
        this.board = new BoardGame(64);
    }

    public void playGame() {
        this.board.generateBoard(this.myCharacter.getClass().getSimpleName());
        System.out.println("Start game");
        this.characterPosition = 0;
        System.out.println(this.characterPosition);
        int length = this.board.getBoard().size();
//        try {
            while (this.characterPosition < length) {
                String userChoice = menu.displayGameMenu();
                if (userChoice.equals("1")) {
                    int roll = Dice.roll();
                    System.out.println("you rolled : " + roll);
                    this.characterPosition = this.characterPosition + roll;
                    if (this.characterPosition > length) {
                        this.characterPosition = length;
//                        throw new CharacterOutOfBoundsException();
                    }
                    System.out.println("New position : " + this.characterPosition);
                    if (this.characterPosition == 64) {
                        System.out.println("Game Over, you won!");
                    }
                } else if (userChoice.equals("2")) {
                    // montrer le personnage
                    menu.displayCharacter(myCharacter);
                } else if (userChoice.equals("3")) {
                    // continuer ?
                    break;
                } else {
                    System.out.println("Error, choice invalid !");
                }
                // si position < taille tableau - 6
            }
//        } catch (CharacterOutOfBoundsException exception){
//            exception.printStackTrace();
//            System.out.println(exception.getMessage());
//        }
        String end = menu.gameOver();
        if(end.equals("1")) {
            System.out.println("Game Over, thanks for playing !");
        } else {
            System.out.println("New Game Starting");
            Game game = new Game(menu);
        }
    }
}
