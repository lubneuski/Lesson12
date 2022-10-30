import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)  {
        task1();
//        task2();

        scn.close();
    }

    private static void task1() {
        String list;
        System.out.println("Введите путь к файлу:");
        scn.hasNextLine();
        String url = scn.nextLine();
        try {
            list = Files.readString(Path.of(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);
    }
}