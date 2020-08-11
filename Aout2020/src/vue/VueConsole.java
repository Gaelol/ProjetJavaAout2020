package vue;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controleur.Controleur;
import modele.Quizz;



public class VueConsole extends Vue implements Observer {
	protected Scanner sc;
	
	public VueConsole(Quizz modele,
			Controleur controleur) {
		super(modele, controleur);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	@Override
	public void update(Observable o, Object arg) {
		affiche(modele.toString() + modele.question);
	}
	
	
	private class ReadInput implements Runnable{
		public void run() {
			
					String rep = sc.next();
					controleur.next(rep);
		
			}
		}
	

	@Override
	public void affiche(String str) {
		System.out.println(str);
		}

	}
