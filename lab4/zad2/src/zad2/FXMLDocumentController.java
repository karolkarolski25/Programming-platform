/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author karol
 */
public class FXMLDocumentController implements Initializable {
    
    private ArrayList chartList = new ArrayList();
    
    private double a, b, c;
    private int count;
    private String legend;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField aText;
    
    @FXML
    private TextField bText;
    
    @FXML
    private TextField cText;
      
    @FXML
    private ComboBox chartsComboBox;
    
    @FXML
    private AreaChart areaChart;
    
    @FXML
    private LineChart lineChart;
    
    @FXML
    private ScatterChart scatterChart;
    
    @FXML
    private void ComboBoxAction(ActionEvent event)
    {
        label.setText("Wybrany typ wykresu: " + chartsComboBox.getValue().toString());
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            a = Double.parseDouble(aText.getText());
            b = Double.parseDouble(bText.getText());
            c = Double.parseDouble(cText.getText());
                 
            if (b == 0) 
            {
                throw new Exception("b == 0!");
            }
            
            legend = "f(x) = " + a + "x^2 + " + b + "x + " + c;
            
            chartList.clear();
 
            GenerateData();
            
            switch(chartsComboBox.getValue().toString())
            {
                case "Line chart":
                    ShowLineChart();
                    break;
                case "Area chart":
                    ShowAreaChart();
                    break;
                case "Scatter chart":
                    ShowScatterChart();
                    break;
                default:
                    break;
            }
        }
        catch (Exception e) {
            System.out.println("ERROR " + e.toString());
        }        
    }
        
    private void GenerateData()
    {
        for(int i = -10; i <= 10; i++)
        {
            chartList.add(a * Math.pow(i, 2) + b * i + c);
        }
    }
    
    private void ShowAreaChart()
    {
        gridPane.getChildren().clear();      
        gridPane.add(AreaChartClass.createChart(legend, chartList), 0, 0);
    }
    
    private void ShowLineChart()
    {        
        gridPane.getChildren().clear();
        gridPane.add(LineChartClass.createChart(legend, chartList), 0, 0);  
    }
    
    private void ShowScatterChart()
    {       
        gridPane.getChildren().clear();
        gridPane.add(ScatterChartClass.createChart(legend, chartList), 0, 0);      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        chartsComboBox.getItems().addAll("Line chart", "Area chart", "Scatter chart");
        
        chartsComboBox.getSelectionModel().select(0);
        
        label.setText("Wybrany typ wykresu: " + chartsComboBox.getValue().toString());  
    }
}
