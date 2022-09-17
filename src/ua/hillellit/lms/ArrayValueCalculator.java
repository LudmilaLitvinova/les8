package ua.hillellit.lms;

import ua.hillellit.lms.exceptions.ArrayDataException;
import ua.hillellit.lms.exceptions.ArraySizeException;

public class ArrayValueCalculator {

  public static void main(String[] args) {
    String[][] strAr = {{"1", "2", "3", "4"}, {"2", "7", "8", "9"}, {"3", "7", "8", "9"},
        {"4", "5", "8", "fgh"}};

    try {
      System.out.println(doCalc(strAr));
    } catch (ArraySizeException | ArrayDataException e) {
      System.out.println(e.getMessage());
    }
  }

  static int doCalc(String[][] ar) throws ArraySizeException, ArrayDataException {
    if (ar == null) {
      throw new ArraySizeException("Масив повинен бути 4 на 4. Ви передали null-масив");
    }
    if (ar.length != 4) {
      throw new ArraySizeException("Масив повинен бути 4 на 4. Невірна кількість стрічок. "
          + "У даному масиві їх кількість дорівнює " + ar.length);
    }
    for (int i = 0; i < ar.length; i++) {
      if (ar[i] == null) {
        throw new ArraySizeException(
            "Масив не повинен мати null. Ви передали null у " + (i + 1) + " стрічці");
      }
      if (ar[i].length != 4) {
        throw new ArraySizeException("Масив повинен бути 4 на 4. Невірна кількість комірок у "
            + (i + 1) + " стрічці");
      }
    }
    int sumAllElements = 0;
    int x;
    for (int i = 0; i < ar.length; i++) {
      for (int j = 0; j < ar[i].length; j++) {
        try {
          x = Integer.parseInt(ar[i][j]);
        } catch (NumberFormatException e) {
          throw new ArrayDataException(
              "У вас невірні дані в " + (i + 1) + " стрічці " + (j + 1) + " комірці. "
                  + e.getMessage());
        }
        sumAllElements += x;
      }
    }
    return sumAllElements;
  }
}

