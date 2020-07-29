package controleur;

import modele.Modele;
import vue.Vue;

public class Controleur {
	 Modele model; 
	Vue vue;
	public Controleur( Modele model) {
		this.model = model;
	}

	public void addView(Vue vue) {
		this.vue = vue;
	}

}