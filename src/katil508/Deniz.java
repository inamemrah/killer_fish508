package katil508;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Deniz extends JPanel implements ActionListener,KeyListener  {
	
	
	int arkaplan_x=0,arkaplan_y=0,arkaplan_gen=1200,arkaplan_yuk=650;
	int player_x=0,player_y=250,player_gen=120,player_yuk=100;
	int balik_x1,balik_y1,balik_gen1,balik_yuk1;
	int balik_x2,balik_y2,balik_gen2,balik_yuk2;
	int balik_x3,balik_y3,balik_gen3,balik_yuk3;
	int balik_x4,balik_y4,balik_gen4,balik_yuk4;
	int balik_x5,balik_y5,balik_gen5,balik_yuk5;
	
	Image arkaplan;
	Image k_balik;
	Image balik1;
	Image balik2;
	Image balik3;
	Image balik4;
	Image balik5;
	Timer zaman=new Timer(30,this);//her 30 snde bir ekrana biþey basýyor saniyenýn binde 30u zmanda ekraný yenýlýyor
	Random r = new Random();
	String yazim="";
	int puan =0;
	int kontrol=1;
	int sayac=0;
	int hýz=1;
	
	public Deniz(){
		
		
		super();
		balik_x1=1500;
		balik_y1=160;
		balik_gen1=85;
		balik_yuk1=50;
		
		balik_x2=balik_x1+r.nextInt(500)+200; // ikinci balýk ilk balýðýn 200 + ve 500 arasýnda gelir
		balik_y2=r.nextInt(400)+200;
		balik_gen2=100;
		balik_yuk2=60;
		
		balik_x3=balik_x2+r.nextInt(500)+200; 
		balik_y3=r.nextInt(600)+30;
		balik_gen3=100;
		balik_yuk3=100;
		
		balik_x4=balik_x3+r.nextInt(500)+200; 
		balik_y4=r.nextInt(450)+150;
		balik_gen4=180;
		balik_yuk4=80;
		
		balik_x5=balik_x4+r.nextInt(500)+200; 
		balik_y5=r.nextInt(350)+150;
		balik_gen5=65;
		balik_yuk5=65;
		
		
		
		arkaplan=Toolkit.getDefaultToolkit().getImage(getClass().getResource("1.jpg"));
		k_balik=Toolkit.getDefaultToolkit().getImage(getClass().getResource("k_balik.gif"));
		balik1=Toolkit.getDefaultToolkit().getImage(getClass().getResource("11.gif"));
		balik2=Toolkit.getDefaultToolkit().getImage(getClass().getResource("balik2.gif"));
		balik3=Toolkit.getDefaultToolkit().getImage(getClass().getResource("9.gif"));
		balik4=Toolkit.getDefaultToolkit().getImage(getClass().getResource("12.gif"));
		balik5=Toolkit.getDefaultToolkit().getImage(getClass().getResource("balik5.gif"));
		
		zaman.start();
		
		
	}
	
	
	public void paint(Graphics g)
	{
		
		//ekrana cýzdýrme
		super.paintComponent(g);
		 g.drawImage(arkaplan, arkaplan_x, arkaplan_y, arkaplan_gen,arkaplan_yuk,null);
		 g.drawImage(k_balik,player_x, player_y, player_gen,player_yuk,null);
		 g.drawImage(balik1, balik_x1, balik_y1, balik_gen1,balik_yuk1,null);
		 g.drawImage(balik2, balik_x2, balik_y2, balik_gen2, balik_yuk2, null);
		 g.drawImage(balik3, balik_x3, balik_y3, balik_gen3, balik_yuk3, null);
		 g.drawImage(balik4, balik_x4, balik_y4, balik_gen4, balik_yuk4, null);
		 g.drawImage(balik5, balik_x5, balik_y5, balik_gen5, balik_yuk5, null);
		 g.setColor(Color.WHITE);
		 
		
	//yenýden dönguye girmesi
		if(kontrol>1){
			
			int art = 0; art++;
			if (art==1){
				kontrol=1;
			}
			
		}
		
	
		
		 String puan_string = Integer.toString(puan);
		 g.setFont(new Font ("Comin Sans Ms", Font.ITALIC,50));
		 g.drawString(puan_string, 600, 50);
		 g.setFont(new Font ("Comin Sans Ms", Font.ITALIC,50));
		 g.drawString(yazim,250, 350);
 
		 	 //String sayacyaz=Integer.toString(sayac);
		 	// g.drawString(sayacyaz, 50, 50);
		
		 sayac++;
		 if(sayac%500==0){
			 
			 hýz+=1;
			 
		 }

	
		 
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Rectangle arkaplan = new Rectangle(arkaplan_x,arkaplan_y,arkaplan_gen,arkaplan_yuk);
		Rectangle k_balik =new Rectangle(player_x ,player_y,player_gen,player_yuk);
		Rectangle balik1 = new Rectangle(balik_x1,balik_y1,balik_gen1,balik_yuk1);
		Rectangle balik2 = new Rectangle(balik_x2,balik_y2,balik_gen2,balik_yuk2);
		Rectangle balik3 = new Rectangle(balik_x3,balik_y3,balik_gen3,balik_yuk3);
		Rectangle balik4 = new Rectangle(balik_x4,balik_y4,balik_gen4,balik_yuk4);
		Rectangle balik5 = new Rectangle(balik_x5,balik_y5,balik_gen5,balik_yuk5);
		
	for(int i =0;i<=8;i++){
		
		if(	 k_balik.intersects(balik4) ) // ana balýk 4.balýka çarptýgýnda durur
			
			zaman.stop();
		else{
		
			balik_x1-=hýz;
			balik_x2-=hýz;
			balik_x3-=hýz;
			balik_x4-=hýz;
			balik_x5-=hýz;
		}
		}

	if(k_balik.intersects(balik1))
	{
		
		//puan artýrma
	 if (kontrol==1)
			 
		 {
		 player_gen+=2;
		 player_yuk+=2;
		 puan=puan+8;
		 kontrol++;
		 }
	 balik_x1=1500;
		
	
		
		
		
	}
	
	if(k_balik.intersects(balik2)){
		
		if (kontrol==1)
			 
		 {
			 player_gen+=2;
			 player_yuk+=2;
		 puan=puan+12;
		 kontrol++;
		 }
		balik_x2=1300+r.nextInt(500)+200;
 
 
	}
		if(k_balik.intersects(balik3)){
			
			 if (kontrol==1)
				 
			 {
				 player_gen+=2;
				 player_yuk+=2;
			 puan=puan+6;
			 kontrol++;
			 }
			 balik_x3=1300+r.nextInt(500)+200; 
		}
			if(k_balik.intersects(balik5)){
				
				
				 if (kontrol==1)
					 
				 {
					 player_gen+=2;
					 player_yuk+=2;
				 puan=puan+2;
				 kontrol++;
				 }
				 balik_x5=1300+r.nextInt(500)+200; 
			}
			if(k_balik.intersects(balik4)){
				
				
				 if (kontrol==1)
					 
				 {
				 kontrol++;
				 }
				yazim=" Oyun Bitti Yeniden Baþlayýnýz !!!";
				 balik_x4=1300+r.nextInt(500)+200; 
				  
			
			}

	
	
			
	
	
	if(balik_x1<0){  // son balýk ekrana girdiðinde balýklarýn tekrardan gelmesi için
		
		balik_x1=1500;
		balik_y1=160;
		balik_gen1=85;
		balik_yuk1=50;
	}
	if(balik_x2<0){
		balik_x2=balik_x1+r.nextInt(500)+200; // ikinci balýk ilk balýðýn + 200  ve 500 arasýnda gelir
		balik_y2=r.nextInt(400)+200;
		balik_gen2=100;
		balik_yuk2=60;
	}
	if(balik_x3<0){
		balik_x3=balik_x2+r.nextInt(500)+200; 
		balik_y3=r.nextInt(600)+30;
		balik_gen3=100;
		balik_yuk3=100;
	}
	if(balik_x4<0){
		balik_x4=balik_x3+r.nextInt(500)+200; 
		balik_y4=r.nextInt(450)+150;
		balik_gen4=180;
		balik_yuk4=80;
	}
	if(balik_x4<0){
		balik_x4=balik_x3+r.nextInt(500)+200; 
		balik_y4=r.nextInt(450)+150;
		balik_gen4=180;
		balik_yuk4=80;
	}
	if(balik_x5<0){
		balik_x5=balik_x4+r.nextInt(500)+200; 
		balik_y5=r.nextInt(350)+150;
		balik_gen5=65;
		balik_yuk5=65;
	}
		
	
	if(balik_x4<0){
		
		balik_x4=1000+r.nextInt(500)+200; 
		balik_y4=r.nextInt(450)+150;
		balik_gen4=80;
		balik_yuk4=80;
		
	}
	
	
	
	
		
		repaint();
	}



	@Override
	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			
			player_y-=20;
			
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			
			player_y+=20;
			
			
		}
		

		
		
		
		if (player_y<0){
			player_y=0;
		}
		
		if (player_y>530){
			player_y=530;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	

	

}
