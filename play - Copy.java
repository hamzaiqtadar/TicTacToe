/* Name: 
UMAR HUSSAIN-05038 
HAMZA IQTADAR-05700
CLASS: BESE 4-A 
We, UMAR HUSSIAN and HAMZA IQTADAR, do verify that the submitted code is our own effort and that we have not copied 
it from any peer or any internet source that has not been acknowledged. I also understand that if my submission fails
the similarity detection, I would be awarded zero marks not only for this submission but the whole evaluation component. */
import java.awt.EventQueue;
import javax.swing.border.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.SwingConstants;
//import java.nio.*;
import java.io.*;
//import java.nio.file.*;
import javax.imageio.ImageIO;		// for adding icons
import java.awt.image.BufferedImage;  
import java.awt.event.*;
import javax.sound.sampled.*;		// for playing sounds

public class play extends JFrame {
	public static Thread timer;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					play frame = new play();
					flout panel = new flout();

					frame.add(panel);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
			 PrimeRun p = new PrimeRun();
		 timer= new Thread(p);
		 timer.start();
	}
	public play() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		// for getting current screen size
		
		setSize( 794, 650);	
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2); // adjusting position such that
		//setResizable(false);														// centre of frame and screen are concurrent
		
		setBackground(new Color(255,195,64));
		
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class flout extends JPanel{									// Panel in which other panel will be added
	GridBagLayout gb=new GridBagLayout( );					// Gridbag layout will be used
	GridBagConstraints gbc=new GridBagConstraints( );
	
	public static JLabel abc;
	
	flout() throws Exception{
		setBackground(new Color(255,195,64));
		setLayout(gb);
		gbc.fill = GridBagConstraints.BOTH;
		// seting Label opaque so that is can be painted
		JLabel msg= new JLabel();	
		msg.setOpaque(true); msg.setBackground(new Color(255,195,64));	// setting specs of Title
		msg.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));	// font
		msg.setHorizontalAlignment(SwingConstants.CENTER);		// center alligned
		msg.setText("T I C  T A C  T O E               P l a y e r  v s.  C o m p u t e r");
		placeat(msg,0,0,15,3);		// calling method to add the title
		
		upnl up= new upnl();			// object of panel extended class and adding to main panel
		placeat(up,0,3,15,3);
		
		Buttonpnl parea = new Buttonpnl();		// object of board where game will be played
		placeat(parea,0,6,15,18);
		
		dpnl dp= new dpnl();					// object of panel placed at the bottom
		placeat(dp,0,21+3,15,3);
	}
	void placeat(Component ab, int column, int row, int width, int high){		// Taken from Lecture to add items in GBlayout 
	gbc.gridx = column;			 // set gridx
	gbc.gridy = row; 			// set gridy
	
	gbc.gridwidth = width; 		// set gridwidth
	gbc.gridheight = high; 		// set gridheight
	
	gb.setConstraints( ab, gbc ); // set constraints
	add( ab); 					 // add component
	}

}

class upnl extends JPanel{			// upper panel
	public static JLabel Pp;		// pause and play
	public static JLabel sound;
	public static JLabel exit;
	public static JLabel Time;		// Time will appear NOT added currently
	
	public static int vol=1;		// flag to control sound 
	public static int state=0;		//and pause play of game
	public static int push=1;
	public static int time;
	
