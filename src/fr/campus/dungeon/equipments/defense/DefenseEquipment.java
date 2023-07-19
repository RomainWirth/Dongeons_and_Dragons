package fr.campus.dungeon.equipments.defense;

public abstract class DefenseEquipment {
    protected int defenseLevel;

    public DefenseEquipment(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {\n" +
                " defense level = " + defenseLevel +
                '}';
    }
}
