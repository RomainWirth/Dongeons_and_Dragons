package fr.campus.dungeon.equipments.defense.magicRobes;

public class MasterRobe extends Robe{
    public MasterRobe(){super(6);}

    @Override
    public String toString() {
        return "Master Robe {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
