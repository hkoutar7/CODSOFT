package Test;
import  DAO.*;
import  Model.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public  static  void  main (String [] argv){

        List <Student> students = new ArrayList<Student>();

        StudentDAO std = new StudentDAO();

        Student student = std.selectStudent(4);

        System.out.println(student);



    }


}
