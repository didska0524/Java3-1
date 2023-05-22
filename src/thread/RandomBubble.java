package thread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class RandomBubble extends JFrame{

    public RandomBubble() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel p = new GamePanel();
        setContentPane(p);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomBubble();
    }
    class GamePanel extends JPanel {
        Timer timer = new Timer(1000, new TimerListener());
        public GamePanel() {
            setLayout(null);
            timer.start();
        }
        class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BubbleThread((int)(Math.random()*300), 0).start();
            }
        }


        class BubbleThread extends Thread {
            JLabel bubble;
            public BubbleThread(int bubbleX, int bubbleY) {
                ImageIcon img = new ImageIcon("images/bubble.jpg");
                bubble = new JLabel(img);
                bubble.setSize(img.getIconWidth(),img.getIconHeight());
                bubble.setLocation(bubbleX, bubbleY);
                add(bubble);
                repaint();
            }

            /*public void run() { //이미지가 화면 밖으로 나갈경우 제거됨
                while (bubble.getY() + bubble.getHeight() > 0) {
                    bubble.setLocation(bubble.getX(), bubble.getY() + 1);
                    try {
                        Thread.sleep(10); // 움직임의 속도를 조절하려면 sleep 시간을 조정하세요.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                remove(bubble); // 이미지가 화면 밖으로 넘어간 후에는 제거합니다.
                repaint();
            }*/

            public void run() { // 교수님이 쓰신 정답
                while(true) {
                    int x = bubble.getX();
                    int y = bubble.getY() + 1;

                    bubble.setLocation(x,y);
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }
}

