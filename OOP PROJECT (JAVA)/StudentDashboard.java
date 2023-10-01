import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame{

    
    public  StudentDashboard(BusManagementSystem system) {

        JFrame frame = new JFrame("Student Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        
        JButton addStudentInfoButton = new JButton("Add Student Info");
        addStudentInfoButton.setFont(new Font("Arial", Font.BOLD, 16));
        addStudentInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addStudentInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField contactNumberField = new JTextField();
                JTextField rollNumberField = new JTextField();
                
                JPanel inputPanel = new JPanel(new GridLayout(2, 2));
                inputPanel.add(new JLabel("Contact Number:"));
                inputPanel.add(contactNumberField);
                inputPanel.add(new JLabel("Roll Number:"));
                inputPanel.add(rollNumberField);
                
                int result = JOptionPane.showConfirmDialog(
                    frame,
                    inputPanel,
                    "Enter Student Information",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );
                
                if (result == JOptionPane.OK_OPTION) {
                    String contactNumber = contactNumberField.getText();
                    String rollNumber = rollNumberField.getText();
                    Student tmp = new Student(system.currentlyLoggedIn.getName(), system.currentlyLoggedIn.getEmail(), system.currentlyLoggedIn.getPassword(), rollNumber, contactNumber);
                    system.currentlyLoggedIn = tmp;
                    BusManagementSystem.saveSystemState(system);
                    JOptionPane.showMessageDialog(frame, "Saved successfully");


    
                }
            }
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("Student Information");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel nameLabel = new JLabel("Name: "+system.currentlyLoggedIn.getName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel emailLabel = new JLabel("Email: "+system.currentlyLoggedIn.getEmail());
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Student tmp = (Student)system.currentlyLoggedIn;
        
        JLabel busNumberLabel = new JLabel("Bus Number: " + );
        busNumberLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        busNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.RED);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        panel.add(busNumberLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(addStudentInfoButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(logoutButton);
        panel.add(Box.createVerticalGlue());
        
        frame.add(panel);
        frame.setLocationRelativeTo(null); // Center the JFrame on the screen
        frame.setVisible(true);
    }
}