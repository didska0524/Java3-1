import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelImage extends JFrame {
    JPanel contentPane = new JPanel();
    ImageIcon apple = new ImageIcon("images/apple.jpg");
    ImageIcon banana = new ImageIcon("images/banana.jpg");
    ImageIcon cherry = new ImageIcon("images/cherry.jpg");
    ImageIcon kiwi = new ImageIcon("images/kiwi.jpg");
    ImageIcon mango = new ImageIcon("images/mango.jpg");


    JLabel la; //= new JLabel(image);
    //JLabel la;


    LabelImage() {
        super("레이블 이미지 출력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.addKeyListener(new MyKeyListener());
        la = new JLabel();

        la.setLocation(50, 50);
        la.setSize(100, 100);
        contentPane.add(la);

        setSize(400, 400);
        setVisible(true);

        setLocationRelativeTo(null);
        contentPane.requestFocus(); // 포커스 지정
    }
    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 입력된 키코드
            switch(keyCode){
                case KeyEvent.VK_A:
                    //image = new ImageIcon("images/apple.jpg");
                    la.setIcon(apple);
                    break;
                case KeyEvent.VK_B:
                    //image = new ImageIcon("images/banana.jpg");
                    la.setIcon(banana);
                    break;
                case KeyEvent.VK_C:
                    //image = new ImageIcon("images/cherry.jpg");
                    la.setIcon(cherry);
                    break;
                case KeyEvent.VK_K:
                    //image = new ImageIcon("images/cherry.jpg");
                    la.setIcon(kiwi);
                    break;
                case KeyEvent.VK_M:
                    //image = new ImageIcon("images/cherry.jpg");
                    la.setIcon(mango);
                    break;
            }
            switch(keyCode) {
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(), la.getY() - 10);
                    break;
                case KeyEvent.VK_DOWN:
                    la.setLocation(la.getX(), la.getY() + 10);
                    break;
                case KeyEvent.VK_LEFT:
                    la.setLocation(la.getX() - 10, la.getY());
                    break;
                case KeyEvent.VK_RIGHT:
                    la.setLocation(la.getX() + 10, la.getY());
                    break;
            }
        }
    }

    public static void main(String [] args) {
        new LabelImage();
    }
}