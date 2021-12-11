package com.company;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.io.Serializable;

//import org.apache.commons.math3.util.Precision;

public class converter extends JFrame implements ActionListener {

    //JFrame frameConverter;
    ImageIcon iconFrame;
    JLabel labelTitle;
    JTextField inputInitialValue;
    JLabel labelInitialValue;
    JComboBox selectInitialValue;
    JComboBox selectFinalValue;
    JLabel labelFinalValue;
    JButton btnConvert;
    JButton btnClose;

    //JPanel panelComboBoxIniatialValue;

    public converter(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLayout(null);
        this.setTitle("Converter");
        //final String iconPath = "C:\Users\bouzi\OneDrive\Desktop\Programs\Java\Convertitore\src\com";
        iconFrame = new ImageIcon("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Convertitore\\src\\com\\iconConverter.png");
        this.setIconImage(iconFrame.getImage());

        labelTitle = new JLabel();
        labelTitle.setText("CONVERTITORE");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setFont(new Font("Roboto", Font.BOLD, 35));
        labelTitle.setForeground(new Color(0x00AB00));
        final int xTitle = 145;
        final int yTitle = -70;
        final int widthTitle = 300;
        final int heightTitle = 250;
        labelTitle.setBounds(xTitle, yTitle, widthTitle, heightTitle);

        final int x1 = 125;

        inputInitialValue = new JTextField();
        inputInitialValue.setPreferredSize(new Dimension(250,60));
        inputInitialValue.setFont(new Font("Roboto", Font.BOLD, 25));
        inputInitialValue.setBackground(new Color(0xffffff/*C4C4C4*/));
        //final int xInput = 125;
        final int yInput = 130;
        final int widthInput = 320;
        final int heightInput = 40;
        inputInitialValue.setBounds(x1, yInput, widthInput, heightInput);
        //inputInitialValue.setEditable(true);

        labelInitialValue = new JLabel();
        labelInitialValue.setText("Initial value:");
        labelInitialValue.setHorizontalTextPosition(JLabel.CENTER);
        labelInitialValue.setFont(new Font("Roboto", Font.BOLD, 20));
        labelInitialValue.setForeground(new Color((0x00AB00)));
        //final int xLabel1 = 125;
        final int yLabel1 = 210;
        final int widthLabel = 150;
        final int heightLabel = 30;
        labelInitialValue.setBounds(x1, yLabel1, widthLabel, heightLabel);

        final String[] values = {"EUR", "USD", "GBP", "JPY", "AUD", "CAD", "CHF"};
        selectInitialValue = new JComboBox(values);
        selectInitialValue.setSize(100, selectInitialValue.getPreferredSize().height);
        //final int xCombobox = 125;
        final int yCombobox1 = 250;
        final int widthCombobox = 120;
        final int heightCombobox = 30;
        selectInitialValue.setBounds(x1, yCombobox1, widthCombobox, heightCombobox);

        labelFinalValue = new JLabel();
        labelFinalValue.setText("Final value:");
        labelFinalValue.setHorizontalTextPosition(JLabel.CENTER);
        labelFinalValue.setFont(new Font("Roboto", Font.BOLD, 20));
        labelFinalValue.setForeground(new Color(0x00AB00));
        final int x2 = 330;
        labelFinalValue.setBounds(x2, 150, widthLabel, widthLabel);


        selectFinalValue = new JComboBox(values);
        selectFinalValue.setSize(100, selectInitialValue.getPreferredSize().height);
        final int yCombobox2=330;
        selectFinalValue.setBounds(330, 250, widthCombobox, heightCombobox);
		/*
		panelComboBoxIniatialValue = new JPanel();
		panelComboBoxIniatialValue.setBounds();
		//panel.add(panelComboBoxIniatialValue);
		panelComboBoxIniatialValue.add(selectInitialValue);
		*/

        btnConvert = new JButton();
        btnConvert.setText("CONVERTI");
        btnConvert.setFocusable(false);
        btnConvert.setHorizontalTextPosition(JButton.CENTER);
        btnConvert.setFont(new Font("Roboto", Font.BOLD, 20));
        btnConvert.setForeground(new Color(0x00AB00));
        final int xbtnConv = 110;
        final int yBtn = 340;
        final int widthBtn = 150;
        final int heightBtn = 40;
        btnConvert.setBounds(xbtnConv, yBtn, widthBtn, heightBtn);
        btnConvert.addActionListener(this);

        btnClose = new  JButton();
        btnClose.setText("CHIUDI");
        btnClose.setFocusable(false);
        btnClose.setHorizontalTextPosition(JButton.CENTER);
        btnClose.setFont(new Font("Roboto", Font.BOLD, 20));
        btnClose.setForeground(new Color(0x00AB00));
        final int xBtnClose = 300;
        btnClose.setBounds(xBtnClose, yBtn, widthBtn, heightBtn);
        btnClose.addActionListener(this);

        this.add(btnClose);
        this.add(btnConvert);
        this.add(selectFinalValue);
        this.add(labelFinalValue);
        this.add(selectInitialValue);
        this.add(labelInitialValue);
        this.add(inputInitialValue);
        this.add(labelTitle);
        //this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnConvert) {
            String initialValue=inputInitialValue.getText();
            if(initialValue.equals("")) {
                try {
                    JOptionPane.showMessageDialog(null, "Inserisci il valore nell'input", "Inserisci il valore", JOptionPane.WARNING_MESSAGE);
                }catch (NumberFormatException as) {
                    as.printStackTrace();
                }
            }else {
                float numInitialValue = Float.parseFloat(initialValue);
                int finalValue = selectFinalValue.getSelectedIndex();

                if(selectInitialValue.getSelectedIndex() == selectFinalValue.getSelectedIndex()) {
                    JOptionPane.showMessageDialog(null, "la valuta iniziale non puo essere uguale alla valuta finale", "Errore di selezione", JOptionPane.WARNING_MESSAGE);
                }else{
                    switch(selectInitialValue.getSelectedIndex()) {
                        case 0:
                            double convEurAltro = eurAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convEurAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 1:
                            double convUsdAltro = usdAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convUsdAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2:
                            double convGbpAltro = gbpAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convGbpAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 3:
                            double convJpyAltro = jpyAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convJpyAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 4:
                            double convAudAltro = audAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convAudAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 5:
                            double convCadAltro = cadAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convCadAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 6:
                            double convChfAltro = chfAltro(numInitialValue, finalValue);
                            JOptionPane.showMessageDialog(null, convChfAltro, "Conversione", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }

                }
            }

        }

        if(e.getSource() == btnClose){
            this.dispose();
        }
    }

