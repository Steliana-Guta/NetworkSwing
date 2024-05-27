import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        super ("Hostname Lookup");

        Container con = getContentPane();
        con.add(new MainWindowPanel());
        setBounds(300,300,500,500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
