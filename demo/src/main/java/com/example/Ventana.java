package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {

    Operaciones op = new Operaciones();

    JLabel lblNum1 = new JLabel("Número 1:");
    JLabel lblNum2 = new JLabel("Número 2:");
    JLabel lblTemp = new JLabel("Temperatura:");
    JLabel lblMoneda = new JLabel("Valor:");
    JLabel lblResultado = new JLabel("Resultado: ");

    JTextField txtNum1 = new JTextField();
    JTextField txtNum2 = new JTextField();
    JTextField txtTemp = new JTextField();
    JTextField txtMoneda = new JTextField();

    JButton btnSumar = new JButton("Sumar");
    JButton btnRestar = new JButton("Restar");
    JButton btnMultiplicar = new JButton("Multiplicar");
    JButton btnDividir = new JButton("Dividir");

    JButton btnCaF = new JButton("°C a °F");
    JButton btnFaC = new JButton("°F a °C");

    JButton btnUSDaCOP = new JButton("USD a COP");
    JButton btnCOPaUSD = new JButton("COP a USD");

    // BOTONES LIMPIAR
    JButton btnLimpiarNum = new JButton("Limpiar números");
    JButton btnLimpiarTemp = new JButton("Limpiar temperatura");
    JButton btnLimpiarMoneda = new JButton("Limpiar moneda");

    public Ventana() {

        setTitle("NexaCalc");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(14, 2, 10, 10));
        setLocationRelativeTo(null);

        // NÚMEROS
        add(lblNum1);
        add(txtNum1);

        add(lblNum2);
        add(txtNum2);

        add(btnSumar);
        add(btnRestar);

        add(btnMultiplicar);
        add(btnDividir);

        add(btnLimpiarNum);

        // TEMPERATURA
        add(lblTemp);
        add(txtTemp);

        add(btnCaF);
        add(btnFaC);

        add(btnLimpiarTemp);

        // MONEDA
        add(lblMoneda);
        add(txtMoneda);

        add(btnUSDaCOP);
        add(btnCOPaUSD);

        add(btnLimpiarMoneda);

        // RESULTADO
        add(lblResultado);

        // EVENTOS
        btnSumar.addActionListener(this);
        btnRestar.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);

        btnCaF.addActionListener(this);
        btnFaC.addActionListener(this);

        btnUSDaCOP.addActionListener(this);
        btnCOPaUSD.addActionListener(this);

        btnLimpiarNum.addActionListener(this);
        btnLimpiarTemp.addActionListener(this);
        btnLimpiarMoneda.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // OPERACIONES MATEMÁTICAS
            if (e.getSource() == btnSumar ||
                e.getSource() == btnRestar ||
                e.getSource() == btnMultiplicar ||
                e.getSource() == btnDividir) {

                if (txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "Por favor ingrese los dos números.");

                    return;
                }

                double a = Double.parseDouble(txtNum1.getText());
                double b = Double.parseDouble(txtNum2.getText());

                double resultado = 0;

                if (e.getSource() == btnSumar) {
                    resultado = op.sumar(a, b);

                } else if (e.getSource() == btnRestar) {
                    resultado = op.restar(a, b);

                } else if (e.getSource() == btnMultiplicar) {
                    resultado = op.multiplicar(a, b);

                } else if (e.getSource() == btnDividir) {
                    resultado = op.dividir(a, b);
                }

                lblResultado.setText("Resultado: " + resultado);
            }

            // TEMPERATURA
            else if (e.getSource() == btnCaF ||
                     e.getSource() == btnFaC) {

                if (txtTemp.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "Por favor ingrese la temperatura.");

                    return;
                }

                double temp = Double.parseDouble(txtTemp.getText());

                double resultado = 0;

                if (e.getSource() == btnCaF) {
                    resultado = op.celsiusAFahrenheit(temp);

                } else {
                    resultado = op.fahrenheitACelsius(temp);
                }

                lblResultado.setText("Resultado: " + resultado);
            }

            // MONEDA
            else if (e.getSource() == btnUSDaCOP ||
                     e.getSource() == btnCOPaUSD) {

                if (txtMoneda.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "Por favor ingrese el valor.");

                    return;
                }

                double valor = Double.parseDouble(txtMoneda.getText());

                double resultado = 0;

                if (e.getSource() == btnUSDaCOP) {
                    resultado = op.dolaresAPesos(valor);

                } else {
                    resultado = op.pesosADolares(valor);
                }

                lblResultado.setText("Resultado: " + resultado);
            }

            // LIMPIAR NÚMEROS
            else if (e.getSource() == btnLimpiarNum) {

                txtNum1.setText("");
                txtNum2.setText("");

                lblResultado.setText("Resultado: ");
            }

            // LIMPIAR TEMPERATURA
            else if (e.getSource() == btnLimpiarTemp) {

                txtTemp.setText("");

                lblResultado.setText("Resultado: ");
            }

            // LIMPIAR MONEDA
            else if (e.getSource() == btnLimpiarMoneda) {

                txtMoneda.setText("");

                lblResultado.setText("Resultado: ");
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Solo se permiten números.");

        } catch (ArithmeticException ex) {

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());
        }
    }
}