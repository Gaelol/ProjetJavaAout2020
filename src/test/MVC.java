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
			 * Cr�ation du mod�le
			 * 
			 * Cr�ation des contr�leurs : Un pour chaque vue
			 * Chaque contr�leur doit avoir une r�f�rence vers le mod�le pour pouvoir le commander
			 * 
			 * Cr�ation des vues.
			 * Chaque vue doit conna�tre son contr�leur et avoir une r�f�rence vers le mod�le pour pouvoir l'observer
			 * 
			 * On donne la r�f�rence � la vue pour chaque contr�leur
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
			 * Cr�er et d�veloppe l'interface Utilisateur de l'application
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