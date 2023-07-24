package fr.campus.dungeon.db;

import com.google.gson.Gson;
import fr.campus.dungeon.characters.Character;
import fr.campus.dungeon.characters.heros.Hero;
import fr.campus.dungeon.characters.heros.Warrior;
import fr.campus.dungeon.characters.heros.Wizard;
import fr.campus.dungeon.equipments.defense.DefenseEquipment;
import fr.campus.dungeon.equipments.offense.AttackEquipment;

import java.sql.*;

public class HeroDB {
    public HeroDB(){}

    public static void newHero(Character myCharacter) {
        ConnectDB connectDB = new ConnectDB();
        Connection con = connectDB.getCon();

//        ResultSet resultSet = null;
        String preparedQuery = "INSERT INTO hero " +
                " (hero_class, name, health_points, strength, offensive_type, offensive_equipment,defensive_type, defensive_equipment) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(preparedQuery);

            preparedStatement.setString(1, myCharacter.getClass().getSimpleName());
            preparedStatement.setString(2, myCharacter.getName());
            preparedStatement.setInt(3, myCharacter.getHealthPoints());
            preparedStatement.setInt(4, myCharacter.getStrength());
            preparedStatement.setString(5, myCharacter.getAttackEquipment().getClass().getName());
            Gson gson = new Gson();
            String jsonAttackEquipment = gson.toJson(myCharacter.getAttackEquipment());
            preparedStatement.setString(6, jsonAttackEquipment);
            preparedStatement.setString(7, myCharacter.getDefenseEquipment().getClass().getName());
            String jsonDefenseEquipment = gson.toJson(myCharacter.getDefenseEquipment());
            preparedStatement.setString(8, jsonDefenseEquipment);

            int results = preparedStatement.executeUpdate();

            System.out.println(results + " Character saved");
        } catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void updateHero(Character myCharacter) {
        ConnectDB connectDB = new ConnectDB();
        Connection con = connectDB.getCon();

//        ResultSet resultSet = null;
        String preparedQuery = "UPDATE hero SET offensive_equipment = ?, defensive_equipment = ? WHERE name = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(preparedQuery);
            Gson gson = new Gson();
            String jsonAttackEquipment = gson.toJson(myCharacter.getAttackEquipment());
            preparedStatement.setString(1, jsonAttackEquipment);
            String jsonDefenseEquipment = gson.toJson(myCharacter.getDefenseEquipment());
            preparedStatement.setString(2, jsonDefenseEquipment);
            preparedStatement.setString(3, myCharacter.getName());

            int results = preparedStatement.executeUpdate();

            System.out.println(results + " Character modified and saved");
        } catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Hero showHero() {
        ConnectDB connectDB = new ConnectDB();
        Connection con = connectDB.getCon();

        ResultSet results = null;
        String query = "SELECT * FROM hero";
        try {
            Statement stmt = con.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()) {
                String name = results.getString("name");
                String heroClass = results.getString("hero_class");
                int healthPoints = results.getInt("health_points");
                int strength = results.getInt("strength");
                String offenseType = results.getString("offensive_type");
                Gson gson = new Gson();
                String jsonAttackEquipmentInString = results.getString("offensive_equipment");
                AttackEquipment offensiveEquipment = (AttackEquipment) gson.fromJson(jsonAttackEquipmentInString, Class.forName(offenseType));
                String defenseType = results.getString("defensive_type");
                String jsonDefenseEquipmentInString = results.getString("defensive_equipment");
                DefenseEquipment defenseEquipment = (DefenseEquipment) gson.fromJson(jsonDefenseEquipmentInString, Class.forName(defenseType));
                Hero hero;
                if (heroClass.equals("Warrior")) {
                    hero = new Warrior(name);
                } else {
                    hero = new Wizard(name);
                }
                hero.setHealthPoints(healthPoints);
                hero.setStrength(strength);
                hero.setAttackEquipment(offensiveEquipment);
                hero.setDefenseEquipment(defenseEquipment);

                return hero;
            }
        } catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
