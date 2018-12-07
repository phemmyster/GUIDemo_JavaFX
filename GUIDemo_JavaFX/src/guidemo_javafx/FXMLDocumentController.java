package guidemo_javafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author NERSTER-PC
 */
public class FXMLDocumentController implements Initializable {

    // these are for check boxes 
    @FXML
    private CheckBox pepperoniCheckBox;
    @FXML
    private CheckBox pineappleCheckBox;
    @FXML
    private CheckBox beaconCheckBox;
    @FXML
    private Label pizzaOrderLabel;

    // these is for choicebox
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Label choiceBoxLabel;

    // for the comboBox
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label comboBoxLabel;

    // for the radioButtom
    @FXML
    private RadioButton phpRadioBtn;
    @FXML
    private RadioButton javaRadioBtn;
    @FXML
    private RadioButton aspRadioBtn;
    @FXML
    private RadioButton cSharpRadioBtn;
    @FXML
    private Label radioButtonLabel;
    private ToggleGroup favPrgmLang;

    //for the choicebox
    public void choiceBoxPushed() {
        choiceBoxLabel.setText("My Favourite fruit is:\n" + choiceBox.getValue().toString());
    }

    // for checkbox method
    public void pizzaOderButtonPushed() {
        String order = "Toppings are: ";

        if (pineappleCheckBox.isSelected()) {
            order += "\npineapple";
        }

        if (pepperoniCheckBox.isSelected()) {
            order += "\npepperoni";
        }

        if (beaconCheckBox.isSelected()) {
            order += "\nbeacon";
        }

        this.pizzaOrderLabel.setText(order);
    }

    // for combobox method
    public void comboBoxWasUpdated() {
        this.comboBoxLabel.setText("Subject selected is:\n" + comboBox.getValue().toString());
    }

    // this method for radioButton
    public void radioButtonChanged() {

        if (this.favPrgmLang.getSelectedToggle().equals(this.javaRadioBtn)) {
            radioButtonLabel.setText("The select language is:\nJava");
        }

        if (this.favPrgmLang.getSelectedToggle().equals(this.phpRadioBtn)) {
            radioButtonLabel.setText("The select language is:\nPhp");
        }

        if (this.favPrgmLang.getSelectedToggle().equals(this.aspRadioBtn)) {
            radioButtonLabel.setText("The select language is:\nAsp.Net");
        }

        if (this.favPrgmLang.getSelectedToggle().equals(this.cSharpRadioBtn)) {
            radioButtonLabel.setText("The select language is:\nC#");
        }
    }

    // this method get called automatically once the prgm is running
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pizzaOrderLabel.setText("");

        // for choicebox
        choiceBoxLabel.setText("");
        choiceBox.setValue("Apples");
        //choiceBox.getItems().add("Apples");
        choiceBox.getItems().addAll("Apples", "Mango", "Oranges", "Pineapple", "Berry", "Banana");

        // this is for the combobox
        comboBox.getItems().add("Physics");
        comboBox.getItems().addAll("Chemistry", "Biology", "Government", "Maths");

        // this is for the radioButton
       // radioButtonLabel.setText("");
        favPrgmLang = new ToggleGroup();
        this.javaRadioBtn.setToggleGroup(favPrgmLang);
        this.phpRadioBtn.setToggleGroup(favPrgmLang);
        this.aspRadioBtn.setToggleGroup(favPrgmLang);
        this.cSharpRadioBtn.setToggleGroup(favPrgmLang);

    }

}
