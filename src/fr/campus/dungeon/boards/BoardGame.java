package fr.campus.dungeon.boards;

public class BoardGame {
    private int [] board; // tableau de 64 cases ?
//    private String loot; // box de loot d'équipement
//    private Character ennemy; // création d'un ennemi

    public BoardGame() {
        this.board = new int[64];
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }
}
