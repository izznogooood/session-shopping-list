package models;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private String sessionId;
    private String name;
    private String icon;
    private String color;
    private String accent;
    private List<ListItem> shoppingList = new ArrayList<>();

    // Empty constructor for Jackson
    public Business() {}

    public Business(String sessionId, String name, String icon, String color, String accent) {
        this.sessionId = sessionId;
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.accent = accent;
    }

    /* A constructor for testing purposes */
    public Business(String sessionId, String name, String icon, String color, String accent, List<ListItem> shoppingList) {
        this.sessionId = sessionId;
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.accent = accent;
        this.shoppingList = shoppingList;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ListItem> getShoppingList() {
        return this.shoppingList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAccent() {
        return accent;
    }

    public void setAccent(String accent) {
        this.accent = accent;
    }

    public void addListItem(ListItem li) {
        shoppingList.add(li);
    }
}
