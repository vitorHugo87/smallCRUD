package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ClasseDao;
import model.dao.DaoFactory;
import model.dao.TeacherDao;
import model.entities.Teacher;

public class TeacherDaoJDBC implements TeacherDao{
	
	private Connection conn;
	
	public TeacherDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Teacher obj) {
		
	}

	@Override
	public void update(Teacher obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Teacher findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		Teacher teacher = new Teacher();
		
		try {
			st = conn.prepareStatement("SELECT * FROM teachers WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				teacher.setId(rs.getInt("id"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
				teacher.setEmail(rs.getString("email"));
				
				ClasseDao classDao = DaoFactory.createClasseDao();
				
				teacher.setClasses(classDao.findByTeacherId(id));
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		return teacher;
	}

	@Override
	public List<Teacher> findAll() {
		return null;
	}
	
	@Override
	public Teacher login(Teacher obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM teachers WHERE username = ? AND password = ?");
			st.setString(1, obj.getUsername());
			st.setString(2, obj.getPassword());
			rs = st.executeQuery();
			
			if(rs.next()) {
				obj.setId(rs.getInt("id"));
				
				obj = findById(obj.getId());
			}
			else {
				obj = null;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		return obj;
	}
	
	public Teacher refreshUser(Teacher obj) {
		obj = findById(obj.getId());
		
		return obj;
	}

}
