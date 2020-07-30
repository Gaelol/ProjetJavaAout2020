package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;

import controleur.Controleur;
import modele.Modele;

public class VueGUI extends Vue implements ActionListener {
	JFrame frame;

		public VueGUI(Modele modele, Controleur controleur,int posX, int posY) {
			super(modele, controleur);
			// TODO Auto-generated constructor stub
			initComponent();
		}
		
		public void initComponent() {
			frame = new JFrame("Example");
			frame.setSize(300,300);
			frame.setVisible(true);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void affiche(String string) {
			// TODO Auto-generated method stub
			
		}
}
