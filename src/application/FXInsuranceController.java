/*
 * Author: Daniel Zelfo
 * Description: This program outputs the total cost of insurance after the user selects the options they want
 * Date: 5/22/2019
 */

package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FXInsuranceController {
	//setting up fxml elements
	@FXML private RadioButton radHMO;
	@FXML private RadioButton radPPO;
	@FXML private CheckBox chkDental;
	@FXML private CheckBox chkVision;
	@FXML private Button btnSubmit;
	@FXML private TextArea txtResult;
	
	//declaring the togglegroup and string array that will be the result textarea
	private final ToggleGroup insuranceType = new ToggleGroup();
	private String [] currentResult = new String[5];
	
	//the initializing method to set the togglegroup for the radio buttons and the initial text of the result textbox
	public void initialize() {
		radHMO.setToggleGroup(insuranceType);
		radPPO.setToggleGroup(insuranceType);
		txtResult.setText(" \n \n \n--------------------------------------------\n ");
	}
	
	//hmo checkbox method
	@FXML protected void radHMOnClick( ActionEvent event ){
		currentResult = txtResult.getText().split("\n");
		currentResult[0] = "the HMO costs $200 per month";
		txtResult.setText(String.join("\n", currentResult));
	}
	
	//ppo checkbox method
	@FXML protected void radPPOOnClick( ActionEvent event ){
		currentResult = txtResult.getText().split("\n");
		currentResult[0] = "the PPO costs $600 per month";
		txtResult.setText(String.join("\n", currentResult));
	}
	
	//dental checkbox method
	@FXML protected void chkDentalOnClick( ActionEvent event ){
		currentResult = txtResult.getText().split("\n");
		if(chkDental.isSelected())
			currentResult[1] = "the dental coverage adds $75 per month";
		else
			currentResult[1] = " ";
		txtResult.setText(String.join("\n", currentResult));
	}
	
	//vision checkbox method
	@FXML protected void chkVisionOnClick( ActionEvent event ){
		currentResult = txtResult.getText().split("\n");
		if(chkVision.isSelected())
			currentResult[2] = "the vision care adds $20 per month";
		else
			currentResult[2] = " ";
		txtResult.setText(String.join("\n", currentResult));
	}
	
	//submit button method
	@FXML protected void btnSubmitOnClick( ActionEvent event ){
		currentResult = txtResult.getText().split("\n");
		int cost = 0;
		//making sure the user selected ppo or hmo option
		if(!(radHMO.isSelected() || radPPO.isSelected())) {
			txtResult.appendText("\nNo type of insurance selected. Selecting HMO.\n");
			radHMO.setSelected(true);
			cost += 200;
		}else{
			if(radHMO.isSelected())
				cost += 200;
			else
				cost += 600;
		}
		if(chkDental.isSelected())
			cost += 75;
		if(chkVision.isSelected())
			cost += 20;
		//outputting the final total cost
		currentResult[4] = "Total cost: $" + cost;
		txtResult.setText(String.join("\n", currentResult));
	}
}
