package model;

import java.util.HashMap;

public class ContactModelWrapper {
    private String imgPath;
    private HashMap<String, String> fieldMap;

    public ContactModelWrapper(String imgPath, HashMap<String, String> fieldMap) {
        this.imgPath = imgPath;
        this.fieldMap = fieldMap;
    }

    public String getImgPath() {
        return imgPath;
    }

    public HashMap<String, String> getFieldMap() {
        return fieldMap;
    }
}
