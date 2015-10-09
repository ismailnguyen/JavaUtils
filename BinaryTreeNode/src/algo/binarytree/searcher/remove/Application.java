package algo.binarytree.searcher.remove;

import algo.binarytree.node.BinaryTreeNode;
import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IBinaryTreeParser.ParseMethod;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.searcher.RecursiveSearcher;

public class Application {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> parent = new BinaryTreeNode<Integer>(5);
		parent.setLeftChild(new BinaryTreeNode<Integer>(3));
		parent.getLeftChild().setLeftChild(new BinaryTreeNode<Integer>(2));
		parent.getLeftChild().getLeftChild().setLeftChild(new BinaryTreeNode<Integer>(2));
		parent.getLeftChild().setRightChild(new BinaryTreeNode<Integer>(4));
		parent.setRightChild(new BinaryTreeNode<Integer>(6));

		//IBinarySearchTreeSearcher<Integer> searcher = new RecursiveSearcher<Integer>(new IntegerComparator());

		/*.... Suppresion de TOUTES les noeuds ayant pour valeur 2 .... */
		
		IParseWork<Integer> work = new IParseWork<Integer>() {
			public void execute(IBinaryTreeNode<Integer> node, int level, String path) {
				System.out.print(node.getValue()+" ");
			}
		};
		
		IParseWork<Integer> operations[] = new IParseWork[] {work};
	
		//parser.parse(parent, ParseMethod.INFIX, operations);

	}

}
