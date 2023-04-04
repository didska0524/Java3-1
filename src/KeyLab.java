import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyLab extends JFrame {
    JPanel contentPane = new JPanel();
    JLabel la = new JLabel("Width = 300, Height = 300");

    int x = 300;
    int y = 300;
    KeyLab() {
        super("상,하,좌,우 키를 이용하여 프레임 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.addKeyListener(new MyKeyListener());

        la.setLocation((x-80)/2, y/2);
        la.setSize(200, 40);
        contentPane.add(la);

        setSize(x,y);
        setVisible(true);

        setLocationRelativeTo(null); // 실행 시 프레임의 위치가 가운데 오도록 함
        contentPane.requestFocus(); // 포커스 지정
    }
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 입력된 키코드
            switch(keyCode) {
                case KeyEvent.VK_UP:
                    setSize(x,y+=10);
                    la.setLocation((x-80)/2, y/2);
                    la.setText("Width = " + x + ", Height = "+ y);
                    //contentPane.setSize(contentPane.getX(), contentPane.getY() - 10);
                    break;
                case KeyEvent.VK_DOWN:
                    setSize(x,y-=10);
                    la.setLocation((x-80)/2, y/2);
                    la.setText("Width = " + x + ", Height = "+ y);
                    break;
                //contentPane.setSize(contentPane.getX(), contentPane.getY() + 10); break;
                case KeyEvent.VK_LEFT:
                    setSize(x-=10,y);
                    la.setLocation((x-80)/2, y/2);
                    la.setText("Width = " + x + ", Height = "+ y);
                    break;
                    //contentPane.setSize(contentPane.getX() - 10, contentPane.getY()); break;
                case KeyEvent.VK_RIGHT:
                    setSize(x+=10,y);
                    la.setLocation((x-80)/2, y/2);
                    la.setText("Width = " + x + ", Height = "+ y);
                    break;
                    //contentPane.setSize(contentPane.getX() + 10, contentPane.getY()); break;
            }
        }
    }

    public static void main(String [] args) {
        new KeyLab();
    }
}