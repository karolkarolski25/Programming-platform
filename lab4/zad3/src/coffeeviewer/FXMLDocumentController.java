/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeviewer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author karol
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn supplierIdColumn;

    @FXML
    private TableColumn priceColumn;

    @FXML
    private TableColumn salesColumn;

    @FXML
    private TableColumn totalColumn;

    @FXML
    private TableView<Coffee> tableView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {   
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        supplierIdColumn.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("sales"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        final ObservableList<Coffee> coffeeList = FXCollections.observableArrayList(new CoffeeDao().GetAllCoffees());
        
        tableView.setItems(coffeeList);
    }     
    
}
