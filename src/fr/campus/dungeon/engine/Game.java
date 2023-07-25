package fr.campus.dungeon.engine;

import fr.campus.dungeon.boards.*;
import fr.campus.dungeon.boards.cases.EmptyCase;
import fr.campus.dungeon.boards.cases.EnemyCase;
import fr.campus.dungeon.boards.cases.LootCase;
import fr.campus.dungeon.characters.Character;
import fr.campus.dungeon.characters.heros.Hero;
import fr.campus.dungeon.db.HeroDB;
import fr.campus.dungeon.equipments.careItems.Potion;
import fr.campus.dungeon.equipments.defense.DefenseEquipment;
import fr.campus.dungeon.equipments.offense.AttackEquipment;

public class Game {
    Hero myCharacter;
    Menu menu;
    BoardGame board;
    private int characterPosition;

    public Game(Menu menu) {
        this.menu = menu;
        addCharacter();
        HeroDB.newHero(myCharacter);
        addBoard();
        playGame();
    }

    public void addCharacter() {
        this.myCharacter = menu.createCharacter();
    }

    public void showCharacter() {
        menu.displayCharacter(this.myCharacter);
    }

    public void addBoard() {
        // création du plateau de jeu
        menu.initBoard();
        this.board = new BoardGame(64);
    }

    public void playGame() {
        this.board.generateBoard(this.myCharacter.getClass().getSimpleName());
        System.out.println("Start game");
        this.characterPosition = 0;
        System.out.println("You enter the donjon on case " + (this.characterPosition + 1));
        int length = this.board.getBoard().size();
//        try {
            while (this.characterPosition < length - 1) {
                String userChoice = menu.displayGameMenu();
                if (userChoice.equals("1")) {
                    int roll = Dice.roll();
                    System.out.println("you rolled : " + roll);
                    this.characterPosition = this.characterPosition + roll;
                    if (this.characterPosition > length - 1) {
                        this.characterPosition = length - 1;
//                        throw new CharacterOutOfBoundsException();
                    }
                    // fonction event
                    System.out.println("New position : " + (this.characterPosition + 1));
                    event();
//                    if (this.characterPosition == 64) {
//                        System.out.println("Game Over, you won!");
//                    }
                } else if (userChoice.equals("2")) {
                    // montrer le personnage
                    menu.displayCharacter(myCharacter);
                } else if (userChoice.equals("3")) {
                    // continuer ?
                    break;
                } else {
                    System.out.println("Error, choice invalid !");
                }
                // si position < taille tableau - 6
            }
//        } catch (CharacterOutOfBoundsException exception){
//            exception.printStackTrace();
//            System.out.println(exception.getMessage());
//        }
        String end = menu.gameOver();
        if(end.equals("1")) {
            System.out.println("Game Over, thanks for playing !");
        } else {
            System.out.println("New Game Starting");
            Game game = new Game(menu);
        }
    }

    // Method event
    public void event(){
        Case currentCase = this.board.getBoard().get(this.characterPosition);
        if (currentCase instanceof EnemyCase) {
            EnemyCase enemyCase = (EnemyCase) currentCase;
//            System.out.println(enemyCase);
            String choice = "";
            while(!choice.equals("1") && !choice.equals("2")) {
                choice = menu.displayFightMenu();
                if (choice.equals("1")){
                    System.out.println("You stand your ground and face the enemy");
                    fight(enemyCase);
                } else if (choice.equals("2")) {
                    System.out.println("You flee like a weakling");
                    int roll = Dice.roll();
                    this.characterPosition = this.characterPosition - roll;
                    if (this.characterPosition < 0) {
                        this.characterPosition = 0;
                    }
                    System.out.println("You move back " + roll + " cases");
                    System.out.println("Your new position is " + (this.characterPosition + 1));
                    event();
                } else {
                    System.out.println("Error, choose again wisely");
                }
            }
        } else if (currentCase instanceof LootCase) {
            LootCase lootCase = (LootCase) currentCase;
            loot(lootCase);
        } else {
            System.out.println("This case is empty, nothing happens");
        }
    }

    // Method Loot
    public void loot(LootCase lootCase) {
        LootBox lootBox = lootCase.getLoot();
        lootAttack(lootBox.getAttackItem());
        lootDefense(lootBox.getDefenseItem());
        lootCareItem(lootBox.getCareItem());
    }

    // Method Loot Attack
    private void lootAttack(AttackEquipment attackEquipment) {
        String choice = this.menu.displayLootMenu(attackEquipment);
        if (choice.equals("1")) {
            this.myCharacter.setAttackEquipment(attackEquipment);
        }
    }

    private void lootDefense(DefenseEquipment defenseEquipment) {
        String choice = this.menu.displayLootMenu(defenseEquipment);
        if (choice.equals("1")) {
            this.myCharacter.setDefenseEquipment(defenseEquipment);
        }
    }

    private void lootCareItem(Potion potion) {
        String choice = this.menu.displayLootMenu(potion);
        if (choice.equals("1")) {
            this.myCharacter.updateHealthPoints(myCharacter.getHealthPoints() + potion.getLevel());
        }
    }

