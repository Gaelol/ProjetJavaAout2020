package vue;
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JButton;

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
		System.out.println(modele);
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

	@Override
	public void valideButton() {
		// TODO Auto-generated method stub
	}
	}
