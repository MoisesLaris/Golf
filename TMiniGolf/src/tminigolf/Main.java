package tminigolf;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame {

	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Main m = new Main();
                m.setVisible(true);
                
            }
        });
	}
	
	public Main() {
               
                add(new JuegoLogica());        
                setResizable(false);
                pack();        
                setTitle("MiniGolf");
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
