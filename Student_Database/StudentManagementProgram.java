package DBclass.Student_Database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class StudentManagementProgram {
    Connection connection;

    public StudentManagementProgram(Connection connection) {
        this.connection = connection;
    }
    /*
    5.3
     - Viết hàm cập nhật số lượng sinh viên (cột NoOfStudent) cho bảng departments, department nào không có sinh viên thì mặc định là 0.
     - Viết hàm tính điểm trung bình của các học sinh (cột AverageScore) theo quy tắc: Điểm TB = [ điểm cao nhất (của 1 môn) * số tín chỉ (credits) ] / tổng số tín chỉ
    */
    public void updateNoOfStudent(String DeptID, String NoOfStudents){
        try {
            String updateSQL = "UPDATE `manage_student`.`departments` SET `NoOfStudents` = '"+NoOfStudents+"' WHERE (`DeptID` = '"+DeptID+"');";
            if (NoOfStudents == null){
                updateSQL = "UPDATE `manage_student`.`departments` SET `NoOfStudents` = '0' WHERE (`DeptID` = '"+DeptID+"');";
            }
            Statement updateStatment = connection.createStatement();
            updateStatment.executeUpdate(updateSQL);
            System.out.println("UPDATED row DeptID = '"+DeptID+"'");
        }catch (Exception e){
            System.out.println("Syntax ERROR");
        }
    }
}