	public upnl(){				// using box layout making menu bar (programmer defined)
		
		setBackground(new Color(255,195,64));
		setLayout(new BoxLayout( this, BoxLayout.X_AXIS ));		// x-axis alignment
		
		//Border line = BorderFactory.createLineBorder(Color.BLACK, 1);		// variable which define border specs.
		
		exit= new JLabel();  		//exit.setBorder(line);			// Adding border to the labels so they look like buttons
		Time= new JLabel();			//	Time.setBorder(line);
		Pp= new JLabel(); 		//Pp.setBorder(line);
		sound= new JLabel(); 	//sound.setBorder(line);

		try {	// Icons of Buttons so at start up
					ImageIcon pp = new ImageIcon(getClass().getResource("pse.png"));
					Pp.setIcon(pp);
		
					ImageIcon sn = new ImageIcon(getClass().getResource("on.png"));
					sound.setIcon(sn);
					
					ImageIcon et = new ImageIcon(getClass().getResource("ext.png"));
					exit.setIcon(et);
				}
		catch (Exception ex) { }
												// adjusting space with glue and adding buttons 
		add( Box.createGlue() ); 	add(Pp);
		add( Box.createGlue() );	add(sound);
		add( Box.createGlue() ); 	add(Time); 
		add( Box.createGlue() );	add(exit);
		add( Box.createGlue() );
			
		exit.addMouseListener(new MouseAdapter(){		// mouse listener to the EXIT
			public void mouseClicked(MouseEvent ok){
				System.exit(0);						// currently exiting the program later we will program it 
			}										// to show a main window i.e. another panel where user can restart
			});
		sound.addMouseListener(new MouseAdapter(){		// listener for sound of game and changing icon
				public void mouseClicked(MouseEvent ok){
					if (vol==1){
					vol=0;
					ImageIcon mute = new ImageIcon(getClass().getResource("off.png"));
						sound.setIcon(mute);
					}
					else{
					vol=1;
					ImageIcon volp = new ImageIcon(getClass().getResource("on.png"));
						sound.setIcon(volp);
					}
					
				}							
			});
		Pp.addMouseListener(new MouseAdapter(){				// pausing and resuming the game 
				public void mouseClicked(MouseEvent ok){
					if (state==1){
					state=0;
					ImageIcon pse = new ImageIcon(getClass().getResource("pse.png"));
						Pp.setIcon(pse);
						//Pp.setText("Pause");
						dpnl.plbl.setText("");
						// for(int i=0; i<15;i++){				// making all buttons looks disable so that user
							// for(int j=0;j<15;j++){			// does not get advantage of pause
								// Buttonpnl.btn[i][j].setEnabled(true);
							// }
						// }
					}							
					else{
						state=1;
						ImageIcon pp = new ImageIcon(getClass().getResource("ply.png"));
						Pp.setIcon(pp);
						//Pp.setText("Play    ");
						dpnl.plbl.setText("PAUSED");
						// for(int i=0; i<15;i++){				// making all buttons looks disable so that user
								// for(int j=0;j<15;j++){			// does not get advantage of pause
									// Buttonpnl.btn[i][j].setEnabled(false);
								// }	
						// }
					}	
			}
		}); // listener ends
	} //method ends
}	// class ends
			
class Buttonpnl extends JPanel {			// class which will generate board
		public static JLabel btn[][]= new JLabel[15][15];	//2d array for 225 buttons
		public static int flag[][]= new int[15][15];		// 2d array for flags
		//public String nm[]= new String[225];
		//public int usrbx[]= new int[123];
	
