package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controleur.Controleur;
import modele.Questions;

public class VueGUI extends Vue implements ActionListener {
	private JFrame frame;
	private JLabel titre,label;
	private JButton button;
	private JPanel topPanel,midPanel,botPanel,sidePanel,valiPanel;
	private JButton tf,button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
	private JTextField reponse;
	private String rep;
	
	
		public VueGUI(Questions modele, Controleur controleur,int posX, int posY) {
			super(modele, controleur);
			
			//JLAbel
			titre = new JLabel("RiquiQuizz",JLabel.CENTER);
			titre.setFont(new Font("Courier New", Font.ITALIC, 64));
			titre.setForeground(Color.orange);
			
			//JFrame
			frame = new JFrame("RiquiQuizz");
		    frame.setResizable(false);
		    frame.setSize(1300,900);
		    frame.setVisible(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    
		    //Layout
		    Container container = frame.getContentPane();
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
		    button1 = new JButton("Question 1");
		    button2 = new JButton("Question 2");
		    button3 = new JButton("Question 3");
		    button4 = new JButton("Question 4");
		    button5 = new JButton("Question 5");
		    button6 = new JButton("Question 6");
		    button7 = new JButton("Question 7");
		    button8 = new JButton("Question 8");
		    button9 = new JButton("Question 9");
		    button10 = new JButton("Question 10");
		    valiPanel.add(button1);
		    valiPanel.add(button2);
		    valiPanel.add(button3);
		    valiPanel.add(button4);
		    valiPanel.add(button5);
		    valiPanel.add(button6);
		    valiPanel.add(button7);
		    valiPanel.add(button8);
		    valiPanel.add(button9);
		    valiPanel.add(button10);
		    
		    //Label Texte
		    label = new JLabel(modele.avance[modele.question],SwingConstants.CENTER);
		    label.setFont(new Font("Courier New", Font.BOLD, 30));
		    label.setOpaque(true);
		    label.setBorder(new LineBorder(Color.black,2));
		   
		    //Texte de la réponse
		    reponse = new JTextField("",60);
		    reponse.setFont(new Font("Courier New", Font.BOLD, 30));
		    
		    //JButton pour la réponse
		    tf = new JButton("Répondre");
		    tf.setFont(new Font("Courier New", Font.BOLD, 30));
		    
		    
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
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source==tf) {
				
				rep = reponse.getText();
				controleur.next(rep);
				
			}
			
		}

		@Override
		public void affiche(String string) {
			label.setText(string);
		}
		
}
