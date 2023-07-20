package fr.campus.dungeon.boards;

import java.util.ArrayList;

public class BoardGame {
    private ArrayList<Case> board; // tableau de 64 cases ?

    public BoardGame() {
        this.board = new ArrayList<Case>();
    }

    public void generateBoard(String className) {

    }

    public ArrayList<Case> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Case> board) {this.board = board;}
}
