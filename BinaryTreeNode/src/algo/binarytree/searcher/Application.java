package algo.binarytree.searcher;

import java.io.FileWriter;
import java.io.IOException;

import algo.binarytree.node.BinaryTreeNode;
import algo.binarytree.parser.BinaryTreeParserRecursive;
import algo.binarytree.searcher.interfaces.IBinarySearchTreeSearchMethod.OccurrenceStrategy;

public class Application {

	public static void main(String[] args) {
		BinaryTreeParserRecursive<Integer> parser = new BinaryTreeParserRecursive<Integer>();

		RecursiveSearcher<Integer> searcher = new RecursiveSearcher<Integer>();
		
		
		BinaryTreeNode<Integer> parent = new BinaryTreeNode<Integer>(5);
		parent.setLeftChild(new BinaryTreeNode<Integer>(3));
		parent.getLeftChild().setLeftChild(new BinaryTreeNode<Integer>(2));
		parent.getLeftChild().setRightChild(new BinaryTreeNode<Integer>(4));
		parent.setRightChild(new BinaryTreeNode<Integer>(6));
		
		//searcher.search(OccurrenceStrategy.FIRST, parent, 3, args);
	}
}
