package fr.campus.dungeon.equipments;

public class DefenseEquipment {
    private String equipmentType; // Shield || Potion
    private int defenseLevel;
    private String equipmentName;

    public DefenseEquipment(String equipmentType, int defenseLevel, String equipmentName) {
        this.equipmentType = equipmentType;
        this.defenseLevel = defenseLevel;
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public String toString() {
        return "{\n" +
                " equipmentType = '" + equipmentType + '\'' +
                ",\n defenseLevel = " + defenseLevel +
                ",\n equipmentName = '" + equipmentName + '\'' +
                '}';
    }
}
