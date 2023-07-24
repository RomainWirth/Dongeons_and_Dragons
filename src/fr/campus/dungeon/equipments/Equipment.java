package fr.campus.dungeon.equipments;

public abstract class Equipment {
    protected int level;
    private String type;

    public Equipment(int level) {
        this.level = level;
        this.type = this.getClass().getSimpleName();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {\n" +
                " defense level = " + level +
                '}';
    }
}
