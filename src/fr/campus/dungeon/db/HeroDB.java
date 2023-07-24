package fr.campus.dungeon.db;

import fr.campus.dungeon.characters.heros.Hero;
import fr.campus.dungeon.characters.heros.Warrior;
import fr.campus.dungeon.characters.heros.Wizard;

import java.sql.*;

public class HeroDB {
    ConnectDB connectDB = new ConnectDB();

    public HeroDB(){}

    public Hero newHero() {
        Connection con = connectDB.getCon();

        ResultSet resultSet = null;
        String preparedQuery = "INSERT INTO hero " +
                " (hero_class, name, health_points, strength, offensive_equipment, defensive_equipment) " +
                " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(preparedQuery);

            preparedStatement.setString(1, "Warrior");

            int results = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
        }

        return null;
    }

    public Hero showHero() {
        Connection con = connectDB.getCon();

        ResultSet results = null;
        String query = "SELECT * FROM hero";
        try {
            Statement stmt = con.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                String name = results.getString("name");
                String heroClass = results.getString("hero_class");
                int healthPoints = results.getInt("health_points");
                int strength = results.getInt("strength");
//                AttackEquipment offensiveEquipment = results.getObject("offensive_equipment", AttackEquipment.class);
//                DefenseEquipment defenseEquipment = results.getObject("defensive_equipment", DefenseEquipment.class);
                Hero hero;
                if (heroClass.equals("Warrior")) {
                    hero = new Warrior(name);
                } else {
                    hero = new Wizard(name);
                }
                hero.setHealthPoints(healthPoints);
                hero.setStrength(strength);
//                hero.setAttackEquipment(offensiveEquipment);
//                hero.setDefenseEquipment(defenseEquipment);

                return hero;
            }
        } catch (SQLException e) {
            //traitement de l'exception
            e.printStackTrace();
        }
        return null;
    }
}
