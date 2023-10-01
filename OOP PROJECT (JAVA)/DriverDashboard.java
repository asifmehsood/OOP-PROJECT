import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverDashboard extends JFrame {
    public DriverDashboard(BusManagementSystem system) {

        Driver currentDriver = (Driver)system.currentlyLoggedIn;

        JFrame frame = new JFrame("Driver Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        
        JButton addDriverInfoButton = new JButton("Add Driver Info");
        addDriverInfoButton.setFont(new Font("Arial", Font.BOLD, 16));
        addDriverInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addDriverInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String phoneNum = JOptionPane.showInputDialog(frame, "Enter contact Number:");
                String licenseNumber = JOptionPane.showInputDialog(frame, "Enter license number:");
                Driver tmp = new Driver(system.currentlyLoggedIn.getName(), system.currentlyLoggedIn.getEmail(), system.currentlyLoggedIn.getPassword(), phoneNum, licenseNumber);
                system.currentlyLoggedIn = tmp;
                BusManagementSystem.saveSystemState(system);
                JOptionPane.showMessageDialog(frame, "Name: " + phoneNum + "\nLicense Number: " + licenseNumber);
                
            

            }
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("Driver Information");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel nameLabel = new JLabel("Name: " + currentDriver.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel emailLabel = new JLabel("Email:" + currentDriver.getEmail());
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel licenseLabel = new JLabel("License Number: " + currentDriver.getLicenseNumber());
        licenseLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        licenseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel contactLabel = new JLabel("Contact Number: " + currentDriver.getContactNumber());
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contactLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel busNumberLabel = new JLabel("Bus Number: " + currentDriver.getRelatedBus());
        busNumberLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        busNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
       
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.RED);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your logout logic here
                System.out.println("Logout button clicked");
                system.currentlyLoggedIn = null;
                dispose();
            }
        });
        
        panel.add(Box.createVerticalGlue());
        panel.add(headingLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(emailLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(licenseLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(contactLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(busNumberLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(addDriverInfoButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(logoutButton);
        panel.add(Box.createVerticalGlue());
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); // Center the JFrame on the screen
        frame.setVisible(true);
    }
}
