package fr.campus.dungeon.equipments;

public class AttackEquipment {
    private String equipmentType; // weapon || spell
    private int attackLevel;
    private String equipmentName;

    public AttackEquipment(String equipmentType, int attackLevel, String equipmentName) {
        this.equipmentType = equipmentType;
        this.attackLevel = attackLevel;
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
