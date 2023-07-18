package fr.campus.dungeon.equipments;

public abstract class AttackEquipment {
    protected String equipmentType;
    protected int attackLevel;
//    protected String equipmentName;

    // constructeur 
    public AttackEquipment(
            String equipmentType,
            int attackLevel
//            String equipmentName
    ) {
        this.equipmentType = equipmentType;
        this.attackLevel = attackLevel;
//        this.equipmentName = equipmentName;
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

//    public String getEquipmentName() {
//        return equipmentName;
//    }
//
//    public void setEquipmentName(String equipmentName) {
//        this.equipmentName = equipmentName;
//    }

    @Override
    public String toString() {
        return "{\n" +
                " equipmentType = '" + equipmentType + '\'' +
                ",\n attackLevel = " + attackLevel +
//                ",\n equipmentName = '" + equipmentName + '\'' +
                '}';
    }
}
