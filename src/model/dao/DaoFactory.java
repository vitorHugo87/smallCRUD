package model.dao;

import db.DB;
import model.dao.impl.ActivityDaoJDBC;
import model.dao.impl.ClasseDaoJDBC;
import model.dao.impl.TeacherDaoJDBC;

public class DaoFactory {

	public static TeacherDao createTeacherDao() {
		return new TeacherDaoJDBC(DB.getConnection());
	}
	
	public static ClasseDao createClasseDao() {
		return new ClasseDaoJDBC(DB.getConnection());
	}
	
	public static ActivityDao createActivityDao() {
		return new ActivityDaoJDBC(DB.getConnection());
	}
}
