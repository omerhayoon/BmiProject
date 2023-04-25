import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutionException;

public class MainScreen extends JLabel {
    private float value;
    double sliderAfterCalculate;
    double bmi;


    JSlider slider = new JSlider(140, 190, 165);
    JLabel currentHeight;

    public MainScreen() {
        slider.setFont(new Font("MV BoLi", Font.PLAIN, 15));
        slider.setOrientation(JSlider.VERTICAL);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(500, 50, 70, 250);
        this.add(slider);
        slider.setVisible(true);
        slider.addChangeListener(this::stateChanged);

        currentHeight = new JLabel("height :" + slider.getValue() + " sm");
        currentHeight.setBounds(500, 320, 150, 20);
        currentHeight.setForeground(Color.BLACK);
        this.add(currentHeight);
        currentHeight.setVisible(true);

        JButton print = new JButton("Print");
        print.setFont(new Font("MV BoLi", Font.PLAIN, 15));
        print.setBounds(500, 400, 100, 50);
        print.setForeground(Color.BLACK);
        this.add(print);
        print.setVisible(true);


        JLabel height = new JLabel("Height");
        height.setBounds(500, 10, 50, 20);
        height.setForeground(Color.BLACK);
        this.add(height);
        height.setVisible(true);


        JLabel personalData = new JLabel("Personal data :");
        personalData.setBounds(40, 10, 100, 20);
        personalData.setForeground(Color.black);
        this.add(personalData);
        personalData.setVisible(true);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 40, 100, 20);
        nameLabel.setForeground(Color.black);
        this.add(nameLabel);
        nameLabel.setVisible(true);

        JTextField nameField = new JTextField("");
        nameField.setBounds(100, 40, 70, 20);
        nameField.setForeground(Color.BLACK);
        this.add(nameField);
        nameField.setVisible(true);

        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    String nameFieldText = nameField.getText();
                    if (!nameFieldText.matches("[a-zA-Z]+")) {
                        nameField.setText("");
                    }
                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                    nameField.setText("");
                }
            }
        });


        JLabel lastName = new JLabel("Last name");
        lastName.setBounds(10, 70, 100, 20);
        lastName.setForeground(Color.black);
        this.add(lastName);
        lastName.setVisible(true);

        JTextField lastNameField = new JTextField("");
        lastNameField.setBounds(100, 70, 70, 20);
        lastNameField.setForeground(Color.BLACK);
        this.add(lastNameField);
        lastNameField.setVisible(true);
        lastNameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    String lastNameFieldText = lastNameField.getText();
                    if (!lastNameFieldText.matches("[a-zA-Z]+")) {
                        lastNameField.setText("");
                    }
                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                    lastNameField.setText("");
                }
            }
        });

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 100, 100, 20);
        ageLabel.setForeground(Color.black);
        this.add(ageLabel);
        ageLabel.setVisible(true);

        JTextField ageField = new JTextField("");
        ageField.setBounds(100, 100, 70, 20);
        ageField.setForeground(Color.BLACK);
        this.add(ageField);
        ageField.setVisible(true);
        ageField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(ageField.getText());
                    if (value > 120) {
                        ageField.setText("");
                        JOptionPane.showMessageDialog(null, "Max age is 120, Min age is 1 ", "Wrong Value",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    ageField.setText("");
                }
            }
        });


        JLabel gender = new JLabel("Gender :");
        gender.setBounds(50, 200, 50, 50);
        gender.setForeground(Color.BLACK);
        this.add(gender);
        gender.setVisible(true);

        JComboBox maleOrFemale = new JComboBox();
        maleOrFemale.addItem("Male");
        maleOrFemale.addItem("Female");
        maleOrFemale.setBounds(50, 250, 100, 20);
        this.add(maleOrFemale);
        maleOrFemale.setVisible(true);

        JLabel bodyFrame = new JLabel("body-frame :");
        bodyFrame.setBounds(50, 300, 100, 50);
        bodyFrame.setForeground(Color.BLACK);
        this.add(bodyFrame);
        bodyFrame.setVisible(true);

        JComboBox bodyFrameBox = new JComboBox();
        bodyFrameBox.addItem("Small");
        bodyFrameBox.addItem("Medium");
        bodyFrameBox.addItem("Large");
        bodyFrameBox.setBounds(50, 350, 100, 20);
        this.add(bodyFrameBox);
        bodyFrameBox.setVisible(true);

        JLabel actualWeight = new JLabel("actual weight");
        actualWeight.setBounds(10, 130, 100, 20);
        actualWeight.setForeground(Color.BLACK);
        this.add(actualWeight);
        actualWeight.setVisible(true);

        JTextField actualWeightField = new JTextField("");
        actualWeightField.setBounds(100, 130, 70, 20);
        actualWeightField.setForeground(Color.BLACK);
        this.add(actualWeightField);
        actualWeightField.setVisible(true);
        actualWeightField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(actualWeightField.getText());
                    if (value < 1 || value > 300) {
                        actualWeightField.setText("");
                        JOptionPane.showMessageDialog(null, "Max weight is 300, Min weight is 1 ", "Wrong Value",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    actualWeightField.setText("");
                }
            }
        });
//        double newHeight=(slider.getValue()*0.01)*(slider.getValue()*0/01);
//        String newWeight=actualWeightField.getText();


        print.addActionListener(e -> {
            try {
                if (nameField.getText() != null && lastNameField.getText() != null && ageField.getText() != null && actualWeightField.getText() != null) {
                    sliderAfterCalculate = slider.getValue() * 0.01;
                    bmi = (Integer.parseInt(actualWeightField.getText())) / (sliderAfterCalculate * sliderAfterCalculate);
                    System.out.println("BMI is: " + bmi);
                    JOptionPane.showMessageDialog(null, "name: " + nameField.getText() + "\n"
                                    + "last name: " + lastNameField.getText() + "\n" + "age: " + ageField.getText() + "\n" + "height is: " + slider.getValue(), "BMI calculate",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (Exception exception){
                JOptionPane.showMessageDialog(null, "all fields must be filled in", "Error Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    public void stateChanged(ChangeEvent event) {
        currentHeight.setText("height :" + slider.getValue() + " sm");

    }
}



