import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGrid extends JFrame {
    JLabel id,pass;
    JTextField idt, pst, mas;

    JButton bt,bt2;

    public LoginGrid() {
        setTitle("로그인화면"); // 프레임의 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        //contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        JPanel contentPane3 = new JPanel();
        contentPane3.setLayout(new GridLayout(1,1));

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2,2)); // 컨텐트팬에 FlowLayout
        // 	배치관리자 달기
        //Container contentPane2 = getContentPane();
        JPanel contentPane2 = new JPanel();
        contentPane2.setLayout(new FlowLayout());

        id=new JLabel("ID");
        pass=new JLabel("PASSWORD");
        idt=new JTextField(14);
        pst=new JPasswordField(14);

        bt= new JButton("확인");
        bt2=new JButton("취소");

        bt.addActionListener(new LoginListener());
        bt2.addActionListener(new LoginListener());
        mas = new JTextField(14);
        mas.setEditable(false);

        contentPane3.add(mas);
        contentPane.add(id);
        contentPane.add(idt);

        contentPane.add(pass);
        contentPane.add(pst);

        contentPane2.add(bt);//,BorderLayout.EAST);
        contentPane2.add(bt2);//,BorderLayout.WEST);
        //contentPane.add(jre);

        setSize(250,150); // 프레임 크기 300x150 설정
        add(contentPane,BorderLayout.CENTER);
        add(contentPane2,BorderLayout.SOUTH);
        add(contentPane3,BorderLayout.NORTH);
        setVisible(true); // 화면에 프레임 출력
    }
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton)e.getSource();
            if(bt.getText().equals("확인")) {
                if (idt.getText().equals("seoil") && pst.getText().equals("1234")) {
                    mas.setText("로그인성공!!");
                }
                else{
                    mas.setText("로그인실패!!");
                }
            }
            else if(bt2.getText().equals("취소")){
                idt.setText("");
                pst.setText("");
            }
        }
    }


    public static void main(String[] args) {
        new LoginGrid();
    }
}