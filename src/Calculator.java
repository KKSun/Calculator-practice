/**
 * Created by brencharlson on 17/8/5.
 */

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.math.BigDecimal;

public class Calculator {
    String str1 = "0";
    String str2 = "0";
    String signal = "+";
    String result = "";

    int k1 = 1;
    int k2 = 1;
    int k3 = 1;
    int k4 = 1;
    int k5 = 1;
    JButton store;

    @SuppressWarnings("rawtypes")
    Vector vt = new Vector(20,10);

    JFrame frame = new JFrame("Calculator");  //面板

    JTextField Result_textField = new JTextField(result,20);  //输入窗

    JButton button_clear = new JButton("AC");  //按键
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button_dot = new JButton(".");
    JButton button_add = new JButton("+");
    JButton button_min = new JButton("-");
    JButton button_times = new JButton("*");
    JButton button_div = new JButton("/");
    JButton equals = new JButton("=");

    public Calculator() {
        button0.setMnemonic(KeyEvent.VK_0);
        Result_textField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel pan1 = new JPanel();
        pan1.setLayout(new GridLayout(4, 4, 5, 5));
        pan1.add(button7);
        pan1.add(button8);
        pan1.add(button9);
        pan1.add(button_div);
        pan1.add(button4);
        pan1.add(button5);
        pan1.add(button6);
        pan1.add(button_times);
        pan1.add(button1);
        pan1.add(button2);
        pan1.add(button3);
        pan1.add(button_min);
        pan1.add(button0);
        pan1.add(button_dot);
        pan1.add(equals);
        pan1.add(button_add);
        pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(Result_textField, BorderLayout.WEST);
        pan2.add(button_clear, BorderLayout.EAST);

        frame.setLocation(300, 300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(pan1, BorderLayout.CENTER);
        frame.add(pan2, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);

        class Listener_clear implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                k5 = 1;
                k2 = 1;
                k1 = 1;
                k3 = 1;
                k4 = 1;
                str1 = "0";
                str2 = "0";
                signal = "";
                result = "";
                Result_textField.setText(result);
                vt.clear();
            }
        }

//        下面的不懂

        class Listener implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);
                if (k1 == 1) {
                    if (k3 == 1) {
                        str1 = "";
                        k5 = 1;
                    }
                    str1 += ss;
                    k3 += 1;
                    Result_textField.setText(str1);
                } else if (k1 == 2) {
                    if (k4 == 1) {
                        str2 = "";
                        k5 = 1;
                    }
                    str2 = str2 + ss;
                    k4 += 1;
                    Result_textField.setText(str2);
                }
            }
        }

        class Listener_signal implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);

                if (k2 == 1) {
                    k1 = 2;
                    k5 = 1;
                    signal = ss2;
                    k2 = k2 + 1;
                } else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a - 2);

                    if (!(c.getText().equals("+"))
                            && !(c.getText().equals("-"))
                            && !(c.getText().equals("*"))
                            && !(c.getText().equals("/")))

                    {
                        cal();
                        str1 = result;
                        k1 = 2;
                        k5 = 1;
                        k4 = 1;
                        signal = ss2;
                    }
                    k2 = k2 + 1;

                }
            }
        }


        class Listener_equals implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {

                store = (JButton) e.getSource();
                vt.add(store);
                cal();

                k1 = 1;
                k2 = 1;
                k3 = 1;
                k4 = 1;

                str1 = result;
            }
        }


        class Listener_xs implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                if (k5 == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();
                    if (k1 == 1) {
                        if (k3 == 1) {
                            str1 = "";
                            k5 = 1;
                        }
                        str1 = str1 + ss2;

                        k3 = k3 + 1;

                        Result_textField.setText(str1);

                    } else if (k1 == 2) {
                        if (k4 == 1) {
                            str2 = "";
                            k5 = 1;
                        }
                        str2 = str2 + ss2;

                        k4 = k4 + 1;

                        Result_textField.setText(str2);
                    }
                }

                k5 = k5 + 1;
            }
        }

        Listener_equals jt_dy = new Listener_equals();

        Listener jt = new Listener();

        Listener_signal jt_signal = new Listener_signal();

        Listener_clear jt_c = new Listener_clear();

        Listener_xs jt_xs = new Listener_xs();

        button7.addActionListener(jt);
        button8.addActionListener(jt);
        button9.addActionListener(jt);
        button_div.addActionListener(jt_signal);
        button4.addActionListener(jt);
        button5.addActionListener(jt);
        button6.addActionListener(jt);
        button_times.addActionListener(jt_signal);
        button1.addActionListener(jt);
        button2.addActionListener(jt);
        button3.addActionListener(jt);
        button_min.addActionListener(jt_signal);
        button0.addActionListener(jt);
        button_dot.addActionListener(jt_xs);
        equals.addActionListener(jt_dy);
        button_add.addActionListener(jt_signal);
        button_clear.addActionListener(jt_c);
    }


    private void cal() {

        double a2;

        double b2;

        String c = signal;

        double result2 = 0;

        if (c.equals("")) {
            Result_textField.setText("Please input operator");

        } else {

            if (str1.equals("."))
                str1 = "0.0";
            if (str2.equals("."))
                str2 = "0.0";
            a2 = Double.valueOf(str1).doubleValue();
            b2 = Double.valueOf(str2).doubleValue();

            if (c.equals("+")) {
                result2 = a2 + b2;
            }
            if (c.equals("-")) {
                result2 = a2 - b2;
            }
            if (c.equals("*")) {
                BigDecimal m1 = new BigDecimal(Double.toString(a2));
                BigDecimal m2 = new BigDecimal(Double.toString(b2));
                result2 = m1.multiply(m2).doubleValue();
            }
            if (c.equals("/")) {
                if (b2 == 0) {
                    result2 = 0;
                } else {
                    result2 = a2 / b2;
                }

            }

            result = ((new Double(result2)).toString());

            Result_textField.setText(result);
        }
    }




    @SuppressWarnings("unused")
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
        Calculator calcu = new Calculator();
    }



}
