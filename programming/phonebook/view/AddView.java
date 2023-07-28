package view;

import model.Person;
import template.AddPage;

public class AddView {
    private AddPage addPage;
    private MainView mainView;

    public AddView(MainView mainView) {
        addPage = new AddPage();
        this.mainView = mainView;

        addPage.getAddPersonBTN().setOnAction(e -> {
            String first_name = addPage.getFirstNameField().getText();
            String last_name = addPage.getLastNameField().getText();
            String phone = addPage.getPhoneField().getText();
            Person person = new Person(first_name, last_name, phone);

            if (person.getFirst_name().length() != 0 && person.getLast_name().length() != 0 && person.getPhone().length() != 0) {
                if (!mainView.getList().search(person)) {
                    mainView.getList().insert(person);
                    mainView.addPersonToTable(person);
                }
            }
        });
    }

    public AddPage getAddPage() {
        return addPage;
    }

    public void setAddPage(AddPage addPage) {
        this.addPage = addPage;
    }

    public MainView getMainView() {
        return mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }
}
