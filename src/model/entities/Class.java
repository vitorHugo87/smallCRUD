package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Class {

	private Integer id;
	private String name;
	private Integer teacherId;
	
	
	List<Activity> activities = new ArrayList<>();
	
	public Class() {
	}

	public Class(Integer id, String name, Integer teacherId, List<Activity> activities) {
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
		this.activities = activities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class other = (Class) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", teacherId=" + teacherId + ", activities=" + activities + "]";
	}
}
