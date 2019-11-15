package com.jyyr.ssm.tools;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class MD5 {

    /**
     * 对密码进行加密
     *
     * @param salt 盐值
     * @param src 原文
     * @return 加密后密码
     */
    public static String getEncrpytedPassword(String src, String salt) {
        // 将原密码加密
        String s1 = md5(src);
        // 再将盐加密
        String s2 = md5(salt);
        // 将2次加密结果拼接，在加密
        String s3 = s1 + s2;
        String result = md5(s3);
        // 将以上结果在加密5次
        for (int i = 0; i < 5; i++) {
            result = md5(result);
        }
        return result;
    }

    /**
     * 获取随机的盐值
     *
     * @return 盐
     */
    public static String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 使用md5算法对数据进行加密
     *
     * @param src 原文
     * @return 密文
     */
    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();
    }


    public static void main(String[] args) {
        String password = "qwe123";
        String salt = getRandomSalt();
        System.out.println("managersalt = "+salt);
        password = getEncrpytedPassword(password,salt);
        System.out.println("加密后的密码 = "+password);
        /*managersalt = 56233497-1483-4BE9-9A11-D0CD4C0F8A93
        加密后的密码 = DF49395959305B413B66C56AF619CDE9*/
    }
}
