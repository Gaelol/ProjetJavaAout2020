package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controleur.Controleur;
import modele.Quizz;

public class VueGUI extends Vue implements ActionListener {
	private JFrame frame;
	private JLabel titre,label,labelQues;
	private JPanel topPanel,midPanel,botPanel,valiPanel,panelQ6,panelQ8;
	private JButton tf,button1,button2,button3,button4,button5,button6,buttonReponse;
	private JTextField reponse;
	private String rep;
	private ArrayList<JButton> buttons;
    private Clip clip; 
    private AudioInputStream audioInputStream;  
    private static String filepath; 
    private Container container;
    private Font font;
    
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
		    topPanel.setLayout(new FlowLayout(3));
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
		    label.setOpaque(true);
		    label.setBorder(new LineBorder(Color.black,2));
			
		    labelQues = new JLabel(modele.toString(),SwingConstants.CENTER);
		    labelQues.setFont(font);
		   
		    //Texte de la réponse
		    reponse = new JTextField("",60);
		    reponse.setFont(font);
		    
		    //JButton pour la réponse
		    tf = new JButton("Répondre");
		    tf.setFont(font);
		    
		    
		    midPanel.add(valiPanel);
		    container.add(label,BorderLayout.CENTER);
		    container.add(botPanel,BorderLayout.SOUTH);
		    botPanel.add(tf);
		    botPanel.add(reponse);
		    container.add(midPanel,BorderLayout.WEST);
		    topPanel.add(titre);

		   //Actions
		    tf.addActionListener(this);
		    
		}
		

		@Override
		public void update(Observable arg0, Object arg1) {
			affiche(modele.toString());
			reponse.setText(null);
			label.setIcon(null);
			
			if(modele.question == 2) {
				label.setText(null);
				label.setIcon(new ImageIcon(VueGUI.class.getResource("/img/Yacht.jpg")));
			}
			
			if(modele.question == 4) {
				try {
					SimpleAudioPlayer(filepath);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}
			}
			
			if(modele.question == 5) {
				clip.stop();
			}
			
			if(modele.question == 6) {
				reponse.setEnabled(false);
				Images();
			}
			
			if(modele.question == 7) {
				panelQ6.setVisible(false);
				label.setVisible(true);
				reponse.setEnabled(false);
				  for(int i = 0; i<10;i++) {
					    buttons.get(i).setEnabled(true);
					    buttons.get(i).addActionListener(this);
				  	}
				  buttonReponse = buttons.get(2);
				 }
			
			if(modele.question == 8) {
				reponse.setEnabled(true);
				Q8();
			}
			
		}

		 public void SimpleAudioPlayer(String filepath) throws UnsupportedAudioFileException,IOException, LineUnavailableException  
			    { 
			        // create AudioInputStream object 
			        audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\gael-\\git\\ProjetJavaAout2020\\Aout2020\\src\\img\\Queen.wav").getAbsoluteFile()); 
			          
			        // create clip reference 
			        clip = AudioSystem.getClip(); 
			          
			        // open audioInputStream to the clip 
			        clip.open(audioInputStream); 
			        
			        clip.start();
			    } 
		 public void Images() {
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
			    
			    panelQ6.add(labelQues,BorderLayout.SOUTH);
			    container.add(panelQ6,BorderLayout.CENTER);
			 
		 }
		 
		 public void Q8() {
			 	label.setVisible(false);
				
				panelQ8 = new JPanel();
				panelQ8.setLayout(new GridLayout());
			    panelQ8.setBorder(new LineBorder(Color.black,2));
			    container.add(panelQ8);
		 }
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source==tf) {
				rep = reponse.getText();
				controleur.next(rep);
				}
			if(source==button3) {
				rep = "3";
				controleur.next(rep);
			}
			if(source== buttonReponse) {
				rep ="question 3";
				controleur.next(rep);
			}
			
		}

		@Override
		public void affiche(String string) {
			label.setText(string);
			if(modele.question > 0) {
				buttons.get(modele.question-1).setBackground(Color.BLUE);
			}
			else {
				
			}
		}
		
}
