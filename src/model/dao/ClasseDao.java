package model.dao;

import java.util.List;

import model.entities.Classe;

public interface ClasseDao {

	void insert(Classe obj);
	void update(Classe obj);
	void deleteById(Integer id);
	Classe findById(Integer id);
	List<Classe> findAll();
	List<Classe> findByTeacherId(Integer teacherId);
}
