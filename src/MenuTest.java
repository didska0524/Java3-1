import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuTest extends JFrame {
    JLabel imgLabel = new JLabel(); // 빈 레이블

    MenuTest() {
        setTitle("Menu에 Action 리스너 만들기 예제");
        createMenu();
        getContentPane().add(imgLabel, BorderLayout.CENTER);
        setSize(250,200); setVisible(true);
    }

    void createMenu() {
        JMenuBar mb = new JMenuBar(); // 메뉴바 생성
        //JMenuBar mb2 = new JMenuBar();
        JMenuItem [] menuItem = new JMenuItem [4];
        JMenuItem [] menuColor = new JMenuItem [4];

        String[] itemTitle = {"Apple", "Banana", "Mango", "Exit"};
        JMenu screenMenu = new JMenu("Image");

        String[] ColorTitle = {"Red", "Green", "Blue", "Exit"};
        JMenu screenMenu2 = new JMenu("Color");

        MenuActionListener listener = new MenuActionListener();
        MenuActionListener2 listener2 = new MenuActionListener2();

        for(int i=0; i<menuItem.length; i++) {
            menuItem[i] = new JMenuItem(itemTitle[i]);
            menuItem[i].addActionListener(listener);
            screenMenu.add(menuItem[i]);
        }
        mb.add(screenMenu);

        for(int i=0; i<menuColor.length; i++) {
            menuColor[i] = new JMenuItem(ColorTitle[i]);
            menuColor[i].addActionListener(listener2);
            screenMenu2.add(menuColor[i]);
        }
        mb.add(screenMenu2);
        setJMenuBar(mb); // 메뉴바를 프레임에 부착

    }
    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch(cmd) { // 메뉴 아이템의 종류 구분
                case "Apple" :
                    imgLabel.setIcon(new
                            ImageIcon("images/apple.jpg"));
                    break;
                case "Banana" :
                    imgLabel.setIcon(new
                            ImageIcon("images/banana.jpg"));
                    break;
                case "Mango" :
                    imgLabel.setIcon(new
                            ImageIcon("images/mango.jpg"));
                    break;
                case "Exit" :
                    System.exit(0); break;
            }
        }
    }
    class MenuActionListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch(cmd) { // 메뉴 아이템의 종류 구분
                case "Red" :
                    getContentPane().setBackground(Color.RED);
                    break;
                case "Green" :
                    getContentPane().setBackground(Color.green);
                    break;
                case "Blue" :
                    getContentPane().setBackground(Color.BLUE);
                    break;
                case "Exit" :
                    System.exit(0); break;
            }
        }
    }

    public static void main(String [] args) {
        new MenuTest();
    }
}