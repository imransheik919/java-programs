
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBC {

	public static void main(String[] args) {
		// insert();
		List<Student> students = getStudentsData();
		for (Student s : students) {
			System.out.println("Id:" + s.getId() + " Name:" + s.getName());
		}
	}

	private static List<Student> getStudentsData() {
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Imran919@");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from studentapp");

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	private static void insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Imran919@");
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate("insert into student.studentapp values(6,'shannu')");

			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
