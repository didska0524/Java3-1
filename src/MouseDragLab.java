import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class MouseDragLab extends JFrame {

    MouseDragLab() {

        setTitle("MouseListener와 MouseMotionListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);
        c.setLayout(null);
        c.setBackground(Color.GREEN);
        setSize(300,200);
        setVisible(true);
        setLocationRelativeTo(null); // 실행 시 프레임의 위치가 가운데 오도록 함

    }

    class MyMouseListener implements MouseListener, MouseMotionListener {

        public void mousePressed(MouseEvent e) {

        }
        public void mouseReleased(MouseEvent e) {
            Component comp = (Component)e.getSource();
            comp.setBackground(Color.GREEN);}

        public void mouseClicked(MouseEvent e) {

        }
        public void mouseEntered(MouseEvent e) {

        }
        public void mouseExited(MouseEvent e) {

        }
        public void mouseDragged(MouseEvent e) {

            Component comp = (Component)e.getSource();
            setTitle("mouseDragged ("+e.getX()+","+e.getY()+")");
            comp.setBackground(Color.RED);

        }

        public void mouseMoved(MouseEvent e) {

        }

    }

    public static void main(String [] args) {
        new MouseDragLab();
    }
}

