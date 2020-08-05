package modele;

import java.util.Observable;
import modele.*;

public class Demarrage extends Observable{
	public int question = 0; 
	public String[] avance = {"Combien font 1+1","Bien ouèj","ntm"};

	public boolean Demarre(String rep) {
		
		if(question == 0) {
			if(rep.equals("2")) {
				return true;
			}
		}
		if(question == 1) {
			if(rep.equals("Bonjour")) {
				return true;
			}
		}
		return false;
	}
}
