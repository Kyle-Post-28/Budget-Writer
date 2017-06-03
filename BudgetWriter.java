/*
Filename: BudgetWriter.java
Author: Kyle Post
Date: February 10, 2017
Purpose: Creates a GUI that reads user
inputs and records the information in
a seperate document.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color.*;
import java.io.*;
import java.util.*;

public class BudgetWriter extends JFrame{
	//Create Labels
	private JLabel date = new JLabel("Date" + "\n (mm/dd/yyyy)");
	private JLabel name = new JLabel("Transaction");
	private JLabel amount = new JLabel("Amount");
	//Create TextFields for input
	private JTextField dateTxt = new JTextField("");
	private JTextField nameTxt = new JTextField("");
	private JTextField amountTxt = new JTextField("");
	//Create Radio buttons and button group
	private JRadioButton withdraw = new JRadioButton("Withdraw");
	private JRadioButton deposit = new JRadioButton("Deposit");
	private ButtonGroup transType = new ButtonGroup();
	//Create Record Button
	private JButton record = new JButton("Record");
	//Create a JOptionPane for pop messages
	private JOptionPane frame = new JOptionPane();
	//Create sperate for input, radio buttons, and main button
	JPanel inputPanel = new JPanel();
	JPanel radioPanel = new JPanel();
	JPanel btnPanel = new JPanel();
	
	//Create filewriter
	private static FileWriter fileWriter;
	private File report =  new File("Budget Report");
	
	//Store all the inputs
	public BudgetWriter(){
		//Create Frame of the Application
		super("Budget Writer");
		setLayout(new GridLayout(3, 1));
		setSize(500, 200);
		setBackground(Color.CYAN);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(inputPanel);
		add(radioPanel);
		add(btnPanel);
		//Create inputPanel
		inputPanel.setLayout(new GridLayout(2, 3));
		inputPanel.add(date); inputPanel.add(name); inputPanel.add(amount);
		inputPanel.add(dateTxt); inputPanel.add(nameTxt); inputPanel.add(amountTxt);
		//Create radioPanel
		radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		radioPanel.add(withdraw); radioPanel.add(deposit);
		transType.add(withdraw); transType.add(deposit);
		//Create btnPanel
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnPanel.add(record);
		//Add action Listener
		record.addActionListener(new RecordBtnListener());	
	}
	//Create a clearText method
	public void clearText() {
        dateTxt.setText("");
		nameTxt.setText("");
		amountTxt.setText("");
    }
	
	
	//Create the RecordBtnListener class
	class RecordBtnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame, "This information has been added to your Budget Report");
			clearText();
		}
	}
	//Create the main application
	public static void main(String[] args){
		BudgetWriter bwApp = new BudgetWriter();
		bwApp.setVisible(true);
	}
}