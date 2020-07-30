package test;

	import controleur.Controleur;
import modele.Modele;
import vue.Vue;
import vue.VueConsole;
import vue.VueGUI;

	
	public class MVC {
			public MVC() {
				//Création du modèle
				
				Modele mod = new Modele();

				//Création des contrôleurs : Un pour chaque vue
				//Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
				
				Controleur consoleControleur = new Controleur(mod);
				Controleur guiControleur = new Controleur(mod);
				
				//Création des vues.
				//Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle pour pouvoir l'observer
				
				VueConsole console = new VueConsole(mod, consoleControleur);
				VueGUI gui = new VueGUI(mod, guiControleur, 0, 0);
				
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