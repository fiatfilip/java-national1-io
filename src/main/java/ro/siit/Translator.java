package ro.siit;

import java.io.*;

public class Translator {
    public static void main(String[] args) {
        try(BufferedReader reader =
                    new BufferedReader(new FileReader("text.txt"));
            PrintWriter writer = new PrintWriter(new FileWriter("pasareste.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                line = translate(line);
                writer.write(line + "\n");
            }
            System.out.println("gata");
            System.err.println("really");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String translate(String line){
        return  line.replace("a", "apa")
                .replace("e", "epe")
                .replace("i", "ipi")
                .replace("o", "opo")
                .replace("u", "upu");
    }
}
