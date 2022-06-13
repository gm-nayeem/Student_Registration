
package StudentRegistration_OopProject;

// import class
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentRegistration extends JFrame implements ActionListener,MouseListener
{
    
    // declare object
    private Container con;
    private JLabel titleLabel, nameLabel, phnLabel, gpaLabel, courseLabel;
    private JTextField nameTf, phnTf, gpaTf, courseTf;
    private JButton addButton, updateButton, deleteButton, clearButton;
    private Font font1,font2;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    
    private String[] columns = { "Name", "GPA", "Course Name", "Phone Number"};
    private String[] rows = new String[4];
    
    // creat class using constructor
    StudentRegistration()
    {
        con = this.getContentPane();
        con.setBackground(Color.PINK);
        con.setLayout(null);
        
        font1 = new Font("Arial", Font.BOLD, 16);
        font2 = new Font("Arial", Font.ITALIC + Font.BOLD, 22);
        
        titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(font2);
        titleLabel.setBounds(260,20,250,60);
        titleLabel.setForeground(Color.MAGENTA);
        con.add(titleLabel);
        
        nameLabel = new JLabel("Name");
        nameLabel.setFont(font1);
        nameLabel.setBounds(20,100,80,40);
        nameLabel.setForeground(Color.MAGENTA);
        con.add(nameLabel);
        
        nameTf = new JTextField();
        nameTf.setFont(font1);
        nameTf.setBounds(120,100,250,40);
        con.add(nameTf);
        
        addButton = new JButton("Add");
        addButton.setBounds(500,100,100,40);
        addButton.setFont(font1);
        addButton.setForeground(Color.MAGENTA);
        con.add(addButton);
        
        phnLabel = new JLabel("Phone");
        phnLabel.setFont(font1);
        phnLabel.setBounds(20,160,80,40);
        phnLabel.setForeground(Color.MAGENTA);
        con.add(phnLabel);
        
        phnTf = new JTextField();
        phnTf.setFont(font1);
        phnTf.setBounds(120,160,250,40);
        con.add(phnTf);
        
        updateButton = new JButton("Update");
        updateButton.setBounds(500,160,100,40);
        updateButton.setFont(font1);
        updateButton.setForeground(Color.MAGENTA);
        con.add(updateButton);
        
        gpaLabel = new JLabel("GPA");
        gpaLabel.setFont(font1);
        gpaLabel.setBounds(20,220,100,40);
        gpaLabel.setForeground(Color.MAGENTA);
        con.add(gpaLabel);
        
        gpaTf = new JTextField();
        gpaTf.setFont(font1);
        gpaTf.setBounds(120,220,250,40);
        con.add(gpaTf);
        
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(500,220,100,40);
        deleteButton.setFont(font1);
        deleteButton.setForeground(Color.MAGENTA);
        con.add(deleteButton);
        
        courseLabel = new JLabel("Course");
        courseLabel.setFont(font1);
        courseLabel.setBounds(20,280,100,40);
        courseLabel.setForeground(Color.MAGENTA);
        con.add(courseLabel);
        
        courseTf = new JTextField();
        courseTf.setFont(font1);
        courseTf.setBounds(120,280,250,40);
        con.add(courseTf);
 
        clearButton = new JButton("Clear");
        clearButton.setBounds(500,280,100,40);
        clearButton.setFont(font1);
        clearButton.setForeground(Color.MAGENTA);
        con.add(clearButton);
        
        table = new JTable();
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font1);
        table.setSelectionBackground(Color.MAGENTA);
        table.setBackground(Color.ORANGE);
        table.setVisible(true);
        table.setRowHeight(30);
        
        scroll = new JScrollPane(table);
        scroll.setBounds(20,360,760,300);
        con.add(scroll);
        
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
         
        table.addMouseListener(this);

    }  
    
    
    // using method for connecting button
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == addButton)
        {
            rows[0] = nameTf.getText();
            rows[1] = gpaTf.getText();
            rows[2] = courseTf.getText();
            rows[3] = phnTf.getText();
            
            if(nameTf.getText().isEmpty() && phnTf.getText().isEmpty() && gpaTf.getText().isEmpty() && courseTf.getText().isEmpty() )
            {
                JOptionPane.showMessageDialog(null, "no value! first take value!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                 model.addRow(rows);
            }

        }
        else if(e.getSource() == clearButton)
        {
            nameTf.setText("");
            phnTf.setText("");
            gpaTf.setText("");
            courseTf.setText("");
            
        }
        else if(e.getSource() == deleteButton)
        {
            int numberOfRaw = table.getSelectedRow();
            
            if(numberOfRaw>=0)
            {
                model.removeRow(numberOfRaw);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "no row has been selected!!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
         else if(e.getSource() == updateButton)
         {
             int numberOfRaw = table.getSelectedRow();
             
             String name = nameTf.getText();
             String phn = phnTf.getText();
             String gpa = gpaTf.getText();
             String course = courseTf.getText();
             
             model.setValueAt(name, numberOfRaw, 0);
             model.setValueAt(gpa, numberOfRaw, 1);
             model.setValueAt(course, numberOfRaw, 2);
             model.setValueAt(phn, numberOfRaw, 3);
         }
    }

    // passing table information
    @Override
    public void mouseClicked(MouseEvent me) {
        
        int numberOfRaw = table.getSelectedRow();
        
        String name = model.getValueAt(numberOfRaw, 0).toString();
        String gpa = model.getValueAt(numberOfRaw, 1).toString();
        String course = model.getValueAt(numberOfRaw, 2).toString();
        String phn = model.getValueAt(numberOfRaw, 3).toString();
        
        nameTf.setText(name);
        phnTf.setText(phn);
        gpaTf.setText(gpa);
        courseTf.setText(course);
        
    }
    
    // creat frame using main method
    public static void main(String[] args) {
        
        StudentRegistration frame = new StudentRegistration();
        
        frame.setBounds(20, 20, 800, 800);
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    //We are not use rest of the method of Mouse Listener
    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

}
