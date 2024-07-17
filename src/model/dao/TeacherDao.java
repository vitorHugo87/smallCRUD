package model.dao;

import java.util.List;

import model.entities.Teacher;

public interface TeacherDao {

	void insert(Teacher obj);
	void update(Teacher obj);
	void deleteById(Integer id);
	Teacher findById(Integer id);
	List<Teacher> findAll();
}
