package assignment1.gui;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private final JFrame frame;
    private JTextField firstInputTextField;
    private JTextField secondInputTextField;
    private JLabel resultValueLabel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton differentiateButton;
    private JButton integrateButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton helpButton;
    private static final Font bigFont = new Font("PT Sans",Font.PLAIN,16);
    private static final Font hugeFont = new Font ("PT Sans", Font.BOLD,16);

    Controller controller = new Controller(this);

    public View(String name) {
        frame = new JFrame(name);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,220);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.prepareGui();
    }

    public void prepareGui(){

        JLabel firstInputLabel = new JLabel("First polynomial:");
        firstInputLabel.setFont(bigFont);
        JLabel secondInputLabel = new JLabel("Second polynomial:");
        secondInputLabel.setFont(bigFont);

        firstInputTextField = new JTextField();
        secondInputTextField = new JTextField();

        addButton = new JButton("+");
        addButton.setFont(hugeFont);
        subtractButton = new JButton("-");
        subtractButton.setFont(hugeFont);
        multiplyButton = new JButton("*");
        multiplyButton.setFont(hugeFont);
        divideButton = new JButton("/");
        divideButton.setFont(hugeFont);
        differentiateButton = new JButton("differentiate");
        differentiateButton.setFont(hugeFont);
        integrateButton = new JButton("integrate");
        integrateButton.setFont(hugeFont);
        helpButton = new JButton("help");
        helpButton.setFont(hugeFont);
        JLabel resultLabel = new JLabel("Result = ");
        resultLabel.setFont(bigFont);
        resultValueLabel = new JLabel();
        resultValueLabel.setFont(bigFont);
        JLabel freeSpaceLabel = new JLabel("");

        GroupLayout layout= new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstInputLabel)
                        .addComponent(secondInputLabel)
                        .addComponent(freeSpaceLabel)
                        .addComponent(resultLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstInputTextField)
                        .addComponent(secondInputTextField)
                        .addComponent(freeSpaceLabel)
                        .addComponent(resultValueLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addButton)
                        .addComponent(multiplyButton)
                        .addComponent(freeSpaceLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(subtractButton)
                        .addComponent(divideButton)
                        .addComponent(freeSpaceLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(differentiateButton)
                        .addComponent(integrateButton)
                        .addComponent(helpButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstInputLabel)
                        .addComponent(firstInputTextField)
                        .addComponent(addButton)
                        .addComponent(subtractButton)
                        .addComponent(differentiateButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(secondInputLabel)
                        .addComponent(secondInputTextField)
                        .addComponent(multiplyButton)
                        .addComponent(divideButton)
                        .addComponent(integrateButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(freeSpaceLabel)
                        .addComponent(freeSpaceLabel)
                        .addComponent(freeSpaceLabel)
                        .addComponent(freeSpaceLabel))
                        .addComponent(helpButton)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(resultLabel)
                        .addComponent(resultValueLabel)));

        layout.linkSize(SwingConstants.HORIZONTAL, addButton, subtractButton);
        layout.linkSize(SwingConstants.HORIZONTAL, multiplyButton, divideButton);
        layout.linkSize(SwingConstants.HORIZONTAL, addButton, divideButton);
        layout.linkSize(SwingConstants.HORIZONTAL, differentiateButton, integrateButton);
        layout.linkSize(SwingConstants.HORIZONTAL, differentiateButton, helpButton);
        frame.getContentPane().setLayout(layout);

        addButton.setActionCommand("ADD");
        subtractButton.setActionCommand("SUBTRACT");
        multiplyButton.setActionCommand("MULTIPLY");
        divideButton.setActionCommand("DIVIDE");
        differentiateButton.setActionCommand("DIFFERENTIATE");
        integrateButton.setActionCommand("INTEGRATE");
        helpButton.setActionCommand("HELP");

        addButton.addActionListener(this.controller);
        subtractButton.addActionListener(this.controller);
        multiplyButton.addActionListener(this.controller);
        divideButton.addActionListener(this.controller);
        differentiateButton.addActionListener(this.controller);
        integrateButton.addActionListener(this.controller);
        helpButton.addActionListener(this.controller);

        differentiateButton.setToolTipText("Click this to differentiate polynomial 1.");
        integrateButton.setToolTipText("Click this to integrate polynomial 1.");

        helpButton.setBackground(Color.pink);
    }

    public JTextField getFirstInputTextField() {
        return firstInputTextField;
    }

    public JTextField getSecondInputTextField() {
        return secondInputTextField;
    }

    public void setResultValueLabel(String resultValueLabel) {
        this.resultValueLabel.setText(resultValueLabel);
    }

}
