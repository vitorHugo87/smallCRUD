package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.CMDManager;
import db.DB;
import db.DbException;
import model.dao.ActivityDao;
import model.entities.Activity;

public class ActivityDaoJDBC implements ActivityDao{
	
	private Connection conn;
	
	public ActivityDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Activity obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO activities(name, classeId) VALUES (?, ?)");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getClassId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Activity obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE activities SET name = ? WHERE id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM activities WHERE id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Activity findById(Integer id) {
		return null;
	}

	@Override
	public List<Activity> findAll() {
		return null;
	}
	
	public List<Activity> findByClasseId(Integer classeId){
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Activity> activitiesList = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM activities WHERE classeId = ?");
			st.setInt(1, classeId);
			rs = st.executeQuery();
			
			while(rs.next()) {
				Activity act = new Activity();
				act.setId(rs.getInt("id"));
				act.setName(rs.getString("name"));
				act.setClassId(rs.getInt("classeId"));
				activitiesList.add(act);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		return activitiesList;
	}

}
