import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();

        scn.close();
    }

    private static void task1() {
        System.out.println("Введите путь к файлу:");
        scn.hasNextLine();
        String url = scn.nextLine();
        try {
             BufferedReader br = new BufferedReader(new FileReader(url));
             String line;
             while ((line = br.readLine()) != null) {
                System.out.println(line);
             }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void task2() {
        String url = "src/AlexLu";
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(url));
            BufferedWriter bwV = new BufferedWriter(new FileWriter("src/valid.txt"));
            BufferedWriter bwIV = new BufferedWriter(new FileWriter("src/invalid.txt"));
            while ((line = br.readLine()) != null) {
                if (line.matches("[A-Za-z0-9]+")&&line.length()==15&&(line.startsWith("contract")||line.startsWith("docnum"))) {
                    bwV.write(line + "\n");
                    bwV.flush();
                }
                else {
                    if (line.length()==15&&(!(line.startsWith("contract")||line.startsWith("docnum")))) {
                        bwIV.write(line+" - не начинается с нужной последовательности\n");
                    bwIV.flush();
                    System.out.println(line);
                    }else if (!line.matches("[A-Za-z0-9]+")) {
                        bwIV.write(line + " - содержит недопустимые символы\n");
                        bwIV.flush();
                    }
                    else {
                        bwIV.write(line + " - не состоит из пятнадцати символов\n");
                        bwIV.flush();
                    }
                }
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}