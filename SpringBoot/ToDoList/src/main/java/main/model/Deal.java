package main.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Deal
{
    @Id
    private String data;
    private String deal;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

}
