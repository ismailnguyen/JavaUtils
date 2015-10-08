package algo.binarytree.util;

import java.io.FileWriter;
import java.io.IOException;

import algo.binarytree.node.BinaryTreeNode;
import algo.binarytree.parser.BinaryTreeParserRecursive;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeParserRecursive<Integer> parser = new BinaryTreeParserRecursive<Integer>();

		BinaryTreePrinterAscii<Integer> printer = new BinaryTreePrinterAscii<Integer>();
		
		BinaryTreeNode<Integer> parent = new BinaryTreeNode<Integer>(5);
		parent.setLeftChild(new BinaryTreeNode<Integer>(3));
		parent.getLeftChild().setLeftChild(new BinaryTreeNode<Integer>(2));
		parent.getLeftChild().setRightChild(new BinaryTreeNode<Integer>(4));
		parent.setRightChild(new BinaryTreeNode<Integer>(6));
		
		try {
			printer.print(parent, new FileWriter("test.txt"), parser);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
