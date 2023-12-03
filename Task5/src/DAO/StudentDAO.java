package DAO;

import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {
    SingletonConnection sing = SingletonConnection.getInstance();

    public List<Student> selectAllStudents () {

        List <Student> students = new ArrayList<Student>();
        Connection conn = sing.getConnection();

        try(PreparedStatement pst = conn.prepareStatement("SELECT * FROM STUDENT");) {

            var result = pst.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String firstName  = result.getString("first_name");
                String lastName  = result.getString("last_name");
                String major  = result.getString("major");
                float totalGrade  = result.getFloat("total_grade");
                students.add(new Student(id, firstName, lastName, major,totalGrade));
            }

       }catch (SQLException ex){
           ex.printStackTrace();
       }

       return  students;
    }

    public void addStudent (Student student){

        Connection conn = sing.getConnection();
        try (PreparedStatement pst = conn.prepareStatement("insert into student(first_name,last_name,major, total_grade)values(?,?,?,?)"); ) {

            pst.setString(1, student.getFirstName().trim().toLowerCase());
            pst.setString(2, student.getLastName().trim().toLowerCase());
            pst.setString(3, student.getMajor().trim().toLowerCase());
            pst.setString(4,String.valueOf( student.getTotalGrade()));

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean updateStudent(Student student) {

        boolean rowUpdated;
        Connection conn = sing.getConnection();
        try ( PreparedStatement pst = conn.prepareStatement("update student set first_name = ?, last_name = ?, major = ?, total_grade = ? where id = ? ")   ) {
            pst.setString(1, student.getFirstName().trim().toLowerCase());
            pst.setString(2, student.getLastName().trim().toLowerCase());
            pst.setString(3, student.getMajor().trim().toLowerCase());
            pst.setString(4,String.valueOf( student.getTotalGrade()));
            pst.setString(5,String.valueOf( student.getId()));

            rowUpdated = pst.executeUpdate() > 0;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            rowUpdated = false;
        }
        return rowUpdated;
    }

    public boolean deleteStudent(int id) {
        int rowDeleted;

        Connection conn = sing.getConnection();
        try ( PreparedStatement pst = conn.prepareStatement("DELETE FROM STUDENT WHERE id = ?")) {

            pst.setString(1, String.valueOf(id));
            rowDeleted = pst.executeUpdate();
            return  (rowDeleted > 0);
        }
        catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }

    }

    public Student selectStudent(int id) {

        Student student = null ;

        Connection conn = sing.getConnection();
        try ( PreparedStatement pst = conn.prepareStatement("SELECT * FROM STUDENT WHERE id = ?")) {
            pst.setString(1, String.valueOf(id));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String  major = rs.getString("major");
                float totalGrade = rs.getFloat("total_grade");
                student = new Student(id, firstName,lastName,major,totalGrade);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return student;
    }

}
