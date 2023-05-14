package PhoneDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class PhoneSetList extends JFrame {
    PhoneDBO pdb = new PhoneDBO();
    JTextArea ta = new JTextArea(20,20);
    JPanel jp = new JPanel();
    JButton b = new JButton("확인");
    public PhoneSetList(){
        setTitle("리스트");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        ta.setSize(100,100);
        ArrayList<PhoneSet> list = pdb.phoneList();
        jp.setLayout(new FlowLayout());
        jp.add(b); // 버튼 추가
        PhoneSet pm;
        for(int i=0;i<list.size();i++){
            pm = list.get(i);
            ta.append(pm.getName()+"  "+pm.getPhone()+"\n");

        }

        jp.add(ta);


        add(jp);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                if(btn.getText().equals("확인"))
                    new PhoneGUI();
                setVisible(false);

            }
        });
        setVisible(true);


    }
    public static void main(String[] args) {
        new PhoneSetList();
    }
}

