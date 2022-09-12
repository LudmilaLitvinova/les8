package ua.hillellit.lms;

import ua.hillellit.lms.exceptions.ArrayDataException;
import ua.hillellit.lms.exceptions.ArraySizeException;

public class ArrayValueCalculator {

  public static void main(String[] args) {
    String[][] strAr = {{"1","2","3","4"},{"1","5","6","7"},{"2","7","8","9"},{"3","edc","8","7"}};

    try {
      System.out.println(doCalc(strAr));
    } catch (ArraySizeException e) {
      System.out.println(e.getMessage());
    } catch (ArrayDataException e){
      System.out.println(e.getMessage());
    }

  }

  static int doCalc(String[][] ar) throws ArraySizeException, ArrayDataException {
    if (ar.length != 4) {
      throw new ArraySizeException("Масив повинен бути 4 на 4 ");
    }
    for (int i = 0; i < ar.length; i++) {
      if (ar[i].length != 4) {
        throw new ArraySizeException("Масив повинен бути 4 на 4 ");
      }
    }
    int sumAllElements=0;
    int x;
    for (int i=0;i<ar.length;i++){
      for (int j=0;j<ar[i].length;j++){
        try{
        x =Integer.parseInt(ar[i][j]);}
        catch (NumberFormatException e){
          throw new ArrayDataException(i+1,j+1);
        }
        sumAllElements+=x;
      }

    }
    return sumAllElements;
  }

}

