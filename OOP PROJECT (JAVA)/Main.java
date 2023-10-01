

import java.util.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public static BusManagementSystem system = null;
    public static void main(String[] args){
        system = BusManagementSystem.loadSystemState();
        if(system == null){
            system = new BusManagementSystem();
        }

        system.currentlyLoggedIn = null;

        // GUI init here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm(system);
            }
        });
        // rest of the code goes here -- you can call a gui function here, and pass
        // system variable for use in GUI. system vairable will provide data to GUI.
        testBusmanagementSystem(system);

        BusManagementSystem.saveSystemState(system);
    }


    static void testBusmanagementSystem(BusManagementSystem system){
        Bus bus1 = new Bus("bus1", 20, 1);
        Driver driver1 = new Driver("Ali", "ali@mail.com", "123", "123", "123");
        driver1.setRelatedBus(bus1);
        Student student1 = new Student("Adnan", "adnan@mail.com", "123", "123", "123");
        student1.setRelatedBus(bus1);
        system.buses.add(bus1);
        system.drivers.add(driver1);
        system.students.add(student1);
        system.displayEverythingFormatted();
    }
}

