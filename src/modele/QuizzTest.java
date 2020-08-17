package modele;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class QuizzTest {
	
	@Test
	void test1() {
		Quizz qui = new Quizz();
		qui.question = 1;
		assertEquals(qui.Demarre("squelette"),true);
		
	}
	
	@Test
	void test2() {
		Quizz qui2 = new Quizz();
		qui2.question = 3;
		assertEquals(qui2.Demarre("vrai"),true);
	}
	
	@Test
	void test3() {
		Quizz qui3 = new Quizz();
		qui3.question = 9;
		assertEquals(qui3.Demarre("35"),false);
	}
	
	@Test
	void test4() {
		Quizz qui4 = new Quizz();
		qui4.question = 5;
		assertEquals(qui4.Demarre("LOUP"),true);
	}
}
