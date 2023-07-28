package template;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddPage extends VBox {
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField phoneField;
    private Button addPersonBTN;
    public AddPage() {
        Label first_nameLBL = new Label("First Name : ");
        firstNameField = new TextField();

        Label last_nameLBL = new Label("Last Name : ");
        lastNameField = new TextField();

        Label phoneLBL = new Label("Phone Number : ");
        phoneField = new TextField();

        VBox lbls = new VBox(first_nameLBL, last_nameLBL, phoneLBL);
        lbls.setAlignment(Pos.CENTER_LEFT);
        lbls.setSpacing(5);

        VBox fields = new VBox(firstNameField, lastNameField, phoneField);
        fields.setAlignment(Pos.CENTER);

        HBox hBox = new HBox(lbls, fields);
        hBox.setAlignment(Pos.CENTER);

        addPersonBTN = new Button("Add Person");

        this.getChildren().addAll(hBox, addPersonBTN);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public void setFirstNameField(TextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(TextField lastNameField) {
        this.lastNameField = lastNameField;
    }

    public void setPhoneField(TextField phoneField) {
        this.phoneField = phoneField;
    }

    public void setAddPersonBTN(Button addPersonBTN) {
        this.addPersonBTN = addPersonBTN;
    }

    public TextField getPhoneField() {
        return phoneField;
    }

    public Button getAddPersonBTN() {
        return addPersonBTN;
    }
}
