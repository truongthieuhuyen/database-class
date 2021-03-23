package DBclass.Student_Database;

public class Department {
    String DeptID;
    String Name;
    String NoOfStudents;

    public Department(String deptID, String noOfStudents) {
        DeptID = deptID;
        NoOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DeptID='" + DeptID + '\'' +
                ", Name='" + Name + '\'' +
                ", NoOfStudents='" + NoOfStudents + '\'' +
                '}';
    }

    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String deptID) {
        DeptID = deptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNoOfStudents() {
        return NoOfStudents;
    }

    public void setNoOfStudents(String noOfStudents) {
        NoOfStudents = noOfStudents;
    }
}
