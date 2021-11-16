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

	public Node(String IP_Dir, int port_dir, int port_node, String FileName){
		File f = new File(FileName);
		try {
			byte[] fileContents= Files.readAllBytes(f.toPath());
			for(int i=0; i<fileContents.length; i++) {
				cbv[i] = new CloudByte(fileContents[i]);
				System.out.println(cbv[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		InjectError();
	}

	public Node(){

	}

	public void InjectError() {
		Scanner scanner = new Scanner(System.in);
		int a = 0;
		while(true) {
			String line = scanner.next();
			System.out.println("ENTREI NO WHILE");
			if(line.equals("ERROR")) {
				System.out.println("ENTREI NO IF #1");
				if (scanner.hasNextInt()) {
					System.out.println("ENTREI NO IF #2");
					line = scanner.next();
					try {
						a = Integer.parseInt(line);
						System.out.println("Bit antes: " + cbv[a]);
						cbv[a].makeByteCorrupt();
						System.out.println("CORRUMPI O BIT " + a);
						System.out.println("Bit depois: " + cbv[a]);
					} catch (NumberFormatException e) {
						break;
					}
				}
			}
		}
		scanner.close();
	}



	@Override
	public void run() {

	}
}