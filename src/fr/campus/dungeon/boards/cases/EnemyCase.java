package fr.campus.dungeon.boards.cases;

import fr.campus.dungeon.boards.Case;
import fr.campus.dungeon.boards.Enemy;

public class EnemyCase implements Case {
    private Enemy enemy;

    public EnemyCase (int position) {
        this.enemy = new Enemy(position);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
