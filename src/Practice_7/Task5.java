package Practice_7;

interface MathCalculable {
    double power(double base, double exponent);
    double complexAbsolute(double real, double imaginary);
    double getPI();
}
class MathFunc implements MathCalculable {
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    public double complexAbsolute(double real, double imaginary) {
        return Math.sqrt(power(real, 2) + power(imaginary, 2));
    }
    public double getPI() {
        return Math.PI;
    }
}

public class Task5 {
    public static void main(String[] args) {
        MathCalculable mathFunc = new MathFunc();
        double radius = 5.0;
        double len = 2 * mathFunc.getPI() * radius;
        System.out.println("Длина окружности: " + len);
        double base = 2.0;
        double pow = 3.0;
        double realPart = 4.0;
        double imaginaryPart = 3.0;
        double resultPower = mathFunc.power(base, pow);
        double resultAbsolute = mathFunc.complexAbsolute(realPart, imaginaryPart);
        System.out.println("Результат возведения в степень: " + resultPower);
        System.out.println("Модуль комплексного числа: " + resultAbsolute);
    }
}
