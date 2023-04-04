import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxEx extends JFrame {
    JCheckBox [] fruits = new JCheckBox [3];
    JRadioButton [] fruits2 = new JRadioButton[3];
    String [] names = {"사과", "바나나", "체리"};

    ImageIcon apple = new ImageIcon("images/apple.jpg");
    ImageIcon banana = new ImageIcon("images/banana.jpg");
    ImageIcon cherry = new ImageIcon("images/cherry.jpg");

    JLabel sumLabel;

    JLabel la;
    CheckBoxEx() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container c = getContentPane();

        JLabel label = new JLabel("사과 1000원, 바나나5000원, 체리20000원");

        c.add(label);
        MyItemListener listener = new MyItemListener();
        MyImageListener listener2 = new MyImageListener();
        for(int i=0; i<fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            c.add(fruits[i]);
            fruits[i].addItemListener(listener);
        }
        sumLabel = new JLabel("합계는 0원입니다");

        c.setLayout(new FlowLayout());
        c.add(sumLabel);

        la = new JLabel();

        la.setLocation(50, 50);
        la.setSize(100, 100);
        c.add(la);

        ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성

        for(int i=0; i<fruits.length; i++) {
            fruits2[i] = new JRadioButton(names[i]);
            fruits2[i].setBorderPainted(true);
            g.add(fruits2[i]);
            c.add(fruits2[i]);
            fruits2[i].addItemListener(listener2);
        }

        setSize(450,350);
        setVisible(true);
        c.requestFocus();
    }
    class MyItemListener implements ItemListener {
        int sum = 0; // 가격의 합
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(e.getItem() == fruits[0])
                    sum += 1000;
                else if(e.getItem() == fruits[1])
                    sum += 5000;
                else
                    sum += 20000;
            }
            else {
                if(e.getItem() == fruits[0])
                    sum -= 1000;
                else if(e.getItem() == fruits[1])
                    sum -= 5000;
                else
                    sum -= 20000;
            }
            sumLabel.setText("현재 " + sum + "원 입니다.");
        }
    }

    class MyImageListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(e.getItem() == fruits2[0])
                    la.setIcon(apple);
                else if(e.getItem() == fruits2[1])
                    la.setIcon(banana);
                else if(e.getItem() == fruits2[2])
                    la.setIcon(cherry);
            }
        }
    }
    public static void main(String [] args) {
        new CheckBoxEx();
    }
}