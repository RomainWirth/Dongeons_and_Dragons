package fr.campus.dungeon.boards;

import fr.campus.dungeon.boards.cases.EmptyCase;
import fr.campus.dungeon.boards.cases.EnemyCase;
import fr.campus.dungeon.boards.cases.LootCase;

import java.util.ArrayList;
import java.util.Random;

public class BoardGame {
    private ArrayList<Case> board; // tableau de 64 cases ?
    int boardSize;

    public BoardGame(int boardSize) {
        this.boardSize = boardSize;
        this.board = new ArrayList<Case>(boardSize);
    }

    public void generateBoard(String className) {
        int numberEmptyCase = 14;
        int numberLootCase = 3;
        int numberEnemyCase = 3;
        for (int position = 0; position < boardSize - 3; position++) {
            if (position%20 == 0) {
                numberEmptyCase = 14;
                numberLootCase = 3;
                numberEnemyCase = 3;
            }
            Random random = new Random();
            int randomNumber = random.nextInt(3) + 1;
            if (position == 0) {
                this.board.add(new EmptyCase(position));
                numberEmptyCase--;
            } else if (
                    (randomNumber == 1 && numberEmptyCase > 0)
                    || (randomNumber == 2 && numberLootCase == 0 && numberEmptyCase > 0)
                    || (randomNumber == 3 && numberEnemyCase == 0 && numberLootCase == 0)
            ) {
                this.board.add(new EmptyCase(position));
                numberEmptyCase--;
            } else if (
                    (randomNumber == 2 && numberLootCase > 0)
                    || (randomNumber == 1 && numberEmptyCase == 0 && numberLootCase > 0)
                    || (randomNumber == 3 && numberEnemyCase == 0 && numberLootCase > 0)
            ) {
                this.board.add(new LootCase(className, position));
                numberLootCase--;
            } else if (
                    (randomNumber == 3 && numberEnemyCase > 0)
                    || (randomNumber == 1 && numberEmptyCase > 0 && numberLootCase == 0)
                    || (randomNumber == 2 && numberLootCase == 0 && numberEmptyCase == 0)
            ){
                this.board.add(new EnemyCase(position));
                numberEnemyCase--;
            }
        }
        this.board.add(new LootCase(className, boardSize - 3));
        this.board.add(new LootCase(className,boardSize - 2));
        this.board.add(new EnemyCase(boardSize - 1));
    }

    public ArrayList<Case> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Case> board) {this.board = board;}
}
