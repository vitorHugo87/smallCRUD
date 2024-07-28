package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ActivityDao;
import model.dao.ClasseDao;
import model.dao.DaoFactory;
import model.entities.Classe;

public class ClasseDaoJDBC implements ClasseDao{
	
	private Connection conn;
	
	public ClasseDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Classe obj) {
		
	}

	@Override
	public void update(Classe obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Classe findById(Integer id) {
		return null;
	}

	@Override
	public List<Classe> findAll() {
		return null;
	}
	
	public List<Classe> findByTeacherId(Integer teacherId){
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Classe> classList = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM classes WHERE teacherId = ?");
			st.setInt(1, teacherId);
			rs = st.executeQuery();
			
			while(rs.next()) {
				Classe classe = new Classe();
				classe.setId(rs.getInt("id"));
				classe.setName(rs.getString("name"));
				classe.setTeacherId(rs.getInt("teacherId"));
				
				ActivityDao actDao =  DaoFactory.createActivityDao();
				
				classe.setActivities(actDao.findByClasseId(classe.getId()));
				
				classList.add(classe);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		return classList;
	}

}
