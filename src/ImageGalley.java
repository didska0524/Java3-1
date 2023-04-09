import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
//배열을 이용해서 코드 간결화 예정, 코드의 효율성 확보
public class ImageGalley extends JFrame {
    ImageIcon im0 = new ImageIcon("images/image0.jpg");
    ImageIcon im1 = new ImageIcon("images/image1.jpg");
    ImageIcon im2 = new ImageIcon("images/image2.jpg");
    ImageIcon im3 = new ImageIcon("images/image3.jpg");

    JLabel imgLabel = new JLabel(im0);

    ImageIcon left = new ImageIcon("images/left.png"); // 버튼에 들어갈 이미지
    ImageIcon right = new ImageIcon("images/right.png");

    JButton btn1 = new JButton(left);
    JButton btn2 = new JButton(right);

    ImageGalley() {
        setTitle("Menu에 Action 리스너 만들기 예제");
        setSize(350,600);

        JPanel cpane = new JPanel();
        cpane.setLayout(new GridLayout(1,1));

        JPanel cpane2 = new JPanel(); 

        setLocationRelativeTo(null); // 결과창 가운데로 오도록 설정

        cpane.add(imgLabel); // 이미지라벨은 cpane에 바로 배치
        cpane2.add(btn1,BorderLayout.EAST); // 왼쪽화살표 버튼을 cpane2에 왼쪽에 배치
        cpane2.add(btn2,BorderLayout.WEST); // 오른쪽화살표 버튼을 cpane2에 오른쪽에 배치

        btn1.addActionListener(new MyListener()); // 왼쪽화살표 버튼을 리스너에 연결
        btn2.addActionListener(new MyListener()); // 오른쪽화살표 버튼을 리스너에 연결

        add(cpane,BorderLayout.CENTER); // cpane과 capne2 자체를 중앙과 아래쪽에 배치
        add(cpane2,BorderLayout.SOUTH);

        setVisible(true); // 결과가 보이도록 설정
    }
    public static void main(String [] args) {
        new ImageGalley();
    }
    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JButton b = (JButton)e.getSource();
            if (b == btn1) { // 왼쪽화살표 버튼
                if(imgLabel.getIcon() ==  im0) {
                    imgLabel.setIcon(im3);
                }
                else if(imgLabel.getIcon() ==  im3) {
                    imgLabel.setIcon(im2);
                }
                else if(imgLabel.getIcon() ==  im2) {
                    imgLabel.setIcon(im1);
                }
                else {
                    imgLabel.setIcon(im0);
                }
            }
            if (b == btn2) { // 왼쪽화살표 버튼
                if(imgLabel.getIcon() ==  im0) {
                    imgLabel.setIcon(im1);
                }
                else if(imgLabel.getIcon() ==  im1) {
                    imgLabel.setIcon(im2);
                }
                else if(imgLabel.getIcon() ==  im2) {
                    imgLabel.setIcon(im3);
                }
                else {
                    imgLabel.setIcon(im0);
                }
            }
        }
    }
}