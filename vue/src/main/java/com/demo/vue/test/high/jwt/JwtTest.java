package com.demo.vue.test.high.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTest {
    //设置过期时间
    private static final long EXPIRE_TIME = 240 * 60 * 1000;
    //token秘钥
    private static final String TOKEN_SECRET = "fdfdf";


    /**
     * 生成token
     * @param username
     * @param permission
     * @return token
     */
    public  String sign(String username, String permission) {
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username,password信息，生成签名
            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", username)
                    .withClaim("permission", permission)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @desc 验证token，通过返回true
     * @params [token]需要校验的串
     **/
    public  boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @desc 解密token，返回一个map
     * @params [token]需要校验的串
     **/
    public  String parseJWT(String token) {
        DecodedJWT decodeToken = JWT.decode(token);
        return decodeToken.getClaim("loginName").asString();
    }

    /**
     * @desc 判断token是否过期
     * @author lj
     */
    public  boolean isJwtExpired(String token) {

        try {
            DecodedJWT decodeToken = JWT.decode(token);
            return decodeToken.getExpiresAt().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }


}
