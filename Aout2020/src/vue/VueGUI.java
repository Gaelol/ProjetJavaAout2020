package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

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
	private JLabel titre,label;
	private JPanel topPanel,midPanel,botPanel,sidePanel,valiPanel;
	private JButton tf;
	private JTextField reponse;
	private String rep;
	private ArrayList<JButton> buttons;
	
		public VueGUI(Quizz modele, Controleur controleur,int posX, int posY) {
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
		    buttons = new ArrayList<JButton>();
		    for(int i = 0; i<10;i++) {
		    buttons.add(new JButton("button"+i));
		    buttons.get(i).setEnabled(true);
		    valiPanel.add(buttons.get(i));
		    }
		  
		    
		    //Label Texte
		    label = new JLabel(modele.toString(),SwingConstants.CENTER);
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
		
		public void valideButton() {
			buttons.get(modele.question-1).setBackground(Color.BLUE);
			buttons.get(modele.question-1).setEnabled(false);
		}
		

		@Override
		public void update(Observable arg0, Object arg1) {
			affiche(modele.toString());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source==tf) {
				if(modele.question == 0) {
					rep = reponse.getText();
					controleur.next(rep);
					
					ImageIcon background = new ImageIcon("Yacht.jpg");
					label.setIcon(background);
				}
				else {
				rep = reponse.getText();
				controleur.next(rep);
				}
			}
			
		}

		@Override
		public void affiche(String string) {
			label.setText(string);
		}
		
}
