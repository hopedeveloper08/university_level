package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import linkedlist.LinkedList;
import linkedlist.Node;
import model.Person;
import template.MainPage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainView {
    private LinkedList list;
    private MainPage mainPage;

    public MainView(LinkedList list) {
        mainPage = new MainPage();
        this.list = list;
        Node h = getList().getHeader();

        while (h != null) {
            addPersonToTable(h.getPerson());
            h = h.getNext();
        }

        mainPage.getAddBTN().setOnAction(e -> {
            AddView addView = new AddView(this);
            Stage addStage = new Stage();
            addStage.setScene(new Scene(addView.getAddPage()));
            addStage.show();
        });

        mainPage.getEditBTN().setOnAction(e -> {
            Person selectedPerson = mainPage.getTableView().getSelectionModel().getSelectedItem();
            if (selectedPerson != null) {
                AddView addView = new AddView(this);
                Stage addStage = new Stage();
                addStage.setScene(new Scene(addView.getAddPage()));
                addStage.show();
                getList().remove(selectedPerson);
                mainPage.getTableView().getItems().remove(selectedPerson);
            }
        });

        mainPage.getRemoveBTN().setOnAction(e -> {
            Person selectedPerson = mainPage.getTableView().getSelectionModel().getSelectedItem();
            if (selectedPerson != null) {
                getList().remove(selectedPerson);
                mainPage.getTableView().getItems().remove(selectedPerson);
            }
        });

        mainPage.getSearchBTN().setOnAction(e -> {
            String s = mainPage.getSearchField().getText();
            Pattern p = Pattern.compile("^"+s+".*");
            Node h3 = getList().getHeader();
            LinkedList temp = new LinkedList();
            while(h3 != null) {
                Matcher m1 = p.matcher(h3.getPerson().getFirst_name());
                boolean b1 = m1.matches();
                Matcher m2 = p.matcher(h3.getPerson().getLast_name());
                boolean b2 = m2.matches();
                Matcher m3 = p.matcher(h3.getPerson().getPhone());
                boolean b3 = m3.matches();
                if(b1 || b2 || b3) {
                    temp.insert(h3.getPerson());
                }
                h3 = h3.getNext();
            }
            SearchView searchView = new SearchView(this, temp);
            Stage searchStage = new Stage();
            searchStage.setScene(new Scene(searchView.getSearchPage()));
            searchStage.setWidth(500);
            searchStage.setHeight(400);
            searchStage.show();
        });

        mainPage.getExitBTN().setOnAction(e -> {
            try {
                FileWriter fw = new FileWriter("persons.txt");

                BufferedWriter bw = new BufferedWriter(fw);

                Node h1 = getList().getHeader();
                while(h1 != null) {
                    bw.append(h1.getPerson().getFirst_name()).append(",");
                    bw.append(h1.getPerson().getLast_name()).append(",");
                    bw.append(h1.getPerson().getPhone());
                    bw.newLine();
                    h1 = h1.getNext();
                }
                bw.close();
            } catch (Exception ex) {
                System.out.println("Error");
            }
            System.exit(0);
        });
    }

    public LinkedList getList() {
        return list;
    }

    public void setList(LinkedList list) {
        this.list = list;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public void addPersonToTable(Person person) {
        mainPage.getTableView().getItems().add(person);
    }
}
