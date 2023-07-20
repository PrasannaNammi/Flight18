package inhertance.tableperclass;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "day21.Courses")
@Table(name = "courses")

public class Courses {
	@Id
	@Column(name = "course_id")
	private String id;

	@Column(name = "course_fname")
	private String name;

	@ManyToMany(mappedBy = "courses")
	Set<Student> students;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudent(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", student=" + students + "]";
	}

}
