package models;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ListItem implements Comparable<ListItem> {
    private final UUID id = UUID.randomUUID();
    private Integer order;
    private int quantity;
    private String name;

    // Empty constructor for
    public ListItem() {}

    public ListItem(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull ListItem li) {
        return this.order.compareTo(li.order);
    }
}
