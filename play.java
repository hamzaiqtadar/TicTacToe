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
					bg panel = new bg();

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




class bgn extends JPanel
{
	public static JLabel newgame;		// pause and play
	public static JLabel ins;
	public static JLabel exit;
	flout pan=new flout();
	ret panl=new ret();
//	begin p=new begin();
	play fr=new play();
//	bg panel=new bg();
	bgn() throws Exception
	{
	setBackground(new Color(255,255,255));
	setLayout(new FlowLayout());
	newgame= new JLabel();  		
	ins= new JLabel();			
	exit= new JLabel();
	
	try {	// Icons of Buttons so at start up
					
					ImageIcon pp = new ImageIcon(getClass().getResource("newgame.png"));
					newgame.setIcon(pp);
		
					ImageIcon sn = new ImageIcon(getClass().getResource("ins1.png"));
					ins.setIcon(sn);
					
					ImageIcon et = new ImageIcon(getClass().getResource("exit1.png"));
					exit.setIcon(et);

			}
		catch (Exception ex) { }
		add(newgame);	
		add(ins);
		add(exit);
			newgame.addMouseListener(new MouseAdapter(){		// mouse listener to the EXIT
				public void mouseClicked(MouseEvent ok){
					fr.dispose();
					fr.add(pan);
					fr.setVisible(true);
				}										// to show a main window i.e. another panel where user can restart
			});
			ins.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent k){
			//		fr.dispose();
					// fr.add(panl);
					// fr.setVisible(true);
				}										// to show a main window i.e. another panel where user can restart
			});	
		
			exit.addMouseListener(new MouseAdapter(){		// mouse listener to the EXIT
			//	public void mouseEntered(MouseEvent k){
			//	ImageIcon ett = new ImageIcon(getClass().getResource("exit2.png"));
			//	exit.setIcon(ett);	
			//	}
				public void mouseClicked(MouseEvent ok){
				System.exit(0);						// currently exiting the program later we will program it 
				}										// to show a main window i.e. another panel where user can restart
			});	
	}
}
class begin extends JPanel{
	
	public static JLabel pic;
	begin()throws Exception{
		setBackground(new Color(255,255,255));
		pic= new JLabel();
		try {	// Icons of Buttons so at start up
					ImageIcon pip = new ImageIcon(getClass().getResource("image.png"));
					pic.setIcon(pip);
				}
		catch (Exception ex) { }
		add(pic);
	}
}		

class bg extends JPanel{
	bgn pn=new bgn();
	begin pnn=new begin();
	bg() throws Exception{
//	setBackground(new Color(255,255,255));
	setLayout(new BoxLayout( this, BoxLayout.Y_AXIS ));	
	add(pnn);
	add(pn);
	}
}

class inst extends JPanel{
	public static JLabel ins=new JLabel();
	{
		setBackground(new Color(255,255,255));
	try {	// Icons of Buttons so at start up
					
					ImageIcon pp = new ImageIcon(getClass().getResource("img1.png"));
					ins.setIcon(pp);
		}
	catch (Exception ex) { }
	add(ins);	
	}		
}

class instruct extends JPanel{
	public static JLabel ins=new JLabel();
//	play frame=new play();
//	flout f=new flout();
//	bg pan2=new bg();
	instruct() throws Exception
	{
	setBackground(new Color(255,255,255));
	setLayout(new FlowLayout());
	
	try{
		ImageIcon ppp = new ImageIcon(getClass().getResource("exit.png"));
		ins.setIcon(ppp);
		}
	catch (Exception ex) { }
	add(ins);	
	ins.addMouseListener(new MouseAdapter(){		// mouse listener to the EXIT
		public void mouseClicked(MouseEvent k){
			System.exit(0);
		//	frame.dispose();
		//	frame.add(pan2);
		//	frame.setVisible(true);
		}										// to show a main window i.e. another panel where user can restart
	});	
	}
}	

class ret extends JPanel
{
	inst pn1=new inst();
	instruct pnn1=new instruct();
	ret() throws Exception
	{
	setBackground(new Color(255,255,255));
	setLayout(new BoxLayout( this, BoxLayout.Y_AXIS ));	
	add(pn1);
	add(pnn1);
	}
}	


class flout extends JPanel{									// Panel in which other panel will be added
	GridBagLayout gb=new GridBagLayout( );					// Gridbag layout will be used
	GridBagConstraints gbc=new GridBagConstraints( );
	
	public static JLabel abc;
	
	flout() throws Exception{
		setBackground(new Color(101,236,59));
		setLayout(gb);
		gbc.fill = GridBagConstraints.BOTH;
		// seting Label opaque so that is can be painted
		JLabel msg= new JLabel();	
		msg.setOpaque(true); msg.setBackground(new Color(101,236,59));	// setting specs of Title
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
		
		setBackground(new Color(101,236,59));
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
		add( Box.createHorizontalStrut(57) ); 	add(Pp);
		add(Box.createHorizontalStrut(57)  );	add(sound);
		add( Box.createHorizontalStrut(57)  ); 	add(Time); 
		add( Box.createHorizontalStrut(57)  );	add(exit);
		add(Box.createHorizontalStrut(57)  );
			
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
		setBackground(new Color(101,236,59) );
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
	public static int wcr=0, prec=0, turn=0, fifa=0;
	public listenmouse(int indexa, int indexb){			// storing values of button index in local variables
	this.asni=indexa;
	this.asnj=indexb;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (upnl.state==0 & srh.clkavail==0){						// works only if game is not paused
			if (Buttonpnl.flag[asni][asnj]==0 ){
				
				Buttonpnl.flag[asni][asnj]=1;
				//System.out.println("CLICKED     "+Buttonpnl.flag[asni][asnj]+"    "+asni+"   "+asnj);
				ImageIcon ucr = new ImageIcon(getClass().getResource("icot.png"));
				Buttonpnl.btn[asni][asnj].setIcon(ucr);
				upnl.push=0; wcr=0; turn=1;	prec=1;		// disabling
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
					//Thread.sleep(1000);
					}
				}
				catch (Exception ee){}
					srh.clkavail=1;			// disabling mouse listener
					pctrn og= new pctrn();
					System.out.println("IN PRE SEARCH ");
					og.winchk();
					if (fifa==0){
						System.out.println("FIFA ZERO");
						og.fifer();
					}
					System.out.println("PREC "+prec);
					if(prec==0)
					{ 
						System.out.println("IN COUNTER SEARXCh");
						srh ade= new srh();
						System.out.println("wcr  "+wcr+"	turn"+turn);
					}							// calling search method from other class (NOT COMPLETED YET THE LOGIC)
					 
					 System.out.println("	out of ifturn"+turn);
					if (turn==0){
						System.out.println("IN ftrn");
						if ( !(og.ftry(asni,asnj)) ){		// written separately because recursion takes place and combined
							if(!(og.ftry2(asni,asnj))){		// recursion gives stackoverflow error
								if(!(og.ftry3(asni,asnj))){
									if(!(og.ftry4(asni,asnj))){
										if(!(og.ftry5(asni,asnj))){
											if(!(og.ftry6(asni,asnj))){
					}}}}}}
					}
					if (wcr==0){
						System.out.println("IN POST SEARH");
						og.pschk();
						//System.out.println("	turn"+turn);
					 }
			 }
			
		}
	}
}			// listener class ends


