package vue;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controleur.Controleur;
import modele.Quizz;


/**
 * La classe VueConsole.
 *
 * @author gael-
 */
public class VueConsole extends Vue implements Observer {
	protected Scanner sc;
	
	/**
	 * Instancie une nouvelle Vue Console.
	 *
	 * @param modele     the modele
	 * @param controleur the controleur
	 */
	public VueConsole(Quizz modele,
			Controleur controleur) {
		super(modele, controleur);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	/**
	 * Rafraichit l'affichage.
	 *
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		affiche(modele.toString());
		
	}
	
	
	/**
	 * Classe permettant de récupérer la ligne insérer dans la console.
	 */
	private class ReadInput implements Runnable{
		
		public void run() {
			while(true) {
					String rep = sc.next();
					controleur.next(rep);
			}
			}
		}
	
	/**
	 * Reçoit une string et l'affiche en console.
	 *
	 * @param str the str
	 */
	@Override
	public void affiche(String str) {
		
		System.out.println(str);

		}
	}
