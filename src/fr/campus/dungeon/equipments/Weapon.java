package fr.campus.dungeon.equipments;

public abstract class Weapon extends AttackEquipment {
    public Weapon(
            String equipmentType,
            int attackLevel) {
        super(equipmentType, attackLevel);
    }
}
