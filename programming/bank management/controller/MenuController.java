package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Account;
import model.CheckingAccount;
import model.SavingsAccount;
import model.TrustAccount;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public static ArrayList<Account> accounts = new ArrayList<>();
    @FXML
    private Button create;
    @FXML
    private Button dw;
    @FXML
    private Button info;
    @FXML
    private Button exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String line = null;
            FileReader fr = new FileReader("accounts.txt");

            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == 1){
                    accounts.add(new Account(data[1], Double.parseDouble(data[2])));
                } else if (Integer.parseInt(data[0]) == 2) {
                    accounts.add(new CheckingAccount(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                } else if (Integer.parseInt(data[0]) == 3) {
                    accounts.add(new SavingsAccount(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                } else if (Integer.parseInt(data[0]) == 4) {
                    accounts.add(new TrustAccount(data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3])));
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println();
        }

        create.setOnAction(e -> {
            loadPage("../view/CreatePage.fxml");
        });

        dw.setOnAction(e -> {
            loadPage("../view/DWPage.fxml");
        });

        info.setOnAction(e -> {
            loadPage("../view/InfoPage.fxml");
        });

        exit.setOnAction(e -> {
            try {
                FileWriter fw = new FileWriter("accounts.txt");

                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0;i < accounts.size();i++) {
                    if (accounts.get(i) instanceof CheckingAccount) {
                        bw.append("2,").append(accounts.get(i).getName()).append(",").append(String.valueOf(accounts.get(i).getBalance())).append(",").append(String.valueOf(((CheckingAccount) accounts.get(i)).getPerCheckFee())).append("\n");
                    } else if (accounts.get(i) instanceof TrustAccount) {
                        bw.append("4,").append(accounts.get(i).getName()).append(",").append(String.valueOf(accounts.get(i).getBalance())).append(",").append(String.valueOf(((TrustAccount) accounts.get(i)).getIntRate())).append("\n");
                    } else if (accounts.get(i) instanceof SavingsAccount) {
                        bw.append("3,").append(accounts.get(i).getName()).append(",").append(String.valueOf(accounts.get(i).getBalance())).append(",").append(String.valueOf(((SavingsAccount) accounts.get(i)).getIntRate())).append("\n");
                    } else {
                        bw.append("1,").append(accounts.get(i).getName()).append(",").append(String.valueOf(accounts.get(i).getBalance())).append("\n");
                    }
                }
                bw.close();
                System.exit(0);
            } catch (Exception ex) {
                MenuController.error_alert("داده ها در سامانه ذخیره نشد!");
            }
        });
    }

    void loadPage(String address) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(address));
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

    static void error_alert(String s){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("خطا!");
        alert.setHeaderText("عملیات انجام نشد...");
        alert.setContentText(s);
        alert.showAndWait();
    }

    static void success_alert(String s){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("موفقیت!");
        alert.setHeaderText("عملیات با موفقیت انجام شد...");
        alert.setContentText(s);
        alert.showAndWait();
    }
}
