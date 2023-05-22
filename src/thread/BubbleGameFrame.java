package thread;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BubbleGameFrame extends JFrame{

    public BubbleGameFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel p = new GamePanel();
        setContentPane(p);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BubbleGameFrame();
    }
    class GamePanel extends JPanel {
        public GamePanel() {
            setLayout(null);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    new BubbleThread(e.getX(),e.getY()).start();
                }
            });
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

            /*public void run() { //이미지가 상단바에 누적됨
                while (bubble.getY() > 0) {
                    bubble.setLocation(bubble.getX(), bubble.getY() - 1);
                    try {
                        Thread.sleep(10); // 움직임의 속도를 조절하려면 sleep 시간을 조정하세요.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }*/

            public void run() { //이미지가 화면 밖으로 나갈경우 제거됨
                while (bubble.getY() + bubble.getHeight() > 0) {
                    bubble.setLocation(bubble.getX(), bubble.getY() - 1);
                    try {
                        Thread.sleep(10); // 움직임의 속도를 조절하려면 sleep 시간을 조정하세요.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                remove(bubble); // 이미지가 화면 밖으로 넘어간 후에는 제거합니다.
                repaint();
            }
        }
    }
}
