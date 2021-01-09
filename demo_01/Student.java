package demo_01;
//使用getter和setter构成学生类

import java.util.Date;

public class Student {
     private String Studentid;
     private String StudentName;
     private String sex;
     private String HomeAddr;
     private String ClassID;

     public Student(String studentid, String studentName, String sex, String homeAddr, String classID) {
          Studentid = studentid;
          StudentName = studentName;
          this.sex = sex;
          HomeAddr = homeAddr;
          ClassID = classID;
     }

     public String getStudentid() {
          return Studentid;
     }

     public void setStudentid(String studentid) {
          Studentid = studentid;
     }

     public String getStudentName() {
          return StudentName;
     }

     public void setStudentName(String studentName) {
          StudentName = studentName;
     }

     public String getSex() {
          return sex;
     }

     public void setSex(String sex) {
          this.sex = sex;
     }

     public String getHomeAddr() {
          return HomeAddr;
     }

     public void setHomeAddr(String homeAddr) {
          HomeAddr = homeAddr;
     }

     public String getClassID() {
          return ClassID;
     }

     public void setClassID(String classID) {
          ClassID = classID;
     }
}






