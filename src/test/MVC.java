package test;

	import controleur.Controleur;

import modele.Quizz;
import vue.VueConsole;
import vue.VueGUI;

	
/**
	 * La classe MVC,contient la classe main.
	 *
	 * @author gael-
	 */
	public class MVC {
			
			/**
			 * Création du modèle
			 * 
			 * Création des contrôleurs : Un pour chaque vue
			 * Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
			 * 
			 * Création des vues.
			 * Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle pour pouvoir l'observer
			 * 
			 * On donne la référence à la vue pour chaque contrôleur
			 */
			public MVC() {
				
				Quizz que = new Quizz();

				Controleur consoleControleur = new Controleur(que);
				Controleur guiControleur = new Controleur(que);

				VueConsole console = new VueConsole(que, consoleControleur);
				VueGUI gui = new VueGUI(que, guiControleur, 200, 100);
				
				consoleControleur.addView(console);
				guiControleur.addView(gui);
				
			}
			
			/**
			 * 
			 * Créer et développe l'interface Utilisateur de l'application
			 * Lance l'application.
			 * 
			 * @param args un tableau de String
			 */
			public static void main(String args[]) {
				//Schedule a job for the event-dispatching thread:
				//creating and showing this application's GUI.
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new MVC();
					}
				});
			}
		}