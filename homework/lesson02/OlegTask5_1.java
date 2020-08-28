package lesson02;

import java.io.*;

public class OlegTask5_1 {
    /* Оператор ветвления if - else */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;

        name = br.readLine();

        if (name.toLowerCase().equals("вася")) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал.");
        }
        if (name.toLowerCase().equals("анастасия")) {
            System.out.println("Я тебя так долго ждал.");
        }
        if (!(name.toLowerCase().equals("вася") || name.toLowerCase().equals("анастасия"))) {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}
