package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class File {
    private final String path;
    public File(String path){
        this.path = path;
    }
    public void Input(String inputend, boolean chk){
        try {
            FileWriter writer = new FileWriter(path, chk);
            String line;
            boolean firstline = false;
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine();
            while (!line.equals(inputend)) {
                if (firstline)
                    writer.write("\n");
                writer.write(line);
                line = scanner.nextLine();
                firstline = true;
            }
            writer.flush();
            writer.close();
        }
        catch (IOException ignored){}
    }
    public void Output() {
        try {
            FileReader reader = new FileReader(path);
            Scanner scanner = new Scanner(reader);
            System.out.print("\"");
            while (scanner.hasNextLine()) {
                System.out.print(scanner.nextLine());
                if (scanner.hasNextLine())
                    System.out.print("\n");
                else
                    System.out.print("\"");
            }
            reader.close();
        }
        catch (IOException ignored){}
    }
}
public class Main {
    public static void main(String[] args){
        String path = "C:\\Users\\Home\\Desktop\\text.txt";
        File myFile = new File(path);
        System.out.println("Запись в файл с клавиатуры(введите #, чтобы закончить ввод):");
        myFile.Input("#", true);
        System.out.println("\nСодержимое файла:");
        myFile.Output();
        System.out.println("\n\nПерезапись файла(введите #, чтобы закончить ввод):");
        myFile.Input("#", false);
        System.out.println("\nСодержимое файла:");
        myFile.Output();
        System.out.println("\n\nЗапись в конец файла(введите #, чтобы закончить ввод):");
        myFile.Input("#", true);
        System.out.println("\nСодержимое файла:");
        myFile.Output();
    }
}