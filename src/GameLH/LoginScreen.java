package GameLH;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    private JFrame frame;
    private JTextField userText;
    private JPasswordField passText;

    public LoginScreen() {
        frame = new JFrame("Login Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Tạo một JPanel cho các ô nhập và nút.
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.YELLOW);  // Thêm màu vàng cho nền.

        JLabel userLabel = new JLabel("User:");
        JLabel passLabel = new JLabel("Password:");
        userText = new JTextField();
        passText = new JPasswordField();
        JButton loginButton = new JButton("Login");

        userLabel.setFont(new Font("Arial", Font.BOLD, 12));
        passLabel.setFont(new Font("Arial", Font.BOLD, 12));

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(new JLabel()); // Thêm khoảng trống.
        panel.add(loginButton);

        loginButton.addActionListener(new LoginListener());

        frame.add(panel, BorderLayout.CENTER);

        // Tạo tiêu đề đẹp mắt.
        JLabel title = new JLabel("Welcome to Our Game", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(title, BorderLayout.NORTH);

        // Thêm màu nền vàng cho toàn bộ màn hình đăng nhập.
        frame.getContentPane().setBackground(Color.YELLOW);

        // Căn chỉnh màn hình chính ở trung tâm của màn hình máy tính.
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = userText.getText();
            String password = new String(passText.getPassword());

            if ("user".equals(user) && "1".equals(password)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                frame.dispose(); // Đóng cửa sổ đăng nhập
                Main.main(null); // Gọi phương thức main của lớp Main
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password");
            }
        }
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}


