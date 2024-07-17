package model.entities;

import java.util.Objects;

public class Activity {

	private Integer id;
	private String name;
	private Integer classeId;
	
	public Activity() {
	}

	public Activity(Integer id, String name, Integer classId) {
		this.id = id;
		this.name = name;
		this.classeId = classId;
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

	public Integer getClassId() {
		return classeId;
	}

	public void setClassId(Integer classId) {
		this.classeId = classId;
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
		Activity other = (Activity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", classId=" + classeId + "]";
	}
}
