import java.util.List;

public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(5);

        binaryTree.addNode(3);
        binaryTree.addNode(7);
        binaryTree.addNode(1);
        binaryTree.addNode(4);
        binaryTree.addNode(6);
        binaryTree.addNode(8);
        /*
               트리 모양
                  5
              3       7
            1   4   6   8
         */

        System.out.println(binaryTree.size()); // 7

        System.out.println();
        System.out.println("====전위 순회=====");
        List<Integer> values = binaryTree.preOrder();
        for (Integer value : values) {
            System.out.printf("%d ", value); // 5 3 1 4 7 6 8
        }

        System.out.println();
        System.out.println("====중위 순회=====");
        values = binaryTree.inOrder();
        for (Integer value : values) {
            System.out.printf("%d ", value); // 1 3 4 5 6 7 8
        }

        System.out.println();
        System.out.println("====후위 순회=====");
        values = binaryTree.postOrder();
        for (Integer value : values) {
            System.out.printf("%d ", value); // 1 4 3 6 8 7 5
        }
    }
}
