package controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import model.Account;
import model.CheckingAccount;
import model.SavingsAccount;
import model.TrustAccount;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable {
    @FXML
    private RadioButton account;
    @FXML
    private RadioButton checkingAccount;
    @FXML
    private RadioButton savingsAccount;
    @FXML
    private RadioButton trustAccount;
    @FXML
    private TextField name;
    @FXML
    private TextField balance;
    @FXML
    private TextField perCheckFee;
    @FXML
    private TextField intRate;
    @FXML
    private Button add;
    @FXML
    private Button addimg;
    @FXML
    private ImageView imgview;
    private File file;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addimg.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilterJPG = new FileChooser.ExtensionFilter("jpg file", "*.JPG");
            FileChooser.ExtensionFilter extensionFilterPNG = new FileChooser.ExtensionFilter("png file", "*.PNG");
            chooser.getExtensionFilters().addAll(extensionFilterJPG, extensionFilterPNG);

            file = chooser.showOpenDialog(null);
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                imgview.setImage(image);
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        });

        account.setOnAction(e11 -> {
            intRate.setDisable(true);
            perCheckFee.setDisable(true);
        });

        checkingAccount.setOnAction(e22 -> {
            perCheckFee.setDisable(false);
            intRate.setDisable(true);
        });

        savingsAccount.setOnAction(e33 -> {
            perCheckFee.setDisable(true);
            intRate.setDisable(false);
        });

        trustAccount.setOnAction(e44 -> {
            perCheckFee.setDisable(true);
            intRate.setDisable(false);
        });

        add.setOnAction(e -> {
            try {
                double b = Double.parseDouble(balance.getText());
                if (account.isSelected()) {
                    Account account1 = new Account(name.getText(), b);
                    add_image();
                    MenuController.accounts.add(account1);
                } else if (checkingAccount.isSelected()) {
                    double p = Double.parseDouble(perCheckFee.getText());
                    CheckingAccount checkingAccount1 = new CheckingAccount(name.getText(), b, p);
                    add_image();
                    MenuController.accounts.add(checkingAccount1);
                } else if (savingsAccount.isSelected()) {
                    double i = Double.parseDouble(intRate.getText());
                    SavingsAccount savingsAccount1 = new SavingsAccount(name.getText(), b, i);
                    add_image();
                    MenuController.accounts.add(savingsAccount1);
                } else if (trustAccount.isSelected()) {
                    double i = Double.parseDouble(intRate.getText());
                    TrustAccount trustAccount1 = new TrustAccount(name.getText(), b, i);
                    add_image();
                    MenuController.accounts.add(trustAccount1);
                }
                MenuController.success_alert("اکانت شما با شماره حساب "+MenuController.accounts.size()+" ثبت شد!");
            } catch (Exception e1) {
                MenuController.error_alert("لطفا مقادیر معتبر وارد کنید!");
            }
        });
    }

    void add_image() throws IOException {
        if (imgview.getImage() != null) {
            File file1 = new File("C:\\Users\\OMID\\Desktop\\2\\bank\\src\\model\\image\\"+MenuController.accounts.size()+".jpg");
            BufferedImage originalImage = ImageIO.read(file);
            ImageIO.write(originalImage, "jpg", file1);
        }
    }
}
