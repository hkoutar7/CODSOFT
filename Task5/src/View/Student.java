package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import DAO.*;

public class Student {
    private JPanel Main;
    private JScrollPane tableHolder;
    private JTable tableStudents;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtMajor;
    private JTextField txtTotalGrade;
    private JButton addButton;
    private JButton updateButton;
    private JTextField txtId;
    private JButton dropButton;
    private JButton searchButton;


    public Student() {

        table_load();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String major = txtMajor.getText();
                Float totalGrade = Float.parseFloat(txtTotalGrade.getText());

                StudentDAO studentDAO = new StudentDAO();

                try {
                    studentDAO.addStudent(new Model.Student(firstName, lastName, major, totalGrade));
                    JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
                    table_load();
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMajor.setText("");
                    txtTotalGrade.setText("");
                    txtFirstName.requestFocus();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String major = txtMajor.getText();
                float totalGrade = Float.parseFloat(txtTotalGrade.getText());

                StudentDAO studentDAO = new StudentDAO();
                boolean isrowsAffected = studentDAO.updateStudent(new Model.Student(id, firstName, lastName,major, totalGrade) );

                if (isrowsAffected) {
                    txtId.setText(String.valueOf(id));
                    txtFirstName.setText(firstName);
                    txtLastName.setText(lastName);
                    txtMajor.setText(major);
                    txtTotalGrade.setText(String.valueOf(totalGrade));
                    txtFirstName.requestFocus();
                    JOptionPane.showMessageDialog(null, "SUCCESS: The record update successfully");

                } else {
                    txtId.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMajor.setText("");
                    txtTotalGrade.setText("");
                    txtFirstName.requestFocus();
                    JOptionPane.showMessageDialog(null, "Error: The record didn't update");
                }
                table_load();
            }
        });
        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int studentId = Integer.parseInt(txtId.getText());
                boolean isDeleted = true;

                StudentDAO studentDAO = new StudentDAO();
                isDeleted = studentDAO.deleteStudent(studentId);

                if (isDeleted)
                    JOptionPane.showMessageDialog(null, "SUCCESS: The record deleted successfully");
                else
                    JOptionPane.showMessageDialog(null, "ERROR: The record failed to delete");

                table_load();

                txtFirstName.setText("");
                txtLastName.setText("");
                txtMajor.setText("");
                txtTotalGrade.setText("");
                txtId.setText("");
                txtFirstName.requestFocus();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int studentId = Integer.parseInt(txtId.getText());
                StudentDAO studentDAO = new StudentDAO();

                Model.Student student = studentDAO.selectStudent(studentId);

                if (student != null){
                txtId.setText(String.valueOf(student.getId()));
                txtFirstName.setText(student.getFirstName());
                txtLastName.setText(student.getLastName());
                txtMajor.setText(student.getMajor());
                txtTotalGrade.setText(String.valueOf(student.getTotalGrade()));
                txtFirstName.requestFocus();
                JOptionPane.showMessageDialog(null, "SUCCESS finding the ercord");
                }
                else {
                    txtId.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMajor.setText("");
                    txtTotalGrade.setText("");
                    txtFirstName.requestFocus();
                    JOptionPane.showMessageDialog(null, "ERROR no record matching");
                }
            }
        });

    }

    void table_load() {
        try {
            StudentDAO studentDAO = new StudentDAO();
            List<Model.Student> students = studentDAO.selectAllStudents();

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Major");
            model.addColumn("Total Grade");

            for (var student : students) {
                model.addRow(new Object[]{student.getId(), student.getFirstName(), student.getLastName(), student.getMajor(), student.getTotalGrade()});
            }

            tableStudents.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student");
        frame.setContentPane(new Student().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        centerFrameOnScreen(frame);
        frame.setResizable(false);

    }

    private static void centerFrameOnScreen(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}

