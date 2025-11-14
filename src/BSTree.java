import java.util.Comparator;

public class BSTree <E, K>{
    private BSTNode<E,K> root;
    private Comparator<K> cmp;

    public BSTree(BSTNode<E, K> root, Comparator<K> cmp) {
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
}
