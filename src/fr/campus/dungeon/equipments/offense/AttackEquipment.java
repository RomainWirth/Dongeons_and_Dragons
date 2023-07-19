package fr.campus.dungeon.equipments.offense;

public abstract class AttackEquipment {
    protected int attackLevel;

    // constructeur 
    public AttackEquipment(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString() {
        return "{\n" +
                ",\n attackLevel = " + attackLevel +
                '}';
    }
}
