package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controleur.Controleur;
import modele.Quizz;

/**
 * The Class VueGUI.
 *
 * @author gael-
 */
public class VueGUI extends Vue implements ActionListener {
	
	
	private JFrame frame;
	
	private JLabel titre,label,labelQ9,resLabel;

	private JPanel topPanel,midPanel,botPanel,valiPanel,panelQ6,panelQ9,panelTestQ9;
	
	private JButton repondre,button1,button2,button3,button4,button5,button6,buttonReponse,q9un,q9deux,q9trois;
	
	private JTextField reponse;
	
	private String rep;
	
	private ArrayList<JButton> buttons;
    
    private Clip clip; 
    
    private AudioInputStream audioInputStream;  
    
    private Container container;
    
    private Font font;
    
    private int int1 = 0,int2 = 0,int3 = 0;
    
		/**
		 * Instantiates a new vue GUI.
		 *
		 * @param modele the modele
		 * @param controleur the controleur
		 * @param posX the pos X
		 * @param posY the pos Y
		 */
		public VueGUI(Quizz modele, Controleur controleur,int posX, int posY) {
			super(modele, controleur);
			
			//Font
			font = new Font("Courier New", Font.BOLD, 30);
			
			//JLAbel
			titre = new JLabel("RiquiQuizz",JLabel.CENTER);
			titre.setFont(new Font("Courier New", Font.ITALIC, 64));
			titre.setForeground(Color.orange);
			
			//JFrame
			frame = new JFrame("RiquiQuizz");
		    frame.setResizable(false);
		    frame.setSize(1300,1000);
		    frame.setVisible(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    
		    //Layout
		    container = frame.getContentPane();
		    container.setLayout(new BorderLayout(8,6));
		    container.setBackground(Color.white);
		    frame.getRootPane().setBorder(new LineBorder(Color.black,2));
		    
		    //Panel Titre
		    topPanel = new JPanel();
		    topPanel.setBorder(new LineBorder(Color.black,2));
		    topPanel.setBackground(Color.white);
		    container.add(topPanel,BorderLayout.NORTH);
		    
		    //Panel Gauche
		    midPanel = new JPanel();
		    midPanel.setBorder(new LineBorder(Color.black,2));
		    midPanel.setBackground(Color.cyan);
		    midPanel.setLayout(new FlowLayout(4,4,4));
		    container.add(midPanel,BorderLayout.WEST);
		    
		    //Panel Question
		    valiPanel = new JPanel();
		    valiPanel.setLayout(new GridLayout(10,10,5,5));
		    valiPanel.setBorder(new LineBorder(Color.black,2));
		    valiPanel.setBackground(Color.red);
		    
		    //Panel Reponse
		    botPanel = new JPanel();
		    botPanel.setLayout(new FlowLayout(2));
		    botPanel.setBorder(new LineBorder(Color.black,2));
		    
		    //JButton
		    buttons = new ArrayList<JButton>();
		    for(int i = 0; i<10;i++) {
		    buttons.add(new JButton("Question "+ (i+1)));
		    buttons.get(i).setEnabled(false);
		    valiPanel.add(buttons.get(i));
		    }
		    
		    
		    //Label Texte
		    label = new JLabel(modele.toString(),SwingConstants.CENTER);
		    label.setFont(font);
		    label.setBorder(new LineBorder(Color.black,2));
		    labelQ9 = new JLabel("",SwingConstants.CENTER);
			labelQ9.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Logique.jpg")));
		
		    reponse = new JTextField("",60);
		    reponse.setFont(font);
		    
		    //JButton pour la réponse
		    repondre = new JButton("Répondre");
		    repondre.setFont(font);
		    repondre.setBackground(Color.LIGHT_GRAY);
		    repondre.setPreferredSize(new Dimension(180, 40));
		    
		    
		    midPanel.add(valiPanel);
		    container.add(label,BorderLayout.CENTER);
		    container.add(botPanel,BorderLayout.SOUTH);
		    botPanel.add(repondre);
		    botPanel.add(reponse);
		    container.add(midPanel,BorderLayout.WEST);
		    topPanel.add(titre);

		   //Actions
		    repondre.addActionListener(this);
		    
		}
		
		/**
		 * Update cont.
		 */
		public void updateCont(){
			affiche(modele.toString());
			reponse.setText(null);
			label.setIcon(null);
			repondre.setIcon(null);
			repondre.setText("Répondre");
			if(modele.numQuestion > 0) {
				buttons.get(modele.numQuestion-1).setBackground(Color.BLUE);
			}
		}
		
		/**
		 * Update.
		 *
		 * @param arg0 the arg 0
		 * @param arg1 the arg 1
		 */
		
		@Override
		public void update(Observable arg0, Object arg1) {
			updateCont();	
			
			if(modele.numQuestion == 2) {
				label.setText(null);
				label.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Yacht.jpg")));
			}
			
			if(modele.numQuestion == 4) {
				try {
					SoundPlayer("C:\\Users\\gael-\\git\\ProjetJavaAout2020\\Aout2020\\src\\img\\Queen.wav");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}
			}
			
			if(modele.numQuestion == 5) {
				clip.stop();
			}
			
			if(modele.numQuestion == 6) {
				reponse.setEnabled(false);
				Q6();
			}
			
			if(modele.numQuestion == 7) {
				panelQ6.setVisible(false);
				label.setVisible(true);
				reponse.setEnabled(false);
				  for(int i = 0; i<10;i++) {
					    buttons.get(i).setEnabled(true);
					    buttons.get(i).addActionListener(this);
				  	}
				  buttonReponse = buttons.get(2);
				 }
			
			if(modele.numQuestion == 8) {
				Q8();
			}
			
			if(modele.numQuestion == 9) {
				Q9();
			}
			if(modele.numQuestion==10) {
				panelTestQ9.setVisible(false);
				label.setVisible(true);
				label.setBorder(null);
			}
		}

		 /**
 		 * Simple audio player.
 		 *
 		 * @param filepath the filepath
 		 * @throws UnsupportedAudioFileException the unsupported audio file exception
 		 * @throws IOException Signals that an I/O exception has occurred.
 		 * @throws LineUnavailableException the line unavailable exception
 		 */
 		public void SoundPlayer(String filepath) throws UnsupportedAudioFileException,IOException, LineUnavailableException  
			    { 
			        // create AudioInputStream object 
			        audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile()); 
			          
			        // create clip reference 
			        clip = AudioSystem.getClip(); 
			          
			        // open audioInputStream to the clip 
			        clip.open(audioInputStream); 
			        
			        clip.start();
			        
			    } 
		 
