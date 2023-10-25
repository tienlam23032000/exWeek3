import java.util.Date;

public class Main {
    public static void main(String[] args) {
            // Tạo sinh viên
            Student student = new Student(1, "Lam", new Date());

            // Tạo giáo viên
            Teacher teacher = new Teacher(101, "Ha", new Date());
            teacher.addSubject("Cau truc du lieu va giai thuat");
            teacher.addSubject("Java backend");

            // Giáo viên nhập điểm cho sinh viên
            student.updateGrade("Java backend", 8, teacher);

            // Sinh viên xem điểm của mình
            System.out.println("Student's Grades:");
            student.viewGrades();

            // Thử cập nhật điểm cho môn học mà giáo viên không dạy
            Teacher teacher2 = new Teacher(102, "Tuan", new Date());
            teacher2.addSubject("Frontend");
            student.updateGrade("Frontend", 9, teacher);

            // Sinh viên xem lại điểm sau cập nhật
            System.out.println("Student's Updated Grades:");
            student.viewGrades();
        }
    }