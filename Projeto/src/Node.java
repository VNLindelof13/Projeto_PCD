import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.lang.Integer;

import javax.sound.sampled.Line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Node implements Runnable{

    private CloudByte[] cbv = new CloudByte[1000000];

    public Node(File f){
        f = new File("data.bin");
        try {
            byte[] fileContents= Files.readAllBytes(f.toPath());
            for(int i=0; i<fileContents.length; i++) {
                cbv[i] = new CloudByte(fileContents[i]);
                System.out.println(cbv[i]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InjectError();
    }

    public Node(){

    }

    public void InjectError() {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        boolean xpto = true;
        while(true) {
            System.out.println("entrou????");
            String line = scanner.next();
            System.out.println(line);
            if(line.equals("ERROR")) {
                System.out.println(" nao d");
                line = scanner.next();
                try {
                    a = Integer.parseInt(line);
                    cbv[a].makeByteCorrupt();
                    System.out.println(cbv[a].isParityOk());
                } catch (NumberFormatException e) {
                   break;
                }
                System.out.println("Conseguimos nao dizemos asneiras");
            }
        }
        scanner.close();
    }



    @Override
    public void run() {

    }
}