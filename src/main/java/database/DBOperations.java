package database;

import common.Constants;
import model.ContactModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    public static void createTable() {
        try {
            Statement stmt = DBConnection.getConnection().createStatement();
            stmt.execute(QueryHandler.getCreateTableQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Statement stmt = DBConnection.getConnection().createStatement();

            stmt.execute(QueryHandler.getDropTableQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addContact(ContactModel contact) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(QueryHandler.getInsertQuery());
            statement.setString(1, contact.name);
            statement.setString(2, contact.number);
            statement.setString(3, contact.address);
            statement.setString(4, contact.imgPath);
            statement.setString(5, contact.imgName);
            statement.setString(6, contact.serverImageUrl);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteContact(int id) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(QueryHandler.getDeleteImageQuery(id));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getContactImage(int id) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(QueryHandler.getImagePathQuery(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString(Constants.IMG_PATH);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<ContactModel> getAllContact() {
        List<ContactModel> contactModels = new ArrayList<>();
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(QueryHandler.getSelectAllQuery());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ContactModel contactModel = new ContactModel();
                contactModel.id = resultSet.getInt(Constants.ID);
                contactModel.name = resultSet.getString(Constants.USER_NAME);
                contactModel.number = resultSet.getString(Constants.MOBILE_NUMBER);
                contactModel.address = resultSet.getString(Constants.ADDRESS);
                contactModel.serverImageUrl = resultSet.getString(Constants.IMG_SERVER_PATH);
                contactModels.add(contactModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactModels;
    }

    public static void clearContactImg(int id) {
        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(QueryHandler.getClearContactImageQuery(id));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getContactImagePath(String imgName) {
        try {
            ResultSet resultSet = DBConnection.getConnection()
                    .prepareStatement(QueryHandler.getImagePathQuery(imgName))
                    .executeQuery();
            while (resultSet.next()) {
                return resultSet.getString(Constants.IMG_PATH);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
