package ch04_DiceRollingGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * DiceRollingGame is the main class for the Dice Rolling Game JOptionPane program.
 * It contains a main method that creates new dice and sets up the custom dialog.
 * 
 * @author sashimimi
 * @version 1.0.0
 * @since 1.0.0
 * @since October 11, 2019
 * @since February 14, 2019 (original)
 */

public class DiceRollingGame
{
	public static Die die1, die2, die3, die4, die5;
	
	public static void main (String[] args)
	{	
		JOptionPane.showMessageDialog(null, "Welcome to the Dice Rolling Game. I will now roll a set of 5 dice for you.", "Dice Roll Game", JOptionPane.PLAIN_MESSAGE);

		List<String> rolls = new ArrayList<String>();
		
		die1 = new Die();
		die2 = new Die();
		die3 = new Die();
		die4 = new Die();
		die5 = new Die();
		
		rolls.add(String.valueOf(die1.getDieNum()));
		rolls.add(String.valueOf(die2.getDieNum()));
		rolls.add(String.valueOf(die3.getDieNum()));
		rolls.add(String.valueOf(die4.getDieNum()));
		rolls.add(String.valueOf(die5.getDieNum()));
		
		String rollCombo = String.join(", ", rolls);
		
		new CustomDialog(rollCombo);
	}
}
