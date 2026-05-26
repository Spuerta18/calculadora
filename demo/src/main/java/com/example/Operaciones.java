package com.example;

public class Operaciones {

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    public double celsiusAFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public double fahrenheitACelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public double dolaresAPesos(double dolares) {
        if (dolares < 0) {
            throw new ArithmeticException("El valor no puede ser menor a 0.");
        }
        return dolares * 3800;
    }

    public double pesosADolares(double pesos) {
        if (pesos < 0) {
            throw new ArithmeticException("El valor no puede ser menor a 0.");
        }
        return pesos / 3800;
    }
}