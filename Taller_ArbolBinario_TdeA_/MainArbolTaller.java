import java.util.Scanner;

public class MainArbolTaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion;

        do {
            System.out.println("\n--- MENÚ ÁRBOL BINARIO ---");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Recorrido InOrden");
            System.out.println("3. Recorrido PreOrden");
            System.out.println("4. Recorrido PostOrden");
            System.out.println("5. Buscar nodo");
            System.out.println("6. Mostrar altura del árbol");
            System.out.println("7. Contar nodos hoja");
            System.out.println("8. Eliminar nodo");
            System.out.println("9. Vaciar árbol");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese valor: ");
                    int valor = sc.nextInt();
                    arbol.agregar(valor);
                    break;
                case 2:
                    arbol.inOrden();
                    break;
                case 3:
                    arbol.preOrden();
                    break;
                case 4:
                    arbol.postOrden();
                    break;
                case 5:
                    System.out.print("Valor a buscar: ");
                    int buscar = sc.nextInt();
                    System.out.println(arbol.buscar(buscar) ? "Existe" : "No existe");
                    break;
                case 6:
                    System.out.println("Altura: " + arbol.altura());
                    break;
                case 7:
                    System.out.println("Nodos hoja: " + arbol.contarHojas());
                    break;
                case 8:
                    System.out.print("Valor a eliminar: ");
                    int eliminar = sc.nextInt();
                    arbol.eliminar(eliminar);
                    break;
                case 9:
                    arbol.vaciar();
                    System.out.println("Árbol vaciado.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            

        } while (opcion != 0);

        sc.close();
    }
}

