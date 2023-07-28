package view;

import linkedlist.LinkedList;
import linkedlist.Node;
import template.SearchPage;

public class SearchView {
    private SearchPage searchPage;
    private MainView mainView;
    private LinkedList list;

    public SearchView(MainView mainView, LinkedList temp) {
        searchPage = new SearchPage();
        this.mainView = mainView;
        this.list = temp;

        Node h = list.getHeader();
        while (h!=null){
            searchPage.getTableView().getItems().add(h.getPerson());
            h = h.getNext();
        }
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public void setSearchPage(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    public MainView getMainView() {
        return mainView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public LinkedList getList() {
        return list;
    }

    public void setList(LinkedList list) {
        this.list = list;
    }
}
