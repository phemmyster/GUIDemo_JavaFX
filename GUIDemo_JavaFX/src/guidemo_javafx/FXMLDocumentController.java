/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo_javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 *
 * @author NERSTER-PC
 */
public class FXMLDocumentController implements Initializable {
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineappleCheckBox;
    @FXML private CheckBox beaconCheckBox;
   // @FXML private Button save;
    @FXML private Label pizzaOrderLabel;
    
   
    public void pizzaOderButtonPushed(){
        String order ="Toppings are: ";
        
        if(pineappleCheckBox.isSelected())
            order += "\npineapple";
        
        if(pepperoniCheckBox.isSelected())
            order += "\npepperoni";
        
        if(beaconCheckBox.isSelected())
            order += "\nbeacon";
        
        this.pizzaOrderLabel.setText(order);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
