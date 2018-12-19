
package guidemo_javafx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ExampleofTableViewController implements Initializable {
    
    //Configure the table
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    
    // This is for the change of view to tableview
    public void changeScreenPushedBtn(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableSceneView = new Scene(tableViewParent);
        
        // This line gets the stage
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableSceneView);
        window.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // set up the column in the table
       firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
       lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
       birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
      
       //load dummy data
       tableView.setItems(getPeople());
       
       
    }  
    // an observableList of people
    public ObservableList<Person> getPeople(){
        ObservableList<Person> people =  FXCollections.observableArrayList();
        people.add(new Person("Phemmy","Akinz",LocalDate.of(1984, Month.MAY, 8)));
        people.add(new Person("Debby","Afo",LocalDate.of(1984, Month.MAY, 8)));
        people.add(new Person("Niffy","Akinz",LocalDate.of(1984, Month.FEBRUARY, 14)));
        people.add(new Person("Fefe","Akinz",LocalDate.of(1984, Month.JULY, 1)));
        return people;
        
    } 

   
    

    
    
}

