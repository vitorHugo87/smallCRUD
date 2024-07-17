package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher {
	private Integer id;
	private String username;
	private String password;
	private String email;
	
	List<Classe> classes = new ArrayList<>();
	
	public Teacher() {
	}

	public Teacher(Integer id, String username, String password, String email, List<Classe> classes) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.classes = classes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
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
		Teacher other = (Teacher) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", classes=" + classes + "]";
	}
}
