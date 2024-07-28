package application;

import java.util.Scanner;

import model.dao.ActivityDao;
import model.dao.DaoFactory;
import model.dao.TeacherDao;
import model.entities.Activity;
import model.entities.Teacher;

public class CMDManager {
	
	public static Integer classe;
	
	ActivityDao activityDao = DaoFactory.createActivityDao();
	TeacherDao teacherDao = DaoFactory.createTeacherDao();
	
	public void getCMD(String place, Scanner sc, Teacher user) {
		
		System.out.print("Command: ");
		String cmd = sc.nextLine();
		
		switch(place) {
		case "menu":
			if(cmd.equals("shwacts")) {
				System.out.print("Select Class (1, 2, 3, etc..): ");
				classe = sc.nextInt();
				if(classe < user.getClasses().size() && classe > 0) {
					UI.showClass(user, classe);
				}
				else {
					System.out.println("Invalid Class!");
				}
			}
			if(cmd.equals("logout")) user.setId(0);
			break;
		case "classe":
			if(cmd.equals("add")) {
				System.out.print("Activity Name: ");
				String name = sc.nextLine();
				int classeId = classe;
				Activity act = new Activity(0, name, classeId);
				activityDao.insert(act);
				
				user = teacherDao.refreshUser(user);
				
				UI.showClass(user, classe);
			}
		}
	}
}