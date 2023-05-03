import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawLab extends JFrame {
    int x=100,y=100;
    char flag;
    DrawLab() {
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

        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawLab();
    }
    class DrawPanel extends JPanel {
        DrawPanel(){
            Timer timer=new Timer(1000, new TimerListener());
            timer.start();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(flag=='L') {
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 50, 50);
            }
            else if (flag=='R'){
                g.setColor(Color.RED);
                g.fillOval(x, y, 50, 50);
            }
            else {
                x+=3;
                g.fillRect(x,y,20,20);
            }
        }
    }
    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
