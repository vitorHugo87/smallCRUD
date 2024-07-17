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
		
		Teacher test = new Teacher();
		TeacherDao teacherDao = DaoFactory.createTeacherDao();
		
		test = teacherDao.findById(1);
		
		System.out.println(test);
		
		sc.close();
	}

}
