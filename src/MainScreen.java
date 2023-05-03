import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;

public class MainScreen extends JLabel {
    private final JSlider slider = new JSlider(140, 190, 165);
    private final String[] bodySize = {"Small", "Medium", "Large"};
    private final String[] genderBox = {"Male", "Female"};
    private final JComboBox maleOrFemale;
    private final JTextField nameField;
    private final JComboBox bodyFrameBox;
    private final JTextField ageField;
    private final JTextField actualWeightField;
    private final JLabel currentHeight;
    private final int MAX_AGE = 120;
    private final int MIN_AGE = 1;
    private final int MAX_WEIGHT = 300;
    private final int MIN_WEIGHT = 1;
    private float value;
    private double bmiAfterCalculate;
    private double bmi;
    private Image background;


    public MainScreen() {
        addBackgroundPicture();
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

        currentHeight = new JLabel("Height :" + slider.getValue() + " cm");
        currentHeight.setBounds(470, 320, 150, 25);
        currentHeight.setForeground(Color.RED);
        currentHeight.setFont(new Font("MV BoLi", Font.PLAIN, 20));
        this.add(currentHeight);
        currentHeight.setVisible(true);


        JLabel height = new JLabel("Height");
        height.setBounds(500, 10, 70, 20);
        height.setForeground(Color.RED);
        height.setFont(new Font("MV BoLi", Font.PLAIN, 20));
        this.add(height);
        height.setVisible(true);

        JLabel personalData = new JLabel("Personal data :");
        personalData.setBounds(40, 10, 150, 20);
        personalData.setForeground(Color.RED);
        personalData.setFont(new Font("MV BoLi", Font.PLAIN, 20));
        this.add(personalData);
        personalData.setVisible(true);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(10, 40, 100, 20);
        nameLabel.setForeground(Color.BLACK);
        this.add(nameLabel);
        nameLabel.setVisible(true);

        nameField = new JTextField("");
        nameField.setBounds(100, 40, 70, 20);
        this.add(nameField);
        nameField.setVisible(true);
        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    String nameFieldText = nameField.getText();
                    if (!nameFieldText.matches("[a-zA-Z\\s\\-]*")) {
                        nameField.setText("");
                    }
                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                    nameField.setText("");
                }
            }
        });
        JLabel lastName = new JLabel("Last name :");
        lastName.setBounds(10, 70, 100, 20);
        lastName.setForeground(Color.BLACK);
        this.add(lastName);
        lastName.setVisible(true);

        JTextField lastNameField = new JTextField("");
        lastNameField.setBounds(100, 70, 70, 20);
        this.add(lastNameField);
        lastNameField.setVisible(true);
        lastNameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    String lastNameFieldText = lastNameField.getText();
                    if (!lastNameFieldText.matches("[a-zA-Z\\s\\-]*")) {
                        lastNameField.setText("");
                    }
                } catch (Exception exception) {
                    System.out.println("Please enter a valid number");
                    lastNameField.setText("");
                }
            }
        });

        JLabel ageLabel = new JLabel("Age :");
        ageLabel.setBounds(10, 100, 100, 20);
        ageLabel.setForeground(Color.BLACK);
        this.add(ageLabel);
        ageLabel.setVisible(true);

        ageField = new JTextField("");
        ageField.setBounds(100, 100, 70, 20);
        this.add(ageField);
        ageField.setVisible(true);
        ageField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(ageField.getText());
                    if (value > MAX_AGE || value < MIN_AGE) {
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
        gender.setBounds(50, 200, 100, 50);
        gender.setForeground(Color.RED);
        gender.setFont(new Font("MV BoLi", Font.PLAIN, 20));
        this.add(gender);
        gender.setVisible(true);

        maleOrFemale = new JComboBox(genderBox);
        maleOrFemale.setBounds(50, 250, 100, 20);
        this.add(maleOrFemale);
        maleOrFemale.setVisible(true);
        maleOrFemale.addActionListener(this::actionPerformed);

        JLabel bodyFrame = new JLabel("body size :");
        bodyFrame.setBounds(50, 300, 150, 50);
        bodyFrame.setForeground(Color.RED);
        bodyFrame.setFont(new Font("MV BoLi", Font.PLAIN, 20));

        this.add(bodyFrame);
        bodyFrame.setVisible(true);

        bodyFrameBox = new JComboBox(bodySize);
        bodyFrameBox.setBounds(50, 350, 100, 20);
        this.add(bodyFrameBox);
        bodyFrameBox.setVisible(true);
        bodyFrameBox.addActionListener(this::actionPerformed);

        JLabel actualWeight = new JLabel("Actual weight :");
        actualWeight.setBounds(10, 130, 100, 20);
        actualWeight.setForeground(Color.BLACK);
        this.add(actualWeight);
        actualWeight.setVisible(true);

        actualWeightField = new JTextField("");
        actualWeightField.setBounds(100, 130, 70, 20);
        this.add(actualWeightField);
        actualWeightField.setVisible(true);

        JLabel by = new JLabel("@By Avihay Navon, David Even-Haim, Omer Hayoon, Avihay Ben-Ami, AAC-CS 2023");
        by.setBounds(3, 430, 800, 40);
        by.setFont(new Font("Arial", Font.BOLD, 12));
        by.setVisible(true);
        by.setForeground(Color.BLACK);
        this.add(by);
        actualWeightField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    value = Float.parseFloat(actualWeightField.getText());
                    if (value < MIN_WEIGHT || value > MAX_WEIGHT) {
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
        JButton print = new JButton("Print BMI");
        print.setFont(new Font("MV BoLi", Font.PLAIN, 15));
        print.setBounds(500, 400, 120, 50);
        print.setForeground(Color.BLACK);
        this.add(print);
        print.setVisible(true);
        new Thread(() -> {
            while (true) {
                if (isEmpty(nameField.getText()) || isEmpty(lastNameField.getText()) || isEmpty(ageField.getText()) || isEmpty(actualWeightField.getText())) {
                    print.setEnabled(false);
                } else {
                    print.setEnabled(true);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        print.addActionListener(e -> {
            bmiAfterCalculate = bmiCalculate(actualWeightField.getText());
            JOptionPane.showMessageDialog(null, "name: " + nameField.getText() + " " + lastNameField.getText() + "\n"
                            + "age: " + ageField.getText() + "\n"
                            + "height: " + slider.getValue() + " cm" + "\n"
                            + "your BMI is: " + bmiAfterCalculate + "\n" + "your BMI is in " + weightStatus(bmiAfterCalculate) + " range." + "\n"
                            + "your actual weight is: " + actualWeightField.getText() + " kg" + "\n"
                            + "your ideal weight is: " + idealWeightCalculate() + " kg", "BMI calculate",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
    //jh

    public boolean isEmpty(String text) {
        if (text.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public void addBackgroundPicture() {
        try {
            background = ImageIO.read(Objects.requireNonNull(getClass().getResource("תמונה1.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public double bmiCalculate(String weight) {
        double height = slider.getValue() * 0.01;
        bmi = (Integer.parseInt(weight)) / (height * height);

        String temp = Double.toString(bmi);
        temp = temp.substring(0, 4);
        bmi = Double.parseDouble(temp);
        return bmi;
    }

    public void stateChanged(ChangeEvent event) {
        currentHeight.setText("height :" + slider.getValue() + " cm");
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bodyFrameBox) {
            bodyFrameBox.getSelectedItem();
        }
        if (event.getSource() == maleOrFemale) {
            maleOrFemale.getSelectedItem();
        }
    }

    public String weightStatus(double bmi) {
        String result = "";
        if (bmi < 15) {
            result = "Anorexic";
        }
        if (bmi >= 15 && bmi < 18.5) {
            result = "Underweight";
        }
        if (bmi >= 18.5 && bmi < 24.9) {
            result = "Normal";
        }
        if (bmi >= 24.9 && bmi < 29.9) {
            result = "Overweight";
        }
        if (bmi >= 29.9 && bmi < 35) {
            result = "Obese";
        }
        if (bmi >= 35) {
            result = "Extreme Obese";
        }
        return result;
    }

    public double idealWeightCalculate() {
        double idealWeight = 0;
        int height = slider.getValue();
        float age = Integer.parseInt(ageField.getText());
        idealWeight = (height - 100 + (age / 10)) * 0.9 * slimness();
        String temp = Double.toString(idealWeight);
        temp = temp.substring(0, 5);
        idealWeight = Double.parseDouble(temp);
        return idealWeight;
    }

    public double slimness() {
        double result = 0.9;
        if (bodyFrameBox.getSelectedItem() == "Medium") {
            result = 1;
        }
        if (bodyFrameBox.getSelectedItem() == "Large") {
            result = 1.1;
        }
        return result;
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}




