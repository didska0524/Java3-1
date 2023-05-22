package thread;

import javax.swing.*;
import java.awt.*;

public class RandomImage extends JFrame {

    ImagePanel ipanel = new ImagePanel();
    int x=50, y=50;

    public RandomImage() {
        setTitle("랜덤 이미지 출력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(ipanel);
        TimerThread th = new TimerThread(ipanel);
        setSize(500,500);
        setVisible(true);
        th.start();
    }

    public static void main(String[] args) {
        new RandomImage();
    }

    class ImagePanel extends JPanel {
        ImageIcon icon = new ImageIcon("images/bubble.jpg");
        Image image = icon.getImage();

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            x+=5;
            g.drawImage(image, x, y, this);
        }
    }
}

class TimerThread extends Thread {
    JPanel panel;
    public TimerThread(JPanel p) {
        this.panel=p;
    }
    public void run() {
        while (true) {
            panel.repaint();
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                return;
            }
        }
    }
}