package GameLH;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;
    private Timer timer;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Thêm sự kiện cho các nút
        for (int i = 0; i < model.rows; i++) {
            for (int j = 0; j < model.cols; j++) {
                int x = i, y = j;
                view.buttons[i][j].addActionListener(e -> handleButtonClick(x, y));
            }
        }

        // Đếm ngược thời gian và hiển thị dạng mm:ss
        timer = new Timer(1000, e -> {
            model.timeLeft--;
            int minutes = model.timeLeft / 60;
            int seconds = model.timeLeft % 60;
            view.timeLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));

            if (model.timeLeft <= 0) {
                timer.stop();
                gameOver();
            }
        });
        timer.start();
    }

    private void handleButtonClick(int x, int y) {
        if (model.isGameOver || model.revealed[x][y]) return;

        // Hiển thị hình ảnh khi lật
        view.updateButtonIcon(view.buttons[x][y], model.board[x][y]);
        model.revealed[x][y] = true;

        if (model.firstX == -1) {
            model.firstX = x;
            model.firstY = y;
        } else {
            int fx = model.firstX, fy = model.firstY;
            if (model.board[fx][fy].equals(model.board[x][y])) {
                model.score += 10;
                view.scoreLabel.setText("Score: " + model.score);
                // Kiểm tra nếu người chơi đã thắng
                if (model.isGameFinished()) {
                    timer.stop(); // Dừng đồng hồ
                    model.isGameOver = true;
                    view.showWinMessage(model.score); // Truyền điểm số từ model khi thắng
                    System.exit(0);
                }
            } else {
                Timer hideTimer = new Timer(500, e -> {
                    view.hideButtonIcon(view.buttons[fx][fy]);
                    view.hideButtonIcon(view.buttons[x][y]);
                    model.revealed[fx][fy] = false;
                    model.revealed[x][y] = false;
                });
                hideTimer.setRepeats(false);
                hideTimer.start();
            }
            model.firstX = -1;
            model.firstY = -1;
        }
    }

    private void gameOver() {
        if (model.isGameOver == false)  {
            view.showGameOverMessage(model.score);  // Truyền điểm số từ model
            System.exit(0);
        } else {
            view.showWinMessage(model.score); // Truyền điểm số từ model khi thắng
            System.exit(0);
        }
    }
}
