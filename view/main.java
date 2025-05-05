package GestionFicherosRomaForns.view;


import GestionFicherosRomaForns.model.Funciones;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String path, fileName, content;

        do {
            System.out.println("\n--- GESTIÓN DE FICHEROS ---");
            System.out.println("1. Crear carpeta");
            System.out.println("2. Crear archivo");
            System.out.println("3. Mostrar archivos de carpeta");
            System.out.println("4. Mostrar contenido de archivo");
            System.out.println("5. Sobrescribir archivo");
            System.out.println("6. Borrar archivo");
            System.out.println("7. Contar caracteres");
            System.out.println("8. Contar palabras");
            System.out.println("9. Reemplazar palabra");
            System.out.println("10. Exportar PDF");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = Integer.parseInt(sc.nextLine());

            try {
                switch (option) {
                    case 1:
                        System.out.print("Nombre carpeta: ");
                        Funciones.createFolder(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Nombre archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Contenido: ");
                        content = sc.nextLine();
                        Funciones.createFile(path, fileName, content);
                        break;
                    case 3:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        String[] files = Funciones.showListFiles(path);
                        for (String f : files) System.out.println(f);
                        break;
                    case 4:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.println(Funciones.showFile(path, fileName));
                        break;
                    case 5:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Nuevo contenido: ");
                        content = sc.nextLine();
                        boolean success = Funciones.overWriteFile(path, fileName, content);
                        if (!success) System.out.println("Archivo no encontrado.");
                        break;
                    case 6:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        Funciones.deleteFile(path, fileName);
                        break;
                    case 7:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Caracteres: " + Funciones.countChars(path, fileName));
                        break;
                    case 8:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Palabras: " + Funciones.countWords(path, fileName));
                        break;
                    case 9:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Palabra a cambiar: ");
                        String oldWord = sc.nextLine();
                        System.out.print("Palabra nueva: ");
                        String newWord = sc.nextLine();
                        System.out.println(Funciones.swapWords(path, fileName, oldWord, newWord));
                        break;
                    case 10:
                        System.out.print("Ruta: ");
                        path = sc.nextLine();
                        System.out.print("Archivo: ");
                        fileName = sc.nextLine();
                        Funciones.printPDF(path, fileName);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
            }
        } while (option != 0);
        sc.close();
    }
}