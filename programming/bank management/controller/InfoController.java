package controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import model.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoController implements Initializable {
    @FXML
    private Button ok;
    @FXML
    private TextField id;
    @FXML
    private ImageView imgview;
    @FXML
    private Pagination slider;
    @FXML
    private TableView<Info> t;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        create_table();

        slider.setPageFactory(pageIndex -> {
            t.getItems().clear();
            editTable(pageIndex);
            return t;
        });

        ok.setOnAction(e -> {
            try {
                slider.setCurrentPageIndex(Integer.parseInt(id.getText()) - 1);
            } catch (Exception e1) {
                MenuController.error_alert("لطفا مقادیر معتبر وارد کنید!");
            }
        });
    }

    void load_img(String i) {
        try {
            File file1 = new File("C:\\Users\\OMID\\Desktop\\2\\bank\\src\\model\\image\\"+i+".jpg");
            BufferedImage bufferedImage = ImageIO.read(file1);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgview.setImage(image);
        } catch (Exception e) {
            imgview.setImage(null);
        }
    }

    public void editTable(int pageIndex) {
        try {
            Account account = MenuController.accounts.get(pageIndex);
            load_img(String.valueOf(pageIndex));
            if (account instanceof CheckingAccount) {
                t.getItems().add(new Info("Account Type", "Checking Account"));
                t.getItems().add(new Info("Name", account.getName()));
                t.getItems().add(new Info("Balance", String.valueOf(account.getBalance())));
                t.getItems().add(new Info("Per Check Fee", String.valueOf(((CheckingAccount) account).getPerCheckFee())));
            } else if (account instanceof TrustAccount) {
                t.getItems().add(new Info("Account Type", "Trust Account"));
                t.getItems().add(new Info("Name", account.getName()));
                t.getItems().add(new Info("Balance", String.valueOf(account.getBalance())));
                t.getItems().add(new Info("Int Rate", String.valueOf(((TrustAccount) account).getIntRate())));
            } else if (account instanceof SavingsAccount) {
                t.getItems().add(new Info("Account Type", "Saving Account"));
                t.getItems().add(new Info("Name", account.getName()));
                t.getItems().add(new Info("Balance", String.valueOf(account.getBalance())));
                t.getItems().add(new Info("Int Rate", String.valueOf(((SavingsAccount) account).getIntRate())));
            } else {
                t.getItems().add(new Info("Account Type", "Simple Account"));
                t.getItems().add(new Info("Name", account.getName()));
                t.getItems().add(new Info("Balance", String.valueOf(account.getBalance())));
            }
        } catch (Exception e) {
            imgview.setImage(null);
        }
    }

    void create_table(){
        t.setPlaceholder(new Label("اکانتی با این شماره حساب وجود ندارد!"));
        TableColumn<Info, String> title =
                new TableColumn<>("title");
        title.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        TableColumn<Info, String> data =
                new TableColumn<>("data");
        data.setCellValueFactory(
                new PropertyValueFactory<>("data"));
        t.getColumns().addAll(title, data);
        t.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
