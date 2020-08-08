package controleur;

import modele.Questions;
import vue.Vue;

public class Controleur {
	Questions modele; 
	Vue vue;
	public Controleur( Questions modele) {
		this.modele = modele;
	}
 
	public void next(String rep) {
		if(modele.Demarre(rep)) {
			
			modele.question +=1;
			vue.affiche(modele.toString() + modele.question);
			
		}
		else{
			
		}
	}
	
	public void addView(Vue vue) {
		this.vue = vue;
	}

}