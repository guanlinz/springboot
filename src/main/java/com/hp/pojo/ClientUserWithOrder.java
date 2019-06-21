package com.hp.pojo;

import java.io.Serializable;

public class ClientUserWithOrder implements Serializable {
    private static final long serialVersionUID = 1974695019401433239L;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ClientUserWithOrder{" +
                "user=" + user +
                ", order=" + order +
                '}';
    }

}
