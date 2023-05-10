package jdbc_study;

import java.util.Scanner;

public class StudentMenu {
    StudentMain m = new StudentMain();
    public StudentMenu() {

        while (true) {
            System.out.println("====학생 관리 프로그램====");
            System.out.println("1.학생 리스트");
            System.out.println("2.학생 정보 추가");
            System.out.println("3.학생 정보 수정");
            System.out.println("4.학생 정보 삭제");
            System.out.println("0.종료");
            System.out.print("입력할 메뉴 선택 : ");
            Scanner s = new Scanner(System.in);
            int num = s.nextInt();

            switch (num) {
                case 1 -> m.getList();
                case 2 -> m.doInsert();
                case 3 -> m.doUpdate();
                case 4 -> m.doDelete();
            }
            if (num==0) {
                break;
            }
        }
    }
}
