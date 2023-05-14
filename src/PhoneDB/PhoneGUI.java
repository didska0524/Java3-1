package PhoneDB;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class PhoneGUI extends JFrame {
    JLabel la = new JLabel("결과창");
    PhoneDBO pdb = new PhoneDBO();
    JTextField phoneID = new JTextField(15);
    JTextArea tf = new JTextArea();
    JTextField phoneNum = new JTextField(15);
    JButton pList = new JButton("리스트");
    JButton pAdd = new JButton("추가");
    JButton pUpdate = new JButton("수정");
    JButton pDelete = new JButton("삭제");
    JButton pEnd = new JButton("종료");
    JPanel cpane = new JPanel();
    JPanel cpane2 = new JPanel();

    public PhoneGUI() {

        setTitle("전화번호 관리");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        cpane.setLayout(new GridLayout(2, 2));

        cpane.add(new JLabel("이 름"));
        cpane.add(phoneID);
        cpane.add(new JLabel("전화번호"));
        cpane.add(phoneNum);

        BtnAction bAction = new BtnAction();
        pList.addActionListener(bAction);
        pAdd.addActionListener(bAction);
        pUpdate.addActionListener(bAction);
        pDelete.addActionListener(bAction);
        pEnd.addActionListener(bAction);

        cpane2.add(pList);
        cpane2.add(pAdd);
        cpane2.add(pUpdate);
        cpane2.add(pDelete);
        cpane2.add(pEnd);

        add(la, BorderLayout.NORTH);
        add(cpane, BorderLayout.CENTER);
        add(cpane2, BorderLayout.SOUTH);
        setVisible(true);
    }

    class BtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton b = (JButton) e.getSource();
            ArrayList<PhoneSet> list = new ArrayList();
            if (b.getText().equals("리스트")) {
                new PhoneSetList();
                setVisible(false);
            }
            if (b.getText().equals("추가")) {
                String name = phoneID.getText();
                String phone = phoneNum.getText();
                PhoneSet ephone = new PhoneSet(name, phone);
                boolean success = pdb.insertPhone(ephone);
                if (success)
                    la.setText("insert 성공");
                else
                    la.setText("insert 실패");
            }
            if (b.getText().equals("삭제")) {
                String name = phoneID.getText();
                PhoneSet ephone = new PhoneSet();
                ephone.setName(name);
                boolean success = pdb.deletePhone(ephone);
                if (success)
                    la.setText("delete 성공");
                else
                    la.setText("delete 실패");
            }
            if (b.getText().equals("수정")) {
                String name = phoneID.getText(); // 이름 받기
                String phone = phoneNum.getText(); // 전화번호 받기
                PhoneSet ephone = new PhoneSet(name, phone);
                boolean success = pdb.updatePhone(ephone);
                if (success)
                    la.setText("update 성공");
                else
                    la.setText("update 실패");
            }
            if (b.getText().equals("종료")) {
                System.exit(0);
            }
        }
    }
}
