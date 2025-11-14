public class BSTNode <E, K>{
    private E content;
    private K key;
    private BSTree<E,K> left;
    private BSTree<E,K> right;

    public BSTNode(E content, K key) {
        this.content = content;
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BSTree<E, K> getLeft() {
        return left;
    }

    public void setLeft(BSTree<E, K> left) {
        this.left = left;
    }

    public BSTree<E, K> getRight() {
        return right;
    }

    public void setRight(BSTree<E, K> right) {
        this.right = right;
    }
}
