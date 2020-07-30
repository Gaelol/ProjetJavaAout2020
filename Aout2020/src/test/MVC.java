package test;

	import controleur.Controleur;
import modele.Modele;
import vue.Vue;
import vue.VueConsole;
import vue.VueGUI;

	
	public class MVC {
			public MVC() {
				//Cr�ation du mod�le
				
				Modele mod = new Modele();

				//Cr�ation des contr�leurs : Un pour chaque vue
				//Chaque contr�leur doit avoir une r�f�rence vers le mod�le pour pouvoir le commander
				
				Controleur consoleControleur = new Controleur(mod);
				Controleur guiControleur = new Controleur(mod);
				
				//Cr�ation des vues.
				//Chaque vue doit conna�tre son contr�leur et avoir une r�f�rence vers le mod�le pour pouvoir l'observer
				
				VueConsole console = new VueConsole(mod, consoleControleur);
				VueGUI gui = new VueGUI(mod, guiControleur, 0, 0);
				
				//On donne la r�f�rence � la vue pour chaque contr�leur
				
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