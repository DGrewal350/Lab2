package task2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * Lab2Part2
 * @author Daniel Grewal
 * @author Nathan Bingham
 */
public class Task2 extends JFrame implements ActionListener {
    
    public static final int WIDTH = 500;
    public static final int HEIGHT = 150;
    
    private JTextField decimal;
    private JTextField binary;
    
    public Task2()
    {
        setTitle("Decimal to Binary Number Converter");
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer( ));
        Container content = getContentPane( );
        content.setLayout(new GridLayout(3, 1));
        
        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new FlowLayout( ));
        
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        buttonPanel.add(convertButton);
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);
        
        //content.add(buttonPanel, BorderLayout.SOUTH);
        
        JPanel upperPanel = new JPanel( );
        upperPanel.setLayout(new FlowLayout( ));
        upperPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel decLabel = new JLabel("Enter a non-negative decimal integer:");
        upperPanel.add(decLabel, BorderLayout.NORTH);
        decimal = new JTextField(15);
        upperPanel.add(decimal, BorderLayout.NORTH);
        
        //content.add(upperPanel, BorderLayout.NORTH);
        
        JPanel midPanel = new JPanel ( );
        midPanel.setLayout(new GridLayout(2, 1));
        midPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel binLabel = new JLabel("The equivalent binary number is:");
        binLabel.setHorizontalAlignment(JLabel.CENTER);
        midPanel.add(binLabel);
        binary = new JTextField(50);
        midPanel.add(binary);
        
        //content.add(midPanel, BorderLayout.CENTER);
        content.add(upperPanel);
        content.add(midPanel);
        content.add(buttonPanel);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand( ).equals("Convert"))
        {
            try
            {
                int quotient = Integer.parseInt(decimal.getText());
                int remainder = 0;
                String returnValue = "";
                
                while (quotient != 0)
                {
                    remainder = quotient % 2;
                    returnValue = returnValue + remainder;
                    
                    quotient = quotient / 2;
                }
                
                binary.setText(new StringBuilder(returnValue).reverse().toString());
            }
            catch (NumberFormatException nfe)
            {
                binary.setText("Error: Invalid input");
            }
        }
        else if (e.getActionCommand( ).equals("Clear"))
        {
            decimal.setText("");
            binary.setText("");
        }
        else
            System.exit(0);
    }
    
    public static void main(String[] args)
    {
        Task2 test = new Task2( );
        test.setVisible(true);
    }
}
