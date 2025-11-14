import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BSTree <E, K> {
    private BSTNode<E, K> root;
    private Comparator<K> cmp;

    public BSTree(Comparator<K> cmp) {
        this.root = null;
        this.cmp = cmp;
    }

    public BSTNode<E, K> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<E, K> root) {
        this.root = root;
    }

    public Comparator<K> getCmp() {
        return cmp;
    }

    public void setCmp(Comparator<K> cmp) {
        this.cmp = cmp;
    }

    // --- BUSCAR ---

    public E buscar(K keyBuscar) {
        return buscarRecursivo(this.root, keyBuscar);
    }

    private E buscarRecursivo(BSTNode<E, K> nodoActual, K keyBuscar) {

        if (nodoActual == null) {
            return null;
        }

        K claveActual = nodoActual.getKey();
        int resultado = this.cmp.compare(keyBuscar, claveActual);

        if (resultado == 0) {
            return nodoActual.getContent();
        }

        else if (resultado < 0) {
            BSTree<E, K> subTree = nodoActual.getLeft();
            if (subTree != null) {
                return buscarRecursivo(subTree.getRoot(), keyBuscar);
            }
            return null;
        }

        else {
            BSTree<E, K> subTree = nodoActual.getRight();
            if (subTree != null) {
                return buscarRecursivo(subTree.getRoot(), keyBuscar);
            }
            return null;
        }
    }

    // --- INSERTAR ---

    public void insertar(E content, K key) {
        if (this.root == null) {
            this.root = new BSTNode<>(content, key);
            return;
        }
        insertarRecursivo(this.root, content, key);
    }

    private void insertarRecursivo(BSTNode<E, K> nodoActual, E content, K key) {

        K claveActual = nodoActual.getKey();
        int comparacion = this.cmp.compare(key, claveActual);

        if (comparacion == 0) {
            nodoActual.setContent(content);
            return;
        }

        else if (comparacion < 0) {
            BSTree<E, K> subArbolIzquierdo = nodoActual.getLeft();

            if (subArbolIzquierdo == null) {
                BSTree<E, K> nuevoSubArbol = new BSTree<>(this.cmp);
                nuevoSubArbol.setRoot(new BSTNode<>(content, key));
                nodoActual.setLeft(nuevoSubArbol);
                return;
            }

            insertarRecursivo(subArbolIzquierdo.getRoot(), content, key);

        } else {
            BSTree<E, K> subArbolDerecho = nodoActual.getRight();

            if (subArbolDerecho == null) {
                BSTree<E, K> nuevoSubArbol = new BSTree<>(this.cmp);
                nuevoSubArbol.setRoot(new BSTNode<>(content, key));
                nodoActual.setRight(nuevoSubArbol);
                return;
            }

            insertarRecursivo(subArbolDerecho.getRoot(), content, key);
        }
    }

    // --- ELIMINAR ---

    public void eliminar(K key) {
        eliminarRecursivo(this, key);
    }

    private void eliminarRecursivo(BSTree<E, K> subTree, K key) {

        if (subTree == null || subTree.getRoot() == null) {
            return;
        }

        BSTNode<E, K> nodoActual = subTree.getRoot();
        K claveActual = nodoActual.getKey();
        int comparacion = this.cmp.compare(key, claveActual);

        if (comparacion < 0) {
            eliminarRecursivo(nodoActual.getLeft(), key);
        }

        else if (comparacion > 0) {
            eliminarRecursivo(nodoActual.getRight(), key);
        }

        else {

            if (nodoActual.getLeft() == null) {
                subTree.setRoot(nodoActual.getRight() != null ? nodoActual.getRight().getRoot() : null);
                return;
            }
            if (nodoActual.getRight() == null) {
                subTree.setRoot(nodoActual.getLeft().getRoot());
                return;
            }

            BSTNode<E, K> sucesor = encontrarMin(nodoActual.getRight().getRoot());

            nodoActual.setKey(sucesor.getKey());
            nodoActual.setContent(sucesor.getContent());

            eliminarRecursivo(nodoActual.getRight(), sucesor.getKey());
        }
    }

    private BSTNode<E, K> encontrarMin(BSTNode<E, K> nodo) {
        while (nodo.getLeft() != null && nodo.getLeft().getRoot() != null) {
            nodo = nodo.getLeft().getRoot();
        }
        return nodo;
    }
}