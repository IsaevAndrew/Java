package Practice_4;

class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new double[rows][columns];
    }

    public void setElement(int row, int column, double value) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            data[row][column] = value;
        } else {
            System.out.println("Недопустимые индексы.");
        }
    }

    public double getElement(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return data[row][column];
        } else {
            System.out.println("Недопустимые индексы.");
            return 0.0;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void addMatrix(Matrix otherMatrix) {
        if (rows == otherMatrix.rows && columns == otherMatrix.columns) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    data[i][j] += otherMatrix.getElement(i, j);
                }
            }
        } else {
            System.out.println("Невозможно выполнить сложение. Размерности матриц не совпадают.");
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] *= scalar;
            }
        }
    }

    public Matrix multiplyByMatrix(Matrix otherMatrix) {
        if (columns != otherMatrix.rows) {
            System.out.println("Невозможно выполнить умножение. Количество столбцов первой матрицы не равно количеству строк второй матрицы.");
            return null;
        }

        Matrix resultMatrix = new Matrix(rows, otherMatrix.columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < otherMatrix.columns; j++) {
                double sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += data[i][k] * otherMatrix.getElement(k, j);
                }
                resultMatrix.setElement(i, j, sum);
            }
        }

        return resultMatrix;
    }


}


public class Task4 {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(3, 2);

        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(0, 2, 3);
        matrix1.setElement(1, 0, 4);
        matrix1.setElement(1, 1, 5);
        matrix1.setElement(1, 2, 6);

        matrix2.setElement(0, 0, 7);
        matrix2.setElement(0, 1, 8);
        matrix2.setElement(1, 0, 9);
        matrix2.setElement(1, 1, 10);
        matrix2.setElement(2, 0, 11);
        matrix2.setElement(2, 1, 12);

        Matrix matrix3 = new Matrix(2, 3);
        matrix3.setElement(0, 0, 3);
        matrix3.setElement(0, 1, 5);
        matrix3.setElement(0, 2, 1);
        matrix3.setElement(1, 0, 0);
        matrix3.setElement(1, 1, 1);
        matrix3.setElement(1, 2, 4);
        System.out.println("Матрица 1:");
        matrix1.printMatrix();

        System.out.println("Матрица 2:");
        matrix2.printMatrix();

        matrix1.addMatrix(matrix3);
        System.out.println("Матрица 1 после сложения с третьей");
        matrix1.printMatrix();

        matrix2.multiplyByScalar(2);
        System.out.println("Матрица 2 после умножения на число 2.");
        matrix2.printMatrix();

        Matrix resultMatrix = matrix1.multiplyByMatrix(matrix2);
        System.out.println("Результат умножения матриц:");
        resultMatrix.printMatrix();
    }
}
