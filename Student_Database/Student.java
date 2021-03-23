package DBclass.Student_Database;

public class Student {
    String StudentID;
    String LastName;
    String FirstName;
    String Sex;
    String DateOfBirth;
    String PlaceOfBirth;
    String DeptID;
    String Scholarship;
    Float AverageScore;

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
//                ", Sex='" + Sex + '\'' +
//                ", DateOfBirth='" + DateOfBirth + '\'' +
//                ", PlaceOfBirth='" + PlaceOfBirth + '\'' +
                ", DeptID='" + DeptID + '\'' +
                ", Scholarship='" + Scholarship + '\'' +
                ", AverageScore='" + AverageScore + '\'' +
                '}';
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return PlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        PlaceOfBirth = placeOfBirth;
    }

    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String deptID) {
        DeptID = deptID;
    }

    public String getScholarship() {
        return Scholarship;
    }

    public void setScholarship(String scholarship) {
        Scholarship = scholarship;
    }

    public Float getAverageScore() {
        return AverageScore;
    }

    public void setAverageScore(Float averageScore) {
        AverageScore = averageScore;
    }

}
