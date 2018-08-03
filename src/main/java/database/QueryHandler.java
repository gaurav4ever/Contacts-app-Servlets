package database;


import common.Constants;

public class QueryHandler {


    public static String getCreateTableQuery() {
        return "CREATE TABLE IF NOT EXISTS " + Constants.TABLE_NAME + "("
                + Constants.ID + " INTEGER PRIMARY KEY AUTO_INCREMENT," + Constants.USER_NAME + " VARCHAR(25)," + Constants.MOBILE_NUMBER
                + " VARCHAR(10)," + Constants.ADDRESS + " VARCHAR(40)," + Constants.IMG_PATH + " VARCHAR(200), " + Constants.IMG_NAME +
                " VARCHAR(200), " + Constants.IMG_SERVER_PATH + " VARCHAR(200))";
    }

    public static String getDropTableQuery() {
        return "DROP TABLE IF EXISTS " + Constants.TABLE_NAME;
    }

    public static String getInsertQuery() {
        return "INSERT INTO " + Constants.TABLE_NAME +
                "( " + Constants.USER_NAME + ", " +
                Constants.MOBILE_NUMBER + ", " +
                Constants.ADDRESS + ", " +
                Constants.IMG_PATH + ", " +
                Constants.IMG_NAME + ", " +
                Constants.IMG_SERVER_PATH +
                " ) VALUES(?,?,?,?,?,?)";
    }

    public static String getSelectAllQuery() {
        return "SELECT * FROM " + Constants.TABLE_NAME;
    }

    public static String getDeleteImageQuery(int id) {
        return "DELETE FROM " + Constants.TABLE_NAME + " WHERE " + Constants.ID + " = " + id;
    }

    public static String getImagePathQuery(int id) {
        return "SELECT " + Constants.IMG_PATH + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.ID + " = " + id;
    }

    public static String getImagePathQuery(String imgName) {
        return "SELECT " + Constants.IMG_PATH + " FROM " + Constants.TABLE_NAME + " WHERE " + Constants.IMG_NAME + " = '" + imgName +"'";
    }

    public static String getClearContactImageQuery(int id) {
        return "UPDATE " + Constants.TABLE_NAME + " SET " + Constants.IMG_PATH + " = '' WHERE " + Constants.ID + " = " + id;
    }
}
