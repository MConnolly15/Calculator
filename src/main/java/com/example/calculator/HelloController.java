package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    String op = "";
    long number1;
    long number2;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button buttonEquals;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonTakeaway;

    @FXML
    private Button buttonTimes;

    @FXML
    private TextField txt_result;

   // @FXML
    //protected void onHelloButtonClick() {
   //   //  welcomeText.setText("Welcome to JavaFX Application!");
   // }

    @FXML
    public void Number(ActionEvent ae){
        String number = ((Button)ae.getSource()).getText();
        txt_result.setText(txt_result.getText()+number);
    }

    public void Operation(ActionEvent ae){
        String operation = ((Button)ae.getSource()).getText();
        if(!operation.equals("=")){

            if(!op.equals("")){
                return;
            }

            op = operation;
            if(!txt_result.getText().isEmpty()) {
                number1 = Long.parseLong(txt_result.getText());
            }
            txt_result.setText("");
        } else {

            if(op.equals("")){
                return;
            }
            if(!txt_result.getText().isEmpty()) {
                number2 = Long.parseLong(txt_result.getText());
            }
            calculate(number1, number2, op);
            op="";
        }
    }

    public void calculate (long n1, long n2, String op){

        switch (op){
            case "+": txt_result.setText(n1 + n2 +"");break;
            case "-": txt_result.setText(n1 - n2 +"");break;
            case "*": txt_result.setText(n1 * n2 +"");break;
            case "/" :
                if(n2 == 0){
                    txt_result.setText("0");break;
                }
                txt_result.setText(n1/n2+ "");break;

        }
    }

    public void clear(ActionEvent ae){
        txt_result.clear();
    }
}