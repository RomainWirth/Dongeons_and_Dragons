package fr.campus.dungeon.boards.cases;

import fr.campus.dungeon.boards.Case;
import fr.campus.dungeon.boards.LootBox;

public class LootCase implements Case {
    private LootBox loot;

    public LootCase (String heroClassName, int position) {
        this.loot = new LootBox(heroClassName, position);
    }

    public LootBox getLoot() {
        return loot;
    }

    public void setLoot(LootBox loot) {
        this.loot = loot;
    }
}
