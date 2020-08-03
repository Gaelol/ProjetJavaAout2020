package vue;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controleur.Controleur;
import modele.Demarrage;



public class VueConsole extends Vue implements Observer {
	protected Scanner sc;
	
	public VueConsole(Demarrage modele,
			Controleur controleur) {
		super(modele, controleur);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(modele);
		printHelp();
		
	}
	

	private void printHelp(){
		affiche("slt");
	}
	
	private class ReadInput implements Runnable{
		public void run() {
		}
	}


	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
		}
	}
