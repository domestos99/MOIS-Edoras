package cz.uhk.mois.edoras;

import java.util.Date;

public class Item {

    private Long id;
    private String state;
    private String content;
    private int count;
    private String date;


    public Item() {
    }

    public Item(Long id, String state, String content, int count, String date) {
        this.id = id;
        this.state = state;
        this.content = content;
        this.count = count;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID: " + id + " State: " + state + " Content: " + content + " Count: " + count + " Date: " + date;
    }
}
