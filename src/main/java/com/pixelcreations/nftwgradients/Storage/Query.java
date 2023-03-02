package com.pixelcreations.nftwgradients.Storage;


import com.pixelcreations.nftwgradients.NFTWGradients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {


    NFTWGradients nftwGradients;


    String createTable = "CREATE TABLE IF NOT EXISTS `gradients` (`uuid` VARCHAR(36) NOT NULL, `player` VARCHAR(36), `gradient` VARCHAR(36) , PRIMARY KEY (`uuid`))";
    String updateGradient = "UPDATE `gradients` SET `gradient` = ? WHERE `uuid` = ?";
    String clearGradient = "UPDATE `gradients` SET `gradient` = ? WHERE `uuid` = ?";
    String checkGradient = "SELECT `gradient` FROM `gradients` WHERE `uuid` = ? AND WHERE `gradient` != null";
    public void createTable() {
        try (Connection conn = nftwGradients.getDatabaseConnection().getHikari().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(createTable);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateGradient(String gradient, String UUID) {
        try (Connection conn = nftwGradients.getDatabaseConnection().getHikari().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(updateGradient);
            statement.setString(1, gradient);
            statement.setString(2, UUID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearGradient(String UUID) {
        try (Connection conn = nftwGradients.getDatabaseConnection().getHikari().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(clearGradient);
            statement.setString(1, null);
            statement.setString(2, UUID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkGradient(String UUID) {
        try (Connection conn = nftwGradients.getDatabaseConnection().getHikari().getConnection()) {
            PreparedStatement statement = conn.prepareStatement(checkGradient);
            statement.setString(1, UUID);
            statement.executeUpdate();
            return statement.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}