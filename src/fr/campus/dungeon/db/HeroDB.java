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
                " (hero_class, name, health_points, min_strength, max_strength, min_stamina, max_stamina, offensive_type, offensive_equipment,defensive_type, defensive_equipment) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(preparedQuery);

            preparedStatement.setString(1, myCharacter.getClass().getSimpleName());
            preparedStatement.setString(2, myCharacter.getName());
            preparedStatement.setInt(3, myCharacter.getHealthPoints());
            preparedStatement.setInt(4, myCharacter.getMinStrength());
            preparedStatement.setInt(5, myCharacter.getMaxStrength());
            preparedStatement.setInt(6, myCharacter.getMinStamina());
            preparedStatement.setInt(7, myCharacter.getMaxStamina());
            preparedStatement.setString(8, myCharacter.getAttackEquipment().getClass().getName());
            Gson gson = new Gson();
            String jsonAttackEquipment = gson.toJson(myCharacter.getAttackEquipment());
            preparedStatement.setString(9, jsonAttackEquipment);
            preparedStatement.setString(10, myCharacter.getDefenseEquipment().getClass().getName());
            String jsonDefenseEquipment = gson.toJson(myCharacter.getDefenseEquipment());
            preparedStatement.setString(11, jsonDefenseEquipment);

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
                int minStrength = results.getInt("min_strength");
                int maxStrength = results.getInt("max_strength");
                int minStamina = results.getInt("min_stamina");
                int maxStamina = results.getInt("min_stamina");
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
                hero.setMinStrength(minStrength);
                hero.setMaxStrength(maxStrength);
                hero.setMinStamina(minStamina);
                hero.setMaxStamina(maxStamina);
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
