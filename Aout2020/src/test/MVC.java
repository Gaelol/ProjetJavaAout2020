package test;

	import controleur.Controleur;
import modele.Demarrage;
import vue.VueConsole;
import vue.VueGUI;

	
	public class MVC {
			public MVC() {
				//Création du modèle
				
				Demarrage modele = new Demarrage();

				//Création des contrôleurs : Un pour chaque vue
				//Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
				
				Controleur consoleControleur = new Controleur(modele);
				Controleur guiControleur = new Controleur(modele);
				
				//Création des vues.
				//Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle pour pouvoir l'observer
				
				VueConsole console = new VueConsole(modele, consoleControleur);
				VueGUI gui = new VueGUI(modele, guiControleur, 100, 100);
				
				//On donne la référence à la vue pour chaque contrôleur
				
				consoleControleur.addView(console);
				guiControleur.addView(gui);
				
			}
			
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