package MainTest;

import Algorithm.DataElement;
import Algorithm.Node;
import Algorithm.Tree;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class MainTest{



    public static void main(String[] args) {
        var n1 = new Node(new DataElement(3));
        n1.add(new DataElement(2));
        var aL = new ArrayList<Integer>();
        System.out.println(aL.size());

        System.out.println("Priiiiiiiiint");
        System.out.println(n1);


        //TEST NODE
        System.out.println("TEST");
        System.out.println("CREATE TREE");
        var tree = new Tree(new DataElement(3));
        tree.add(new DataElement(7));
        tree.add(new DataElement(4));
        tree.add(new DataElement(9));
        tree.add(new DataElement(10));
        tree.add(new DataElement(0));
        tree.add(new DataElement(5));
        tree.add(new DataElement(6));
        tree.add(new DataElement(8));
        tree.add(new DataElement(2));
        tree.add(new DataElement(1));
        tree.add(new DataElement(20));
        tree.add(new DataElement(15));
        tree.add(new DataElement(14));
        tree.add(new DataElement(12));


        //System.out.println(tree.getRoot().getChildren()[1].getChildren()[0].getSiblings()[0].nodeDataElemnetsToString());


        System.out.println("PRINT TREE");
        //System.out.println(tree.getRoot().getChildren()[0]);
        System.out.println(tree);


    }


}