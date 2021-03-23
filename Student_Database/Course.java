package DBclass.Student_Database;

public class Course {
    String CourseID;
    String Name;
    Integer Credits;

    @Override
    public String toString() {
        return "Course{" +
                "CourseID='" + CourseID + '\'' +
                ", Name='" + Name + '\'' +
                ", Credits=" + Credits +
                '}';
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCredits() {
        return Credits;
    }

    public void setCredits(Integer credits) {
        Credits = credits;
    }
}
