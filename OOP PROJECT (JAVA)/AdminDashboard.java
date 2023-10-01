import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame {
    public AdminDashboard(BusManagementSystem system) {
        // Set up the JFrame
        setTitle("Bus Management Page");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(7, 1, 10, 10));

        // Create the buttons
        JButton addBusButton = new JButton("Add Bus");
        JButton assignDriverButton = new JButton("Assign Bus to Driver");
        JButton assignStudentButton = new JButton("Assign Bus to Student");
        JButton deleteDriverButton = new JButton("Delete Driver");
        JButton deleteBusButton = new JButton("Delete Bus");
        JButton deleteStudentButton = new JButton("Delete Student");
        JButton logoutButton = new JButton("Logout");

        // Add action listeners to the buttons
        
        addBusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle adding a bus
                String busNumber = JOptionPane.showInputDialog(null, "Enter bus number:");
                String route = JOptionPane.showInputDialog(null, "Enter bus route:");
                Bus b  =new Bus(busNumber, 50, Integer.parseInt(route));
                system.buses.add(b);
                BusManagementSystem.saveSystemState(system);
                JOptionPane.showMessageDialog(null, "Added bus");
            }
        });


        assignDriverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle assigning a bus to a driver
                String busNumber = JOptionPane.showInputDialog(null, "Enter bus number:");
                String driverEmail = JOptionPane.showInputDialog(null, "Enter driver email:");

                Bus thisBus = null;

                for(Bus b: system.buses){
                    if(b.getNumber().equals(busNumber)) thisBus = b;
                }

                for(int i = 0; i < system.drivers.size(); i++){
                    if(system.drivers.get(i).getEmail().equals(driverEmail)){
                        system.drivers.get(i).setRelatedBus(thisBus);
                       BusManagementSystem.saveSystemState(system);
                       break;
                    }
                }
                JOptionPane.showMessageDialog(null, "Assign Successful");
            }
        });

        assignStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle assigning a bus to a student
                String busNumber = JOptionPane.showInputDialog(null, "Enter bus number:");
                String studentEmail = JOptionPane.showInputDialog(null, "Enter student email:");
                
                Bus thisBus = null;
                for(Bus b:system.buses){ 
                    if(b.getNumber().equals(busNumber)) {
                        thisBus = b;
                    }else{
                        JOptionPane.showMessageDialog(null, "Bus not found");
                    }
                for(Student s: system.students) {
                    if (s.getEmail().equals(studentEmail)) s.setRelatedBus(thisBus);{
                        BusManagementSystem.saveSystemState(system);
                            break;
                    }
                }


                JOptionPane.showMessageDialog(null, "Assign successful");
            }
        });


        
        deleteDriverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle deleting a driver
                String email = JOptionPane.showInputDialog(null, "Enter driver email:");
                for(Driver u: system.drivers){
                    if(u.getEmail().equals(email)){ 
                        system.drivers.remove(u); 
                        BusManagementSystem.saveSystemState(system);
                        break; 
                    }
                }
                JOptionPane.showMessageDialog(null, "Delete Driver");
            }
        });

        deleteBusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle deleting a bus
                String busNumber = JOptionPane.showInputDialog(null, "Enter bus number:");
                // Add your logic here using busNumber variable
                JOptionPane.showMessageDialog(null, "Delete Bus button clicked\nBus Number: " + busNumber);
                for(Bus b: system.buses){
                    if(b.getNumber().equals(busNumber)){ 
                        system.buses.remove(b); 
                        BusManagementSystem.saveSystemState(system);
                        break;
                    }
                }
            }
        });

        deleteStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle deleting a student
                String email = JOptionPane.showInputDialog(null, "Enter student email:");
                // Add your logic here using email variable
                JOptionPane.showMessageDialog(null, "Delete Student button clicked\nEmail: " + email);
                for(Student s: system.students){
                    if(s.getEmail().equals(email)){ 
                        system.students.remove(s); 
                        BusManagementSystem.saveSystemState(system);
                        break; 
                    }
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to handle logout
                // Add your logic here
                dispose();
            }
        });


        // Add the buttons to the panel
        buttonPanel.add(addBusButton);
        buttonPanel.add(assignDriverButton);
        buttonPanel.add(assignStudentButton);
        buttonPanel.add(deleteDriverButton);
        buttonPanel.add(deleteBusButton);
        buttonPanel.add(deleteStudentButton);
        buttonPanel.add(logoutButton);

        // Add the panel to the JFrame
        add(buttonPanel, BorderLayout.CENTER);

        // Display the JFrame
        setVisible(true);
    }
}
