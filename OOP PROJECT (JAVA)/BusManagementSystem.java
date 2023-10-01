
import java.io.*;
import java.util.*;


// Not related to GUI -- to add anthing to GUI, use methods from here.
// This class holds the data for use in GUI.
class BusManagementSystem implements Serializable {

    User currentlyLoggedIn = null;

    ArrayList<Bus> buses;
    ArrayList<Driver> drivers;
    ArrayList<Student> students;

    public BusManagementSystem(){
        buses = new ArrayList<Bus>();
        drivers = new ArrayList<Driver>();
        students = new ArrayList<Student>();
    }

    public void displayEverythingFormatted(){
        System.out.println("Buses:");
        for(Bus bus: buses){
            System.out.println("Number: " + bus.getNumber());
            System.out.println("Seats: " + bus.getSeats());
            System.out.println("Route: " + bus.getRoute());
            System.out.println();
        }

        System.out.println("Drivers:");
        for(Driver driver: drivers){
            System.out.println("Name: " + driver.getName());
            System.out.println("Email: " + driver.getEmail());
            System.out.println("License Number: " + driver.getLicenseNumber());
            System.out.println("Contact Number: " + driver.getContactNumber());
            System.out.println();
        }

        System.out.println("Students:");
        for(Student student: students){
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Contact Number: " + student.getContactNumber());
            System.out.println();
        }
    }

    
    static void saveSystemState(BusManagementSystem system){
        try {
            FileOutputStream fileOut = new FileOutputStream("system.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(system);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in system.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    static BusManagementSystem loadSystemState(){
        BusManagementSystem system = null;
        try {
            FileInputStream fileIn = new FileInputStream("system.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            system = (BusManagementSystem) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("BusManagementSystem class not found");
            c.printStackTrace();
        }
        return system;
    }
}
