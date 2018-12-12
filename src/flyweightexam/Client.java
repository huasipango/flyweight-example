/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweightexam;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author israt
 */
public class Client extends JFrame {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	private static final String shapes[] = { "R", "O" };
	private static final Color colors[] = { Color.red, Color.green, Color.blue };
	private static final boolean fill[] = { true, false };
	private static final String font[] = { "Arial", "Courier" };

	public Client() {
		Container contentPane = getContentPane();

		JButton startButton = new JButton("Dibujar Figuras");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
                
                //Ubica la ventana en la mitad
                Toolkit toolkit = Toolkit.getDefaultToolkit();  
                Dimension screenSize = toolkit.getScreenSize();   
                int x = (screenSize.width - getWidth()) / 2;  
                int y = (screenSize.height - getHeight()) / 2;  
                
                setLocation(x, y); 

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Graphics g = panel.getGraphics();
				for (int i = 0; i < 100; ++i) {
					MyShape shape = ShapeFactory.getShape(getRandomShape());
					shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
							getRandomHeight(), getRandomColor(),
							getRandomFill(), getRandomFont());
                                        System.out.println(i);
				}
			}
		});
	}

	private String getRandomShape() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() {
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 7));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 7));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private boolean getRandomFill() {
		return fill[(int) (Math.random() * fill.length)];
	}

	private String getRandomFont() {
		return font[(int) (Math.random() * font.length)];
	}

	public static void main(String[] args) {
		Client client = new Client();
	}
}
