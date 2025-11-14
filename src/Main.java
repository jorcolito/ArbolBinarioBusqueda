import java.util.Comparator;

public class Main {
    static void main() {

        Comparator<Integer> comparadorEntero = (o1, o2) -> o1.compareTo(o2);

        BSTree<String, Integer> arbolClientes = new BSTree<>(comparadorEntero);

        arbolClientes.insertar("Registro 100", 100);
        arbolClientes.insertar("Registro 50", 50);
        arbolClientes.insertar("Registro 150", 150);
        arbolClientes.insertar("Registro 25", 25);
        arbolClientes.insertar("Registro 75", 75);
        arbolClientes.insertar("Registro 125", 125);
        arbolClientes.insertar("Registro 175", 175);
        arbolClientes.insertar("Actualizar 50", 50);


        String resultado1 = arbolClientes.buscar(50);
        System.out.println("Buscar 50: " + resultado1);

        String resultado2 = arbolClientes.buscar(99);
        System.out.println("Buscar 99: " + (resultado2 == null ? "OK (null)" : "ERROR"));

        arbolClientes.eliminar(100);

        String nuevaRaiz = arbolClientes.buscar(125);
        System.out.println("Nueva Raíz (125): " + (nuevaRaiz != null ? "OK" : "ERROR"));

        String eliminado = arbolClientes.buscar(100);
        System.out.println("Buscar 100: " + (eliminado == null ? "OK (null)" : "ERROR"));
    }
}