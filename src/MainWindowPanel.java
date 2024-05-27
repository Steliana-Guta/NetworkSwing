import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainWindowPanel extends JPanel implements ActionListener {
    private JLabel resultLabel;
    private JTextField searchBox;
    private JButton searchButton;

    public MainWindowPanel() {
        super();

        setLayout(null);

        setupLabelHostName();
        setupTextFieldHostName();
        setupButton();
        setupLabelResult();
    }

    private void setupLabelHostName() {
        JLabel label = new JLabel("Hostname");
        label.setBounds(100,100,200,35);

        add(label);

    }

    private void setupTextFieldHostName () {
        searchBox = new JTextField();
        searchBox.setBounds(200, 100, 220, 35);

        add(searchBox);
    }

    private void setupButton() {
        searchButton = new JButton();
        searchButton.setBounds(125, 200, 220,35);

        searchButton.addActionListener(this);
        searchButton.setText("Get Address");
        add(searchButton);
    }

    private void setupLabelResult () {
        resultLabel = new JLabel("Type a hostname and click Search Button");
        resultLabel.setBounds(100,150, 440,35);

        add(resultLabel);

    }

    private void doSearch() {
        InetAddress host = null;
        resultLabel.setText("Looking up this computer's address...");

        try {
            host = InetAddress.getLocalHost();

            resultLabel.setText(
                    String.format("Address: %s" +
                            "   Hostname: %s", host.getHostAddress(), host.getHostName()));


        }
        catch (UnknownHostException e) {
            System.out.println("Unable to resolve name and address");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton) {
            doSearch();
        }
    }
}
