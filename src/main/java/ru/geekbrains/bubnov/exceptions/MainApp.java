package ru.geekbrains.bubnov.exceptions;

public class MainApp {
    public static void main(String[] args) {

        String[][] array = {
                {"8", "5", "4", "2"},
                {"7", "9", "2", "6"},
                {"5", "8", "7", "1"},
                {"3", "2", "9", "4"}
        };
        try {
            getSumElement(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static void getSumElement(String[][] array) throws MyArraySizeException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("Не допустимый размер массива");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Не допустимый размер массива");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка преобразования в число элемента массива " + array[i][j] + " с индексами " + i + " " + j);
                }

            }

        }
        System.out.println(sum);
    }
}
