//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
    JFrame frame = new JFrame("Calcolatrice");
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton decButton;
    JButton equButton;
    JButton delButton;
    JButton clrButton;
    JButton negButton;
    JPanel panel;
    Font myFont = new Font("Helvetica", 1, 30);
    double num1 = 0.0;
    double numb2 = 0.0;
    double result = 0.0;
    char operator;

    Calculator() {
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(420, 550);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setResizable(false);
        this.textField = new JTextField();
        this.textField.setBounds(50, 25, 300, 50);
        this.textField.setFont(this.myFont);
        this.textField.setEditable(false);
        this.addButton = new JButton("+");
        this.subButton = new JButton("-");
        this.mulButton = new JButton("x");
        this.divButton = new JButton("÷");
        this.decButton = new JButton(".");
        this.equButton = new JButton("=");
        this.delButton = new JButton("Delete");
        this.clrButton = new JButton("Clear");
        this.negButton = new JButton("(-)");
        this.functionButtons[0] = this.addButton;
        this.functionButtons[1] = this.subButton;
        this.functionButtons[2] = this.mulButton;
        this.functionButtons[3] = this.divButton;
        this.functionButtons[4] = this.decButton;
        this.functionButtons[5] = this.equButton;
        this.functionButtons[6] = this.delButton;
        this.functionButtons[7] = this.clrButton;
        this.functionButtons[8] = this.negButton;

        int i;
        for(i = 0; i < 9; ++i) {
            this.functionButtons[i].addActionListener(this);
            this.functionButtons[i].setFont(this.myFont);
            this.functionButtons[i].setFocusable(false);
        }

        for(i = 0; i < 10; ++i) {
            this.numberButtons[i] = new JButton(String.valueOf(i));
            this.numberButtons[i].addActionListener(this);
            this.numberButtons[i].setFont(this.myFont);
            this.numberButtons[i].setFocusable(false);
        }

        this.negButton.setBounds(50, 430, 100, 50);
        this.delButton.setBounds(150, 430, 100, 50);
        this.clrButton.setBounds(250, 430, 100, 50);
        this.panel = new JPanel();
        this.panel.setBounds(50, 100, 300, 300);
        this.panel.setLayout(new GridLayout(4, 4, 10, 10));
        this.panel.setBackground(new Color(238, 238, 238));
        this.panel.add(this.numberButtons[1]);
        this.panel.add(this.numberButtons[2]);
        this.panel.add(this.numberButtons[3]);
        this.panel.add(this.addButton);
        this.panel.add(this.numberButtons[4]);
        this.panel.add(this.numberButtons[5]);
        this.panel.add(this.numberButtons[6]);
        this.panel.add(this.subButton);
        this.panel.add(this.numberButtons[7]);
        this.panel.add(this.numberButtons[8]);
        this.panel.add(this.numberButtons[9]);
        this.panel.add(this.mulButton);
        this.panel.add(this.decButton);
        this.panel.add(this.numberButtons[0]);
        this.panel.add(this.equButton);
        this.panel.add(this.divButton);
        this.frame.add(this.negButton);
        this.frame.add(this.panel);
        this.frame.add(this.delButton);
        this.frame.add(this.clrButton);
        this.frame.add(this.textField);
        this.frame.setVisible(true);
    }

    public static void calculator() {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; ++i) {
            if (e.getSource() == this.numberButtons[i]) {
                this.textField.setText(this.textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == this.decButton) {
            this.textField.setText(this.textField.getText().concat("."));
        }

        if (e.getSource() == this.addButton) {
            this.num1 = Double.parseDouble(this.textField.getText());
            this.operator = '+';
            this.textField.setText(" ");
        }

        if (e.getSource() == this.subButton) {
            this.num1 = Double.parseDouble(this.textField.getText());
            this.operator = '-';
            this.textField.setText(" ");
        }

        if (e.getSource() == this.mulButton) {
            this.num1 = Double.parseDouble(this.textField.getText());
            this.operator = '*';
            this.textField.setText(" ");
        }

        if (e.getSource() == this.divButton) {
            this.num1 = Double.parseDouble(this.textField.getText());
            this.operator = '/';
            this.textField.setText(" ");
        }

        if (e.getSource() == this.equButton) {
            this.numb2 = Double.parseDouble(this.textField.getText());
            switch (this.operator) {
                case '*':
                    this.result = this.num1 * this.numb2;
                    break;
                case '+':
                    this.result = this.num1 + this.numb2;
                case ',':
                case '.':
                default:
                    break;
                case '-':
                    this.result = this.num1 - this.numb2;
                    break;
                case '/':
                    this.result = this.num1 / this.numb2;
            }

            this.textField.setText(String.valueOf(this.result));
            this.num1 = this.result;
        }

        if (e.getSource() == this.clrButton) {
            this.textField.setText("");
        }

        if (e.getSource() == this.delButton) {
            String string = this.textField.getText();
            this.textField.setText("");

            for(int i = 0; i < string.length() - 1; ++i) {
                JTextField var10000 = this.textField;
                String var10001 = this.textField.getText();
                var10000.setText(var10001 + string.charAt(i));
            }
        }

        if (e.getSource() == this.negButton) {
            double temp = Double.parseDouble(this.textField.getText());
            temp *= -1.0;
            this.textField.setText(String.valueOf(temp));
        }

    }
}
