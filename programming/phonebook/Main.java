import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import linkedlist.LinkedList;
import model.Person;
import view.MainView;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LinkedList list = new LinkedList();

        try {
            String line = null;
            FileReader fr = new FileReader("persons.txt");

            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Person person = new Person(data[0], data[1], data[2]);
                list.insert(person);
            }

            br.close();
        } catch (Exception e) {
            System.out.println();
        }

        MainView mainView = new MainView(list);
        primaryStage.setScene(new Scene(mainView.getMainPage()));
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);

        primaryStage.show();
    }
}
