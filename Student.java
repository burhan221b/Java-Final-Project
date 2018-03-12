/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author BurhanAhmad
 */
public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private int id;
    
    public Student(String fname, String lname, int idnum)
    {
        firstName = fname;
        lastName = lname;
        id = idnum;
    }
    
    public void setID(int i)
    {
        id = i;
    }
    
    public int getID()
    {
        return id;
    }
    
    public void setGrade(int g)
    {
        grade = g;
    }
    
    public int getGrade()
    {
        return grade;
    }
    
    public void removeString()
    {
        firstName = "";
        lastName = "";
    }
    
    public void removeInt()
    {
        grade = 0;
        id = 0;
    }
    
    public String getLastname()
    {
        return lastName;
    }
    
    public String getName()
    {
        String fullname = firstName +" "+ lastName;
        return fullname;
    }
    
    public void setNewStudent(String fname, String lname, int idnum)
    {
        firstName = fname;
        lastName = lname;
        id = idnum;
    }
//    
//    public Boolean checkId()
//    {
//        if(id == null)
//        {
//            return true;
//        } else
//            return false;
//    }
}
