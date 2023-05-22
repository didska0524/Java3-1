package thread0522;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneWriter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        System.out.println("전화 번호부 입력....");

        try {
            FileWriter fout = new FileWriter("C:\\Phone\\phone.txt");
            while (true) {
                System.out.println("이름, 전화번호부......");
                str = scan.nextLine();
                if(str.equals("그만")) break;
                fout.write(str);
                fout.write('\n');

            }
            fout.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
