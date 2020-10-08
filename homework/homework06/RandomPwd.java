package homework06;

import java.util.Random;

public class RandomPwd {
     public static String nextPwd(){
        final char[] str = ("abcdefghijklmnopqrstuvwxyz" +
                "0123456789" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789").toCharArray();

        Random rnd = new Random();

        int length = rnd.nextInt(6) + 5;
        StringBuilder strPassword = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            strPassword.append(str[rnd.nextInt(str.length)]);
        }
        return strPassword.toString();
    }
}
