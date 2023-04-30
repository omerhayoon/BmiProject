import javax.swing.*;

public class Window extends JFrame {
    private final int WIDTH = 700;
    private final int HEIGHT = 500;
    MainScreen mainScreen = new MainScreen();


    public Window() { //בנאי לחלון
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // פעולה לכפתור האיקס
        this.setTitle("BMI calculate");
        this.setResizable(false); //לאפשר שינוי גודל חלון
        this.setSize(WIDTH, HEIGHT); //הגדרת גודל החלון
        this.setLocationRelativeTo(null);
        this.add(mainScreen);
        this.setVisible(true); // הגדרת נראות חלון
    }
}
