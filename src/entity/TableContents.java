package entity;

import java.sql.Time;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author AezA
 */
public class TableContents {
    
    private SimpleStringProperty date;
    private SimpleStringProperty entry;
    private SimpleStringProperty exit;
    private SimpleStringProperty coffeeShop;
    private SimpleStringProperty leave;

    public TableContents(String date, Time entry, Time exit, int coffeeShop, String leave) {
        this.date = new SimpleStringProperty(date);
        this.entry = new SimpleStringProperty(entry != null ? entry.toString().substring(0, 5) : null);
        this.exit = new SimpleStringProperty(exit != null ? exit.toString().substring(0, 5) : null);
        this.coffeeShop = new SimpleStringProperty(String.valueOf(coffeeShop));
        this.leave = new SimpleStringProperty(leave);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getEntry() {
        return entry.get();
    }

    public void setEntry(String entry) {
        this.entry.set(entry);
    }

    public String getExit() {
        return exit.get();
    }

    public void setExit(String exit) {
        this.exit.set(exit);
    }

    public String getCoffeeShop() {
        return coffeeShop.get();
    }

    public void setCoffeeShop(String coffeeShop) {
        this.coffeeShop.set(coffeeShop);
    }

    public String getLeave() {
        return leave.get();
    }

    public void setLeave(String leave) {
        this.leave.set(leave);
    }
    
}
