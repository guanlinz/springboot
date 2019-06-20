package com.hp.pojo;

public class ClientUserWithOrder {
    private ClientUser user;
    private Order order;

    public ClientUser getUser() {
        return user;
    }

    public void setUser(ClientUser user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ClientUserWithOrder{" +
                "user=" + user +
                ", order=" + order +
                '}';
    }
}
