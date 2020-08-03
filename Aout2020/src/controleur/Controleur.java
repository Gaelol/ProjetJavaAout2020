package controleur;

import modele.Demarrage;
import vue.Vue;

public class Controleur {
	 Demarrage model; 
	Vue vue;
	public Controleur( Demarrage model) {
		this.model = model;
	}

	public void addView(Vue vue) {
		this.vue = vue;
	}

}