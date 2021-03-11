package costTreballador;
/**
 * Classe per a guardar les dades d'un treballador
 * No tenim main perquè no la farem servir a soles
 * @author EMILIO
 *
 */
class Treballador{
	static final int DIRECTOR=0;
	static final int SUBDIRECTOR=1;
	static final int BASE=2;
	String nomTreballador;
	int tipusTreballador;
	float nominaTreballador;
	int horesExtresTreballador;
	//Constructor amb arguments, alternatiu al constructor per defecte
	Treballador (String nom, int tipus, float nomina, int hores){
		nomTreballador = nom;
		tipusTreballador = tipus;
		nominaTreballador = nomina;
		horesExtresTreballador = hores;
	}
	//Constructor buit per defecte, l'hem de declarar si volem poder usar-lo per culpa d'haver declarat l'anterior
	Treballador(){
	}
	void setNom (String nom) throws Exception {
		//Si la longitud del nou nom es inferior a tres caracters llença excepcio avisant del problema
		if (nom.length() < 3) {
			throw new Exception("El nom ha de tenir 3 o més caracters");
		}
		//En cas contrari assigna el nom
		nomTreballador = nom;
	}
	String getNom () {
		return nomTreballador;
	}
	void setNomina(float euros) {
		//Per simplicitat no comprovem que la nomina és superior a zero ja que el programa no fallarà per aquest error
		//i així ens estalviem les excepcions
		nominaTreballador = euros;
	}
	float getNomina() {
		return nominaTreballador;
	}
	void setHoresExtres(int hores) {
		//Les hores extra poden ser zero sense problema
		horesExtresTreballador = hores;
	}
	int getHoresExtres() {
		return horesExtresTreballador;
	}
	void setTipusTreballador(int tipus) throws Exception {
		//Aqui no és recomanable estalviar-se les comprovacions perquè el tipus de treballador només pot ser DIRECTOR, SUbDIRECTOR o BASE
		if ((tipus == DIRECTOR)||(tipus==SUBDIRECTOR)||(tipus==BASE)) {
			//Si el tipus és vàlid, l'assignem
			tipusTreballador = tipus;
		} else {
			//Si el tipus no és valid, creem excepció
			throw new Exception("Tipus de treballador no vàlid");
		}
	}
	int getTipusTreballador() {
		return tipusTreballador;
	}
}
/**
 * Classe per a calcular el cost total de les nomines del personal
 * @author EMILIO
 *
 */
public class costPersonal {
	//static enum TipusTreballador{
	// DIRECTOR, SUBDIRECTOR, BASE
	//}
	
	/*
	 *  Aquest metode primer si no troba cap treballador tornara zero. El següent que fara es 
	 *  calcular el sou de cada tipus de treballador. El director i el subdirector el seu cost 
	 *  sera la nomina sense hores extra i el treballador base es calculara sumant la seva 
	 *  nomina més les hores extra multiplicades per 20€ la hora. AL final aquest metode retornara
	 *  el total del cost dels treballadors.
	 *  
	 */
	static float CalculaCostDelPersonal(Treballador treballadors[]) {
		float costFinal = 0;
		Treballador treballador;
		
		if (treballadors == null) {
				return 0;
		}
		for (int i = 0; i < treballadors.length; i++) {
			treballador = treballadors[i];
			if ( treballador.getTipusTreballador() == Treballador.DIRECTOR ||
					treballador.getTipusTreballador() == Treballador.SUBDIRECTOR) {
				costFinal += treballador.getNomina();
			}
			else
			{
				costFinal += treballador.getNomina() +
						(treballador.getHoresExtres() * 20);
			}
		}
		return costFinal;
	}
	
	/*
	 * Aquest metode calcula EL COST DE CADA TIPUS DE TREBALLADORS. El director i el 
	 *  subdirector el seu cost sera la nomina sense hores extra i el treballador base es
	 *  calculara sumant la seva nomina més les hores extra multiplicades per 20€ la hora.
	 */
	static float CostTreballador(Treballador treballador){
		if ( treballador.getTipusTreballador() == Treballador.DIRECTOR ||
				treballador.getTipusTreballador() == Treballador.SUBDIRECTOR ) {
			return treballador.getNomina();
		}
		else {
			return treballador.getNomina()+ (treballador.getHoresExtres() *
					20);
		}
	}
	
	/*
	 * Aquest metode es la versio refactoritzada del mètode que calcula el cost total dels treballadors
	 */
	static float CalculaCostDelPersonal2(Treballador treballadors[]) {
		//Versio refactoritzada del mètode anterior
		float costFinal = 0;
		Treballador treballador;
		for (int i = 0; i < treballadors.length; i++) {
			costFinal= costFinal + CostTreballador(treballadors[i]);
		}
		return costFinal;
	}
}