package fr.campus.dungeon.equipments.defense.magicRobes;

public class ArchmageRobe extends Robe{
    public ArchmageRobe(){super(9);}

    @Override
    public String toString() {
        return "Archmage Robe {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
