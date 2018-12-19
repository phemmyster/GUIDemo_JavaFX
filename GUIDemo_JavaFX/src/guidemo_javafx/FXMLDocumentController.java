package guidemo_javafx;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


    public class FXMLDocumentController implements Initializable {

    // items  for check boxes 
    @FXML
    private CheckBox pepperoniCheckBox;
    @FXML
    private CheckBox pineappleCheckBox;
    @FXML
    private CheckBox beaconCheckBox;
    @FXML
    private Label pizzaOrderLabel;

    // items  for choicebox
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Label choiceBoxLabel;

    //items  for the comboBox
    @FXML
    private ComboBox comboBox;
    @FXML
    private Label comboBoxLabel;

    // items for the radioButtom
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
    
    
    // items for ListView and TextArea
    @FXML ListView listView;
    @FXML TextArea moviesTextArea;
    
    // This is for the change of view to tableview
    public void changeScreenPushedBtn(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ExampleofTableView.fxml"));
        Scene tableSceneView = new Scene(tableViewParent);
        
        // This line gets the stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableSceneView);
        window.show();
    }
    

    //methods for the choicebox
    public void choiceBoxPushed() {
        choiceBoxLabel.setText("My Favourite fruit is:\n" + choiceBox.getValue().toString());
    }

    // method for checkbox 
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

    //method for combobox 
    public void comboBoxWasUpdated() {
        this.comboBoxLabel.setText("Subject selected is:\n" + comboBox.getValue().toString());
    }

    // radioButton for  method 
    public void radioButtonChanged() {

        if (this.favPrgmLang.getSelectedToggle().equals(this.javaRadioBtn)) {
            radioButtonLabel.setText("The select language is: Java");
        }

        if (this.favPrgmLang.getSelectedToggle().equals(this.phpRadioBtn)) {
            radioButtonLabel.setText("The select language is: Php");
        }

        if (this.favPrgmLang.getSelectedToggle().equals(this.aspRadioBtn)) {
            radioButtonLabel.setText("The select language is: Asp");
        }

        if (this.favPrgmLang.getSelectedToggle().equals(this.cSharpRadioBtn)) {
            radioButtonLabel.setText("The select language is: C#");
        }
    }
    
    // method for btn-> selected genre btn
    public void listViewPushedBtn(){
        String textAreaString = "";
        ObservableList listOfItem = listView.getSelectionModel().getSelectedItems();
        for(Object items: listOfItem){
            textAreaString += String.format("%s%n", (String) items);
            moviesTextArea.setText(textAreaString);
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
                
                
         // this is for adding ListView Items
         listView.getItems().addAll("Action","Comedy","Romance","Animation","Sci-Fi","Western","Drama","Adventure");
         listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // for multiple selection

    }

}
