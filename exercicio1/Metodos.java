package exercicio1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Alba
 */
public class Metodos {
    /*
     1) crear o directorio 'arquivosdir' na ruta '/home/oracle/NetBeansProjects/arquivos/' sempre e cando dito directorio non exista.
     comprobar que a ruta foi creada ou existe mediante o comandos do sistema operativo
     */

    public static void crearDirectorio() {
        File directorio = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir");
        directorio.mkdirs();
    }

    /*
     2) crear  o arquivo Products1.txt no directorio mencionado anteriormente (arquivosdir) sempre e cando dito arquivo non exista. 
     comprobar que o arquivo foi creado ou existe mediante comandos do sistema operativo
     */
    public static void crearArquivo() throws IOException {
        File arquivo = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        if (arquivo.createNewFile()) {
            System.out.println("Creouse un arquivo");
        } else {
            System.out.println("O arquivo xa existe");
        }
    }

    /*
     3) comprobar que a ruta foi creada mediante o metodo da clase File axeitado 
     comprobar que o arquivo foi creado mediante o metodo da clase File axeitado
     */
    public static void comprobarRutaArq() {
        Path ruta = Paths.get("/home/oracle/NetBeansProjects/arquivos/arquivosdir");
        if (Files.exists(ruta)) {
            System.out.println("A ruta xa existe.");
        } else {
            System.out.println("A ruta non existe.");
        }

        Path rutaArq = Paths.get("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        if (Files.exists(rutaArq)) {
            System.out.println("O arquivo xa existe.");
        } else {
            System.out.println("O arquivo non existe.");
        }
    }

    /*
     4)crear o directorio 'subdir'  na ruta '/home/oracle/NetBeansProjects/arquivos/arquivosdir/' creada anteriormente
     crear o arquivo Products2.txt no directorio mencionado anteriormente (subdir) sempre e cando dito arquivo non exista. 
     */
    public static void crearSubDirectorioeArquivo() throws IOException {
        File subdirectorio = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/subdir");
        subdirectorio.mkdir();

        File arquivo2 = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products2.txt");

        if (arquivo2.createNewFile()) {
            System.out.println("Creouse un arquivo");
        } else {
            System.out.println("O arquivo xa existe");
        }
    }

    /*
     5)amosar arquivos e subdirectorios do directorio creado '/home/oracle/NetBeansProjects/arquivos/arquivosdir/'
     utilizar para elo o metodo da clase File axeitado : debería verse o seguinte resultado:
     Products1.txt
     subdir
     */
    public static void amosarArqDir() throws IOException {
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/");
        File[] arquivos = f.listFiles();
        for (File arquivo : arquivos) {
            System.out.println(arquivo.getName());
        }

        if (arquivos == null) {
            System.out.println("Directorio sen arquivos.");
        }
    }
    
    /*
    6)utilizando  os metodos axeitados amosar a ruta que corresponde ao 
    primeiro  directorio creado:
    */
    public static void amosarRutaDir() {
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/");
        System.out.println(f.getAbsolutePath());
    }

    /*
     7)utilizando  os metodos axeitados amosar a seguinte informacion sobre o primeiro obxecto arquivo creado:
     nome
     ruta
     si e posible ou non escribir nel
     si e posible ou non ler del
     a sua lonxitude en bytes (para isto escribir no arquivo mediante calquerea editor de texto  ,  o texto 'ola')
     */
    public static void amosarInfoArq1() {
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");
        System.out.println(f.getName() + "\n" + f.getAbsolutePath() + "\nTamaño en bytes: " + f.length());

        if (f.canWrite()) {
            System.out.println("É posible escribir nel.");
        } else {
            System.out.println("Non é posible escribir nel.");
        }

        if (f.canRead()) {
            System.out.println("É posible ler del.");
        } else {
            System.out.println("Non é posible ler del.");
        }
    }

    /*
     8) forzar a que o mesmo arquivo referido no apartado anterior sexa de so lectura
     */
    public static void forzarSoLectura() {
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");

        //si existe el archivo...
        if (f.exists()) {
            f.setReadOnly(); //poner solo lectura
        }
    }

    /*
     9)forzar a que o arquivo referido no apartado anterior pase de novo a ser de novo de escritura
     comprobar dende o sistema operativo que se pode ler do arquivo
     */
    public static void pasarAEscritura() {
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");

        //si existe el archivo
        if (f.exists()) {
            f.setWritable(true, false); //pasa a escritura para todos los usuarios
        }
    }

    /*
     10)borrar o arquivo referido no apartado anterior
     comprobar dende o sistema operativo que o arquivo foi borrado
     */
    public static void borrarArq1() {
        File f = new File("/home/oracle/NetBeansProjects/arquivos/arquivosdir/Products1.txt");

        if (f.exists()) {
            f.delete();
            System.out.println("Arquivo borrado.");
        }
    }

    /*
     11)borrar os o resto de arquivos e directorios creados anteriormente
     */
    public static void borrarTodo(File f) {
        File[] contidos = f.listFiles();
        if (contidos != null) {
            for (File file : contidos) {
                borrarTodo(file);

            }
        }
        f.delete();
        System.out.println("Directorios e arquivos borrados.");
    }
}
