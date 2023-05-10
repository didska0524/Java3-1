package jdbc_study;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    StudentDAO dao = null;

    public StudentMain() {
        dao = new StudentDAO();
    }
    public void getList(){ //1.학생 리스트
        ArrayList<Student> list = dao.studentList();
        for(Student s:list)
            System.out.println(s.toString());
    }
    public void doInsert(){ //2.학생 정보 추가
        System.out.println("추가할 학생 정보를 입력하시요..");
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scanner.next();
        if(!isInt(id)){
            System.out.println("id는 문자열로 입력해 주세요");
            doInsert();
        }
        System.out.print("NAME: ");
        String name = scanner.next();
        System.out.print("Dept: ");
        String dept = scanner.next();
        Student student = new Student(id,name,dept);

        boolean success = dao.insertStudent(student);
        if(success)
            System.out.println("학생 정보 추가 성공");
        else
            System.out.println("학생 정보 추가 실패");
    }

    public void doUpdate(){ //3. 학생 정보 수정
        Scanner s = new Scanner(System.in);
        System.out.print("변경하고 싶은 학생 id : ");
        String id = s.next();
        if(!isInt(id)){
            System.out.println("id는 문자열로 입력해 주세요");
            doUpdate();
        }
        System.out.print("변경하고 싶은 학생 name : ");
        String name = s.next();
        System.out.print("변경하고 싶은 학생 dept : ");
        String dept = s.next();
        Student student = new Student(id, name, dept);

        boolean success = dao.updateStudent(student);
        if(success)
            System.out.println("학생 정보 수정 성공");
        else
            System.out.println("학생 정보 수정 실패");
    }

    public void doDelete(){ //4. 학생 정보 삭제
        Scanner s = new Scanner(System.in);
        System.out.println("삭제하고 싶은 학생 id : ");
        String id = s.next();
        Student student = new Student(id);
        boolean success = dao.deleteStudent(student);
        if(success)
            System.out.println("학생 삭제 성공");
        else
            System.out.println("학생 삭제 실패");
    }

    public static boolean isInt(String s){
        try {
            int num = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        StudentMenu s = new StudentMenu();
    }
}