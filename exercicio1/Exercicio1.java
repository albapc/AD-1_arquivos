package exercicio1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Alba
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        Metodos.crearDirectorio();
//        Metodos.crearArquivo();
//        Metodos.crearSubDirectorioeArquivo();
//        Metodos.amosarArqDir();
//        Metodos.comprobarRutaArq();
//        Metodos.amosarRutaDir();
//        Metodos.forzarSoLectura();
//        Metodos.pasarAEscritura();
//        Metodos.amosarInfoArq1();
//        Metodos.borrarArq1();
//
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/");
        Metodos.borrarTodo(f);
    }

}