	Buttonpnl() throws Exception{				// grid layout
		setBackground(new Color(255,174,0) );
		setLayout(new GridLayout(15,15,2,2));
		  
		  
		  for( int i=0;i<15;i++){
			  for(int j=0;j<15;j++){
				  btn[i][j]= new JLabel();
				  btn[i][j].setOpaque(false);							// setting button clear to get desired color
				 // btn[i][j].setContentAreaFilled(false);
				  flag[i][j]=0;											// intializing all flags
				  btn[i][j].addMouseListener(new listenmouse(i,j));		// using extended mouse adapter
				  ImageIcon img = new ImageIcon(getClass().getResource("icob.png"));
				  btn[i][j].setIcon(img);
				  this.add(btn[i][j]);
			  }
		  }
	}
}
class listenmouse extends MouseAdapter{					// extending mouseadapter to change it to our requirement
	private final int asni, asnj;
	public listenmouse(int indexa, int indexb){			// storing values of button index in local variables
	this.asni=indexa;
	this.asnj=indexb;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (upnl.state==0){						// works only if game is not paused
			if (Buttonpnl.flag[asni][asnj]==0 ){
				
				Buttonpnl.flag[asni][asnj]=1;
				ImageIcon ucr = new ImageIcon(getClass().getResource("icot.png"));
				Buttonpnl.btn[asni][asnj].setIcon(ucr);
				upnl.push=0;
				// ImageIcon bnk = new ImageIcon(getClass().getResource("bnk.png"));
				// upnl.Time.setIcon(bnk);
				
				try{
					if(upnl.vol==1){			// generate sound only if not muted
					Thread.sleep(10);
					File audi= new File("kj.wav");
					AudioInputStream clk= AudioSystem.getAudioInputStream(audi.getAbsoluteFile());
					Clip port = AudioSystem.getClip();		// clip object which put sound to audio system
					port.open(clk);							// open the stream that is read from file
					port.start();							// start to play the sound
					
					}
				}
				catch (Exception ee){}
				 srh ade= new srh();			// calling search method from other class (NOT COMPLETED YET THE LOGIC)
			 }
			
		}
	}
}			// listener class ends
class srh {
		static int row, col;
	public	srh(){
		// column wise
		int pwin=0;
		int cwin=0;
	search:	for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				if(Buttonpnl.flag[j][i]==1)
				pwin+=1;
				 if(pwin==5){
				// code to be added
				// System.out.println("User Wins");
				// return;
				}
				else if (Buttonpnl.flag[j][i]==2){
					if(j<13)
						j+=1;
				}
				else if (Buttonpnl.flag[j][i]==0){
					if(j<13 &j>1){
					if (Buttonpnl.flag[j+1][i]==1){
						//System.out.println("IN PC SHP");
						Buttonpnl.flag[j][i]=2;
						
						try{
						Thread.sleep(1000);
						ImageIcon tik = new ImageIcon(getClass().getResource("icoc.png"));
						Buttonpnl.btn[j][i].setIcon(tik);
						if (upnl.vol==1){
						Thread.sleep(10);
						File audi= new File("kj.wav");
						AudioInputStream clk= AudioSystem.getAudioInputStream(audi.getAbsoluteFile());
						Clip port = AudioSystem.getClip();		// clip object which put sound to audio system
						port.open(clk);		// open the stream that is read from file
						port.start();
						}
						}
						catch (Exception ee){}
						upnl.push=1;
						//play.timer.start();
						
						return;
					}
					else {
					Buttonpnl.flag[j][i]=2;
						
						
						try{
						Thread.sleep(1000);
						ImageIcon tik = new ImageIcon(getClass().getResource("icoc.png"));
						Buttonpnl.btn[j][i].setIcon(tik);
						if (upnl.vol==1){
						Thread.sleep(10);
						File audi= new File("kj.wav");
						AudioInputStream clk= AudioSystem.getAudioInputStream(audi.getAbsoluteFile());
						Clip port = AudioSystem.getClip();		// clip object which put sound to audio system
						port.open(clk);		// open the stream that is read from file
						port.start();
						}
						}
						catch (Exception ee){}
						upnl.push=1;
					//	play.timer.start();
						return;
					
					}
					}else {
					Buttonpnl.flag[j][i]=2;
						
						
						try{
						Thread.sleep(1000);
						ImageIcon tik = new ImageIcon(getClass().getResource("icoc.png"));
						Buttonpnl.btn[j][i].setIcon(tik);
						if (upnl.vol==1){
						Thread.sleep(10);
						File audi= new File("kj.wav");
						AudioInputStream clk= AudioSystem.getAudioInputStream(audi.getAbsoluteFile());
						Clip port = AudioSystem.getClip();		// clip object which put sound to audio system
						port.open(clk);		// open the stream that is read from file
						port.start();
						}
						}
						catch (Exception ee){}
						upnl.push=1;
						//play.timer.start();
						return;
					
					}
				
				}
			}
		
			}
		
		}
	public void winchk(){}
}




class dpnl extends JPanel{
	public static JPanel usr;
	public static JPanel pc;
	public static JPanel pause;
	
	public static JLabel uu;
	public static JLabel cc;
	public static JLabel plbl;
	
	dpnl(){
		upnl.push=1;
		
		setBackground(new Color(255,195,64));
		setLayout(new GridLayout(1,3));
		
		usr= new JPanel();								// adding 3  panels and in them the 3 labels
		usr.setBackground(new Color(255,195,64));
		usr.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pause= new JPanel();
		pause.setBackground(new Color(255,195,64));
		pause.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		pc= new JPanel();
		pc.setBackground(new Color(255,195,64));
		pc.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		uu= new JLabel();
		cc= new JLabel();
		plbl= new JLabel();		// this will display pause when paused is clicked
		
		plbl.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		plbl.setHorizontalAlignment(SwingConstants.CENTER);
			
			try {					// setting images for user and pc
					ImageIcon uimg = new ImageIcon(getClass().getResource("usr.png"));
					ImageIcon cimg = new ImageIcon(getClass().getResource("cmp.png"));
						uu.setIcon(uimg);
						cc.setIcon(cimg);
				}
				catch (Exception ex) { }
		usr.add(uu);
		pc.add(cc);
		pause.add(plbl);
		add(usr); 
		add(pause);
		add(pc);
	}
}



class PrimeRun implements Runnable {
         public static int snd=1;
         PrimeRun() {
             
         }
 
         public  void  run() {
           
				int i=1;
			tic:	for( i=1;i<=30;i++){
					
					if(upnl.push==1){
					
					String aer= new String ("./aa/num ("+i+").png");
					
					if(i==10){
						this.danger();
					}
					try{
					ImageIcon oo = new ImageIcon(getClass().getResource(aer));
					upnl.Time.setIcon(oo);
					Thread.sleep(1000);
					}
					
					catch(Exception el){}
					if (i==30){
						snd=0;
						break tic;
					}
					}
					
					else i=0;
				 }
				 System.out.println("out of loop");
			 
			 
	
         }
		 
		 void danger(){
		 }
     }