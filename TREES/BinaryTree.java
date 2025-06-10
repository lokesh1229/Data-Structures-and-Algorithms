import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data = key;
    }
}

public class BinaryTree {

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
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0;i<level;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                subList.add(q.poll().data);
            }
            ans.add(subList);
        }
        return ans;
    }

    public static int heightOfBinaryTree(Node root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
    }

    public static void printKdistances(Node root,int k){
        if(root == null){
            return;
        }
        if(k == 0){
            System.out.print(root.data+" ");
        }else{
            printKdistances(root.left, k-1);
            printKdistances(root.right, k-1);
        }
    }

    public static int sizeOfBinaryTree(Node root){
        if(root == null){
            return 0;
        }
        return 1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right);
    }

    public static int getMaximumValue(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data,Math.max(getMaximumValue(root.left), getMaximumValue(root.right)));
    }

    public static boolean childrenSumProperty(Node root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int sum = 0;
        if(root.left!=null){
            sum+=root.left.data;
        }
        if(root.right!=null){
            sum+=root.right.data;
        }
       return ((root.data == sum) && childrenSumProperty(root.left) && childrenSumProperty(root.right));
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
        System.out.print(levelorder(root));
        System.out.println();
        System.out.println(heightOfBinaryTree(root));
        printKdistances(root, 2);
        System.out.println();
        System.out.println(sizeOfBinaryTree(root));
        System.out.println(getMaximumValue(root));
    }
}