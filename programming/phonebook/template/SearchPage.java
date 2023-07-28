package template;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Person;

public class SearchPage extends BorderPane {
    private TableView<Person> tableView;

    public SearchPage() {
        tableView = new TableView<>();
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<Person, String> phoneCol = new TableColumn<>("Phone Number");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, phoneCol);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        this.setCenter(tableView);
    }

    public TableView<Person> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Person> tableView) {
        this.tableView = tableView;
    }
}
