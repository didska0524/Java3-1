import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class LabelMouseEvent extends JFrame {

    public LabelMouseEvent() {

        setTitle("계산기");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new GridLayout(3,4));

        for(int i=0; i<12; i++) {

            JLabel label = new JLabel(String.format("%d", i));
            c.add(label); // 컨텐트팬에 버튼 컴포넌트 추가
            label.addMouseListener(new MYMouseListener());
            label.setOpaque(true);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelMouseEvent();
    }

    class MYMouseListener implements MouseListener {

        public void mouseClicked(MouseEvent e) { // 마우스 클릭 시
            JLabel lab = (JLabel) e.getSource();
            lab.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))); // new Color(int r, int g, int b)
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

    }

}