package GameLH;

public class Main {
    public static void main(String[] args) {
        int rows = 4, cols = 4, timeLimit = 30;
        Model model = new Model(rows, cols, timeLimit);
        View view = new View(rows, cols);
        new Controller(model, view);
    }
}
