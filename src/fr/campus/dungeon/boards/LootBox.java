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
    protected AttackEquipment attackItem;
    protected DefenseEquipment defenseItem;
    protected Potion careItem;
    private String className;
    private int position;

    // Constructeur
    public LootBox(String className, int position){
        this.className = className;
        this.position = position;
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
                    case 1 -> {
                        return new RustySword();
                    }
                    case 2 -> {
                        return new Mace();
                    }
                    case 3 -> {
                        return new ShortSword();
                    }
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1 -> {
                        return new Mace();
                    }
                    case 2 -> {
                        return new ShortSword();
                    }
                    case 3 -> {
                        return new Axe();
                    }
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1 -> {
                        return new ShortSword();
                    }
                    case 2 -> {
                        return new Axe();
                    }
                    case 3 -> {
                        return new LegendarySword();
                    }
                }
            } else if (position == 61 || position == 62) {
                return new LegendarySword();
            }
        } else { // Wizard
            if (position <= 20) {
                switch (randomNumber) {
                    case 1 -> {
                        return new RainOfThorns();
                    }
                    case 2 -> {
                        return new LightningBolt();
                    }
                    case 3 -> {
                        return new FireBall();
                    }
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1 -> {
                        return new LightningBolt();
                    }
                    case 2 -> {
                        return new FireBall();
                    }
                    case 3 -> {
                        return new IceRain();
                    }
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1 -> {
                        return new FireBall();
                    }
                    case 2 -> {
                        return new IceRain();
                    }
                    case 3 -> {
                        return new WindSword();
                    }
                }
            } else if (position == 61 || position == 62) {
                return new WindSword();
            }
        }
        return null;
    }

    public DefenseEquipment generateRandomDefenseItem(){
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (className.equals("Warrior")) {
            if (position <= 20) {
                switch (randomNumber) {
                    case 1 -> {
                        return new WoodenShield();
                    }
                    case 2 -> {
                        return new NordicShield();
                    }
                    case 3 -> {
                        return new KingdomShield();
                    }
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1 -> {
                        return new NordicShield();
                    }
                    case 2 -> {
                        return new KingdomShield();
                    }
                    case 3 -> {
                        return new LegendaryShield();
                    }
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1 -> {
                        return new KingdomShield();
                    }
                    case 2 -> {
                        return new LegendaryShield();
                    }
                    case 3 -> {
                        return new DragonScaleShield();
                    }
                }
            } else if (position == 61 || position == 62) {
                return new DragonScaleShield();
            }
        } else { // Wizard
            if (position <= 20) {
                switch (randomNumber) {
                    case 1 -> {
                        return new ApprenticeRobe();
                    }
                    case 2 -> {
                        return new NoviceRobe();
                    }
                    case 3 -> {
                        return new MageRobe();
                    }
                }
            } else if (position > 20 && position <= 40) {
                switch (randomNumber) {
                    case 1 -> {
                        return new NoviceRobe();
                    }
                    case 2 -> {
                        return new MageRobe();
                    }
                    case 3 -> {
                        return new MasterRobe();
                    }
                }
            } else if (position > 40 && position <= 60) {
                switch (randomNumber) {
                    case 1 -> {
                        return new MageRobe();
                    }
                    case 2 -> {
                        return new MasterRobe();
                    }
                    case 3 -> {
                        return new ArchmageRobe();
                    }
                }
            } else if (position == 61 || position == 62) {
                return new ArchmageRobe();
            }
        }
        return null;
    }

    public Potion generateRandomCareItem(){
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;
        if (position <= 20) {
            switch (randomNumber) {
                case 1, 2 -> {
                    return new StandardHealingPotion();
                }
                case 3 -> {
                    return new MediumHealingPotion();
                }
            }
        } else if (position > 20 && position <= 40) {
            switch (randomNumber) {
                case 1 -> {
                    return new StandardHealingPotion();
                }
                case 2, 3 -> {
                    return new MediumHealingPotion();
                }
            }
        } else if (position > 40 && position <= 60) {
            switch (randomNumber) {
                case 1 -> {
                    return new MediumHealingPotion();
                }
                case 2, 3 -> {
                    return new LargeHealingPotion();
                }
            }
        } else if (position == 61 || position == 62) {
            return new LargeHealingPotion();
        }
        return null;
    }

    public AttackEquipment getAttackItem() {
        return attackItem;
    }

    public void setAttackItem(AttackEquipment attackItem) {
        this.attackItem = attackItem;
    }

    public DefenseEquipment getDefenseItem() {
        return defenseItem;
    }

    public void setDefenseItem(DefenseEquipment defenseItem) {
        this.defenseItem = defenseItem;
    }

    public Potion getCareItem() {
        return careItem;
    }

    public void setCareItem(Potion careItem) {
        this.careItem = careItem;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
