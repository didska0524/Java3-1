import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ForkJoinPool;

public class SwingEx8 extends JFrame {

    JLabel hj;
    JButton bot,bot2,bot3;

    SwingEx8() {
        setTitle("OpenChallenge"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        //contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout
        JPanel contentPane2 = new JPanel();
        contentPane2.setBackground(Color.gray);
        contentPane2.setLayout(new BorderLayout());

        bot= new JButton("Open");
        bot2=new JButton("Read");
        bot3=new JButton("Close");
        contentPane.add(bot);//,BorderLayout.NORTH);
        contentPane.add(bot2);//,BorderLayout.NORTH);
        contentPane.add(bot3);//,BorderLayout.NORTH);

        hj = new JLabel("Hello Java!");
        //hj.setSize(100,20);
        hj.setBounds(100,50,100,20);
        add(hj);


        setSize(300, 300);
        add(contentPane,BorderLayout.NORTH);
        add(contentPane2,BorderLayout.CENTER);
        setVisible(true); // 화면에 프레임 출력

    }

    public static void main(String[] args) {
        new SwingEx8();
    }
}