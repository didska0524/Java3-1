package thread0522;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class PhoneGUI extends JFrame {
    JTextField name = new JTextField(25);
    JTextField num = new JTextField(25);
    JButton add = new JButton("첨가");
    JButton close = new JButton("종료");

    JLabel la = new JLabel("결과안내");

    JPanel cpane = new JPanel();
    JPanel cpane2 = new JPanel();

    public static void main(String[] args) {
        new PhoneGUI();
    }

    public PhoneGUI() {

        setTitle("전화번호 관리");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        cpane.setLayout(new GridLayout(2, 2));

        cpane.add(new JLabel("이 름"));
        cpane.add(name);
        cpane.add(new JLabel("전화번호"));
        cpane.add(num);

        BtnAction bAction = new BtnAction();
        add.addActionListener(bAction);
        close.addActionListener(bAction);

        cpane2.add(add);
        cpane2.add(close);

        add(la, BorderLayout.NORTH);
        add(cpane, BorderLayout.CENTER);
        add(cpane2, BorderLayout.SOUTH);
        setVisible(true);
    }

    class BtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton b = (JButton) e.getSource();
            try {
                FileWriter fout = new FileWriter("C:\\Phone\\phone.txt", true);
                if (b.getText().equals("첨가")) {
                    String InputName = name.getText();
                    String InputNum = num.getText();

                    // name, num 이 공백인지 확인
                    if (InputName.isEmpty() || InputNum.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "이름과 전화번호를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String [] InputSet = {InputName, InputNum};

                    fout.write(String.join(", ", InputSet));
                    fout.write("\n");
                    fout.flush();

                    name.setText("");
                    num.setText("");
                    la.setText(InputName + "님의 정보가 정상적으로 입력되었습니다. ");
                }
                if (b.getText().equals("종료")) {
                    fout.close();
                    System.exit(0);
                }
            } catch (IOException ex) {
                System.out.println("입출력 오류");
            }
        }
    }
}
