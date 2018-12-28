package katil508;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Baslangic_Ekrani extends JPanel implements ActionListener {
	
	Image kapak;
	int kapak_x,kapak_y,kapak_yuk,kapak_gen;
	
	ImageIcon icon;
	JButton basla = new JButton("Baþla");
	
	static JFrame pencere = new JFrame("KOD ADI 508");
	static JFrame pencere2 = new JFrame("KOD ADI 508");
	
	
	public Baslangic_Ekrani(){
		
		kapak_x=0;
		kapak_y=0;
		kapak_gen=700;
		kapak_yuk=900;
		
		kapak=Toolkit.getDefaultToolkit().getImage(getClass().getResource("kapak.jpg"));
		pencere.setBounds(0,0,700,900);
		pencere.add(this);
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		icon=new ImageIcon(kapak);

		basla.addActionListener(this);
		this.add(basla);
		
		pencere.setVisible(true);
		
	}
	
	public void paint (Graphics g)
	{
		g.drawImage(kapak,kapak_x,kapak_y,kapak_gen,kapak_yuk, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0){
		Deniz d= new Deniz();
		pencere2.add(d);
		pencere2.setResizable(false);
		pencere2.setSize(1200,650);
		pencere2.setVisible(true);
		pencere2.addKeyListener(d);
		pencere2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pencere.setVisible(false);
	}
}
