package geoipredis.redis;

/**
 * User: Marushevskiy L.
 * Date: 05.01.13
 * Time: 23:38
 */

public class ValidateUtil {

    public static boolean checkNullOrEmptyString(String val) {

        if (val == null || val.isEmpty() || val.equals("null")) {
            return true;
        }

        return false;
    }

    public static boolean checkNull(Object obj) {
        return obj == null;
    }
}
