package fr.campus.dungeon.boards.cases;

import fr.campus.dungeon.boards.Case;
import fr.campus.dungeon.boards.LootBox;

public class LootCase implements Case {
    public LootBox getLoot() {
        return Loot;
    }

    public void setLoot(LootBox loot) {
        Loot = loot;
    }

    private LootBox Loot;

}
