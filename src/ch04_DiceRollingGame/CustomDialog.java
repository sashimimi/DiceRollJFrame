package ch04_DiceRollingGame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CustomDialog creates the custom JFrame dialog message.
 * It contains methods to build the dialog and to act when certain actions are performed.
 * 
 * @author sashimimi
 * @version 1.0.0
 * @since 1.0.0
 * @since October 11, 2019
 * @since February 14, 2019 (original)
 */

@SuppressWarnings("serial")
public class CustomDialog extends JFrame implements ActionListener
{
	private JButton dice1, dice2, dice3, dice4, dice5, finish;
	private JLabel diceLabel;
	private int d1 = 0, d2 = 0, d3 = 0, d4 = 0, d5 = 0;
	
	/**
	 * Constructor to create a new custom dialog with specific settings.
	 * 
	 * @param message  the first randomized combination of dice rolls
	 */
	public CustomDialog(String message)
	{
		buildDialog(message);
		setTitle("Dice Roll Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Builds the custom dialog message with six buttons, 5 "reroll dice" buttons and 1 "finish" button.
	 * It also assigns actions to the various buttons.
	 * 
	 * @param message  the first randomized combination of dice rolls
	 */
	private void buildDialog(String message)
	{
		dice1 = new JButton("Reroll Dice #1");
		dice2 = new JButton("Reroll Dice #2");
		dice3 = new JButton("Reroll Dice #3");
		dice4 = new JButton("Reroll Dice #4");
		dice5 = new JButton("Reroll Dice #5");
		finish = new JButton("Finish");
		diceLabel = new JLabel(message);
		
		// Build the custom dialog
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 2;
		c.gridy = 0;
		dataPanel.add(diceLabel, c);
		c.gridy = 2;
		dataPanel.add(finish, c);
		
		c.gridy = 1;
		c.gridx = 0;
		dataPanel.add(dice1, c);
		c.gridx = 1;
		dataPanel.add(dice2, c);
		c.gridx = 2;
		dataPanel.add(dice3, c);
		c.gridx = 3;
		dataPanel.add(dice4, c);
		c.gridx = 4;
		dataPanel.add(dice5, c);
		
		// Assign actions to the buttons
		dice1.setActionCommand("dice1");
		dice2.setActionCommand("dice2");
		dice3.setActionCommand("dice3");
		dice4.setActionCommand("dice4");
		dice5.setActionCommand("dice5");
		finish.setActionCommand("finish");
		
		dice1.addActionListener(this);
		dice2.addActionListener(this);
		dice3.addActionListener(this);
		dice4.addActionListener(this);
		dice5.addActionListener(this);
		finish.addActionListener(this);
		
		add(dataPanel);
		pack();
	}
	
	/**
	 * Changes the label text to a new number depending on what button was pressed.
	 * 
	 * @param dieNum  the random number to change the label to
	 * @param index  where in the result string to place the dieNum
	 * @param message  the original message to change
	 * @return string to change the value of the label
	 */
	private String changeLabel(int dieNum, int index, String message)
	{
		List<String> split = new ArrayList<String>(Arrays.asList(message.split(", ")));
		split.set(index, String.valueOf(dieNum));
		return String.join(", ", split);
	}
	
	/**
	 * Checks for button clicks and changes the specific label the user requested to a random number.
	 * 
	 * @param e  the ActionEvent
	 */
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		
		if (cmd.equals("dice1"))
		{	
			if (d1 < 3)
			{
				diceLabel.setText(changeLabel(DiceRollingGame.die1.genRandNum(), 0, diceLabel.getText()));
				d1++;
				
				if (d1 == 3)
					dice1.setEnabled(false);
			}
		}
		else if (cmd.equals("dice2"))
		{
			if (d2 < 3)
			{
				diceLabel.setText(changeLabel(DiceRollingGame.die2.genRandNum(), 1, diceLabel.getText()));
				d2++;
				
				if (d2 == 3)
					dice2.setEnabled(false);
			}
		}
		else if (cmd.equals("dice3"))
		{
			if (d3 < 3)
			{
				diceLabel.setText(changeLabel(DiceRollingGame.die3.genRandNum(), 2, diceLabel.getText()));
				d3++;
				
				if (d3 == 3)
					dice3.setEnabled(false);
			}
		}
		else if (cmd.equals("dice4"))
		{
			if (d4 < 3)
			{
				diceLabel.setText(changeLabel(DiceRollingGame.die4.genRandNum(), 3, diceLabel.getText()));
				d4++;
				
				if (d4 == 3)
					dice4.setEnabled(false);
			}
		}
		else if (cmd.equals("dice5"))
		{
			if (d5 <= 3)
			{
				diceLabel.setText(changeLabel(DiceRollingGame.die5.genRandNum(), 4, diceLabel.getText()));
				d5++;
				
				if (d5 == 3)
					dice5.setEnabled(false);
			}
		}
		else if (cmd.equals("finish"))
			System.exit(0);
	}
}
