import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Uma empresa que implementar um novo sistema de backup no qual arquivos são guardados em fitas de dados
 * <p>
 * O novo sistema deve seguir as duas seguintes regras:
 * 1- Nunca colocar mais de dois arquivos na mesma fita.
 * 2- Os arquivos não podem ser divididos entre multiplas fitas.
 * <p>
 * É garantido que todas as fitas tenham o mesmo tamanho e que eals sempre serão capazes de guardar o maior arquivo.
 * Toda vez que este processor for executado, nós ja saberemos o tamanho de cada arquivo e a capacidade da fita.
 * Com isso em mente, desenho uma soluçã oqeu seja capaz de contar quantas fitas serão requeridas para guardar o backup da forma mais eficiente.
 * O parâmetro de sua função será uma estrutura que contera o tamanho dos arquivos e a capacidade da fita.
 * Você deve retornar a quantidade minima de fitas requeridas para guardar os arquivos.
 * <p>
 * Exemplo:
 * Input: Tape Size = 100; Fita: 70, 10, 20
 * Output: 2
 */

public class BackSystem {


    public interface Batch {
        int[] gerFileSizes();

        int getTapeSize();
    }

    private static class newBatch implements Batch {
        @Override
        public int[] gerFileSizes() {
            return new int[]{
                    70, 10, 20, 40, 50, 60, 50, 100, 100
            };
        }

        @Override
        public int getTapeSize() {
            return 100;
        }
    }

    private class Tape{
        private int stored;
        private int numberOfFiles;

        public Tape(int stored) {
            this.stored = stored;
            this.numberOfFiles = 1;
        }

        public int getStored() {
            return stored;
        }

        public void addStorage(int storage){
            this.stored += storage;
        }

        public int getNumberOfFiles() {
            return numberOfFiles;
        }

        public void addFile(){
            this.numberOfFiles++;
        }
    }

    public int minNumberOfTapes(Batch batch) {
        int[] fileSizes = batch.gerFileSizes();
        Arrays.sort(fileSizes);

        int numberOfTapes = 0;
        List<Tape> list = new ArrayList<>();

        for(int i = fileSizes.length - 1; i >= 0; i--){
            boolean storage = false;

            for(Tape tape : list){
                if (((tape.getStored() + fileSizes[i]) <= batch.getTapeSize()) && (tape.getNumberOfFiles() < 2)) {
                    tape.addStorage(fileSizes[i]);
                    tape.addFile();
                    storage = true;
                    break;
                }
            }

            if(!storage){
                numberOfTapes++;
                list.add(new Tape(fileSizes[i]));
            }
        }


        return numberOfTapes;
    }

    static void main(String[] args) {

        BackSystem backSystem = new BackSystem();
        Batch batch = new newBatch();

        System.out.println(backSystem.minNumberOfTapes(batch));

    }

}
