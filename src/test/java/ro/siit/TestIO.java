package ro.siit;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestIO {
    @Test
    public void test_copy_byte(){
        String fileName = "out.png";
        File out = new File(fileName);
        int i = 1;
        while(out.exists()){
            fileName = "out_" + i++ + ".png";
            out = new File(fileName);
        }
        try(FileInputStream fileInputStream = new FileInputStream("in.png");
                FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
            int chunk;
            while((chunk = fileInputStream.read()) != -1){
                fileOutputStream.write(chunk);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not accessible");
        }
    }

    @Test
    public void test_copy_char(){
        try(FileReader fileReader = new FileReader("LICENSE");
        FileWriter fileWriter = new FileWriter("LICENSE_BK")){
            int character;
            while((character = fileReader.read()) != -1){
                fileWriter.write(character);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_buffered_read_write(){
        try(BufferedReader reader = new BufferedReader(new FileReader("LICENSE"));
        PrintWriter writer = new PrintWriter(new FileWriter("LICENSE_BK"))){
            String line;
            while((line = reader.readLine()) != null){
                writer.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_write_object(){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("data.obj"))){
            writer.writeObject(new Entitate("val1", "val2", new Subentitate()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_read_object(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("data.obj"))){
            Entitate e = (Entitate)reader.readObject();
            System.out.println(e.getP1());
            System.out.println(e.getP2());
            System.out.println(e.getP3());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_copy_nio(){
        Path input = Paths.get("LICENSE");
        Path output = Paths.get("LICENSE_BK");
        try {
            Files.copy(input, new FileOutputStream(output.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_readLines_nio() throws IOException {
        Path input = Paths.get("LICENSE");
        List<String> lines = Files.readAllLines(input, Charset.forName("utf-8"));
        System.out.println(lines.get(7));
    }
}