    // Method Fight
    public void fight(EnemyCase currentCase) {
        // Force Personnage
        int characterMinStrength = myCharacter.getMinStrength();
        int characterMaxStrength = myCharacter.getMaxStrength();
        int characterAddupStrength = myCharacter.getAttackEquipment().getLevel();
        // Défense Personnage
        int characterMinStamina = myCharacter.getMinStamina();
        int characterMaxStamina = myCharacter.getMaxStamina();
        int characterAddupDefense = myCharacter.getDefenseEquipment().getLevel();
        // Vie totale Personnage
        int characterHealthPoints = myCharacter.getHealthPoints();

        // Force total Ennemi
        Enemy enemy = currentCase.getEnemy();
        int enemyMinStrength = enemy.getVillain().getMinStrength();
        int enemyMaxStrength = enemy.getVillain().getMaxStrength();
        int enemyAddupStrength = enemy.getVillain().getAttackEquipment().getLevel();
        // Défense Ennemi
        int enemyMinStamina = enemy.getVillain().getMinStamina();
        int enemyMaxStamina = enemy.getVillain().getMaxStamina();
        int enemyAddupDefense = enemy.getVillain().getDefenseEquipment().getLevel();

        // Vie totale Ennemi
        int enemyHealthPoints = enemy.getVillain().getHealthPoints();

        String fightChoice = "";
        int currentAttack;
        int currentDefense;
        int damage;
        while (enemyHealthPoints > 0 && characterHealthPoints > 0) {
            fightChoice = menu.fightMenu();
            if (fightChoice.equals("1")) {
                int characterRoll = Dice.roll();
                System.out.println("***********************************************************");
                System.out.println("******************** YOUR TURN STARTED ********************");
                System.out.println("***********************************************************");
                System.out.println("It's your turn, you rolled : " + characterRoll);
                if (characterRoll == 1 || characterRoll == 2) {
                    System.out.println("Roll failed, your attack is at minimum : " + characterMinStrength);
                    currentAttack = characterMinStrength + characterAddupStrength;
                    System.out.println("Luckily for you, you have equipment ("+ characterAddupStrength +" added), your total attack is at : " + currentAttack);
                } else {
                    System.out.println("Roll is a success, your attack is at its maximum : " + characterMaxStrength);
                    currentAttack = characterMaxStrength + characterAddupStrength;
                    System.out.println("Your equipment add boost to your attack ("+ characterAddupStrength +" added), your total attack is at : " + currentAttack);
                }
                int enemyRoll = Dice.roll();
                System.out.println("The enemy defended and rolled a : " + enemyRoll);
                if (enemyRoll == 1 || enemyRoll == 2 || enemyRoll == 3) {
                    System.out.println("Roll failed, enemy defense is at minimum : " + enemyMinStamina);
                    currentDefense = enemyMinStamina + enemyAddupDefense;
                    System.out.println("If the enemy has equipment, his maximum defense is at : " + currentDefense);
                } else {
                    System.out.println("Enemy roll is a success, enemy defense is at its maximum : " + enemyMaxStamina);
                    currentDefense = enemyMaxStamina + enemyAddupDefense;
                    System.out.println("The enemy's equipment add boost to it's defense, to a total at : " + currentDefense);
                }
                damage = currentAttack - currentDefense;
                if (damage <= 0) {
                    System.out.println("Your first strike is not strong enough. No damage done on the enemy...");
                    System.out.println("******************************************************");
                    System.out.println("******************** ENEMY'S TURN ********************");
                    System.out.println("******************************************************");
                    System.out.println("it's the enemy's turn !");
                    enemyRoll = Dice.roll();
                    System.out.println("The enemy rolled a : " + enemyRoll);
                    if (enemyRoll == 1 || enemyRoll == 2 || enemyRoll == 3) {
                        System.out.println("Enemy's roll failed, enemy attack is at minimum : " + enemyMinStrength);
                        currentAttack = enemyMinStrength + enemyAddupStrength;
                        System.out.println("If the enemy has equipment, his maximum defense is at : " + currentAttack);
                    } else {
                        System.out.println("Enemy roll is a success, enemy attack is at its maximum : " + enemyMaxStrength);
                        currentAttack = enemyMaxStrength + enemyAddupStrength;
                        System.out.println("Your equipment add boost to your attack : " + currentAttack);
                    }
                    System.out.println("You defend the attack and roll the Dice : ");
                    characterRoll = Dice.roll();
                    System.out.println("you rolled : " + characterRoll);
                    if (characterRoll == 1 || characterRoll == 2) {
                        System.out.println("Roll failed, your defense is at minimum : " + characterMinStamina);
                        currentDefense = characterMinStamina + characterAddupDefense;
                        System.out.println("Luckily for you, you have equipment, your current attack is at : " + currentDefense);
                    } else {
                        System.out.println("Roll is a success, your defense is at its maximum : " + characterMaxStamina);
                        currentDefense = characterMaxStamina + characterAddupDefense;
                        System.out.println("Your equipment add boost to your attack : " + currentDefense);
                    }
                    damage = currentAttack - currentDefense;
                    if (damage <= 0) {
                        System.out.println("You parry the enemy strike and didn't get any damage");
                    } else {
                        System.out.println("The enemy's attack hits you... you took " + damage + " damage");
                        characterHealthPoints = characterHealthPoints - damage;
                        if (characterHealthPoints <= 0) {
                            System.out.println("The enemy's strike was too strong for you... you died in excruciating pain");
                            System.out.println("************************************************************");
                            System.out.println("******************** GAME OVER YOU LOSE ********************");
                            System.out.println("************************************************************");
                        } else {
                            System.out.println("You took damage, but you're strong and it's your turn to strike back !");
                            System.out.println("************************************************************");
                            System.out.println("******************** ENEMY'S TURN ENDED ********************");
                            System.out.println("************************************************************");
                        }
                    }
                } else {
                    System.out.println("The first strike hits it's target with : " + damage + " damage.");
                    enemyHealthPoints = enemyHealthPoints - damage;
                    if (enemyHealthPoints <= 0) {
                        System.out.println("The enemy is now dead, you are victorious of this fight !");
                        System.out.println("************************************************************");
                        System.out.println("******************** THE FIGHT IS ENDED ********************");
                        System.out.println("************************************************************");
                        currentCase.setEnemy(null);
                    } else {
                        System.out.println("******************************************************");
                        System.out.println("******************** ENEMY'S TURN ********************");
                        System.out.println("******************************************************");
                        System.out.println("It's the enemy's turn !");
                        enemyRoll = Dice.roll();
                        System.out.println("The enemy rolled a : " + enemyRoll);
                        if (enemyRoll == 1 || enemyRoll == 2 || enemyRoll == 3) {
                            System.out.println("Enemy's roll failed, enemy attack is at minimum : " + enemyMinStrength);
                            currentAttack = enemyMinStrength + enemyAddupStrength;
                            System.out.println("If the enemy has equipment, his maximum defense is at : " + currentAttack);
                        } else {
                            System.out.println("Enemy roll is a success, enemy attack is at its maximum : " + enemyMaxStrength);
                            currentAttack = enemyMaxStrength + enemyAddupStrength;
                            System.out.println("Your equipment add boost to your attack : " + currentAttack);
                        }
                        System.out.println("You defend the attack and roll the Dice : ");
                        characterRoll = Dice.roll();
                        System.out.println("you rolled : " + characterRoll);
                        if (characterRoll == 1 || characterRoll == 2) {
                            System.out.println("Roll failed, your defense is at minimum : " + characterMinStamina);
                            currentDefense = characterMinStamina + characterAddupDefense;
                            System.out.println("Luckily for you, you have equipment, your current attack is at : " + currentDefense);
                        } else {
                            System.out.println("Roll is a success, your defense is at its maximum : " + characterMaxStamina);
                            currentDefense = characterMaxStamina + characterAddupDefense;
                            System.out.println("Your equipment add boost to your attack : " + currentDefense);
                        }
                        damage = currentAttack - currentDefense;
                        if (damage <= 0) {
                            System.out.println("You parry the enemy strike and didn't get any damage");
                        } else {
                            System.out.println("The enemy's attack hits you... you took " + damage + " damage");
                            characterHealthPoints = characterHealthPoints - damage;
                            if (characterHealthPoints <= 0) {
                                System.out.println("The enemy's strike was too strong for you... you died in excruciating pain");
                                System.out.println("************************************************************");
                                System.out.println("******************** GAME OVER YOU LOSE ********************");
                                System.out.println("************************************************************");
                            } else {
                                System.out.println("You took damage, but you're strong and it's your turn to strike back !");
                            }
                        }
                    }
                }
            } else if (fightChoice.equals("2")) {
                System.out.println("You flee like a weakling");
                int roll = Dice.roll();
                this.characterPosition = this.characterPosition - roll;
                if (this.characterPosition < 0) {
                    this.characterPosition = 0;
                }
                System.out.println("You move back " + roll + " cases");
                System.out.println("Your new position is " + (this.characterPosition + 1));
                event();
            } else {
                System.out.println("Error, choose again wisely");
            }


//            System.out.println("You strike " + totalCharacterStrength);
//            if (totalCharacterStrength >= totalEnemyHealthPoints) {
//                totalEnemyHealthPoints = 0;
//                System.out.println("The enemy is dead, you win the fight");
//                currentCase.setEnemy(null);
//            } else {
//                System.out.println("The enemy strike back : " + totalEnemyStrength);
//                totalEnemyHealthPoints = totalEnemyHealthPoints - totalCharacterStrength;
//                if (totalEnemyStrength >= totalCharacterHealthPoints) {
//                    totalCharacterHealthPoints = 0;
//                    System.out.println("You are dead, game over, you lose");
//                } else {
//                    totalCharacterHealthPoints = totalCharacterHealthPoints - totalEnemyStrength;
//                }
//            }
        }
    }
}