package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DWController implements Initializable {
    @FXML
    private TextField id;
    @FXML
    private TextField amount;
    @FXML
    private Button ok;
    @FXML
    private TextField id0;
    @FXML
    private TextField amount1;
    @FXML
    private Button ok1;
    @FXML
    private TextField id1;
    @FXML
    private TextField id2;
    @FXML
    private TextField amount2;
    @FXML
    private Button ok2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ok.setOnAction(e -> {
            try {
                if (MenuController.accounts.get(Integer.parseInt(id.getText()) - 1).deposit(Double.parseDouble(amount.getText()))){
                    MenuController.success_alert(" مبلغ"+amount.getText()+" به حساب "+id.getText()+" واریز شد!");
                }
                else {
                    MenuController.error_alert(null);
                }
            }
            catch (Exception e1) {
                MenuController.error_alert("لطفا مقادیر معتبر وارد کنید!");
            }
        });

        ok1.setOnAction(e -> {
            try {
                if (MenuController.accounts.get(Integer.parseInt(id0.getText()) - 1).withdraw(Double.parseDouble(amount1.getText()))){
                    MenuController.success_alert(" مبلغ"+amount1.getText()+" از حساب "+id0.getText()+" برداشت شد!");
                }
                else {
                    MenuController.error_alert(null);
                }
            }
            catch (Exception e1) {
                MenuController.error_alert("لطفا مقادیر معتبر وارد کنید!");
            }
        });

        ok2.setOnAction(e -> {
            try {
                if (Integer.parseInt(id1.getText())!=Integer.parseInt(id2.getText()) && MenuController.accounts.get(Integer.parseInt(id1.getText()) - 1).withdraw(Double.parseDouble(amount2.getText())) && MenuController.accounts.get(Integer.parseInt(id2.getText()) - 1).deposit(Double.parseDouble(amount2.getText()))){
                    MenuController.success_alert(" مبلغ"+amount2.getText()+" به حساب "+id2.getText()+" واریز شد!");
                }
                else {
                    MenuController.error_alert(null);
                }
            }
            catch (Exception e1) {
                MenuController.error_alert("لطفا مقادیر معتبر وارد کنید!");
            }
        });
    }
}
