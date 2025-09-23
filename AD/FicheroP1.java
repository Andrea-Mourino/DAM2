import java.io.File;
import java.io.IOException;

public class FicheroP1 {

    // 1) Detecta se é directorio
    public static String eDirectorio(String ruta) {
        File f = new File(ruta);
        if (f.isDirectory()) {
            return "é directorio";
        } else {
            return "non é directorio";
        }
    }

    // 2) Detecta se é ficheiro
    public static String eFicheiro(String ruta) {
        File f = new File(ruta);
        if (f.isFile()) {
            return "é ficheiro";
        } else {
            return "non é ficheiro";
        }
    }

    // 3) Crea directorio se non existe
    public static void creaDirectorio(String ruta) {
        File dir = new File(ruta);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directorio creado.");
            } else {
                System.out.println("Non se puido crear o directorio.");
            }
        } else {
            System.out.println("O directorio xa existe.");
        }
    }

    // 4) Crea ficheiro dentro dun directorio existente
    public static void creaFicheiro(String dirName, String fileName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            File ficheiro = new File(dir, fileName);
            if (!ficheiro.exists()) {
                try {
                    if (ficheiro.createNewFile()) {
                        System.out.println("Ficheiro creado.");
                    }
                } catch (IOException e) {
                    System.out.println("Erro creando o ficheiro: " + e.getMessage());
                }
            } else {
                System.out.println("O ficheiro xa existe.");
            }
        } else {
            System.out.println("O directorio non existe.");
        }
    }

    // 5) Comprobar permisos de acceso
    public static void modoAcceso(String dirName, String fileName) {
        File f = new File(dirName, fileName);
        if (f.exists()) {
            System.out.println("escritura " + (f.canWrite() ? "si" : "non"));
            System.out.println("lectura " + (f.canRead() ? "si" : "non"));
        } else {
            System.out.println("O ficheiro non existe.");
        }
    }

    // 6) Lonxitude en bytes
    public static void calculaLonxitude(String dirName, String fileName) {
        File f = new File(dirName, fileName);
        if (f.exists()) {
            System.out.println("Lonxitude: " + f.length() + " bytes");
        } else {
            System.out.println("O ficheiro non existe.");
        }
    }

    // 7) Poñer como só lectura
    public static void mLectura(String dirName, String fileName) {
        File f = new File(dirName, fileName);
        if (f.exists()) {
            if (f.setReadOnly()) {
                System.out.println("O ficheiro agora é só lectura.");
            } else {
                System.out.println("Non se puido cambiar a só lectura.");
            }
        } else {
            System.out.println("O ficheiro non existe.");
        }
    }

    // 8) Poñer como escritura posible
    public static void mEscritura(String dirName, String fileName) {
        File f = new File(dirName, fileName);
        if (f.exists()) {
            if (f.setWritable(true)) {
                System.out.println("O ficheiro agora é editable.");
            } else {
                System.out.println("Non se puido cambiar a editable.");
            }
        } else {
            System.out.println("O ficheiro non existe.");
        }
    }

    // 9) Borrar ficheiro
    public static void borraFicheiro(String dirName, String fileName) {
        File f = new File(dirName, fileName);
        if (f.exists()) {
            if (f.delete()) {
                System.out.println("Ficheiro eliminado.");
            } else {
                System.out.println("Non se puido eliminar o ficheiro.");
            }
        } else {
            System.out.println("Ficheiro inexistente");
        }
    }

    // 10) Borrar directorio
    public static void borraDirectorio(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            if (dir.delete()) {
                System.out.println("Directorio eliminado.");
            } else {
                System.out.println("Ruta inexistente ou con descendencia.");
            }
        } else {
            System.out.println("Ruta inexistente ou non é directorio.");
        }
    }

    // 11) Amosar contido dun directorio (primeiro nivel)
    public static void mContido(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            String[] contido = dir.list();
            if (contido != null) {
                for (String nome : contido) {
                    System.out.println(nome);
                }
            }
        } else {
            System.out.println("Ruta inexistente ou non é directorio.");
        }
    }

    // 12) Recorrer recursivamente
    public static void recur(File f) {
        if (f.isDirectory()) {
            System.out.println("[DIR] " + f.getAbsolutePath());
            File[] files = f.listFiles();
            if (files != null) {
                for (File sub : files) {
                    recur(sub);
                }
            }
        } else {
            System.out.println("    [FILE] " + f.getAbsolutePath());
        }
    }

    // Pequeno main de proba
    public static void main(String[] args) {
        // Exemplo: cambia as rutas polo teu sistema
        System.out.println(eDirectorio("C:\\Users"));
        System.out.println(eFicheiro("C:\\Users\\Public\\documento.txt"));

        creaDirectorio("C:\\ProbaJava");
        creaFicheiro("C:\\ProbaJava", "test.txt");

        modoAcceso("C:\\ProbaJava", "test.txt");
        calculaLonxitude("C:\\ProbaJava", "test.txt");

        mLectura("C:\\ProbaJava", "test.txt");
        mEscritura("C:\\ProbaJava", "test.txt");

        mContido("C:\\ProbaJava");

        // recur(new File("C:\\ProbaJava"));

        // borraFicheiro("C:\\ProbaJava", "test.txt");
        // borraDirectorio("C:\\ProbaJava");
    }
}
