package GameLH;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public JButton[][] buttons; // Các nút lật hình
    public JLabel scoreLabel;   // Hiển thị điểm số
    public JLabel timeLabel;    // Hiển thị thời gian

    public View(int rows, int cols) {
        setTitle("Game Lật Hình");
        setLayout(null);
        setSize(cols * 100 + 50, rows * 100 + 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buttons = new JButton[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBounds(25 + j * 100, 50 + i * 100, 90, 90);
                buttons[i][j].setIcon(new ImageIcon(getClass().getResource("/GameLH/Icon/icon000.jpg"))); // Hình mặc định
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                add(buttons[i][j]);
            }
        }

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(25, rows * 100 + 60, 200, 30);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(scoreLabel);

        timeLabel = new JLabel("Time: 00:30");
        timeLabel.setBounds(cols * 100 - 100, 10, 100, 30);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(timeLabel);

        setVisible(true);
    }

    // Cập nhật nút để hiển thị hình ảnh khi lật
    public void updateButtonIcon(JButton button, Icon icon) {
        button.setIcon(icon);
    }

    // Ẩn hình ảnh của nút khi không trùng
    public void hideButtonIcon(JButton button) {
        button.setIcon(new ImageIcon(getClass().getResource("/GameLH/Icon/icon000.jpg"))); // Hình mặc định
    }
    // Hiển thị thông báo "You Win!" khi người chơi thắng
    public void showWinMessage(int score) {
        JOptionPane.showMessageDialog(this, "You Win! Congratulations!\nYour Score: " + score);
    }

    // Hiển thị thông báo "Game Over" khi hết thời gian
    public void showGameOverMessage(int score) {
        JOptionPane.showMessageDialog(this, "Game Over!\nYour Score: " + score);
    }
}
