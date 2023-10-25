import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person{
    private ArrayList<String> subjects; // List of subjects the teacher teaches

    public Teacher(int id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth);
        subjects = new ArrayList<>();
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public boolean teachesSubject(String subject) {
        return subjects.contains(subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjects);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", subjects=" + subjects +
                '}';
    }
}