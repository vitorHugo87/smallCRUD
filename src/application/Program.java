package application;

import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.TeacherDao;
import model.entities.Teacher;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		TeacherDao teacherDao = DaoFactory.createTeacherDao();
		
		Teacher user = new Teacher();
		do {
			System.out.print("Enter username: ");
			user.setUsername(sc.nextLine());
			System.out.print("Enter password: ");
			user.setPassword(sc.nextLine());
			
			user = teacherDao.login(user);
		}while(user.getId() == 0);
		
		System.out.println(user);
		
		sc.close();
	}

}
