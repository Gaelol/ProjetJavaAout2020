package vue;
import java.util.InputMismatchException;
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
		affiche(modele.avance[modele.question]);
		printHelp();
	}
	

	private void printHelp(){
		affiche("Réponse à la question : ");
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true){
				try{
					String rep = sc.next();
						controleur.next(rep);
				}
				catch(InputMismatchException e) {
					System.out.println("Réponse érronée, veuillez réessayer!");
				}
			}}
		}
	

	@Override
	public void affiche(String str) {
		System.out.println(str);
		}
	}
