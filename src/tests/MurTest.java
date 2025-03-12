package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import modele.Mur;

class MurTest {
	
	Mur mur1 = new Mur();
	Mur mur2 = new Mur();
	
	@Test
	void testToucheObjetGauche() {
		// mur2 touche à gauche du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(40);
		mur2.setPosY(50);
		assertTrue(mur1.toucheObjet(mur2));			
	}
	
	@Test
	void testToucheObjetDroite() {
		// mur2 touche à droite du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(60);
		mur2.setPosY(50);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}	
	@Test
	void testToucheObjetHaut() {
		// mur2 touche au dessus du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(50);
		mur2.setPosY(40);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}
	@Test
	void testToucheObjetBas() {
		// mur2 touche en dessous du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(50);
		mur2.setPosY(60);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}
	@Test
	void testNonToucheObjetGauche() {
		// mur2 ne touche pas à gauche du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(10);
		mur2.setPosY(50);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}
	@Test
	void testNonToucheObjetDroite() {
		// mur2 ne touche pas à droite du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(90);
		mur2.setPosY(50);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}
	@Test
	void testNonToucheObjetHaut() {
		// mur2 ne touche pas au dessus du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(50);
		mur2.setPosY(10);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}
	@Test
	void testNonToucheObjetBas() {
		// mur2 ne touche pas en dessous du mur1
		mur1.setPosX(50);
		mur1.setPosY(50);
		mur2.setPosX(50);
		mur2.setPosY(90);
		assertTrue(mur1.toucheObjet(mur2));	
		
	}
}
