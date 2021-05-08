package models;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private String sessionId;
    private String name;
    private final ArrayList<ListItem> shoppingList = new ArrayList<>();

    public Business(String sessionId, String name) {
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ListItem> getShoppingList() {
        return this.shoppingList;
    }

    public void addListItem(ListItem li) {
        shoppingList.add(li);
    }

    public int itemsInList() {
        return shoppingList.size();
    }
}
