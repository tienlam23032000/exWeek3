import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student extends Person {
    private HashMap<String, Integer> grades; // Mappings of subject to grades
    private Date updatedIn;
    private Teacher updatedBy;

    public Student(int id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth);
        grades = new HashMap<>();
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public Date getUpdatedIn() {
        return updatedIn;
    }

    public Teacher getUpdatedBy() {
        return updatedBy;
    }

    public void viewGrades() { // Xem diem
        for (String subject : grades.keySet()) {
            System.out.println("Subject: " + subject + ", Grade: " + grades.get(subject));
        }
    }

    public void setGrades(HashMap<String, Integer> grades) {
        this.grades = grades;
    }

    public void setUpdatedIn(Date updatedIn) {
        this.updatedIn = updatedIn;
    }

    public void setUpdatedBy(Teacher updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void updateGrade(String subject, int grade, Teacher teacher) {
        // Kiểm tra xem người cập nhật là giáo viên
        if (teacher instanceof Teacher) {
            // Kiểm tra xem giáo viên có thẩm quyền thay đổi điểm của môn học này không
            if (teacher.teachesSubject(subject)) {
                grades.put(subject, grade);
                updatedIn = new Date();
                updatedBy = teacher;
                System.out.println("Grade for " + subject + " updated by " + teacher.getName());
            } else {
                System.out.println("Teacher " + teacher.getName() + " is not authorized to update " + subject);
            }
        } else {
            System.out.println("Only teachers are authorized to update grades.");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(grades, student.grades) &&
                Objects.equals(updatedIn, student.updatedIn) &&
                Objects.equals(updatedBy, student.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grades, updatedIn, updatedBy);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", grades=" + grades +
                ", updatedIn=" + updatedIn +
                ", updatedBy=" + updatedBy.getName() +
                '}';
    }
}
