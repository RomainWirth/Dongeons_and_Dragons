package fr.campus.dungeon.equipments;

public abstract class Equipment {
    protected int level;

    public Equipment(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {\n" +
                " defense level = " + level +
                '}';
    }
}
