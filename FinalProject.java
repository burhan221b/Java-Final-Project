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

import java.util.Scanner;
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        int num = 0;
        int id = 0;
        int tempnum = 0;
        int buttons;
        int roster = 0;
        int seats = 0;
        int a =0;
        int b=0;
        int c=0;
        int d=0;
        int f=0;
        int studentplaceholder;
        int report = 0;


        //Made a array class
        //ids will be index numbers 
        Student[] database = new Student[50];
//        for (int  i = 0; i < database.length; i++)
//        {
//            database[i] = new Student();
//        }
        String temp; //temporary variable to store info
        
        System.out.println("_______________DATABASE______________");
        System.out.println("Welcome Professor to your Database.");
        System.out.println("");
        
        do{
//            Student[] database = new Student[50];
            System.out.println("");
            System.out.println("You currently have " + seats + " in your class.");
            System.out.println("What would you like to do?");
            System.out.println("(Type in the number)");
            System.out.println("1.	Add students to the class");
            System.out.println("2.	Set grades for any student to the class");
            System.out.println("3.	Show a class report");
            System.out.println("4.	Remove a student from the class");
            System.out.println("5.      Exit");
            System.out.println("--------------------------------------------------");
            System.out.print("");
            Boolean breakloop = false;
            buttons = input.nextInt();
            if(buttons == 1)
            {
                System.out.println("Add students to the class");
                System.out.println("You currently have " + seats + ", "
                        + "please enter the number of students you wish to add.");
                num = input.nextInt();
                roster += num;
                seats += num;
                
                if(roster > 50)
                {
                    System.out.println("Adding " +num+" students takes this course beyonde it's 50 student capacity");
                    continue;
                }
              
//                System.out.println("Please enter IDs");
                for(int i = 0; i < num; i++)
                {
                    //!!!here add if id=0 then use that i slot for adding new student. !!!
                    //this is supposed to help keep atleast 50 students in class. 
                    //make if statement that u can't have id of 0
                    //reuse id0 to fill in gap
//                    if(database[i].getID() == 0){
//                        tempnum = roster - num + i;
//                        studentplaceholder = tempnum + 1;
//                        System.out.println("New student " + studentplaceholder);
//                        System.out.println("Please enter ID");
//                        id = input.nextInt();
//                    }
                    tempnum = roster - num + i;
                    int jtempnum = roster - num;
                    studentplaceholder = seats - num + i + 1;
                    System.out.println("New student " + studentplaceholder);
                    System.out.println("Please enter ID (use numbers) -- Note, you can not use '0' by itself.");
//                    database[tempnum] = new Student();
                    id = input.nextInt();
                    //NEED TO FIX CODE BELOW
                    for(int j = 0; j < tempnum; j++)
                    {
                        if(database[j].getID() == id)
                        {
                            System.out.println("The Student ID you entered already exist.");
                            roster -=1;
                            seats -=1;
                            breakloop = true;
                            break;
                        }
                    }
                    if(breakloop == true)
                    {
                        breakloop = false;
                        break;
                    }
//                    database[tempnum].setID(id);

                    System.out.println("Please enter Student ID#"+id+" first name.");
                    String fname = input.next();
                    System.out.println("Please enter Student "+fname+"'s last name.");
                    String lname = input.next();
                    for(int k =0; k < jtempnum; k++)
                    {
                      if(database[k].getID() == 0)
                      {
                          report = k;
                          breakloop = true;
                          break;
                          //mihgt have to roster -1
                      }
                    }
                    if(breakloop == true)
                    {
                        database[report].setNewStudent(fname, lname, id);
                        roster-=1;
                        breakloop = false;
                    }else{
                        database[tempnum] = new Student(fname, lname, id);  
                    }
                      
                    


                               
                }
            }
            if(buttons == 2)
            {
                breakloop = false;
                System.out.println("Set grades for any student to the class");
                System.out.println("Please enter ID");
                int idb = input.nextInt();
                for(int i = 0; i < roster; i++)
                {
                    if(database[i].getID() == idb)
                    {
                        System.out.println("Please enter NUMBER Grade (0 - 100) for ID #" + database[i].getID());
                        int grade = input.nextInt();
                        database[i].setGrade(grade);
                        System.out.println("ID #" + database[i].getID() + " now has a grade of " + database[i].getGrade());
                        breakloop = false;
                        break;
                    } else
                        breakloop = true;
                    
                }
                if(breakloop == true)
                {
                    System.out.println("A student with ID #" +idb  + " hasn't been created yet, so we can not assign grade.");
                    breakloop = false;
                }
                
            }
            
            if(buttons == 3)
            {
                System.out.println("Show a class report");
                System.out.println("(Type in the number)");
                System.out.println("1.	Each student's ID, name, and grade");
                System.out.println("2.	The class average grade");
                System.out.println("3.	The student with the highest grade");
                System.out.println("4.	Data in a sorted order");
                buttons = input.nextInt();
                if(buttons == 1)
                {
                    for(int i = 0; i < roster; i++)
                    {
                        if(database[i].getID() != 0){
                        System.out.println("Student ID #" + database[i].getID() + " - "+database[i].getName()+" has grade " + 
                                database[i].getGrade() + "/100");
                        }
                    }
                }
                if(buttons == 2)
                {
                    int average = 0;
                    for(int i = 0; i < roster; i++)
                    {
                        if(database[i].getID() != 0){
                            average += database[i].getGrade();

                            //grades
                            if(database[i].getGrade() >= 90)
                                a++;
                            else if(database[i].getGrade() >= 80)
                                b++;
                            else if(database[i].getGrade() >= 70)
                                c++;
                            else if(database[i].getGrade() >= 60)
                                d++;
                            else
                                f++;
                        }
                        
                    }
                    average = average/seats;
                    System.out.println("  |         AVERAGE            ");
                    System.out.println("  |           __            ");
                    System.out.println("  |        __|  |__         ");
                    System.out.println("  |     __|  |  |  |__      ");
                    System.out.println("  |    |  |  |  |  |  |     ");
                    System.out.println("  |    |  |  |  |  |  |     ");
                    System.out.println("  |-------------------------");
                    System.out.println("  0           "+average+"        100");
                    
                    
                    System.out.println("");
                    System.out.println("     Number of Grades        ");
                    System.out.println("A = "+a);
                    System.out.println("B = "+b);
                    System.out.println("C = "+c);
                    System.out.println("D = "+d);
                    System.out.println("F = "+f);

                
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                f = 0;
                }
                
                if(buttons == 3)
                {
                   int highest= 0;
                   for(int i = 0; i < roster; i++)
                   {
                       if(database[highest].getGrade() < database[i].getGrade())
                       {
                           highest = i;
                       }
                   }
                   
                   System.out.println("Student ID #" + database[highest].getID() +" - "+ database[highest].getName()+ " has the highest grade with " + 
                                database[highest].getGrade() + "/100");
                }
                
                if(buttons == 4)
                {
                    System.out.println("");
                    System.out.println("Data in a sorted order");
                    System.out.println("(Type in the number)");
                    System.out.println("1.	Ordered by ID");
                    System.out.println("2.	Ordered by last name");
                    System.out.println("3.	Ordered by highest to lowest grades");
                    
                    buttons = input.nextInt();
                    if(buttons == 1)
                        
                        //NEED TO FIX!
                        //just get ids and put them in array without class array. 
                        //use bubble array. 
                        //learn to sort string 
                        
                        //use roster[1]. new student (roster[0].getId()); for buuble tech
                    {
                        //https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
                        System.out.println("Ordered by ID");
                        int[] orderId = new int[seats];
                        for(int i =0; i < roster; i++)
                        {
                            if(database[i].getID() != 0)
                            {
                                orderId[i] = database[i].getID();
                            }
                        }
                        int n = orderId.length;
                        int tempId = 0;

                        for (int i = 0; i < n; i++) {
                            for (int j = 1; j < (n - i); j++) {

                                if (orderId[j - 1] > orderId[j]) {
                                    tempId = orderId[j - 1];
                                    orderId[j - 1] = orderId[j];
                                    orderId[j] = tempId;
                                }

                            }
                        }
                        for(int k = 0; k < orderId.length; k++)
                        {
                            System.out.println(orderId[k]);
                        }
                    }
 
                    if(buttons == 2)
                    {
                        //https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
                        System.out.println("Ordered by last name");
                        
                        String[] orderlast = new String[seats];
                        for(int i =0; i < roster; i++)
                        {
                            if(database[i].getID() != 0)
                            {
                                orderlast[i] = database[i].getLastname();
                            }
                        }
//                        _______________________________________________________________________________________
//https://stackoverflow.com/questions/18689672/how-to-sort-a-string-array-alphabetically-without-using-compareto-or-arrays-sor
//link above for code below.
                        boolean done = false;
                        while(done == false){
                          done = true;
                          for(int i=0;i<orderlast.length-1;i++)
                          {
                            int numm = 0;
                            if(orderlast[i] != null && orderlast[i + 1] != null)
                            {
                                String name1=orderlast[i]; String name2=orderlast[i+1];
                                numm=name1.compareTo(name2);
                            }
                            else if(orderlast[i] == null && orderlast[i + 1] == null){
                              numm = 0;
                            }
                            else if(orderlast[i] == null){
                              numm = 1;
                            }
                            else {
                              numm = -1;
                            }
                            if(numm>0)
                            {
                                String tempp=orderlast[i];
                                orderlast[i]=orderlast[i+1];
                                orderlast[i+1]=tempp;
                                done=false;
                            }
                          }
                        }
                        for(int k = 0; k < orderlast.length; k++)
                        {
                            System.out.println(orderlast[k]);
                        }
//                        __________________________________________________________________________________________
//                        int j;
//                        boolean flag = true;  // will determine when the sort is finished
//                        String tempstring;
//
//                        while (flag)
//                        {
//                              flag = false;
//                              for( j = 0;  j < orderlast.length - 1;  j++ )
//                              {
//                                      if ( orderlast[j].compareToIgnoreCase( orderlast[j+1] ) > 0 )
//                                      {                                             // ascending sort
//                                                  tempstring = orderlast[j];
//                                                  orderlast[j] = orderlast[j+1];     // swapping
//                                                  orderlast[j+1] = tempstring;
//                                                  flag = true;
//                                       }
//                               }
//                        }
      
                    
                    }
                    
                    if(buttons == 3)
                    {
                        System.out.println("Ordered by highest to lowest grades");
                        int[] ordergrade = new int[seats];
                        for(int i =0; i < roster; i++)
                        {
                            if(database[i].getID() != 0)
                            {
                                ordergrade[i] = database[i].getGrade();
                            }
                        }
                        int n = ordergrade.length;
                        int tempId = 0;

                        for (int i = 0; i < n; i++) {
                            for (int j = 1; j < (n - i); j++) {

                                if (ordergrade[j - 1] < ordergrade[j]) {
                                    tempId = ordergrade[j - 1];
                                    ordergrade[j - 1] = ordergrade[j];
                                    ordergrade[j] = tempId;
                                }

                            }
                        }
                        System.out.println("__Highest to Lowest___");
                        for(int k = 0; k < ordergrade.length; k++)
                        {
                            int listnum = k +1;
                            System.out.println(listnum + " : " + ordergrade[k]);
                        }
                        
                        //---------------------------
                        int highest= 0;
                        for(int i = 0; i < roster; i++)
                        {
                            if(database[highest].getGrade() < database[i].getGrade())
                            {
                                highest = i;
                            }
                        }
                   
                        System.out.println("Student ID #" + database[highest].getID() +" - "+ database[highest].getName()+ " has the highest grade with " + 
                                     database[highest].getGrade() + "/100");
                        //----------------------------
                    
                    }
                    

                }
            }
            if(buttons == 4)
                {
                    System.out.println("Remove a student from the class");
                    System.out.println("Please enter Student ID # to remove student from your course.");
                    int idr = input.nextInt();
                    for(int i = 0; i < roster; i++)
                    {
                        if(database[i].getID() == idr)
                        {
                            System.out.println("Student with ID#" +database[i].getID()+" with the name "+ database[i].getName()+ " has been removed.");
                            database[i].removeString();
                            database[i].removeInt();
                            seats -=1;
                            
//                            database[i] = null;
                            break;
//                            Student[] database[i] = new Student;

                        } else if(i == (roster - 1)) 
                            System.out.println("The Student ID you entered does not exist.");
                    } 
                    
                }
            System.out.println("");
            System.out.println("");
        } while(buttons != 5);
    }
    
}
