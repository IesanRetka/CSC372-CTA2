package com.criticalthinking.csc372;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AgeCalculator {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Age Calculator");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JLabel label = new JLabel("enter your birth date (yyyy-mm-dd):");
		JTextField textField = new JTextField(10);
		JButton button = new JButton("Calculate Age");
		JLabel ageLabel = new JLabel("Your age will appear here.");
		
		panel.add(label);
		panel.add(textField);
		panel.add(button);
		panel.add(ageLabel);
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthDateStr = textField.getText();
                try {
                    LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate currentDate = LocalDate.now();
                    int age = Period.between(birthDate, currentDate).getYears();
                    ageLabel.setText("Your age is: " + age);
                } catch (Exception ex) {
                    ageLabel.setText("Invalid date format.");
                }
            }
        });
		
		frame.setVisible(true);
	}
}
