import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
//성명 , 전화번호 = 텍스트필드
//학과 = 콤보박스
//출력내용 = 텍스트아리아

public class PhoneBook extends JFrame {
    JTextArea ta;
    //JTextField tf;
    JTextField [] tf = new JTextField[3];
    JComboBox cb;
    String [] department = {"소프트웨어공학과", "전기전자공학과", "간호학과"};

    PhoneBook() {
        setTitle("텍스트필드 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel c = new JPanel();
        c.setLayout(new GridLayout(3,2));
        JPanel c2 = new JPanel();
        c2.setLayout(new GridLayout());

        for(int i=0; i<tf.length; i++) {
            tf[i] = new JTextField("",20);
            tf[i].addActionListener(e -> {
                JTextField t = (JTextField) e.getSource();
                ta.append(t.getText() + "\n");
                t.setText("");
            });
        }

        c.add(new JLabel("이름 "));
        c.add(tf[0]);

        c.add(new JLabel("TEL "));
        c.add(tf[1]);

        c.add(new JLabel("학과 "));
        cb = new JComboBox(department);
        c.add(cb);
        cb.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            int index = cb.getSelectedIndex();
            ta.append(department[index] + "\n");
        });



        ta = new JTextArea("", 7, 20);
        c2.add(new JScrollPane(ta));


        setSize(300,300);
        add(c,BorderLayout.CENTER);
        add(c2,BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String [] args) {
        new PhoneBook();
    }
}