public class Rules {
    public byte [][] dataCopy  = new byte[20][10];
    byte [][] sortedData = new byte[20][10];

    public void isQual(byte first_position, byte second_position) {
        if (first_position == second_position) {
            System.out.println("equals");
        }
    }

    public void paintArray() {
        for (byte indiceLinha = 0; indiceLinha < 20; indiceLinha++) {
            for (byte indiceColuna = 0; indiceColuna <= 8; indiceColuna++) {
                if (Data.data[indiceLinha][indiceColuna] == Data.data[indiceLinha][indiceColuna + 1])
                    paintLineEqualPositions(indiceLinha, indiceColuna);
                if (indiceLinha >= 1) {
                    if (Data.data[indiceLinha][indiceColuna] == Data.data[indiceLinha - 1][indiceColuna])
                        paintEqualsColumnsPositions(indiceLinha, indiceColuna);
                }
            }
        }
    }

    public void paintLineEqualPositions(byte linePosition, byte columnPosition) {
        dataCopy[linePosition][columnPosition] = (byte) 6;
        dataCopy[linePosition][columnPosition + 1] = (byte) 6;
    }

    public void paintEqualsColumnsPositions(byte linePosition, byte columnPosition) {
        dataCopy[linePosition][columnPosition]=(byte)6;
        dataCopy[linePosition-1][columnPosition]=(byte)6;
    }

    public void copyPaintedCellsToMainArray(){
        for (byte i = 0; i < 20; i++) {
            for (byte j = 0; j < 10; j++) {
               if (dataCopy[i][j] == 6){
                   Data.data[i][j] = dataCopy[i][j];
               }
            }
        }
    }

    public void printArrayAfterCoping(){
        System.out.println();
        System.out.println("==================================================== \n" +
                "ARRAY AFTER PAINTING WITH BLACK");
        for (byte i = 0; i < 20; i++){
            for (byte j = 0; j < 10; j++){
                System.out.print(Data.data[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public void sortArray() {
        byte indexLine=0, for_k=0;
        for (byte j = 0; j < 10; j++) {
            for (byte i = 0; i < 19; i++) {
                indexLine = (byte) (i + 1);
                for (byte k = indexLine; k < 20 ; k++){
                    if (Data.data[k][j] < Data.data[i][j]) {
                        for_k = k;
                        swap(j,i,for_k);
                    }
                }
            }
        }
    }

    public void swap( byte j, byte i, byte for_k){
        byte minIndex = Data.data[for_k][j];
        Data.data[for_k][j] = Data.data[i][j];
        Data.data[i][j] = minIndex;
    }

    public static void main(String[] args) {
        Data d = new Data();
        Rules r = new Rules();
        d.random_value();
        d.fillArray();
        r.paintArray();
        r.copyPaintedCellsToMainArray();
        r.printArrayAfterCoping();
        r.sortArray();

        System.out.println();
        System.out.println("==================================================== \n" +
                "ARRAY AFTER Sorting");
        for (byte i = 0; i < 20; i++){
            for (byte j = 0; j < 10; j++){
                System.out.print(d.data[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
