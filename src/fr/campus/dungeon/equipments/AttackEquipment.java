package fr.campus.dungeon.equipments;

public class AttackEquipment {
    // Attributs (propriétés) de la classe équipement offensif
    // type d'équipement, qui va varier selon le type de personnage créé : Warrior ou Wizard
    private String equipmentType; // weapon || spell
    // points d'attaque
    private int attackLevel;
    // nom de l'équipement
    private String equipmentName;

    // constructeur 
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

    @Override
    public String toString() {
        return "AttackEquipment{\n" +
                "equipmentType='" + equipmentType + '\'' +
                ",\n attackLevel=" + attackLevel +
                ",\n equipmentName='" + equipmentName + '\'' +
                '}';
    }
}
