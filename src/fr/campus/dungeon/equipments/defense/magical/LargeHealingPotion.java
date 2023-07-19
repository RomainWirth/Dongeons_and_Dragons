package fr.campus.dungeon.equipments.defense.magical;

public class LargeHealingPotion extends Potion{
    public LargeHealingPotion(){super(5);}

    @Override
    public String toString() {
        return "Large Healing Potion {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
