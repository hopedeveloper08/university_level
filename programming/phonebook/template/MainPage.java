package template;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Person;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TableColumn;
import javafx.geometry.Pos;

public class MainPage extends BorderPane {
    private TableView<Person> tableView;
    private Button addBTN;
    private Button removeBTN;
    private Button searchBTN;
    private Button editBTN;
    private Button exitBTN;
    private TextField searchField;

    public MainPage() {
        tableView = new TableView<>();
        addBTN = new Button("Add");
        removeBTN = new Button("Remove");
        editBTN = new Button("Edit");
        searchBTN = new Button("Search");
        exitBTN = new Button("Exit");

        searchBTN.setMaxWidth(Double.MAX_VALUE);
        addBTN.setMaxWidth(Double.MAX_VALUE);
        removeBTN.setMaxWidth(Double.MAX_VALUE);
        editBTN.setMaxWidth(Double.MAX_VALUE);
        exitBTN.setMaxWidth(Double.MAX_VALUE);

        searchField = new TextField();

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<Person, String> phoneCol = new TableColumn<>("Phone Number");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, phoneCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        HBox hBox = new HBox(searchField, searchBTN);
        hBox.setSpacing(8);

        VBox vBox = new VBox(addBTN, editBTN, removeBTN, exitBTN);
        vBox.setSpacing(16);
        vBox.setAlignment(Pos.BOTTOM_CENTER);

        this.setTop(hBox);
        this.setCenter(tableView);
        this.setRight(vBox);
    }

    public TableView<Person> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Person> tableView) {
        this.tableView = tableView;
    }

    public Button getAddBTN() {
        return addBTN;
    }

    public void setAddBTN(Button addBTN) {
        this.addBTN = addBTN;
    }

    public Button getRemoveBTN() {
        return removeBTN;
    }

    public void setRemoveBTN(Button removeBTN) {
        this.removeBTN = removeBTN;
    }

    public Button getSearchBTN() {
        return searchBTN;
    }

    public void setSearchBTN(Button searchBTN) {
        this.searchBTN = searchBTN;
    }

    public Button getEditBTN() {
        return editBTN;
    }

    public void setEditBTN(Button editBTN) {
        this.editBTN = editBTN;
    }

    public Button getExitBTN() {
        return exitBTN;
    }

    public void setExitBTN(Button exitBTN) {
        this.exitBTN = exitBTN;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public void setSearchField(TextField searchField) {
        this.searchField = searchField;
    }
}
