package eu.rexo.secondplugin.Utils;

import java.sql.*;

import eu.rexo.secondplugin.Utils.*;

public class DBManager {
    public void createTable() {
        try(Statement statement = Database.getStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PRICHODY " +
                    "(`id` INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(16) NOT NULL, " +
                    "uuid VARCHAR(64) NOT NULL, " +
                    "prichod VARCHAR(255) NOT NULL DEFAULT '')");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS ODCHODY " +
                    "(`id` INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(16) NOT NULL, " +
                    "uuid VARCHAR(64) NOT NULL, " +
                    "odchod VARCHAR(255) NOT NULL DEFAULT '')");
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void pridatPrichod(String jmeno, String uuid, String prichod) {
        try (Statement statement = Database.getStatement()) {
            statement.executeUpdate("INSERT INTO prichody (name, uuid, prichod) VALUES " +
                    "('" + jmeno + "', '" + uuid + "', '" + prichod + "')");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String[] ziskatPrichody(String jmeno) throws SQLException {
        String[] prichody = new String[10];

        Statement xstatement = Database.getStatement();
        Connection connection = xstatement.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT prichod FROM prichody WHERE name = ?")) {
            statement.setString(1, jmeno);

            try (ResultSet resultSet = statement.executeQuery()) {
                int i = 0;
                while (resultSet.next()) {
                    String prichod = resultSet.getString("prichod");
                    prichody[i] = prichod;
                    i++;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return prichody;
    }

    public void pridatOdchod(String jmeno, String uuid, String odchod) {
        try (Statement statement = Database.getStatement()) {
            statement.executeUpdate("INSERT INTO odchody (name, uuid, odchod) VALUES ('" + jmeno + "', '" + uuid + "', '" + odchod + "')");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String[] ziskatOdchody(String jmeno) throws SQLException {
        String[] odchody = new String[10];

        Statement xstatement = Database.getStatement();
        Connection connection = xstatement.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT odchod FROM odchody WHERE name = ?")) {
            statement.setString(1, jmeno);

            try (ResultSet resultSet = statement.executeQuery()) {
                int i = 0;
                while (resultSet.next()) {
                    String odchod = resultSet.getString("odchod");
                    odchody[i] = odchod;
                    i++;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return odchody;
    }
}
