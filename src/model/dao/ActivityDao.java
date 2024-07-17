package model.dao;

import java.util.List;

import model.entities.Activity;

public interface ActivityDao {

	void insert(Activity obj);
	void update(Activity obj);
	void deleteById(Integer id);
	Activity findById(Integer id);
	List<Activity> findAll();
	List<Activity> findByClasseId(Integer classeId);
}
