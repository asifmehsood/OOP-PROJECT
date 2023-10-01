

import java.io.*;
import java.util.*;

class Bus implements Serializable {
    private String number;
    private int seats;
    private int route;

    public Bus(String number, int seats, int route){
        this.number = number;
        this.seats = seats;
        this.route = route;
    }

    public String getNumber(){
        return number;
    }

    public int getSeats(){
        return seats;
    }

    public int getRoute(){
        return route;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public void setRoute(int route){
        this.route = route;
    }
}