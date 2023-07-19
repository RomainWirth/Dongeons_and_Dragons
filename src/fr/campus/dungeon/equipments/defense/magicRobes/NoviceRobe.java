package fr.campus.dungeon.equipments.defense.magicRobes;

public class NoviceRobe extends Robe {
    public NoviceRobe(){super(3);}

    @Override
    public String toString() {
        return "Novice Robe {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
