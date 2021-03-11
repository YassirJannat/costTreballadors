package costTreballador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class costPersonalTest {

	@Test
	void testCalculaCostDelPersonalAmb3() {
		
		float resultat;
		float resultatCorrecte = 6400;
		
		Treballador treballadors[] = new Treballador [3];
		treballadors[0] =  new Treballador("Alex", Treballador.DIRECTOR, 2000, 0);
		treballadors[1] =  new Treballador("Jordi", Treballador.SUBDIRECTOR, 2000, 0);
		treballadors[2] =  new Treballador("Yassir", Treballador.BASE, 2000, 20);
		
		resultat = costPersonal.CalculaCostDelPersonal(treballadors);
		
		assertEquals(resultat, resultatCorrecte, "S'esperava que retornara 6400");
		
	}
	
	@Test
	void testCalculaCostDelPersonalAmb1() {
		
		float resultat;
		float resultatCorrecte = 2000;
		
		Treballador treballadors[] = new Treballador [1];
		treballadors[0] =  new Treballador("Alex", Treballador.SUBDIRECTOR, 2000, 0);
		
		resultat = costPersonal.CalculaCostDelPersonal(treballadors);
		
		assertEquals(resultat, resultatCorrecte, "S'esperava que retornara 2000");
		
	}
	
	@Test
	void testCalculaCostDelPersonalAmb0() {
		
		float resultat;
		float resultatCorrecte = 0;
		
		Treballador treballadors[] = null;
		
		resultat = costPersonal.CalculaCostDelPersonal(treballadors);
		
		assertEquals(resultat, resultatCorrecte, "S'esperava que retornara zero");
	}

}
