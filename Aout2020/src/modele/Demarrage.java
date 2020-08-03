package modele;

import java.util.Observable;
import modele.*;

public class Demarrage extends Observable{
	public int avance = 0;
	
	public int Avance() {
		avance += 1; 
		return avance;		
	}
}
