package maps2;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import allList.Employee;



public class StudentUIForm {





	public static void main(String[] args) {


		StudentServerCode server = new StudentServerCode();

		Scanner sc = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);

		while(true)
		{
			System.out.println("\n\n\n        *** Application ***");
			System.out.println("1. Add Student ");
			System.out.println("2. Update Student Profile");
			System.out.println("3. Add Student Marks. ");
			System.out.println("4. View Student Marks by Roll Number & Stream. ");
			System.out.println("5. View Students Based on Stream. ");
			System.out.println("6. View Student Marks (High to low) Based on Stream.");
			System.out.println("7. View Student Based on State.");
			System.out.println("8. Get Student Profile Based on Roll Number & Stream ");
			System.out.println("9. View All Students");// print entire map
			System.out.println("10. Add Student Certificates");
			System.out.println("11. View Student Based on Certificate.");

			System.out.println("0. EXIT");
			System.out.println("\n\t Enter Option ");

			switch (sc.nextInt()) {
			case 1:

				System.out.println("Enter Student Name ");
				String studentName = scStr.nextLine();

				System.out.println("Enter Student Stream ");
				System.out.println("IT/CS/ELE/MCA");
				String studentStream = scStr.nextLine();
				studentStream = studentStream.trim().toUpperCase();

				int rollNum = getRandom();

				Student basicStudent = new Student(rollNum, studentName, studentStream);

				int count = server.insertStudent(basicStudent);
				System.out.println(" Student Added in Stream "+studentStream+" total Students are :- "+count);
				break;

			case 2:

				System.out.println("Enter Student Roll Number ");
				int rollNumber = sc.nextInt();

				System.out.println("Enter Student Stream ");
				String searchStream = scStr.nextLine();

				Student s = server.getStudentBasedOnRollNumberAndStream(rollNumber, searchStream);

				if(s != null)
				{
					// if student is not null then only update the profile otherwise render msg

					System.out.println("Enter House Number ");
					String houseNumber = scStr.nextLine();

					System.out.println("Enter City ");
					String city = scStr.nextLine();

					System.out.println("Enter State ");
					String state = scStr.nextLine();

					System.out.println("Enter Email ");
					String email = scStr.nextLine();

					System.out.println("Enter Phone Number ");
					long phoneNumber = sc.nextLong();

					StudentDetails profile = new StudentDetails(houseNumber, city, state, phoneNumber, email);

					Student updatedStudent = server.updateStudentProfile(s, profile);
					printStudents(updatedStudent);
				}
				else
				{
					System.out.println(" \n STUDENT NOT FOUND WRONG ROLL NUMBER OR STREAM \n");
					System.out.println("Entered Roll Number "+rollNumber);
					System.out.println("Entered Stream "+searchStream);
					
				}

       break;

				

			case 3:
				System.out.println("Enter Student Roll Number ");
				int rollNo = sc.nextInt();

				System.out.println("Enter Student Stream ");
				String searchStr = scStr.nextLine();
                
				Student desiredStudent=server.getStudentBasedOnRollNumberAndStream(rollNo, searchStr);
				//entering subject wise marks of desired student
				Subject java=new Subject("oops", "abs", 78);
				Subject db=new Subject("database", "abs", 76);
				Subject os=new Subject("operating system", "abs", 70);
				Subject cloud=new Subject("oops", "abs", 56);
				Subject st=new Subject("testing", "abs", 67);
				List<Subject> subjectList=new ArrayList<>();//allign these subj into a list
				subjectList.add(java);
				subjectList.add(db);
				subjectList.add(os);
				subjectList.add(cloud);
				subjectList.add(st);
				
				//it takes student info and student marks
				 Student desiredStudentWithMarks=server.addStudentMarks(desiredStudent, subjectList);
				 printStudents(desiredStudentWithMarks);
				 
				 
				 break;
				 
			
				
                
			  case 4:
				
				System.out.println("Enter Student Roll Number ");
				int rollNum11 = sc.nextInt();

				System.out.println("Enter Student Stream ");
				String searchStream1 = scStr.nextLine();
				searchStream1=searchStream1.trim().toUpperCase();
				Student desiredMarkStudent=server.getStudentBasedOnRollNumberAndStream(rollNum11, searchStream1);
				
				 printStudents(desiredMarkStudent);
				 
				break;

			case 5:
				System.out.println("Enter Student Stream ");
				System.out.println("IT/CS/ELE/MCA");
				String searchedStream = scStr.nextLine();
				searchedStream = searchedStream.trim().toUpperCase();

				List<Student> allStudents =  server.getStudentByStream(searchedStream);
				for (Student student : allStudents) {
					printStudents(student);
				}

				break;

			case 6:
				System.out.println("Enter Student Stream ");
				System.out.println("IT/CS/ELE/MCA");
				String searchedStream1 = scStr.nextLine();
				searchedStream = searchedStream1.trim().toUpperCase();
				Student desiredSortedMarks=(Student) server.getStudentByStream(searchedStream1);
				
				      List<Student> s1= server.getStudentByStreamSortedByMarks(searchedStream1);
				     System.out.println(s1);
				break;
			case 7:
				System.out.println("Enter Student state");
				
				String searchedState= scStr.nextLine();
				
			searchedState = searchedState.trim().toUpperCase();
			List<Student> allStudents1 =  server.getStudentByState(searchedState);
			 
			for (Student student : allStudents1) {
				printStudents(student);
			}
			
				break;
			case 8:
				System.out.println("Enter Student Roll Number ");
				int rollNumber1 = sc.nextInt();

				System.out.println("Enter Student Stream ");
				String searchStream11 = scStr.nextLine();
				searchStream1=searchStream11.trim().toUpperCase();
				Student desiredStudentProfile=server.getStudentBasedOnRollNumberAndStream(rollNumber1, searchStream11);
				 printStudents(desiredStudentProfile);
				break;
			case 9:
				break;
			case 10:
				System.out.println("Enter Student Roll Number ");
				int rollNum1 = sc.nextInt();

				System.out.println("Enter Student Stream ");
				String searchStr1 = scStr.nextLine();
				Student s11=server.getStudentBasedOnRollNumberAndStream(rollNum1, searchStr1);
				
					if(s11!= null)
					{
						List<Certificate> certificates =getCertificates();
						
						Student studentWithCertificates=server.addStudentCertificates(s11, certificates);
						
							
							printStudents(studentWithCertificates);
						}
					
				
				
				break;
			case 11: 
				
	            System.out.println("Enter Student certificate name");
				
			    	String searchedCert= scStr.nextLine();
				
			searchedCert= searchedCert.trim().toUpperCase();
			List<Student> allStudents11=  server.getStudentByCertificate(searchedCert);
			List<Certificate> certificates =getCertificates();
			 System.out.println(certificates);
			
			break;
			case 0:				
			default:
				System.exit(0);
			}//end switch

		}//end while

	}//end of Main


	public static void printStudents(Student student)
	{


			System.out.print("\n"+student.getRollNum()+"\t");
			System.out.print(student.getName()+"\t");
			System.out.print(student.getStream()+"\t");

			System.out.println("\n Student Profile \n");
			StudentDetails profile = student.getProfile();
			if(profile != null)
			{
				System.out.print(profile.getHouseNumber()+" "+profile.getCity()+" "+profile.getState()+" \t");
				System.out.print(profile.getPhoneNumber()+" \t");
				System.out.print(profile.getEmail()+" \t");
			}
			else
			{
				System.out.println(" *** Profile Not Update !!!");
			}

			List<Subject> subjects = student.getAllSubjects();

			System.out.println("\n  Subject Details \n");

			if(subjects != null)
			{
				for (Subject subject : subjects) {
					System.out.println(subject.getSubjectName()+" - "+subject.getMarksObtain());
				}
			}
			else
			{
				System.out.println("  Marks Not Updated By Faculty !!! ");
			}
			List<Certificate> certificates =student.getAllCertificates();

			System.out.println("\n  Certificate Details \n");

			if(certificates != null)
			{
				for (Certificate certificate : certificates) {
					System.out.println(certificate.getCerName()+" - "+certificate.getCertNo());
				}
			}
			else
			{
				System.out.println("  Marks Not Updated By Faculty !!! ");
			}
			

			System.out.println("\n____________________________________________________________________________\n");


			

	}

	public static int getRandom()
	{
		return new Random().nextInt(1000);
	}
	public static List<Certificate> getCertificates()
	{
		Certificate c1=new Certificate(24356, "aws", "Technical");
		Certificate c2=new Certificate(600987, "placement", "graduation");
		Certificate c3=new Certificate(5436, "gold medal", "sport");
		Certificate c4=new Certificate(8976, "python", "Technical");
		List<Certificate> certificates=new ArrayList();
		certificates.add(c1);
		certificates.add(c2);
		certificates.add(c3);
		certificates.add(c4);
		
		return  certificates;
		
	}
}