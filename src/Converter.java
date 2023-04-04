import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter extends JFrame {
    JLabel jlaF, jlaC, jre;
    JTextField jTeF, jTeC;
    //JButton jbt, jbt2;
    public Converter() {
        setTitle("온도변환기"); // 프레임의 타이틀 달기
        setSize(280, 150); // 프레임 크기 280x150 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); // 컨텐트팬 알아내기
        contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
        contentPane.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout


        jlaF=new JLabel("화씨온도(F)");
        jlaC=new JLabel("섭씨온도(C)");
        jre = new JLabel("출력값");
        jTeF=new JTextField(14);
        jTeC=new JTextField(14);
        JButton jbt = new JButton("화씨를 섭씨로 변환");
        JButton jbt2=new JButton("섭씨를 화씨로 변환");
        jbt.addActionListener(new ConverterListener());
        jbt2.addActionListener(new ConverterListener());

        contentPane.add(jlaF);
        contentPane.add(jTeF);

        contentPane.add(jlaC);
        contentPane.add(jTeC);

        contentPane.add(jbt);
        contentPane.add(jbt2);

        contentPane.add(jre);

        this.pack(); // pack()는 기본 사이즈 지정   this.pack()은 내가 설정한 사이즈를 받음
        setVisible(true); // 화면에 프레임 출력
    }

    class ConverterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jbt = (JButton)e.getSource();
            JButton jbt2 = (JButton)e.getSource();
                if (jbt2.getText().equals("섭씨를 화씨로 변환")) {
                    double c = Double.parseDouble(jTeC.getText());
                    double f = (c * 1.8) + 32;
                    jre.setText(String.format("%7.2f", f));
                    jbt2.setText("완료");
                }
                else if (jbt2.getText().equals("완료")) {
                    jre.setText("출력값");
                    jbt2.setText("섭씨를 화씨로 변환");
                }
                if (jbt.getText().equals("화씨를 섭씨로 변환")) {
                    double f = Double.parseDouble(jTeF.getText());
                    double c = (f - 32) / 1.8;
                    jre.setText(String.format("%7.2f", c));
                    jbt.setText("완료");
                }
                else if (jbt.getText().equals("완료")) {
                    jre.setText("출력값");
                    jbt.setText("화씨를 섭씨로 변환");
                }
                else {
                    jre.setText("오류");
                }
            }
        }


    public static void main(String[] args) {
        new Converter();
    }
}