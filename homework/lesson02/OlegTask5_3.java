package lesson02;

import java.io.*;

public class OlegTask5_3 {
    /* Оператор ветвления switch - case */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;

        name = br.readLine();

        switch (name.toLowerCase()){
            case "вася":
                System.out.println("Привет!");
            case "анастасия":
                System.out.println("Я тебя так долго ждал.");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
                break;
        }
    }
}
