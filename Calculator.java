import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] fumctions = new JButton[8];
    JButton add, minus, mux, div, dec, equal, delete, clear;
    JPanel panel;
    double num1=0, num2=0, result=0;
    char operator;


    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setEditable(false);

        add = new JButton("+");
        minus = new JButton("-");
        div = new JButton("/");
        mux = new JButton("*");
        dec = new JButton(".");
        clear = new JButton("CLEAR");
        equal = new JButton("=");
        delete = new JButton("DEL");

        fumctions[0]= add;
        fumctions[1]= minus;
        fumctions[2]= mux;
        fumctions[3]= div;
        fumctions[4]= dec;
        fumctions[5]= equal;
        fumctions[6]= delete;
        fumctions[7]= clear;

        for(int i=0;i<8;i++){
            fumctions[i].addActionListener(this);
            fumctions[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
        }

        delete.setBounds(50,430,145,50);
        clear.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(minus);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(div);
        panel.add(mux);
        panel.add(dec);
        panel.add(numbers[0]);
        panel.add(clear);
        panel.add(equal);
        panel.add(delete);





        frame.add(panel);
        frame.add(textField);
        frame.add(delete);
        frame.add(clear);
        frame.setVisible(true);


    }
    public static void main (String[]args){

        Calculator calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){


            if(e.getSource()==numbers[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==dec){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==add){
            num1= Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==minus){
            num1= Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mux){
            num1= Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==div){
            num1= Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equal){
            num2= Double.parseDouble(textField.getText());
            switch (operator){
                case'+':
                    result= num1 + num2;
                    break;
                case'-':
                    result= num1-num2;
                    break;
                case'*':
                    result= num1*num2;
                    break;
                case'/':
                    result= num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1= result;
        }
        if(e.getSource()==clear){

            textField.setText("");
        }
        if(e.getSource()==delete){
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));

            }
        }



    }
}
