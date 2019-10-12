package ch04_DiceRollingGame;

/**
 * Die creates a template for a die.
 * It contains methods that generate die numbers.
 * 
 * @author sashimimi
 * @version 1.0.0
 * @since 1.0.0
 * @since October 11, 2019
 * @since February 14, 2019 (original)
 */

public class Die 
{
	private int dieNum;
	
	public Die()
	{
		dieNum = genRandNum();
	}

	public int getDieNum() 
	{
		return dieNum;
	}

	public void setDieNum(int dieNum) 
	{
		this.dieNum = dieNum;
	}
	
	/**
	 * Generates a random number using the Math.random static method.
	 * 
	 * @return  the random number
	 */
	public int genRandNum()
	{
		int num = ((int)(Math.random() * 100) % 6 + 1);
		return num;
	}
}
