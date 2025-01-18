package GameLH;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Model {
    public Icon[][] board; // Ma trận chứa hình ảnh
    public boolean[][] revealed; // Trạng thái lật của các ô
    public int rows, cols; // Kích thước bảng
    public int score; // Điểm số người chơi
    public int timeLeft; // Thời gian còn lại (giây)
    public int firstX = -1, firstY = -1; // Vị trí ô đầu tiên được lật
    public boolean isGameOver = false; // Trạng thái kết thúc trò chơi

    public Model(int rows, int cols, int timeLimit) {
        this.rows = rows;
        this.cols = cols;
        this.timeLeft = timeLimit;
        this.score = 0;
        this.board = new Icon[rows][cols];
        this.revealed = new boolean[rows][cols];

        generateBoard(); // Sinh ma trận hình ảnh ngẫu nhiên
    }

    private void generateBoard() {
        int totalIcons = (rows * cols) / 2;  // Tổng số cặp hình cần
        ArrayList<Icon> icons = new ArrayList<>();

        // Tạo danh sách các hình ảnh
        for (int i = 1; i <= totalIcons; i++) {
            Icon icon = loadImage("/GameLH/Icon/abstract_image_0" + i + ".png");
            if (icon != null) {
                icons.add(icon);
                icons.add(icon); // Mỗi hình thêm 2 lần (cặp)
            }
        }

        // Xáo trộn danh sách các icon
        Collections.shuffle(icons);

        // Gán hình ảnh vào bảng
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = icons.get(index++);
            }
        }
    }

    private Icon loadImage(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Không tìm thấy hình ảnh: " + path);
            return null;
        }
    }
    // Kiểm tra nếu trò chơi đã kết thúc (tất cả các cặp đã lật đúng)
    public boolean isGameFinished() {
        // Tổng số cặp bài đúng (tính số điểm tối đa)
        int totalPairs = (rows * cols) / 2;
        int maxScore = totalPairs * 10;  // Mỗi cặp đúng sẽ cộng 10 điểm

        // Kiểm tra nếu điểm số hiện tại đã đạt tối đa
        return this.score == maxScore;
    }
}
