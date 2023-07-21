package fr.campus.dungeon.boards.cases;

import fr.campus.dungeon.boards.Case;

public class EmptyCase implements Case {
    private int position;

    public EmptyCase(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
