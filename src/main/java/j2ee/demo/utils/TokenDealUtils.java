package j2ee.demo.utils;

import java.io.UnsupportedEncodingException;

public class TokenDealUtils {
    public static final long WRONG_TOKEN = -10000;

    public static long getIdFromToken(String authorization) throws UnsupportedEncodingException {
        String[] param = Base64Utils.decode(authorization).split("_");
        if(param.length != 2){
            return WRONG_TOKEN;
        }
        return Long.parseLong(param[0]);
    }

    public static String getSecondPartFromToken(String authorization) throws UnsupportedEncodingException {
        String[] param = Base64Utils.decode(authorization).split("_");
        if(param.length != 2){
            return null;
        }
        return param[1];
    }
}
