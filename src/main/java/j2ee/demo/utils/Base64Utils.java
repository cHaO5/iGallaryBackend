package j2ee.demo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {
    public static String encode(String message) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(message.getBytes("utf-8"));
    }

    public static String decode(String message) throws UnsupportedEncodingException {
        return new String(Base64.getDecoder().decode(message), "utf-8");
    }
}
