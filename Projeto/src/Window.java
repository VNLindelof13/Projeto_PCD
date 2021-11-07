import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Window {

	private JFrame frame;

	public Window() {

		frame = new JFrame("Client");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		
		frame.pack();
	}

	public void open() {
		frame.setVisible(true);
	}

	private void addFrameContent() {
		//	frame.setLayout(new GridLayout(1,3));
		frame.setLayout(new BorderLayout());
		
		Container t = new Container();
		t.setLayout(new FlowLayout());

		JLabel label = new JLabel("Posição a consultar:");
		t.add(label);

		JTextField position = new JTextField("1000");
		position.setPreferredSize( new Dimension(100,20));;
		t.add(position);

		JLabel label2 = new JLabel("Comprimento:");
		t.add(label2);

		JTextField length = new JTextField("10");
		length.setPreferredSize( new Dimension(100,20));;
		t.add(length);

		JButton button = new JButton("Consultar");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//	JOptionPane.showMessageDialog(frame, check.isSelected() ? "checked" : "not checked");

			}
		});
		t.add(button);	
		
		frame.add(t, BorderLayout.NORTH);
		
		JTextField response = new JTextField("Respostas aparecerão aqui...");
		response.setPreferredSize( new Dimension(frame.getWidth(),70));;
		frame.add(response, BorderLayout.CENTER);
//		frame.add(response, BorderLayout.SOUTH);
		
// 		TENTATIVA DE CENTRAR O TITULO
		
//		FontMetrics fm = frame.getFontMetrics(frame.getFont());
//		int frameWidth = frame.getWidth();
//      int titleWidth = fm.stringWidth("Cliente");
//      int spaceWidth = fm.stringWidth(" ");
//      int centerPos = (frameWidth / 2) - (titleWidth / 2);
//      int spaceCount = centerPos / spaceWidth;
//      String pad = "";
//      pad = String.format("%" + (spaceCount - 14) + "s", pad);
//      frame.setTitle(pad + "Cliente");

		


	}

	public static void main(String[] args) {
		Window window = new Window();
		window.open();
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		
	}


}