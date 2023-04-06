package com.thenewjonathan.test;

import com.thenewjonathan.enums.Dice;
import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest
{

	@Test
	public void testDice()
	{
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.D4.getDie().roll();
			assertFalse(roll < 1 || roll > 4);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.D6.getDie().roll();
			assertFalse(roll < 1 || roll > 6);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.D8.getDie().roll();
			assertFalse(roll < 1 || roll > 8);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.D10.getDie().roll();
			assertFalse(roll < 1 || roll > 10);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.D12.getDie().roll();
			assertFalse(roll < 1 || roll > 12);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.D20.getDie().roll();
			assertFalse(roll < 1 || roll > 20);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.DD4.getDie().roll();
			assertFalse(roll < 2 || roll > 8);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.DD6.getDie().roll();
			assertFalse(roll < 2 || roll > 12);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.DD8.getDie().roll();
			assertFalse(roll < 2 || roll > 16);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.DD10.getDie().roll();
			assertFalse(roll < 2 || roll > 20);
		}
		for (int i = 0; i < 300; i++)
		{
			int roll = Dice.DD12.getDie().roll();
			assertFalse(roll < 2 || roll > 24);
		}
		for (int i = 0; i < 300; i++)
		{
			assertFalse(Dice.percentageRoll(0));
			assertTrue(Dice.percentageRoll(100));
		}
		assertEquals("name of 4 sided die", Dice.D4.toString(), "1d4");
		assertEquals("name of 6 sided die", Dice.D6.toString(), "1d6");
		assertEquals("name of 8 sided die", Dice.D8.toString(), "1d8");
		assertEquals("name of 10 sided die", Dice.D10.toString(), "1d10");
		assertEquals("name of 12 sided die", Dice.D12.toString(), "1d12");
		assertEquals("name of 20 sided die", Dice.D20.toString(), "1d20");
		assertEquals("name of 4 sided die", Dice.DD4.toString(), "2d4");
		assertEquals("name of 6 sided die", Dice.DD6.toString(), "2d6");
		assertEquals("name of 8 sided die", Dice.DD8.toString(), "2d8");
		assertEquals("name of 10 sided die", Dice.DD10.toString(), "2d10");
		assertEquals("name of 12 sided die", Dice.DD12.toString(), "2d12");
	}
}
