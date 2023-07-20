package fr.campus.dungeon.boards;

import fr.campus.dungeon.equipments.Equipment;
import fr.campus.dungeon.equipments.defense.DefenseEquipment;
// items 1
import fr.campus.dungeon.equipments.defense.shields.WoodenShield;
import fr.campus.dungeon.equipments.defense.magicRobes.ApprenticeRobe;
// items 2
import fr.campus.dungeon.equipments.defense.shields.NordicShield;
import fr.campus.dungeon.equipments.defense.magicRobes.NoviceRobe;
// items 3
import fr.campus.dungeon.equipments.defense.shields.KingdomShield;
import fr.campus.dungeon.equipments.defense.magicRobes.MageRobe;
// items 4
import fr.campus.dungeon.equipments.defense.shields.LegendaryShield;
import fr.campus.dungeon.equipments.defense.magicRobes.MasterRobe;
// items 5
import fr.campus.dungeon.equipments.defense.shields.DragonScaleShield;
import fr.campus.dungeon.equipments.defense.magicRobes.ArchmageRobe;

import fr.campus.dungeon.equipments.offense.AttackEquipment;
// items 1
import fr.campus.dungeon.equipments.offense.weapons.RustySword;
import fr.campus.dungeon.equipments.offense.spells.RainOfThorns;
// items 2
import fr.campus.dungeon.equipments.offense.weapons.Mace;
import fr.campus.dungeon.equipments.offense.spells.LightningBolt;
// items 3
import fr.campus.dungeon.equipments.offense.weapons.ShortSword;
import fr.campus.dungeon.equipments.offense.spells.FireBall;
// items 4
import fr.campus.dungeon.equipments.offense.weapons.Axe;
import fr.campus.dungeon.equipments.offense.spells.IceRain;
// items 5
import fr.campus.dungeon.equipments.offense.weapons.LegendarySword;
import fr.campus.dungeon.equipments.offense.spells.WindSword;

import fr.campus.dungeon.equipments.careItems.Potion;
// items 1 et 2
import fr.campus.dungeon.equipments.careItems.StandardHealingPotion;
// items 3 et 4
import fr.campus.dungeon.equipments.careItems.MediumHealingPotion;
// items 4 et 5
import fr.campus.dungeon.equipments.careItems.LargeHealingPotion;

import java.util.Random;

public class LootBox {
    protected Equipment equipment;
    protected AttackEquipment attackItem;
    protected DefenseEquipment defenseItem;
    protected Potion careItem;
    private String className;
    private int position;

    // Constructeur
    public LootBox(String className, int position){
        this.attackItem = generateRandomAttackItem();
        this.defenseItem = generateRandomDefenseItem();
        this.careItem = generateRandomCareItem();
    }

    // Methods
    public AttackEquipment generateRandomAttackItem(){
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        // N.B. : position héros initialisée à 0
        if (className.equals("Warrior")) {
            if (position <= 20) {
                switch (randomNumber) {
                    case 1:
                        return new RustySword();
                        break;
                    case 2:
                        return new Mace();
                        break;
                    case 3:
                        return new ShortSword();
                        break;
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1:
                        return new Mace();
                        break;
                    case 2:
                        return new ShortSword();
                        break;
                    case 3:
                        return new Axe();
                        break;
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1:
                        return new ShortSword();
                        break;
                    case 2:
                        return new Axe();
                        break;
                    case 3:
                        return new LegendarySword();
                        break;
                }
            } else if (position == 61 || position == 62) {
                return new LegendarySword();
            }
        } else { // Wizard
            if (position <= 20) {
                switch (randomNumber) {
                    case 1:
                        return new RainOfThorns();
                    break;
                    case 2:
                        return new LightningBolt();
                    break;
                    case 3:
                        return new FireBall();
                    break;
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1:
                        return new LightningBolt();
                        break;
                    case 2:
                        return new FireBall();
                        break;
                    case 3:
                        return new IceRain();
                        break;
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1:
                        return new FireBall();
                        break;
                    case 2:
                        return new IceRain();
                        break;
                    case 3:
                        return new WindSword();
                        break;
                }
            } else if (position == 61 || position == 62) {
                return new WindSword();
            }
        }
    }

    public DefenseEquipment generateRandomDefenseItem(){
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (className.equals("Warrior")) {
            if (position <= 20) {
                switch (randomNumber) {
                    case 1:
                        return new WoodenShield();
                        break;
                    case 2:
                        return new NordicShield();
                        break;
                    case 3:
                        return new KingdomShield();
                        break;
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1:
                        return new NordicShield();
                        break;
                    case 2:
                        return new KingdomShield();
                        break;
                    case 3:
                        return new LegendaryShield();
                        break;
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1:
                        return new KingdomShield();
                        break;
                    case 2:
                        return new LegendaryShield();
                        break;
                    case 3:
                        return new DragonScaleShield();
                        break;
                }
            } else if (position == 61 || position == 62) {
                return new DragonScaleShield();
            }
        } else { // Wizard
            if (position <= 20) {
                switch (randomNumber) {
                    case 1:
                        return new ApprenticeRobe();
                        break;
                    case 2:
                        return new NoviceRobe();
                        break;
                    case 3:
                        return new MageRobe();
                        break;
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1:
                        return new NoviceRobe();
                        break;
                    case 2:
                        return new MageRobe();
                        break;
                    case 3:
                        return new MasterRobe();
                        break;
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1:
                        return new MageRobe();
                        break;
                    case 2:
                        return new MasterRobe();
                        break;
                    case 3:
                        return new ArchmageRobe();
                        break;
                }
            } else if (position == 61 || position == 62) {
                return new ArchmageRobe();
            }
        }
    }

    public Potion generateRandomCareItem(){
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (position <= 20) {
            switch (randomNumber) {
                case 1, 2:
                    return new StandardHealingPotion();
                    break;
                case 3:
                    return new MediumHealingPotion();
                    break;
            }
        } else if (position > 20 && position <= 40) {
            switch (randomNumber) {
                case 1:
                    return new StandardHealingPotion();
                    break;
                case 2, 3:
                    return new MediumHealingPotion();
                    break;
            }
        } else if (position > 40 && position <= 60) {
            switch (randomNumber) {
                case 1:
                    return new MediumHealingPotion();
                    break;
                case 2, 3:
                    return new LargeHealingPotion();
                    break;
            }
        } else if (position == 61 || position == 62) {
            return new LargeHealingPotion();
        }
    }
}
