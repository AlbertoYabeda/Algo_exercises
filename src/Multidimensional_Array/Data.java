package Multidimensional_Array;

import static java.lang.Math.random;

public class Data {
     public static byte data [][] = new byte[20][10];

     public byte random_value (){
          byte value = (byte) Math.round(random()*5);

          return value;
     }

     public void fillArray(){
          for (byte i = 0; i < 20; i++){
               for (byte j = 0; j < 10; j++){
                    data[i][j] = random_value();
                    System.out.print(data[i][j]+"\t");
               }
               System.out.println();
          }
     }
}
