import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.lang.Integer;
import java.net.InetAddress;
import java.net.Socket;

import javax.sound.sampled.Line;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Node implements Runnable{
	private BufferedReader input;
	private PrintWriter output;
	private Socket socket;
	private CloudByte[] cbv = new CloudByte[1000000];
	private int port_dir;
	private int port_node;
	private String IP_node;


	public Node(String IP_node, int port_dir, int port_node, String FileName) throws IOException{
		this.port_dir = port_dir;
		this.port_node = port_node;
		this.IP_node = IP_node;
		File f = new File(FileName);
		try {
			byte[] fileContents= Files.readAllBytes(f.toPath());
			for(int i=0; i<fileContents.length; i++) {
				cbv[i] = new CloudByte(fileContents[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		connectToServer();
		sendMessages();
		output.println("nodes");
		String str = input.readLine();
		System.out.println(str);
		injectError();


	}

	public Node(){

	}

	public void injectError() {
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
						System.out.println("Byte antes: " + cbv[a]);
						cbv[a].makeByteCorrupt();
						System.out.println("CORRUMPI O BYTE " + a);
						System.out.println("Byte depois: " + cbv[a]);
					} catch (NumberFormatException e) {
						break;
					}
				}
			}
		}
		scanner.close();
	}

	void connectToServer() throws IOException {
		//		InetAddress endereco = InetAddress.getByName("127.0.0.1");
		InetAddress endereco = InetAddress.getByName(InetAddress.getLocalHost().getHostName());
		System.out.println("Endereco:" + endereco);
		System.out.println("Porto: " + port_dir);
		socket = new Socket(endereco, port_dir);
		System.out.println("Socket:" + socket);
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),	true);
	}


	void sendMessages() throws IOException {
		output.println("INSC " + IP_node + " " + port_node);
		String str = input.readLine();
		System.out.println(str);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {//...  
		}

		output.println("FIM");
	}



	@Override
	public void run() {

	}
}