package fr.campus.dungeon.equipments.defense.magicRobes;

public class MageRobe extends Robe {
    public MageRobe(){super(4);}

    @Override
    public String toString() {
        return "Mage Robe {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
