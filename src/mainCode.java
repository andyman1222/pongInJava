

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class mainCode extends JPanel{
	public static square player1=new square(0,"player1");
	public static square player2=new square(975,"player2");
	public static boolean gameOn = false;
	static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static circle circle1=new circle();
	public void paint(Graphics g){
		tick(g);
		g.setColor(Color.white);
		player1.initialize(g);
		player2.initialize(g);
		circle1.initialize(g);
		g.setFont(new Font("Courier New",Font.BOLD,20));
		if(!gameOn) g.drawString("PONG", 250, 250);
		g.drawString(player1.pointsString + "-" + player2.pointsString,500,500);
		repaint();
	}
	public static void main(String[] args) {
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./sanstaina.ttf")));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame frame=new JFrame("Pong");
		frame.add(new mainCode());
		//frame.add(mainCode.player());
		frame.setSize(1050, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KeyPress keys=new KeyPress();
		frame.addKeyListener(keys);
		circle1.respawn((int)Math.round((Math.random()*2)+1));
	}
	public static void tick(Graphics g){
		try{Thread.sleep(0,1);}
		catch(Exception e){}
		g.setColor(Color.black);
		g.fillRect(0,0,1000,500);
		g.setColor(Color.white);
	}
	public static void addPoints(int player, int point){
		if(player==1){
			player1.points+=point;
		}
		else{
			player2.points+=point;
		}
	}
	public static void startGame(){
		circle1.respawn((int)Math.round((Math.random()*2)+1));
		player1.points = 0;
		player2.points = 0;
		gameOn = true;
	}
}
