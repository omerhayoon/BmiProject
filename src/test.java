import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {

    private JLabel heightLabel, weightLabel, bmiLabel;
    private JTextField heightField, weightField, bmiField;
    private JButton calculateButton, clearButton;
    private JCheckBox metricCheckbox;

    public test() {
        // Set the title and size of the frame
        setTitle("BMI Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the labels and fields for height, weight, and BMI
        heightLabel = new JLabel("Height (cm): ");
        weightLabel = new JLabel("Weight (kg): ");
        bmiLabel = new JLabel("BMI: ");
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        bmiField = new JTextField(10);
        bmiField.setEditable(false);

        // Create the Calculate and Clear buttons
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        // Create the Metric checkbox
        metricCheckbox = new JCheckBox("Use metric system");
        metricCheckbox.addActionListener(this);

        // Add the components to the frame
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(heightLabel, gbc);
        gbc.gridy++;
        panel.add(weightLabel, gbc);
        gbc.gridy++;
        panel.add(bmiLabel, gbc);
        gbc.gridx++;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(heightField, gbc);
        gbc.gridy++;
        panel.add(weightField, gbc);
        gbc.gridy++;
        panel.add(bmiField, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(calculateButton, gbc);
        gbc.gridy++;
        panel.add(clearButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(metricCheckbox, gbc);
        add(panel);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double bmi;

            if (metricCheckbox.isSelected()) {
                // Use metric units
                bmi = weight / (height / 100 * height / 100);
            } else {
                // Use imperial units
                bmi = weight / (height * height) * 703;
            }

            bmiField.setText(String.format("%.2f", bmi));
        } else if (e.getSource() == clearButton) {
            heightField.setText("");
            weightField.setText("");
            bmiField.setText("");
        }
    }
}

