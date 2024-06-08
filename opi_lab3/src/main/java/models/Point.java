package models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.html.HtmlSelectBooleanCheckbox;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "points")
@SessionScoped
public class Point implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private Float x;
    private Float y;
    private Float r;
    private Boolean status;
    private String time;
    private long scriptTime;

    public Point() {
    }

    public Point(Float x, Float y, Float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Point(Long id, Float x, Float y, Float r, Boolean status, String time, long scriptTime) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.status = status;
        this.time = time;
        this.scriptTime = scriptTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    // Возьмем x из HTML IDfff
    public void updateX(ValueChangeEvent e) {
        String id = ((HtmlSelectBooleanCheckbox) e.getSource()).getId();
        boolean isChecked = (boolean) e.getNewValue();
        if (isChecked) {
            setX(Float.parseFloat(id.substring(5, id.length()).replace("x", ".")));
        }
    }
//ABCDE
    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getStatusString() {
        return (status)
                ? "попаданиeе"
                : "промах";
    }

    public String getStatusHTMLClass() {
        return (status)
                ? "green-status"
                : "red-status";
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getScriptTime() {
        return scriptTime;
    }

    public void setScriptTime(long scriptTime) {
        this.scriptTime = scriptTime;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + r;
    }
}
