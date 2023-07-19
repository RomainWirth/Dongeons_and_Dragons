package fr.campus.dungeon.equipments.defense.magical;

public class StandardHealingPotion extends Potion {
    public StandardHealingPotion(){super(2);}

    @Override
    public String toString() {
        return "Standard Healing Potion {\n" +
                " defenseLevel = " + defenseLevel +
                '}';
    }
}
