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
    public void updateCharacter() {
        // appelé
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
        System.out.println(this.characterPosition);
        int length = this.board.getBoard().size();
//        try {
            while (this.characterPosition < length) {
                String userChoice = menu.displayGameMenu();
                if (userChoice.equals("1")) {
                    int roll = Dice.roll();
                    System.out.println("you rolled : " + roll);
                    this.characterPosition = this.characterPosition + roll;
                    if (this.characterPosition > length) {
                        this.characterPosition = length;
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
        // Force totale Personnage
        int characterStrength = myCharacter.getStrength();
        int characterAddupStrength = myCharacter.getAttackEquipment().getAttackLevel();
        int totalCharacterStrength = characterStrength + characterAddupStrength;
        // Vie totale Personnage
        int characterHealthPoints = myCharacter.getHealthPoints();
        int characterAddupHealthPoints = myCharacter.getDefenseEquipment().getLevel();
        int totalCharacterHealthPoints =  characterHealthPoints + characterAddupHealthPoints;

        // Force total Ennemi
        Enemy enemy = currentCase.getEnemy();
        int enemyStrength = enemy.getVillain().getStrength();
        int enemyAddupStrength = enemy.getVillain().getAttackEquipment().getAttackLevel();
        int totalEnemyStrength = enemyStrength + enemyAddupStrength;
        // Vie totale Ennemi
        int enemyHealthPoints = enemy.getVillain().getHealthPoints();
        int enemyAddupHealthPoints = enemy.getVillain().getDefenseEquipment().getLevel();
        int totalEnemyHealthPoints = enemyHealthPoints + enemyAddupHealthPoints;

        while (totalEnemyHealthPoints > 0 && totalCharacterHealthPoints > 0) {
            System.out.println("You strike " + totalCharacterStrength);
            if (totalCharacterStrength >= totalEnemyHealthPoints) {
                totalEnemyHealthPoints = 0;
                System.out.println("The enemy is dead, you win the fight");
                currentCase.setEnemy(null);
            } else {
                System.out.println("The enemy strike back : " + totalEnemyStrength);
                totalEnemyHealthPoints = totalEnemyHealthPoints - totalCharacterStrength;
                if (totalEnemyStrength >= totalCharacterHealthPoints) {
                    totalCharacterHealthPoints = 0;
                    System.out.println("You are dead, game over, you lose");
                } else {
                    totalCharacterHealthPoints = totalCharacterHealthPoints - totalEnemyStrength;
                }
            }
        }
    }
}