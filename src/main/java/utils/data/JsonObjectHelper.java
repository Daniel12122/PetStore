package utils.data;

import org.json.simple.JSONObject;
import pojo.user.User;

public class JsonObjectHelper {
    public static String generateJSONForLogin(User user) {

        JSONObject credentials = new JSONObject();
        credentials.put("username", user.getUsername());
        credentials.put("password", user.getPassword());

        return credentials.toJSONString();
    }
}
