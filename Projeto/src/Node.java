import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Node implements Runnable{

	private File f;
	private CloudByte[] cbv = new CloudByte[100];	

	public Node(File f){
		this.f = f;

	}

	public Node(){
	try {
		Scanner scanner = new Scanner(f);
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void run() {

	}
}
