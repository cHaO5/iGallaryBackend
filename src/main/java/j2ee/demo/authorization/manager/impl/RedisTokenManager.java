package j2ee.demo.authorization.manager.impl;

import j2ee.demo.authorization.manager.TokenManager;
import j2ee.demo.authorization.model.TokenModel;
import j2ee.demo.configuration.Constants;
import j2ee.demo.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储和验证token的实现类
 * @see TokenManager
 */
@Component
public class RedisTokenManager implements TokenManager {

    private RedisTemplate<Integer, String> redis;

    @Autowired
    public void setRedis(@Qualifier("redisTemplate") RedisTemplate redis) {
        this.redis = redis;
        //泛型设置成Integer后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    public TokenModel createToken(Integer userId) {
        //使用uuid作为源token
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String token = null;
        try {
            token = Base64Utils.encode(userId + "_" + uuid);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("生成token错误");
        }
        TokenModel model = new TokenModel(userId, token);
        //存储到redis并设置过期时间
        redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }

        String[] param = new String[0];
        try {
            param = Base64Utils.decode(authentication).split("_");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        if (param.length != 2) {
            return null;
        }

        //使用userId和源token简单拼接成的token，可以增加加密措施
        Integer userId = Integer.parseInt(param[0]);
        return new TokenModel(userId, authentication);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redis.boundValueOps(model.getUserId()).get();
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(Integer userId) {
        redis.delete(userId);
    }
}
