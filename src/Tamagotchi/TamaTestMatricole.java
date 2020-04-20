package Tamagotchi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class TamaTestMatricole
{
	// Attenzione, costruttore utilizzato:
	// public Tamagotchi (String nome, int gradoAffettivo, int gradoSazieta)
	
	@Test
	public void dieForZeroSatisfaction() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 0, 50);
		assertTrue(tama.isMorto());
	}
	
	@Test
	public void dieForZeroHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 0);
		assertTrue(tama.isMorto());
	}
	
	@Test
	public void aliveWhenSatisfactionAndHungerAreGood() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.isMorto());
	}

	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction() throws Exception 
	{
		new Tamagotchi("Kira", -10, 50);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void cantInstantiatePetWithNegativeHunger() throws Exception 
	{
		new Tamagotchi("Kira", 50, -10);
	}
	

	@Test 
	public void petCanReceivePets() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.daiCarezze(1);
		assertFalse(tama.isTriste());
	}
	
	@Test
	public void petCanReceiveCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.daiBiscotti(1);
		assertFalse(tama.isTriste());
	}
	
	@Test
	public void petIsUnhappyDueToHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 10);
		assertTrue(tama.isTriste());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 95);
		assertTrue(tama.isTriste());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.isTriste());
	}
	
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 99);
		tama.daiBiscotti(10);
		boolean res=tama.isMorto();
		assertTrue(res);
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 29, 50);
		tama.daiCarezze(10);
		assertFalse(tama.isTriste());
	}
}
