import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;



public class Calculator {
    int boardwidth = 360;
    int boardheight = 540;

    Color customviolet = new Color(88,0,156);
    Color customblack  = new Color(28,28,28);
    Color customlightgray = new Color(80,80,80);

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculator");
    JLabel displayLevel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel  = new JPanel();

    String A = "0";
    String operator = null;
    String B = null;

    Calculator(){
        frame.setSize(boardwidth,boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayLevel.setBackground(Color.BLACK);
        displayLevel.setForeground(Color.WHITE);
        displayLevel.setFont(new Font("Arial",Font.PLAIN,80));
        displayLevel.setHorizontalAlignment(JLabel.RIGHT);
        displayLevel.setText("0");
        displayLevel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLevel);
        frame.add(displayPanel,BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(5,4));
        buttonPanel.setBackground(Color.BLACK);
        frame.add(buttonPanel);



        for(int i = 0; i<buttonValues.length; i++){
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(Color.BLACK));


            if(Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(Color.lightGray);
                button.setForeground(Color.WHITE);
            } else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customviolet);
                button.setForeground(Color.WHITE);
            }
            else{
                button.setBackground(Color.darkGray);
                button.setForeground(Color.WHITE);
            }

            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    if(Arrays.asList(rightSymbols).contains(buttonValue)){

                    } else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                        if(buttonValue == "AC"){
                            clearAll();
                            displayLevel.setText("0");
                        } else if (buttonValue == "+/-") {
                            
                        } else if (buttonValue == "%") {

                        }
                    }
                    else{
                        if(buttonValue.equals(".")){
                            if(!displayLevel.getText().contains(buttonValue)){
                                displayLevel.setText(displayLevel.getText() + buttonValue);
                            }
                        } else if ("0123456789".contains(buttonValue)) {
                            if(displayLevel.getText().equals("0")){
                                displayLevel.setText(buttonValue);
                            }
                            else {
                                displayLevel.setText(displayLevel.getText() + buttonValue);
                            }
                        }
                    }
                }
            });
        }
        frame.setVisible(true);
    }
    void clearAll(){
        A = "0";
        operator = null;
        B = null;
    }
}
