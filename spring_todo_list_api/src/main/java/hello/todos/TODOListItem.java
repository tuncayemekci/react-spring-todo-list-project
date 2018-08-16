package hello.todos;

import java.util.Date;
import java.util.GregorianCalendar;

public class TODOListItem {
    private int id;
    private String text;
    private boolean completed = false;
    private String description;
    private Date deadline;

    public static int numberOfItems = 0;


    public TODOListItem(String text) {
        this.text = text;
        id = numberOfItems++;
        deadline = GregorianCalendar.getInstance().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