class dpnl extends JPanel{
	public static JPanel usr;
	public static JPanel pc;
	public static JPanel pause;
	
	public static JLabel uu;
	public static JLabel cc;
	public static JLabel plbl;
	
	dpnl(){
		upnl.push=1;
		
		setBackground(new Color(101,236,59));
		setLayout(new GridLayout(1,3));
		
		usr= new JPanel();								// adding 3  panels and in them the 3 labels
		usr.setBackground(new Color(101,236,59));
		usr.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pause= new JPanel();
		pause.setBackground(new Color(101,236,59));
		pause.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		pc= new JPanel();
		pc.setBackground(new Color(101,236,59));
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



class PrimeRun implements Runnable {			// creating thread for timer to clock
         public static int snd=1;
         PrimeRun() {
             
         }
 
         public  void  run() {
           
				int i=1;
			tic:	for( i=1;i<=30;i++){
					
					if(upnl.push==1 ){
					
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
				// System.out.println("out of loop");
         }
		 
		 void danger(){
		 }
}

class srh {									// search for the possible wins of player and try to stop them
		public static int clkavail=0; 
	public	srh(){
		
		int pwin=0,   cwin=0,flg=0;
		int pwind=0, cwind=0;
		int pwinr=0, cwinr=0;
		int pwinl=0, cwinl=0;
		int pwinq=0, cwinq=0;
		int pwinx=0, cwinx=0;
		ImageIcon pcm = new ImageIcon(getClass().getResource("icoc.png"));
	
	dig1:	for(int i=10;i>=0;i--){						// diagonnaly search from to right to bottom left
				for(int j=0;j<(15-i);j++){												
					if(Buttonpnl.flag[0+j][i+j]== 1){
						pwin+=1;	cwin=0;
					}
					else if(Buttonpnl.flag[0+j][i+j]== 2){
						pwin=0;	cwin+=1;
					}
					else if(Buttonpnl.flag[0+j][i+j]== 0){
						
							if(pwin==4){
								Buttonpnl.flag[0+j][i+j]= 2;
								Buttonpnl.btn[j][i+j].setIcon(pcm);
									flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
								return;
							}
							else if(pwin==3){ 
								System.out.println((j)+" if  "+(i+j));
								if( (j+1)<15 & (i+j+1)<15 ){
										if( Buttonpnl.flag[0+j+1][i+j+1]== 1){
									//		try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
											Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
												flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
											return;
										}
									}
										else if ((j-4)>0 & (i+j-4)>0 ){
											if( Buttonpnl.flag[j-4][i+j-4]== 0){
												System.out.println((j-4)+" dig1   "+(i+j-4));
												Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
												flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
												return;
											}
										}
										  
										pwin=0;
									
							}
							else if(pwin==2 & (j+2)<15 & (i+j+2)<15){
									if( Buttonpnl.flag[0+j+2][i+j+2]== 1 & Buttonpnl.flag[0+j+1][i+j+1]== 1){
							//			try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
											flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else  pwin=0;
							}
							else if(pwin==1 & (j+3)<15 & (i+j+3)<15){
									if( Buttonpnl.flag[0+j+1][i+j+1]== 1 & Buttonpnl.flag[0+j+2][i+j+2]== 1 
																			& Buttonpnl.flag[0+j+3][i+j+3]== 1){
							//			try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
											flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else pwin=0;
							}
							else if(pwin==0 & (j+4)<15 & (i+j+4)<15){
								if( Buttonpnl.flag[0+j+1][i+j+1]== 1 & Buttonpnl.flag[0+j+2][i+j+2]== 1 
																			& Buttonpnl.flag[0+j+3][i+j+3]== 1 
																			& Buttonpnl.flag[0+j+4][i+j+4]== 1){
								//		try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
											flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
										return;
								}
							}
					}
					if(pwin==5){
								System.out.println("USER wins");
								for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[j-k][i+j-k].setIcon(py);
								listenmouse.wcr=1;
								}
								pwin=0;	return;
					}
					if(cwin==5){
						System.out.println("COMPUTER WINS");
						for(int k=0;k<=4;k++){
						ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
						Buttonpnl.btn[j-k][i+j-k].setIcon(pyc);
						}
						pwin=0;	return;
					}
				}
				pwin=0; cwin=0;
			}	// for loop fro diagonal left to write upper half ends ends
			
	// lower left triangle	
	dig2:	for(int i=10;i>=1;i--){							// search diagonally like this (\)fro top left to the bottom right 
				for(int j=0,n=0;j<(15-i);j++, n++){
				
					if(Buttonpnl.flag[i+n][j]== 1){
						pwind+=1;	cwind=0;
					}
					else if(Buttonpnl.flag[i+n][j]== 2){
						pwind=0;	cwind+=1;
					}
					else if(Buttonpnl.flag[i+n][j]== 0){
							if(pwind==4){
								Buttonpnl.flag[i+n][j]= 2;
					//			try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[i+n][j].setIcon(pcm);
									flg=1;	this.presse();	pwind=0;	upnl.push=1;	clkavail=0;
								return;
							}
							else if(pwind==3 &(i+n+1)<15 & (j+1)<15 ){
									if( Buttonpnl.flag[i+n+1][j+1]==1){
						//				try {	Thread.sleep(1000);	} 	catch(Exception eq4){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.presse();	pwind=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else if ((i+n-4)>0 & (j-4)>0 ){
											if( Buttonpnl.flag[i+n-4][j-4]== 0){
												System.out.println("in dig 2");
												Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
												flg=1;	this.presse();	pwind=0;	upnl.push=1;	clkavail=0;
												return;
											}
									}
								 pwind=0;
							}
							else if(pwind==2 & (i+n+2)<15 & (j+2)<15){
									if( Buttonpnl.flag[i+n+1][j+1]==1 & Buttonpnl.flag[i+n+2][j+2]==1){
								//		try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.presse();	pwind=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else  pwind=0;	//System.out.println("pwin"+pwin);
							}
							else if(pwind==1 & (i+n+3)<15 & (j+3)<15){
									if( Buttonpnl.flag[i+n+1][j+1]==1 & Buttonpnl.flag[i+n+2][j+2]==1
																			& Buttonpnl.flag[i+n+3][j+3]==1){
									//	try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.presse();	pwind=0;	upnl.push=1;	clkavail=0;
										return;
									
									}
									else { 
										pwind=0;
									}
							}
							else if(pwind==0 & (i+n+4)<15 & (j+4)<15){
									if( Buttonpnl.flag[i+n+1][j+1]==1 & Buttonpnl.flag[i+n+2][j+2]==1
																			& Buttonpnl.flag[i+n+3][j+3]==1
																			&  Buttonpnl.flag[i+n+4][j+4]==1){
									//	try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.presse();	pwind=0;	upnl.push=1;	clkavail=0;
										return;
									}
							}	
					}
					if(pwind==5){		// check conditions
								System.out.println("USER wins");
								for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+n-k][j-k].setIcon(py);
								listenmouse.wcr=1;
								}
								pwind=0;	return;
					}
					if(cwind==5){		// check conditions
						System.out.println("COMPUTER WINS");
						for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+n-k][j-k].setIcon(py);
								}
						cwind=0;	return;
					}
				} // outer for ends	
					pwind=0; cwind=0;
			}	// for loop ends
			
// up to down lookup
	uds:	for(int d=0; d<=14;d++){					
				for(int t=0;t<=14;t++){
					if(Buttonpnl.flag[t][d]== 1){
						pwinl+=1;	cwinl=0;
					}
					else if(Buttonpnl.flag[t][d]== 2){
						pwinl=0;	cwinl+=1;
					}
					else if(Buttonpnl.flag[t][d]== 0){
							if(pwinl==4){
								Buttonpnl.flag[t][d]= 2;
							//	try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[t][d].setIcon(pcm);
									flg=1;	this.presse();	pwinl=0;	upnl.push=1;	clkavail=0;
								return;
							}
							
							else if(pwinl==3 &(t+1)<15 ){
									if( Buttonpnl.flag[t+1][d]== 1){
								//		try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.presse();	pwinl=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else if ((t-4)>0 ){
											if( Buttonpnl.flag[t-4][d]== 0){
												Buttonpnl.flag[t][d]=2;		Buttonpnl.btn[t][d].setIcon(pcm);
												flg=1;	this.presse();	pwinl=0;	upnl.push=1;	clkavail=0;
												return;
											}
									}
									 pwinl=0;
							}
							else if(pwinl==2 & (t+2)<15){
									if( Buttonpnl.flag[t+1][d]== 1 & Buttonpnl.flag[t+2][d]== 1){
								//		try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.presse();	pwinl=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else  {pwinl=0;	System.out.println("pwin"+pwin);}
							}
							else if(pwinl==1 & (t+3)<15 ){
									if( Buttonpnl.flag[t+1][d]== 1 & Buttonpnl.flag[t+2][d]== 1 
																			& Buttonpnl.flag[t+3][d]== 1 ){
								//		try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.presse();	pwinl=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else { 
										pwinl=0;
									}
							}
							else if(pwinl==0 & (t+4)<15 ){
								if( Buttonpnl.flag[t+1][d]== 1 & Buttonpnl.flag[t+2][d]== 1 
																			& Buttonpnl.flag[t+3][d]== 1
																			& Buttonpnl.flag[t+4][d]== 1){
								//		try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.presse();	pwinl=0;	upnl.push=1;	clkavail=0;
										return;
									}
							}
					}
					if(pwinl==5){
								System.out.println("USER wins");
								for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[t-k][d].setIcon(py);
								listenmouse.wcr=1;
								}
								pwinl=0;	return;
					}
					if(cwinl==5){
						System.out.println("COMPUTER WINS");
						for(int k=0;k<=4;k++){
						ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
						Buttonpnl.btn[t-k][d].setIcon(pyc);
						}
						pwinl=0;	return;
					}
				}
					pwinl=0; cwinl=0;
			}
			
// left to right look up	
	lrs:	for(int d=0; d<=14;d++){					// left to right lookup same as up down just variable position change
				for(int t=0;t<=14;t++){
					if(Buttonpnl.flag[d][t]== 1){
						pwinq+=1;	cwinq=0;
					}
					else if(Buttonpnl.flag[d][t]== 2){
						pwinq=0;	cwinq+=1;
					}
					else if(Buttonpnl.flag[d][t]== 0){
						
							if(pwinq==4){			
								Buttonpnl.flag[t][d]= 2;
							//	try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[d][t].setIcon(pcm);
									flg=1;	this.presse();	pwinq=0;	upnl.push=1;	clkavail=0;
								return;
							}
							else if(pwinq==3 &(t+1)<15 ){
									if( Buttonpnl.flag[d][t+1]== 1){
							//			try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.presse();	pwinq=0;	upnl.push=1;	clkavail=0;
										
										return;
									}
									else if ((t-4)>0 ){
											if( Buttonpnl.flag[d][t-4]== 0){
											System.out.println("in lrs");
												Buttonpnl.flag[d][t]=2;		Buttonpnl.btn[d][t].setIcon(pcm);
												flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
												return;
											}
									}
									pwinq=0;
							}
							else if(pwinq==2 & (t+2)<15){
									if( Buttonpnl.flag[d][t+1]== 1 & Buttonpnl.flag[d][t+2]== 1){
								//		try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.presse();	pwinq=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else  pwinq=0;
									
							}
							else if(pwinq==1 & (t+3)<15 ){
									if( Buttonpnl.flag[d][t+1]== 1 & Buttonpnl.flag[d][t+2]== 1 
																			& Buttonpnl.flag[d][t+3]== 1 ){
								//		try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.presse();	pwinq=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else pwinq=0;
							}
							else if(pwin==0 & (t+4)<15 ){
								if( Buttonpnl.flag[d][t+1]== 1 & Buttonpnl.flag[d][t+2]== 1 
															   & Buttonpnl.flag[d][t+3]== 1
															   & Buttonpnl.flag[d][t+4]== 1){
								//		try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.presse();	pwinq=0;	upnl.push=1;	clkavail=0;
										return;
									}
							}
					}
					if(pwinq==5){
							System.out.println("USER wins");
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[d][t-k].setIcon(py);
								listenmouse.wcr=1;
							}
						pwinq=0;	return;
					}
					if(cwinq==5){
						System.out.println("COMPUTER WINS");
						for(int k=0;k<=4;k++){
							ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
							Buttonpnl.btn[d][t-k].setIcon(pyc);
						}
						pwinq=0;	return;
					}
				}
				pwinq=0; cwinq=0;
			}
// right upper triangle diagonals					from top to centre of board		like this (/)
	rudig:		for(int i=14;i>=4;i--){		// right diagonal right diagonal right diagonal right diagonal
				for(int j=0;j<=i;j++){
					if(Buttonpnl.flag[j][i-j]== 1){
						pwinr+=1;	cwinr=0;								
					}
					else if(Buttonpnl.flag[j][i-j]== 2){
						pwinr=0;	cwinr+=1;
					}
					else if(Buttonpnl.flag[j][i-j]== 0){
							
							if(pwinr==4){
								Buttonpnl.flag[j][i-j]= 2;
					//			try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[j][i-j].setIcon(pcm);
									flg=1;	this.presse();	pwinr=0;	upnl.push=1;	clkavail=0;
								return;
							}
							else if(pwinr==3 &(j+1)<15 & (i-j-1)>=0 ){
									if( Buttonpnl.flag[j+1][i-j-1]== 1){
					//					try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.presse();	pwinr=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else if ((j-4)>0 & (i-j+4)<15 ){
											if( Buttonpnl.flag[j-4][i-j+4]== 0){
												Buttonpnl.flag[j][i-j]=2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
												flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
												return;
											}
									}
									pwinr=0;
									
							}
							else if(pwinr==2 & (j+2)<15 & (i-j-2)>=0){
									if( Buttonpnl.flag[j+2][i-j-2]== 1 & Buttonpnl.flag[j+1][i-j-1]== 1){
					//					try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
									Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.presse();	pwinr=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else  {pwinr=0;	
									}
							}
							else if(pwinr==1 & (j+3)<15 & (i-j-3)>=0){
									if( Buttonpnl.flag[j+2][i-j-2]== 1 & Buttonpnl.flag[j+1][i-j-1]== 1 
																			&Buttonpnl.flag[j+3][i-j-3]== 1 ){
					//					try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.presse();	pwinr=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else 
										pwinr=0;
										
							}
							else if(pwinr==0 & (j+4)<15 & (i-j-4)>=0){
								if( Buttonpnl.flag[j+1][i-j-1]== 1 & Buttonpnl.flag[j+2][i-j-2]== 1 
																			& Buttonpnl.flag[j+3][i-j-3]== 1 
																			& Buttonpnl.flag[j+4][i-j-4]== 1){
					//					try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.presse();	pwinr=0;	upnl.push=1;	clkavail=0;
										return;
									}
							}
					}
					if(pwinr==5){
								System.out.println("USER wins");
								for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[j-k][i-j+k].setIcon(py);
								listenmouse.wcr=1;
								}
								pwinr=0;	return;
					}
					if(cwinr==5){
						System.out.println("COMPUTER WINS");
						for(int k=0;k<=4;k++){
						ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
						Buttonpnl.btn[j-k][i-j+k].setIcon(pyc);
						}
						pwinr=0;	return;
					}
				}
						pwinr=0; cwinr=0;
			}
// right lower triangle						// searching like this (/)
	rldig:	for(int i=10;i>=1;i--){		// right diagonal right diagonal right diagonal right diagonal
				for(int j=14, m=0;j>=i;j--,m++){
					if(Buttonpnl.flag[i+m][j]== 1){
						pwinx+=1;	cwinx=0;
					}
					else if(Buttonpnl.flag[i+m][j]== 2){
						pwinx=0;	cwinx+=1;
					}
					else if(Buttonpnl.flag[i+m][j]== 0){
							if(pwinx==4){
								Buttonpnl.flag[i+m][j]= 2;
					//			try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[i+m][j].setIcon(pcm);
									flg=1;	this.presse();	pwinx=0;	upnl.push=1;	clkavail=0;
								return;
							}
							
							else if(pwinx==3 &(i+m+1)<15 & (j-1)>=0 ){
									if( Buttonpnl.flag[i+m+1][j-1]== 1){
					//					try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.presse();	pwinx=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else if ((i+m-4)>0 & (j+4)<15 ){
											if( Buttonpnl.flag[i+m-4][j+4]== 0){
												Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
												flg=1;	this.presse();	pwin=0;	upnl.push=1;	clkavail=0;
												return;
											}
									} 
										pwinx=0;
									
							}
							else if(pwinx==2 &(i+m+2)<15 & (j-2)>=0 ){
									if( Buttonpnl.flag[i+m+1][j-1]== 1 & Buttonpnl.flag[i+m+2][j-2]== 1){
					//					try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
									Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.presse();	pwinx=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else  {pwinx=0;	
									}
							}
							else if(pwinx==1 & (i+m+3)<15 & (j-3)>=0 ){
									if( Buttonpnl.flag[i+m+1][j-1]== 1 & Buttonpnl.flag[i+m+2][j-2]== 1 
																			&Buttonpnl.flag[i+m+3][j-3]== 1 ){
					//					try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.presse();	pwinx=0;	upnl.push=1;	clkavail=0;
										return;
									}
									else 
										pwinx=0;
										
							}
							else if(pwinx==0 & (i+m+4)<15 & (j-4)>=0 ){
								if(  Buttonpnl.flag[i+m+1][j-1]== 1 & Buttonpnl.flag[i+m+2][j-2]== 1 
																			&Buttonpnl.flag[i+m+3][j-3]== 1
																			& Buttonpnl.flag[i+m+4][j-4]== 1){
					//					try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.presse();	pwinx=0;	upnl.push=1;	clkavail=0;
										return;
									}
							}
					}
					if(pwinx==5){
								System.out.println("USER wins");
								for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+m-k][j+k].setIcon(py);
								listenmouse.wcr=1;
								}
								pwinx=0;	return;
					}
					if(cwinx==5){
						System.out.println("COMPUTER WINS");
						for(int k=0;k<=4;k++){
						ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
						Buttonpnl.btn[i+m-k][j+k].setIcon(pyc);
						}
						pwinx=0;	return;
					}
				}
					pwinx=0; cwinx=0;
			}
			
			
			clkavail=0; 	System.out.println("Function call ending");
			listenmouse.turn=0;
			//pwind=0; pwin=0;cwin=0; cwind=0; pwinr=0; cwinr=0;
		}	// method ends
		
		
		
	
	public void presse(){
		try{
		
		File audi= new File("pj.wav");
		AudioInputStream clk= AudioSystem.getAudioInputStream(audi.getAbsoluteFile());
		Clip port = AudioSystem.getClip();		// clip object which put sound to audio system
		port.open(clk);		// open the stream that is read from file
		port.start();
		}
		catch(Exception e5){}
	}
}



class pctrn {			
		ImageIcon pcm = new ImageIcon(getClass().getResource("icoc.png"));
		pctrn(){
			
		}
		
		public void winchk(){					// search for consective four like above where it go for counter after click 
			int ccwin=0, ppwin=0;
			
			for(int i=10;i>=0;i--){
					for(int j=0;j<(15-i);j++){
						if(Buttonpnl.flag[j][i+j]== 1)
							{ppwin+=1; ccwin=0;}
						else if(Buttonpnl.flag[j][i+j]== 2)
							{ccwin+=1; ppwin=0;}
						else if(Buttonpnl.flag[j][i+j]== 0)
							{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[j-k][i+j-k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
								//listenmouse.wcr=1;				// to disbale the clock and the mouse listener
								}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[j-k][i+j-k].setIcon(pyc);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
							}
							return;
						}
					}
						ccwin=0; ppwin=0;
			}
			for(int i=10;i>=1;i--){			
					for(int j=0,n=0;j<(15-i);j++, n++){
						if(Buttonpnl.flag[i+n][j]== 1)
							{ppwin+=1; ccwin=0;}
						else if (Buttonpnl.flag[i+n][j]== 2)
							{ccwin+=1; ppwin=0;}
						else if (Buttonpnl.flag[i+n][j]== 0)
							{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+n-k][j-k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
								//listenmouse.wcr=1;
							}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+n-k][j-k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
			}
			for(int d=0; d<=14;d++){					
					for(int t=0;t<=14;t++){
						if(Buttonpnl.flag[t][d]== 1)
							{ppwin+=1; ccwin=0;}
						else if(Buttonpnl.flag[t][d]== 2)
							{ccwin+=1; ppwin=0;}
						else if(Buttonpnl.flag[t][d]== 0)
							{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[t-k][d].setIcon(py);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
								//listenmouse.wcr=1;
							}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[t-k][d].setIcon(pyc);
							upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
			}
			for(int d=0; d<=14;d++){	// left to right lookup same as up down just variable position change
					for(int t=0;t<=14;t++){
						if(Buttonpnl.flag[d][t]== 1)
							{ppwin+=1; ccwin=0;}
						else if (Buttonpnl.flag[d][t]== 2)
							{ccwin+=1; ppwin=0;}
						else if (Buttonpnl.flag[d][t]== 0)
							{	ccwin=0; ppwin=0;		}
						
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[d][t-k].setIcon(py);
							upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
								//listenmouse.wcr=1;
							}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[d][t-k].setIcon(pyc);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
			}
			for(int i=14;i>=4;i--){		// right diagonal right diagonal right diagonal right diagonal
					for(int j=0;j<=i;j++){
						if(Buttonpnl.flag[j][i-j]== 1)
							{ppwin+=1; ccwin=0;}
						else if (Buttonpnl.flag[j][i-j]== 2)
							{ccwin+=1; ppwin=0;}
						else if (Buttonpnl.flag[j][i-j]== 0)
							{	ccwin=0; ppwin=0;		}
						
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[j-k][i-j+k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;
								//listenmouse.wcr=1;
								}
								return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[j-k][i-j+k].setIcon(pyc);
								upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
			}
			for(int i=10;i>=1;i--){		// right diagonal right diagonal right diagonal right diagonal
					for(int j=14, m=0;j>=i;j--,m++){
						if(Buttonpnl.flag[i+m][j]== 1)
								{ ppwin+=1; ccwin=0;}
						else if(Buttonpnl.flag[i+m][j]== 2)
								{	ccwin+=1; ppwin=0;	}
						else if (Buttonpnl.flag[i+m][j]== 0)
								{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
									ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
									Buttonpnl.btn[i+m-k][j+k].setIcon(py);
									upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
									}
							return;
						}
						else if	(ccwin==5){
							for(int k=0;k<=4;k++){
							ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
							Buttonpnl.btn[i+m-k][j+k].setIcon(pyc);
							upnl.push=0;	srh.clkavail=1;		listenmouse.prec=1;	listenmouse.fifa=1;listenmouse.turn=1;
							}
							return;
						}
					
					} ccwin=0; ppwin=0;
			}
			//listenmouse.prec=0;
			listenmouse.fifa=0;
		}
	public void pschk(){						//post check after cpu has played for any win if possible 
	int ccwin=0, ppwin=0;
		for(int i=10;i>=0;i--){
					for(int j=0;j<(15-i);j++){
						if(Buttonpnl.flag[j][i+j]== 1)
							{ppwin+=1; ccwin=0;}
						else if(Buttonpnl.flag[j][i+j]== 2)
							{ccwin+=1; ppwin=0;}
						else if(Buttonpnl.flag[j][i+j]== 0)
							{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[j-k][i+j-k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;		// to disbale the clock and the mouse listener
								listenmouse.turn=1;
								}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[j-k][i+j-k].setIcon(pyc);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
							}
							return;
						}
					}
						ccwin=0; ppwin=0;
		}
		for(int i=10;i>=1;i--){			
					for(int j=0,n=0;j<(15-i);j++, n++){
						if(Buttonpnl.flag[i+n][j]== 1)
							{ppwin+=1; ccwin=0;}
						else if (Buttonpnl.flag[i+n][j]== 2)
							{ccwin+=1; ppwin=0;}
						else if (Buttonpnl.flag[i+n][j]== 0)
							{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+n-k][j-k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
								//listenmouse.wcr=1;
							}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[i+n-k][j-k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
		}
		for(int d=0; d<=14;d++){					
					for(int t=0;t<=14;t++){
						if(Buttonpnl.flag[t][d]== 1)
							{ppwin+=1; ccwin=0;}
						else if(Buttonpnl.flag[t][d]== 2)
							{ccwin+=1; ppwin=0;}
						else if(Buttonpnl.flag[t][d]== 0)
							{	ccwin=0; ppwin=0;		}
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[t-k][d].setIcon(py);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
								//listenmouse.wcr=1;
							}
							return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[t-k][d].setIcon(pyc);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
		}
		for(int d=0; d<=14;d++){	// left to right lookup same as up down just variable position change
			for(int t=0;t<=14;t++){
				if(Buttonpnl.flag[d][t]== 1)
					{ppwin+=1; ccwin=0;}
				else if (Buttonpnl.flag[d][t]== 2)
					{ccwin+=1; ppwin=0;}
				else if (Buttonpnl.flag[d][t]== 0)
					{	ccwin=0; ppwin=0;		}
				
				if (ppwin==5){
					for(int k=0;k<=4;k++){
						ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
						Buttonpnl.btn[d][t-k].setIcon(py);
						upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
						//listenmouse.wcr=1;
					}
					return;
				}
				else if (ccwin==5){
					for(int k=0;k<=4;k++){
						ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
						Buttonpnl.btn[d][t-k].setIcon(pyc);
						upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
					}
					return;
				}
			}
			ccwin=0; ppwin=0;
		}
		for(int i=14;i>=4;i--){		// right diagonal right diagonal right diagonal right diagonal
					for(int j=0;j<=i;j++){
						if(Buttonpnl.flag[j][i-j]== 1)
							{ppwin+=1; ccwin=0;}
						else if (Buttonpnl.flag[j][i-j]== 2)
							{ccwin+=1; ppwin=0;}
						else if (Buttonpnl.flag[j][i-j]== 0)
							{	ccwin=0; ppwin=0;		}
						
						if (ppwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
								Buttonpnl.btn[j-k][i-j+k].setIcon(py);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
								//listenmouse.wcr=1;
								}
								return;
						}
						else if (ccwin==5){
							for(int k=0;k<=4;k++){
								ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
								Buttonpnl.btn[j-k][i-j+k].setIcon(pyc);
								upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
							}
							return;
						}
					}
					ccwin=0; ppwin=0;
		}
		for(int i=10;i>=1;i--){		// right diagonal right diagonal right diagonal right diagonal
			for(int j=14, m=0;j>=i;j--,m++){
				if(Buttonpnl.flag[i+m][j]== 1)
						{ ppwin+=1; ccwin=0;}
				else if(Buttonpnl.flag[i+m][j]== 2)
						{	ccwin+=1; ppwin=0;	}
				else if (Buttonpnl.flag[i+m][j]== 0)
						{	ccwin=0; ppwin=0;		}
				if (ppwin==5){
					for(int k=0;k<=4;k++){
							ImageIcon py = new ImageIcon(getClass().getResource("pwin.png"));
							Buttonpnl.btn[i+m-k][j+k].setIcon(py);
							upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
							}
					return;
				}
				else if	(ccwin==5){
					for(int k=0;k<=4;k++){
					ImageIcon pyc = new ImageIcon(getClass().getResource("cwin.png"));
					Buttonpnl.btn[i+m-k][j+k].setIcon(pyc);
					upnl.push=0;	srh.clkavail=1;	listenmouse.turn=1;
					}
					return;
				}
			
			} ccwin=0; ppwin=0;
		}
		//System.out.println("WINCHK END");
		listenmouse.turn=0;
	}
	
	
	
	
	public void fifer(){				// after user turn it will find only if pc has a chance to win if yes it will go for it and end the game
		int pwin=0,   cwin=0,flg=0;
		int pwind=0, cwind=0;
		int pwinr=0, cwinr=0;
		int pwinl=0, cwinl=0;
		int pwinq=0, cwinq=0;
		int pwinx=0, cwinx=0;
		ImageIcon pcm = new ImageIcon(getClass().getResource("icoc.png"));
		System.out.println("IN FIFEER");
	dig1:	for(int i=10;i>=0;i--){
				for(int j=0;j<(15-i);j++){
					if(Buttonpnl.flag[0+j][i+j]== 1){
						pwin+=1;	cwin=0;
					}
					else if(Buttonpnl.flag[0+j][i+j]== 2){
						pwin=0;	cwin+=1;
					}
					else if(Buttonpnl.flag[0+j][i+j]== 0){
						
							if(cwin==4){
								Buttonpnl.flag[0+j][i+j]= 2;
								Buttonpnl.btn[j][i+j].setIcon(pcm);
									flg=1;	this.dolby();	cwin=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
								return;
							}
							else if(cwin==3){ 
								if( (j+1)<15 & (i+j+1)<15 ){
										if( Buttonpnl.flag[0+j+1][i+j+1]== 2){
									//		try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
											Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
												flg=1;	this.dolby();	cwin=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
											return;
										}
									}
									else  
										cwin=0;
									
							}
							else if(cwin==2 & (j+2)<15 & (i+j+2)<15){
									if( Buttonpnl.flag[0+j+2][i+j+2]== 2 & Buttonpnl.flag[0+j+1][i+j+1]== 2){
							//			try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
											flg=1;	this.dolby();	cwin=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else  cwin=0;
							}
							else if(cwin==1 & (j+3)<15 & (i+j+3)<15){
									if( Buttonpnl.flag[0+j+1][i+j+1]== 2 & Buttonpnl.flag[0+j+2][i+j+2]== 2
																			& Buttonpnl.flag[0+j+3][i+j+3]== 2){
							//			try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
											flg=1;	this.dolby();	cwin=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else cwin=0;
							}
							else if(cwin==0 & (j+4)<15 & (i+j+4)<15){
								if( Buttonpnl.flag[0+j+1][i+j+1]== 2 & Buttonpnl.flag[0+j+2][i+j+2]== 2 
																			& Buttonpnl.flag[0+j+3][i+j+3]== 2 
																			& Buttonpnl.flag[0+j+4][i+j+4]== 2){
								//		try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[0+j][i+j]= 2;		Buttonpnl.btn[j][i+j].setIcon(pcm);
											flg=1;	this.dolby();	cwin=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
								}
							}
					}
					
				}
				pwin=0; cwin=0;
			}	// for loop fro diagonal left to write upper half ends ends
			
	// lower left triangle	
	dig2:	for(int i=10;i>=1;i--){			
				for(int j=0,n=0;j<(15-i);j++, n++){
				
					if(Buttonpnl.flag[i+n][j]== 1){
						pwind+=1;	cwind=0;
					}
					else if(Buttonpnl.flag[i+n][j]== 2){
						pwind=0;	cwind+=1;
					}
					else if(Buttonpnl.flag[i+n][j]== 0){
							if(cwind==4){
								Buttonpnl.flag[i+n][j]= 2;
					//			try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[i+n][j].setIcon(pcm);
									flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
								listenmouse.turn=1;
								return;
							}
							else if(cwind==3 &(i+n+1)<15 & (j+1)<15 ){
									if( Buttonpnl.flag[i+n+1][j+1]==2){
						//				try {	Thread.sleep(1000);	} 	catch(Exception eq4){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else 
								 cwind=0;
							}
							else if(cwind==2 & (i+n+2)<15 & (j+2)<15){
									if( Buttonpnl.flag[i+n+1][j+1]==2 & Buttonpnl.flag[i+n+2][j+2]==2){
								//		try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else  cwind=0;	//System.out.println("pwin"+pwin);
							}
							else if(cwind==1 & (i+n+3)<15 & (j+3)<15){
									if( Buttonpnl.flag[i+n+1][j+1]==2 & Buttonpnl.flag[i+n+2][j+2]==2
																			& Buttonpnl.flag[i+n+3][j+3]==2){
									//	try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									
									}
									else { 
										cwind=0;
									}
							}
							else if(cwind==0 & (i+n+4)<15 & (j+4)<15){
									if( Buttonpnl.flag[i+n+1][j+1]==2 & Buttonpnl.flag[i+n+2][j+2]==2
																			& Buttonpnl.flag[i+n+3][j+3]==2
																			&  Buttonpnl.flag[i+n+4][j+4]==2){
									//	try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[i+n][j]=2;		Buttonpnl.btn[i+n][j].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
							}	
					}
					
				} // outer for ends	
					pwind=0; cwind=0;
			}	// for loop ends
			
// up to down lookup
	uds:	for(int d=0; d<=14;d++){					
				for(int t=0;t<=14;t++){
					if(Buttonpnl.flag[t][d]== 1){
						pwinl+=1;	cwinl=0;
					}
					else if(Buttonpnl.flag[t][d]== 2){
						pwinl=0;	cwinl+=1;
					}
					else if(Buttonpnl.flag[t][d]== 0){
							if(cwinl==4){
								Buttonpnl.flag[t][d]= 2;
							//	try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[t][d].setIcon(pcm);
									flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
								return;
							}
							
							else if(cwinl==3 &(t+1)<15 ){
									if( Buttonpnl.flag[t+1][d]== 2){
								//		try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else 
									 pwinl=0;
							}
							else if(cwinl==2 & (t+2)<15){
									if( Buttonpnl.flag[t+1][d]== 2 & Buttonpnl.flag[t+2][d]==2){
								//		try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else  cwinl=0;	
							}
							else if(cwinl==1 & (t+3)<15 ){
									if( Buttonpnl.flag[t+1][d]== 2 & Buttonpnl.flag[t+2][d]== 2
																			& Buttonpnl.flag[t+3][d]== 2 ){
								//		try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else { 
										cwinl=0;
									}
							}
							else if(cwinl==0 & (t+4)<15 ){
								if( Buttonpnl.flag[t+1][d]==2 & Buttonpnl.flag[t+2][d]== 2 
																			& Buttonpnl.flag[t+3][d]== 2
																			& Buttonpnl.flag[t+4][d]== 2){
								//		try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[t][d]= 2;		Buttonpnl.btn[t][d].setIcon(pcm);
											flg=1;	this.dolby();	cwind=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
							}
					}
					
				}
					pwinl=0; cwinl=0;
			}
			
// left to right look up	
	lrs:	for(int d=0; d<=14;d++){					// left to right lookup same as up down just variable position change
				for(int t=0;t<=14;t++){
					if(Buttonpnl.flag[d][t]== 1){
						pwinq+=1;	cwinq=0;
					}
					else if(Buttonpnl.flag[d][t]== 2){
						pwinq=0;	cwinq+=1;
					}
					else if(Buttonpnl.flag[d][t]== 0){
						
							if(cwinq==4){			
								Buttonpnl.flag[t][d]= 2;
							//	try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[d][t].setIcon(pcm);
									flg=1;	this.dolby();	cwinq=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
								return;
							}
							else if(cwinq==3 &(t+1)<15 ){
									if( Buttonpnl.flag[d][t+1]== 2){
							//			try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.dolby();	cwinq=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else 
									pwinq=0;
							}
							else if(cwinq==2 & (t+2)<15){
									if( Buttonpnl.flag[d][t+1]== 1 & Buttonpnl.flag[d][t+2]== 1){
								//		try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.dolby();	cwinq=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else  cwinq=0;
									
							}
							else if(cwinq==1 & (t+3)<15 ){
									if( Buttonpnl.flag[d][t+1]== 2 & Buttonpnl.flag[d][t+2]== 2
																			& Buttonpnl.flag[d][t+3]== 2 ){
								//		try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.dolby();	cwinq=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else cwinq=0;
							}
							else if(cwin==0 & (t+4)<15 ){
								if( Buttonpnl.flag[d][t+1]== 2& Buttonpnl.flag[d][t+2]== 2 
															   & Buttonpnl.flag[d][t+3]== 2
															   & Buttonpnl.flag[d][t+4]== 2){
								//		try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[d][t]= 2;		Buttonpnl.btn[d][t].setIcon(pcm);
											flg=1;	this.dolby();	cwinq=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
							}
					}
					
				}
				pwinq=0; cwinq=0;
			}
// right upper triangle diagonals
	rudig:		for(int i=14;i>=4;i--){		// right diagonal right diagonal right diagonal right diagonal
				for(int j=0;j<=i;j++){
					if(Buttonpnl.flag[j][i-j]== 1){
						pwinr+=1;	cwinr=0;								
					}
					else if(Buttonpnl.flag[j][i-j]== 2){
						pwinr=0;	cwinr+=1;
					}
					else if(Buttonpnl.flag[j][i-j]== 0){
							
							if(cwinr==4){
								Buttonpnl.flag[j][i-j]= 2;
					//			try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[j][i-j].setIcon(pcm);
									flg=1;	this.dolby();	cwinr=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
								return;
							}
							else if(cwinr==3 &(j+1)<15 & (i-j-1)>=0 ){
									if( Buttonpnl.flag[j+1][i-j-1]==2){
					//					try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.dolby();	cwinr=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									
									cwinr=0;
									
							}
							else if(cwinr==2 & (j+2)<15 & (i-j-2)>=0){
									if( Buttonpnl.flag[j+2][i-j-2]==2 & Buttonpnl.flag[j+1][i-j-1]== 2){
					//					try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
									Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.dolby();	cwinr=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else  {cwinr=0;	
									}
							}
							else if(cwinr==1 & (j+3)<15 & (i-j-3)>=0){
									if( Buttonpnl.flag[j+2][i-j-2]== 2& Buttonpnl.flag[j+1][i-j-1]== 2 
																			&Buttonpnl.flag[j+3][i-j-3]== 2 ){
					//					try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.dolby();	cwinr=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else 
										cwinr=0;
										
							}
							else if(cwinr==0 & (j+4)<15 & (i-j-4)>=0){
								if( Buttonpnl.flag[j+1][i-j-1]==2 & Buttonpnl.flag[j+2][i-j-2]== 2 
																			& Buttonpnl.flag[j+3][i-j-3]==2 
																			& Buttonpnl.flag[j+4][i-j-4]== 2){
					//					try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[j][i-j]= 2;		Buttonpnl.btn[j][i-j].setIcon(pcm);
											flg=1;	this.dolby();	cwinr=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
							}
					}
				}
						pwinr=0; cwinr=0;
			}
// right lower triangle
	rldig:	for(int i=10;i>=1;i--){		// right diagonal right diagonal right diagonal right diagonal
				for(int j=14, m=0;j>=i;j--,m++){
					if(Buttonpnl.flag[i+m][j]== 1){
						pwinx+=1;	cwinx=0;
					}
					else if(Buttonpnl.flag[i+m][j]== 2){
						pwinx=0;	cwinx+=1;
					}
					else if(Buttonpnl.flag[i+m][j]== 0){
							if(cwinx==4){
								Buttonpnl.flag[i+m][j]= 2;
					//			try {	Thread.sleep(1000);	} 	catch(Exception ee4){}
								Buttonpnl.btn[i+m][j].setIcon(pcm);
									flg=1;	this.dolby();	cwinx=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
								return;
							}
							
							else if(cwinx==3 &(i+m+1)<15 & (j-1)>=0 ){
									if( Buttonpnl.flag[i+m+1][j-1]== 2){
					//					try {	Thread.sleep(1000);	}	 catch(Exception eq4){}
										Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.dolby();	cwinx=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									 
										cwinx=0;
									
							}
							else if(cwinx==2 &(i+m+2)<15 & (j-2)>=0 ){
									if( Buttonpnl.flag[i+m+1][j-1]==2 & Buttonpnl.flag[i+m+2][j-2]== 2){
					//					try {	Thread.sleep(1000);	}	 catch(Exception e4j){}
									Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.dolby();	cwinx=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else  {cwinx=0;	
									}
							}
							else if(cwinx==1 & (i+m+3)<15 & (j-3)>=0 ){
									if( Buttonpnl.flag[i+m+1][j-1]== 2 & Buttonpnl.flag[i+m+2][j-2]==2 
																			&Buttonpnl.flag[i+m+3][j-3]== 2 ){
					//					try {	Thread.sleep(1000);	}	 catch(Exception ek4){}
										Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.dolby();	cwinx=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
									else 
										cwinx=0;
										
							}
							else if(cwinx==0 & (i+m+4)<15 & (j-4)>=0 ){
								if(  Buttonpnl.flag[i+m+1][j-1]== 2 & Buttonpnl.flag[i+m+2][j-2]== 2
																			&Buttonpnl.flag[i+m+3][j-3]== 2
																			& Buttonpnl.flag[i+m+4][j-4]== 2){
					//					try {	Thread.sleep(1000);	} 	catch(Exception ek4){}
										Buttonpnl.flag[i+m][j]= 2;		Buttonpnl.btn[i+m][j].setIcon(pcm);
											flg=1;	this.dolby();	cwinx=0;	upnl.push=0;	srh.clkavail=1; listenmouse.wcr=0;
									listenmouse.turn=1;
										return;
									}
							}
					}
				}
					pwinx=0; cwinx=0;
			}
			
			//clkavail=0; 
		listenmouse.prec=0;
	}
	
	public void dolby(){			
		try{
		
		File audi= new File("pj.wav");
		AudioInputStream clk= AudioSystem.getAudioInputStream(audi.getAbsoluteFile());
		Clip port = AudioSystem.getClip();		// clip object which put sound to audio system
		port.open(clk);		// open the stream that is read from file
		port.start();
		}
		catch(Exception e5){}
	}
	
	
	// the recursive function if no win condition or counter condition occurs
	// in six directions related to the position of user turn 
	
	public boolean  ftry(int a,int b ){
			if (Buttonpnl.flag[a][b]== 0){
				Buttonpnl.flag[a][b]= 2;
				Buttonpnl.btn[a][b].setIcon(this.pcm);
				this.dolby();
				return true;
			}
			else if (Buttonpnl.flag[a][b]!=0 &(b-1)>-1 & (a-1)>-1){
				
					return ftry(a-1,b-1);
			}
			return false;
	}
	public boolean  ftry2(int a,int b ){
		if (Buttonpnl.flag[a][b]== 0){
			Buttonpnl.flag[a][b]= 2;
			Buttonpnl.btn[a][b].setIcon(this.pcm);
			this.dolby();
			return true;
		}
		else if (Buttonpnl.flag[a][b]!=0 & (a+1)<15 & (b+1)<15){
			
				return ftry2(a+1,b+1);
		}
		return false;
	}
	public boolean  ftry3(int a,int b ){
		if (Buttonpnl.flag[a][b]== 0){
			Buttonpnl.flag[a][b]= 2;
			Buttonpnl.btn[a][b].setIcon(this.pcm);
			this.dolby();
			return true;
		}
		else if (Buttonpnl.flag[a][b]!=0 &(b-1)>-1){
				// ftry(a,b-1);
				return ftry3(a,b-1);
		}
		return false;
	}
	public boolean  ftry4(int a,int b ){
		if (Buttonpnl.flag[a][b]== 0){
			Buttonpnl.flag[a][b]= 2;
			Buttonpnl.btn[a][b].setIcon(this.pcm);
			this.dolby();
			return true;
		}
		else if (Buttonpnl.flag[a][b]!=0 & (b+1)<15){
				// ftry(a,b+1);
					return ftry4(a,b+1);
		}
		return false;
	}
	public boolean  ftry5(int a,int b ){
		if (Buttonpnl.flag[a][b]== 0){
			Buttonpnl.flag[a][b]= 2;
			Buttonpnl.btn[a][b].setIcon(this.pcm);
			this.dolby();
			return true;
		}
		else if (Buttonpnl.flag[a][b]!=0 & (a+1)<15){
				// ftry5(a+1,b);
					return ftry5(a+1,b);
		}
		return false;
	}
	public boolean  ftry6(int a,int b ){
		if (Buttonpnl.flag[a][b]== 0){
			Buttonpnl.flag[a][b]= 2;
			Buttonpnl.btn[a][b].setIcon(this.pcm);
			this.dolby();
			return true;
		}
		else if (Buttonpnl.flag[a][b]!=0 & (a-1)>-1){
				// ftry6(a-1,b);
					return ftry6(a-1,b);
			}
			
			System.out.println("GAME OVER ");
			return false;
	}
}

