package lesson02;

import java.io.*;

public class OlegTask5_2 {
    /* Оператор ветвления if - else - if */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;

        name = br.readLine();

        if (name.equalsIgnoreCase("вася")){
                System.out.println("Привет!");
                System.out.println("Я тебя так долго ждал.");
        } else if (name.equalsIgnoreCase("анастасия")) {
            System.out.println("Я тебя так долго ждал.");
        } else {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}
