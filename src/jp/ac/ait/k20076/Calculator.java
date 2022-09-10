package jp.ac.ait.k20076;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Calculator extends JFrame {
    private final StringBuilder str = new StringBuilder();
    private JPanel panel1;
    private JButton Zero;
    private JButton Plus;
    private JButton Dot;
    private JButton Zero2;
    private JButton Equal;
    private JButton Clear;
    private JButton AllClear;
    private JButton One;
    private JButton Two;
    private JButton Three;
    private JButton Minus;
    private JButton Multi;
    private JButton Six;
    private JButton Five;
    private JButton Four;
    private JButton Percent;
    private JButton Seven;
    private JButton Eight;
    private JButton Nine;
    private JButton Division;
    private JButton Remain;
    private JLabel Current;
    private JLabel ShowCalC;
    private JButton outTaxButton;
    private JButton inTaxButton;
    private JButton setTaxButton;
    private JButton Music;
    private String del;
    private int count = 0;
    private double numtmp;
    private double tax = 1.10;

    public void Calc() {
        switch (ShowCalC.getText()) {
            case "+":
                numtmp += Double.parseDouble(Current.getText());
                Current.setText(String.valueOf(numtmp));
                count = Current.getText().length();
                break;
            case "-":
                numtmp -= Double.parseDouble(Current.getText());
                Current.setText(String.valueOf(numtmp));
                count = Current.getText().length();
                break;
            case "*":
                numtmp *= Double.parseDouble(Current.getText());
                Current.setText(String.valueOf(numtmp));
                count = Current.getText().length();
                break;
            case "/":
                try {
                    numtmp /= Double.parseDouble(Current.getText());
                    Current.setText(String.valueOf(numtmp));
                    count = Current.getText().length();
                    if (String.valueOf(numtmp).equals("Infinity")) {
                        throw new ArithmeticException();
                    }

                } catch (ArithmeticException a) {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "Infinityです!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                    numtmp = 0;
                    ShowCalC.setText("");
                }
                break;
            case "%(div)":
                try {
                    numtmp = numtmp % Double.parseDouble(Current.getText());
                    Current.setText(String.valueOf(numtmp));
                    count = String.valueOf(numtmp).length();
                    if (String.valueOf(numtmp).equals("NaN")) {
                        throw new ArithmeticException();
                    }
                } catch (ArithmeticException a) {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "非数です!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                    numtmp = 0;
                    ShowCalC.setText("");
                }
                break;
        }
    }

    public static void Sound(String url) {
        try {
            Clip clip = AudioSystem.getClip();
            if (url.equals("Wo Ai Beijing Tiananmen.wav") || url.equals("March of the Volunteers.wav")) {
                clip.open(AudioSystem.getAudioInputStream(new File(url)));
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.open(AudioSystem.getAudioInputStream(new File(url)));
                clip.start();
            }
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public Calculator() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(800, 800, 800, 800);
        setContentPane(panel1);
        setTitle("计算器");

        Zero.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!(Current.getText().equals("0"))) {
                Sound("0.wav");
                count = str.length();
                str.append("0");
                Current.setText(str.toString());
            }
        });
        Zero2.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else if (!(Current.getText().equals("0"))) {
                if (str.length() + 2 > 14) {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "15桁より多くは配置できません!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Sound("00.wav");
                    str.append("0");
                    str.append("0");
                    count = str.length();
                    Current.setText(str.toString());
                }
            }
        });

        One.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (str.toString().contains(str.toString())) {
                    Current.setText("0");
                }
                Sound("1.wav");
                str.append("1");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Two.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("2.wav");
                str.append("2");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Three.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("3.wav");
                str.append("3");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Four.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("4.wav");
                str.append("4");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Five.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("5.wav");
                str.append("5");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Six.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("6.wav");
                str.append("6");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Seven.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("7.wav");
                str.append("7");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Eight.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("8.wav");
                str.append("8");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        Nine.addActionListener(e -> {
            if (str.length() > 14) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "15桁より多くは配置できません!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Sound("9.wav");
                str.append("9");
                Current.setText(str.toString());
                count = str.length();
            }
        });
        AllClear.addActionListener(e -> {
            Sound("all clear.wav");
            count = 0;
            numtmp = 0;
            str.delete(0, str.length());
            Current.setText("0");
            ShowCalC.setText("");
        });
        Clear.addActionListener(e -> {
            Sound("pi.wav");
            if (ShowCalC.getText().equals("+") || ShowCalC.getText().equals("-") || ShowCalC.getText().equals("*") || ShowCalC.getText().equals("/") || ShowCalC.getText().equals("%(div)") || ShowCalC.getText().equals("%(perc)")) {
                str.delete(0, str.length());
                str.append(Current.getText());
                count = str.toString().length();
                ShowCalC.setText("");
            }
            if (str.length() > 0) {
                count--;
                if (count != 0) {
                    str.setLength(str.length() - 1);
                    del = str.toString();
                    Current.setText(del);
                } else {
                    count = 0;
                    str.delete(0, str.length());
                    numtmp = 0;
                    Current.setText("0");
                }
            } else {
                count = 0;
                numtmp = 0;
                str.delete(0, str.length());
                Current.setText("0");
            }
        });
        Plus.addActionListener(e -> {
            try {
                Sound("plus.wav");
                if (ShowCalC.getText().equals("-") || ShowCalC.getText().equals("*") || ShowCalC.getText().equals("/") || ShowCalC.getText().equals("%(div)") || ShowCalC.getText().equals("%(perc)")) {
                    Calc();
                } else if (ShowCalC.getText().equals("outTax") || ShowCalC.getText().equals("inTax")) {
                    numtmp = Double.parseDouble(Current.getText());
                    ShowCalC.setText("+");
                } else {
                    numtmp += Double.parseDouble(str.toString());
                }
                str.delete(0, str.length());
                if (String.valueOf(numtmp).length() < 14) {
                    Current.setText(String.valueOf(numtmp));
                    count = String.valueOf(numtmp).length();
                    ShowCalC.setText("+");
                    //System.out.println(count);
                } else {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "15桁より多くは配置できません!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException a) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        Minus.addActionListener(e -> {
            Sound("minus.wav");
            try {
                if (ShowCalC.getText().equals("+") || ShowCalC.getText().equals("*") || ShowCalC.getText().equals("/") || ShowCalC.getText().equals("%(div)") || ShowCalC.getText().equals("%(perc)")) {
                    Calc();
                } else if (ShowCalC.getText().equals("outTax") || ShowCalC.getText().equals("inTax")) {
                    numtmp = Double.parseDouble(Current.getText());
                    ShowCalC.setText("-");
                } else {
                    if (numtmp != 0) {
                        numtmp -= Double.parseDouble(str.toString());
                    } else {
                        numtmp = Double.parseDouble(str.toString());
                    }
                }
                str.delete(0, str.length());
                if (String.valueOf(numtmp).length() < 14) {
                    Current.setText(String.valueOf(numtmp));
                    count = String.valueOf(numtmp).length();
                    ShowCalC.setText("-");
                } else {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "15桁より多くは配置できません!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException a) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        Multi.addActionListener(e -> {
            Sound("multi.wav");
            try {
                if (ShowCalC.getText().equals("+") || ShowCalC.getText().equals("-") || ShowCalC.getText().equals("/") || ShowCalC.getText().equals("%(div)") || ShowCalC.getText().equals("%(perc)")) {
                    Calc();
                } else if (ShowCalC.getText().equals("outTax") || ShowCalC.getText().equals("inTax")) {
                    numtmp = Double.parseDouble(Current.getText());
                    ShowCalC.setText("*");
                } else {
                    if (numtmp != 0) {
                        numtmp *= Double.parseDouble(str.toString());
                    } else {
                        numtmp = Double.parseDouble(str.toString());
                    }
                }
                str.delete(0, str.length());
                if (String.valueOf(numtmp).length() < 14) {
                    Current.setText(String.valueOf(numtmp));
                    count = String.valueOf(numtmp).length();
                    ShowCalC.setText("*");
                } else {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "15桁より多くは配置できません!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException a) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        Division.addActionListener(e -> {
            Sound("division.wav");
            try {
                if (ShowCalC.getText().equals("+") || ShowCalC.getText().equals("-") || ShowCalC.getText().equals("*") || ShowCalC.getText().equals("%(div)") || ShowCalC.getText().equals("%(perc)")) {
                    Calc();
                } else if (ShowCalC.getText().equals("outTax") || ShowCalC.getText().equals("inTax")) {
                    numtmp = Double.parseDouble(Current.getText());
                    ShowCalC.setText("/");
                } else {
                    if (numtmp != 0) {
                        try {
                            numtmp /= Double.parseDouble(str.toString());
                            if (String.valueOf(numtmp).equals("Infinity")) {
                                throw new ArithmeticException();
                            }
                        } catch (ArithmeticException a) {
                            Sound("error.wav");
                            JOptionPane.showMessageDialog(
                                    panel1, "Infinityです!", "计算器",
                                    JOptionPane.ERROR_MESSAGE);
                            numtmp = 0;
                        }
                    } else {
                        numtmp = Double.parseDouble(str.toString());
                    }
                }
                str.delete(0, str.length());
                if (String.valueOf(numtmp).length() < 14) {
                    Current.setText(String.valueOf(numtmp));
                    count = String.valueOf(numtmp).length();
                    ShowCalC.setText("/");
                } else {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "15桁より多くは配置できません!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException a) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        Remain.addActionListener(e -> {
            Sound("pi.wav");
            try {
                if (ShowCalC.getText().equals("+") || ShowCalC.getText().equals("-") || ShowCalC.getText().equals("*") || ShowCalC.getText().equals("/") || ShowCalC.getText().equals("%(perc)")) {
                    Calc();
                } else if (ShowCalC.getText().equals("outTax") || ShowCalC.getText().equals("inTax")) {
                    numtmp = Double.parseDouble(Current.getText());
                    ShowCalC.setText("%(div)");
                } else {
                    if (numtmp != 0) {
                        try {
                            numtmp = numtmp % Double.parseDouble(str.toString());
                            if (String.valueOf(numtmp).equals("NaN")) {
                                throw new ArithmeticException();
                            }
                        } catch (ArithmeticException a) {
                            Sound("error.wav");
                            JOptionPane.showMessageDialog(
                                    panel1, "非数です!", "计算器",
                                    JOptionPane.ERROR_MESSAGE);
                            numtmp = 0;
                        }
                    } else {
                        numtmp = Double.parseDouble(str.toString());
                    }
                }
                str.delete(0, str.length());
                if (String.valueOf(numtmp).length() < 14) {
                    Current.setText(String.valueOf(numtmp));
                    count = String.valueOf(numtmp).length();
                    ShowCalC.setText("%(div)");
                } else {
                    Sound("error.wav");
                    JOptionPane.showMessageDialog(
                            panel1, "15桁より多くは配置できません!", "计算器",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException a) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        Percent.addActionListener(e -> {
            Sound("pi.wav");
            try {
                if (ShowCalC.getText().equals("+") || ShowCalC.getText().equals("-") || ShowCalC.getText().equals("*") || ShowCalC.getText().equals("/") || ShowCalC.getText().equals("%(div)")) {
                    Calc();
                }
                str.delete(0, str.length());
                str.append(Current.getText());
                numtmp = Double.parseDouble(str.toString()) / 100.0;
                Current.setText(String.valueOf(numtmp));
                str.delete(0, str.length());
                ShowCalC.setText("%(perc)");
            } catch (NumberFormatException a) {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        Equal.addActionListener(e -> {
            Sound("equal.wav");
            Calc();
            ShowCalC.setText("");
        });
        Dot.addActionListener(e -> {
            Sound("dian.wav");
            if (!str.toString().contains(".")) {
                if (Current.getText().equals("0")) {
                    str.append("0");
                }
                str.append(".");
                Current.setText(str.toString());
                count = String.valueOf(numtmp).length();
            } else {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        outTaxButton.addActionListener(e -> {
            Sound("pi.wav");
            numtmp = Double.parseDouble(Current.getText()) / tax;
            BigDecimal x = new BigDecimal(numtmp);
            x = x.setScale(1, RoundingMode.HALF_UP);
            Current.setText(String.valueOf(x));
            count = Current.getText().length();
            ShowCalC.setText("outTax");
        });
        inTaxButton.addActionListener(e -> {
            Sound("pi.wav");
            numtmp = Double.parseDouble(Current.getText()) * tax;
            BigDecimal x = new BigDecimal(numtmp);
            x = x.setScale(1, RoundingMode.HALF_UP);
            Current.setText(String.valueOf(x));
            count = Current.getText().length();
            ShowCalC.setText("inTax");
        });
        setTaxButton.addActionListener(e -> {
            Sound("pi.wav");
            if (!Current.getText().equals("0")) {
                tax = (Double.parseDouble(Current.getText()) + 100) / 100;
                Current.setText("0");
                str.delete(0, str.length());
                //System.out.println(tax);
                JOptionPane.showMessageDialog(
                        panel1, "税率は" + (int) (tax * 100 - 100) + "%に変更されました", "计算器",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                Sound("error.wav");
                JOptionPane.showMessageDialog(
                        panel1, "不正な入力です!", "计算器",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        Music.addActionListener(e -> {
                Sound("music.wav");
            Music.setEnabled(false);
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Calculator().setVisible(true));
    }
}