    public double eurAltro(float numInitialValue, int finalValue){
        double numConvertitoEur = 0;
        switch(finalValue) {
            case 1:
                numConvertitoEur = numInitialValue * 1.14;
                break;
            case 2:
                numConvertitoEur = numInitialValue * 1.17;
                break;
            case 3:
                numConvertitoEur = numInitialValue * 129.01;
                break;
            case 4:
                numConvertitoEur = numInitialValue * 1.58;
                break;
            case 5:
                numConvertitoEur = numInitialValue * 1.44;
                break;
            case 6:
                numConvertitoEur = numInitialValue * 0.96;
                break;
        }

        numConvertitoEur =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoEur));
        return numConvertitoEur;
    }

    public double usdAltro(float numInitialValue, int finalValue) {
        double numConvertitoUsd = 0;
        switch(finalValue) {
            case 0:
                numConvertitoUsd = numInitialValue * 0.88;
                break;
            case 2:
                numConvertitoUsd = numInitialValue * 0.76;
                break;
            case 3:
                numConvertitoUsd = numInitialValue * 113.65;
                break;
            case 4:
                numConvertitoUsd = numInitialValue * 1.39;
                break;
            case 5:
                numConvertitoUsd = numInitialValue * 1.26;
                break;
            case 6:
                numConvertitoUsd = numInitialValue * 0.96;
                break;
        }

        numConvertitoUsd =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoUsd));
        return numConvertitoUsd;
    }

    public double gbpAltro(float numInitialValue, int finalValue) {
        double numConvertitoGbp = 0;

        switch(finalValue) {
            case 0:
                numConvertitoGbp = numInitialValue * 1.17;
                break;
            case 1:
                numConvertitoGbp = numInitialValue * 1.32;
                break;
            case 3:
                numConvertitoGbp = numInitialValue * 150.37;
                break;
            case 4:
                numConvertitoGbp = numInitialValue * 0.54;
                break;
            case 5:
                numConvertitoGbp = numInitialValue * 0.60;
                break;
            case 6:
                numConvertitoGbp = numInitialValue * 1.22;
                break;
        }

        numConvertitoGbp =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoGbp));
        return numConvertitoGbp;
    }

    public double jpyAltro(float numInitialValue, int finalValue) {
        double numConvertitoJpy = 0;

        switch(finalValue) {
            case 0:
                numConvertitoJpy = numInitialValue * 0.0078;
                break;
            case 1:
                numConvertitoJpy = numInitialValue * 0.0088;
                break;
            case 2:
                numConvertitoJpy = numInitialValue * 0.0067;
                break;
            case 4:
                numConvertitoJpy = numInitialValue * 81.58;
                break;
            case 5:
                numConvertitoJpy = numInitialValue * 89.87;
                break;
            case 6:
                numConvertitoJpy = numInitialValue * 0.0081;
                break;
        }

        numConvertitoJpy =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoJpy));
        return numConvertitoJpy;
    }

    public double audAltro(float numInitialValue, int finalValue) {
        double numConvertitoAud = 0;

        switch(finalValue) {
            case 0:
                numConvertitoAud = numInitialValue * 0.63;
                break;
            case 1:
                numConvertitoAud = numInitialValue * 0.72;
                break;
            case 2:
                numConvertitoAud = numInitialValue * 0.54;
                break;
            case 3:
                numConvertitoAud = numInitialValue * 81.56;
                break;
            case 5:
                numConvertitoAud = numInitialValue * 0.91;
                break;
            case 6:
                numConvertitoAud = numInitialValue * 0.66;
                break;
        }

        numConvertitoAud =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoAud));
        return numConvertitoAud;
    }

    public double cadAltro(float numInitialValue, int finalValue) {
        double numConvertitoCad = 0;

        switch(finalValue) {
            case 0:
                numConvertitoCad = numInitialValue * 0.70;
                break;
            case 1:
                numConvertitoCad = numInitialValue * 0.79;
                break;
            case 2:
                numConvertitoCad = numInitialValue * 0.60;
                break;
            case 3:
                numConvertitoCad = numInitialValue * 89.88;
                break;
            case 4:
                numConvertitoCad = numInitialValue * 1.10;
                break;
            case 6:
                numConvertitoCad = numInitialValue * 0.73;
                break;
        }

        numConvertitoCad =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoCad));
        return numConvertitoCad;
    }

    public double chfAltro(float numInitialValue, int finalValue) {
        double numConvertitoChf = 0;

        switch(finalValue) {
            case 0:
                numConvertitoChf = numInitialValue * 0.96;
                break;
            case 1:
                numConvertitoChf = numInitialValue * 1.09;
                break;
            case 2:
                numConvertitoChf = numInitialValue * 0.82;
                break;
            case 3:
                numConvertitoChf = numInitialValue * 0.0081;
                break;
            case 4:
                numConvertitoChf = numInitialValue * 1.51;
                break;
            case 5:
                numConvertitoChf = numInitialValue * 1.37;
                break;
        }

        numConvertitoChf =Double.parseDouble(new DecimalFormat("###.##").format(numConvertitoChf));
        return numConvertitoChf;
    }

}

