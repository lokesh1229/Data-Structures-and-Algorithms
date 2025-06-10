import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

public class BinaryTrees {
    
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static List<List<Integer>> levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> a = new LinkedList<>();
        if(root==null){
            return a;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> l = new LinkedList<Integer>();
            for(int i=0;i<level;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                l.add(q.poll().data);
            }
            a.add(l);
        }
        return a;
    }

    public static int maximumDepth(Node root){
        if(root==null){
            return 0;
        }
        int lh = maximumDepth(root.left);
        int rh = maximumDepth(root.right);
        return Math.max(lh, rh)+1;
    }

    public static int iterativeMaxDepth(Node root){
        int d = 0;
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> a = new LinkedList<>();
        if(root==null){
            return d;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> l = new LinkedList<Integer>();
            d++;
            for(int i=0;i<level;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                l.add(q.poll().data);
            }
            a.add(l);
        }
        return d;

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        System.out.println(levelorder(root));
        System.out.println(maximumDepth(root));
        System.out.println(iterativeMaxDepth(root));
        
    }
}
