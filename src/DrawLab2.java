

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class DrawLab2 extends JFrame {

    JButton st = new JButton("중지");

    JButton cn = new JButton("시작");

    int x=100, y=100; // 초기 사각형 좌표가 100,100 이므로 이렇게 설정

    String flag;

    DrawLab2() {

        setTitle("마우스 드래깅으로 타원 그리기 예제");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new MyPanel());


        setSize(300, 300);

        setLocationRelativeTo(null); // 결과창 가운데로

        setVisible(true);

    }

    public static void main(String [] args) {

        new DrawLab2();

    }

// 사각형을 그릴 패널 작성. 이 패널에 마우스 리스너 구현

    class MyPanel extends JPanel {

        public MyPanel() {

            Timer timer = new Timer(10, new TimerListener());

            timer.start();

            add(st);

            add(cn);

            st.addActionListener(new MyActionListener() { // 중지버튼을 눌렀을 때

                @Override

                public void actionPerformed(ActionEvent e) {

                    JButton b = (JButton)e.getSource();

                    if(b.getText() == "중지")

                        timer.stop();

                }


            });

            cn.addActionListener(new MyActionListener() { // 시작버튼을 눌렀을 때

                @Override

                public void actionPerformed(ActionEvent e) {

                    JButton b = (JButton)e.getSource();

                    if(b.getText() == "시작")

                        timer.start();

                }

            });

        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            x+=1;

            g.fillRect(x, y, 20, 20);

        }

        class TimerListener implements ActionListener { // 타이머 클래스

            @Override

            public void actionPerformed(ActionEvent e) {

                repaint();

            }

        }

        class MyActionListener implements ActionListener { // 버튼과 연결된 액션클래스

            @Override

            public void actionPerformed(ActionEvent e) {

            }


        }

    }

}


/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLab2 extends JFrame {
    int x=100,y=100;
    char flag;
    DrawLab2() {
        DrawPanel dpanel = new DrawPanel();
        setTitle("도형그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(dpanel);
        dpanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                x=e.getX();
                y=e.getY();
                if (e.getButton()==MouseEvent.BUTTON1)
                    flag='L';
                else
                    flag='R';
                repaint();
            }
        });
        stop.addActionListener(new ActionListener());

        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawLab2();
    }
    class DrawPanel extends JPanel {
        Timer timer = new Timer(1000, new TimerListener());

        DrawPanel() {
            timer.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (flag == 'L') {
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 50, 50);
            } else if (flag == 'R') {
                g.setColor(Color.RED);
                g.fillOval(x, y, 50, 50);
            } else {
                x += 3;
                g.fillRect(x, y, 20, 20);
            }
        }

        public void ball_stop() {
            timer.stop();
        }

        class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
    }
}
*/



























/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawLab2 extends JFrame {
    int x=10,y=100;
    int flag;

    JButton stopball, startball;
    DrawLab2() {
        DrawPanel dpanel = new DrawPanel();
        setTitle("도형그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(dpanel);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout

        stopball.addActionListener(new MyListener());
        startball.addActionListener(new MyListener());

        */
/*dpanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                x=e.getX();
                y=e.getY();
                if (e.getButton()==MouseEvent.BUTTON1)
                    flag='L';
                else
                    flag='R';
                repaint();
            }
        });*//*



        stopball = new JButton("중지");
        startball = new JButton("시작");

        contentPane.add(stopball);
        contentPane.add(startball);

        setSize(500,500);
        setVisible(true);

        add(dpanel,BorderLayout.NORTH);
        add(contentPane,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new DrawLab2();
    }
    class DrawPanel extends JPanel {
        public DrawPanel(){
            Timer timer=new Timer(1000, new TimerListener());
            timer.start();
            timer.setDelay(10);
            if (flag==1){
                timer.stop();
            }
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(flag == 0) {
                g.fillOval(x, y, 10, 10);
                x++;
            }
            else if(flag==1) {
                g.fillOval(x, y, 10, 10);
            }
        }
    }
    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            if (e.getSource()== stopball){
                flag=1;
            }
            else if (e.getSource()== startball){
                flag=0;
            }
        }
    }
}
*/
