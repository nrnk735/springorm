package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		
//		Student student=new Student(2678,"Ishita","Uttar Pradesh");
//	    int r=studentDao.insert(student);
//		System.out.println("Done"+r);
		
		
		//CRUD OPERATION WRITING SPRING ORM PROJECT
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		while(go)
		{
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all students");
			System.out.println("PRESS 3 for get detail of single student");
			System.out.println("PRESS 4 for delete students");
			System.out.println("PRESS 5 for update students");
			System.out.println("PRESS 6 exit");
			
			try
			{
				int input=Integer.parseInt(br.readLine());
				
				switch(input)
				{
				case 1:
					//add a new student
					//Taking input from user
					System.out.println("Enter user id :");
					int uId=Integer.parseInt(br.readLine());
					
					System.out.println("enter user name:");
					String uName=br.readLine();
					
					System.out.println("Enter user city: ");
					String uCity=br.readLine();
					
					
					//Creating student object and setting values 
					Student s=new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					//Saving student object to database by calling insert
					int r=studentDao.insert(s);
					System.out.println(r+"Student added");
					System.out.println("***********************************************");
					System.out.println();
					
					break;
				case 2:
					//display all student
					System.out.println("***********************************************");
					List<Student> allStudents=studentDao.getAllStudents();
					for(Student st:allStudents)
					{
						System.out.println("Id:"+st.getStudentId());
						System.out.println("Name:"+st.getStudentName());
						System.out.println("City:"+st.getStudentCity());
						System.out.println("---------------------------------------");
					}
						
					
					break;
				case 3:
					//get single student data
					System.out.println("Enter user id :");
					int userId=Integer.parseInt(br.readLine());
					Student student=studentDao.getStudent(userId);
					System.out.println("Id:"+student.getStudentId());
					System.out.println("Name:"+student.getStudentName());
					System.out.println("City:"+student.getStudentCity());
					System.out.println("---------------------------------------");
					
					
					break;
				case 4:
					//delete student
					System.out.println("Enter user id :");
					int id=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted..........");
					
					break;
				case 5:
					//update the student
					
					break;
				case 6:
					//exit
					
					
					go=false;
					break;
				
				default:
					System.out.println("WRONG CASE ENTERED");
				}
				
			}catch(Exception e)
			{
				System.out.println("Invalid Input Try with another one !!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thank you for using application");
		System.out.println("See you soon");

	}

}