		 /**
 		 * Q6.
 		 */
 		public void Q6() {
			 label.setVisible(false);
			 
			 panelQ6 = new JPanel();
			 
			    panelQ6.setLayout(new GridLayout(0,2));
			    panelQ6.setBorder(new LineBorder(Color.black,2));
			    button1 = new JButton("");
			    button1.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Mi.jpg")));
			    panelQ6.add(button1);
			    button1.addActionListener(this);
			    button2 = new JButton("");
			    button2.setIcon(new ImageIcon(VueGUI.class.getResource("/img/La.jpg")));
			    panelQ6.add(button2);
			    button2.addActionListener(this);
			    button3 = new JButton("");
			    button3.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Ré.jpg")));
			    panelQ6.add(button3);
			    button3.addActionListener(this);
			    button4 = new JButton("");
			    button4.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Sol.jpg")));
			    panelQ6.add(button4);
			    button4.addActionListener(this);
			    button5 = new JButton("");
			    button5.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Si.jpg")));
			    panelQ6.add(button5);
			    button5.addActionListener(this);
			    button6 = new JButton("");
			    button6.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Mi2.jpg")));
			    panelQ6.add(button6);
			    button6.addActionListener(this);
			    panelQ6.setBorder(BorderFactory.createTitledBorder(null, modele.toString(), TitledBorder.CENTER, TitledBorder.TOP,font));
			   
			    container.add(panelQ6,BorderLayout.CENTER);
			 
		 }
		 
		 /**
 		 * Q8.
 		 */
 		public void Q8() {
			 
			 	label.setText(null);
				label.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Charlie.jpg")));
				repondre.setText("");
				repondre.setIcon(new ImageIcon(VueGUI.class.getResource("/img/butCharlie.jpg")));
				label.setBorder(BorderFactory.createTitledBorder(null, modele.toString(), TitledBorder.CENTER, TitledBorder.TOP,font));
				
		 }
		 
		 /**
 		 * Q9.
 		 */
 		public void Q9() {
			label.setVisible(false);
			panelTestQ9 = new JPanel();
			panelTestQ9.setLayout(new GridLayout(2,0));
			panelQ9 = new JPanel(); 
			panelQ9.setLayout(new GridLayout(0,3));
			q9un = new JButton(""+int1);
			panelQ9.add(q9un);
			q9un.addActionListener(this);
			q9deux = new JButton(""+int2);
			panelQ9.add(q9deux);
			q9deux.addActionListener(this);
			q9trois = new JButton(""+int3);
			panelQ9.add(q9trois);
			q9trois.addActionListener(this);
			panelTestQ9.add(labelQ9);
			panelTestQ9.add(panelQ9);
			container.add(panelTestQ9);
			panelTestQ9.setBorder(BorderFactory.createTitledBorder(null, modele.toString(), TitledBorder.CENTER, TitledBorder.TOP,font));
			reponse.setEnabled(false);
		 }

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			if(source==repondre) {
				if(modele.numQuestion == 9) {
					rep =  ""+ int1 + int2 + int3 ;
					controleur.next(rep);
				}
				if(modele.numQuestion == 8) {
					rep = "bouton";
					controleur.next(rep);
				}
				
				else {
				rep = reponse.getText();
				controleur.next(rep);
				}
			}
			if(source==button3) {
				rep = "3";
				controleur.next(rep);
			}
			
			if(source== buttonReponse) {
				rep ="question 3";
				controleur.next(rep);
			}
			
			if(source==q9un) {
				if(int1<9) {
				int1++;
				}
				else{
					int1=0;
					}
				q9un.setText(""+int1);
			}
			if(source==q9deux) {
				if(int2<9) {
					int2++;
					}
					else{
						int2=0;
						}
				q9deux.setText(""+int2);
			}
			if(source==q9trois) {
				if(int3<9) {
					int3++;
					}
					else{
						int3=0;
						}
				q9trois.setText(""+int3);
			}
			
		}

		/**
		 * Affiche.
		 *
		 * @param string the string
		 */
		@Override
		public void affiche(String string) {
			label.setText(string);
		}
		
		/**
		 * Resultats.
		 */
		public void resultats() {
			resLabel.setText("Faux! Réessayez");
		}
		
}
