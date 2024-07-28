package application;

import java.util.List;

import model.entities.Activity;
import model.entities.Classe;
import model.entities.Teacher;

public class UI {
	
	public static String place = "";

	public static void showMenu(Teacher obj) {
		place = "menu";
		clearConsole();
		
		System.out.println("Welcome " + obj.getUsername());
		System.out.println("Classes:");
		int i = 1;
		for(Classe c : obj.getClasses()) {
			System.out.println(i + " - " + c.getName());
			i++;
		}
		
		System.out.println("- - - COMMANDS - - -");
		System.out.println("shwacts - Show Activities");
		System.out.println("logout - Quit System");
	}
	
	public static void showClass(Teacher obj, Integer classe) {
		place = "classe";
		clearConsole();
		List<Activity> activities = obj.getClasses().get(classe - 1).getActivities();

		System.out.println(obj.getClasses().get(classe - 1).getName() + " Activities: ");
		
		int i = 1;
		for(Activity act : activities) {
			System.out.println(i + " - " + act.getName());
			i++;
		}
		
		System.out.println("- - - COMMANDS - - -");
		System.out.println("add - Add new Activity");
		System.out.println("update - Update Activity");
		System.out.println("delete - Delete Activity");
		System.out.println("return - Return to Menu");
	}
	
	private static void clearConsole() {
		for(int i = 0; i < 20; i++) {
			System.out.println();
		}
	}
}
