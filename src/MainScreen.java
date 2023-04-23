import javax.swing.*;
import java.awt.*;

public class MainScreen extends JLabel {
    JSlider slider = new JSlider(140, 190, 165);

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

        JLabel name = new JLabel("Name");
        name.setBounds(10, 40, 100, 20);
        name.setForeground(Color.black);
        this.add(name);
        name.setVisible(true);

        JTextField nameField = new JTextField("");
        nameField.setBounds(100, 40, 70, 20);
        nameField.setForeground(Color.BLACK);
        this.add(nameField);
        nameField.setVisible(true);

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

        JLabel age = new JLabel("Age");
        age.setBounds(10, 100, 100, 20);
        age.setForeground(Color.black);
        this.add(age);
        age.setVisible(true);

        JTextField ageField = new JTextField("");
        ageField.setBounds(100, 100, 70, 20);
        ageField.setForeground(Color.BLACK);
        this.add(ageField);
        ageField.setVisible(true);

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


    }


}
