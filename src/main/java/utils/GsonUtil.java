package utils;

import com.google.gson.Gson;

public class GsonUtil {

    private static Gson gson;

    private static Gson getGsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static String getJson(Object o) {
        return getGsonInstance().toJson(o);
    }
}
