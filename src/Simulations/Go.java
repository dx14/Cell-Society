package Simulations;


import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.JOptionPane;

public class Go{
	// THIS IS THE CLASS YOU NEED TO RUN
	public static void main(String[] args){
		String[] choices = { "A", "B", "C"};
	    String input = (String) JOptionPane.showInputDialog(null, "Sim Type",
	        "Choose Simulation", JOptionPane.QUESTION_MESSAGE, null, 
	        choices,
	        choices[1]);
		  JTextField xField = new JTextField(5);
	      JTextField yField = new JTextField(5);
	      int width;
	      int height;
	      String type;
	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("width"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("height"));
	      myPanel.add(yField);

	      int result = JOptionPane.showConfirmDialog(null, myPanel, 
	               "Please Enter Width and Height Values", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  	try{
	    		width = Integer.parseInt(xField.getText());
	    		}catch (NumberFormatException ex) {
	    		    System.out.println("WIDTH MUST BE INTEGER VALUE");
	    		}
	    	  	try{
		    		height = Integer.parseInt(yField.getText());
		    		}catch (NumberFormatException ex) {
		    		    System.out.println("HEIGHT MUST BE INTEGER VALUE");
		    		}
	      }
	}
}
