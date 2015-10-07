package algo.binarytree.parser.works;

import algo.binarytree.node.BinaryTreeNode;
import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.BinaryTreeParserRecursive;
import algo.binarytree.parser.interfaces.IBinaryTreeParser.ParseMethod;
import algo.binarytree.parser.interfaces.IParseWork;

public class Application {

	public static void main(String[] args) {
		
		BinaryTreeParserRecursive<Integer> parser = new BinaryTreeParserRecursive<Integer>();

		BinaryTreeNode<Integer> parent = new BinaryTreeNode<Integer>(5);
		parent.setLeftChild(new BinaryTreeNode<Integer>(3));
		parent.getLeftChild().setLeftChild(new BinaryTreeNode<Integer>(2));
		parent.getLeftChild().setRightChild(new BinaryTreeNode<Integer>(4));
		parent.getLeftChild().getLeftChild().setRightChild(new BinaryTreeNode<Integer>(7));
		parent.getLeftChild().getLeftChild().getRightChild().setRightChild(new BinaryTreeNode<Integer>(7));

		TreeHeightWork<Integer> height = new TreeHeightWork<Integer>();
		TreeKindWork<Integer> kind = new TreeKindWork<Integer>();
		DepthAverageExtern<Integer> depth = new DepthAverageExtern<Integer>();
		PathLengthExternal<Integer> extern = new PathLengthExternal<Integer>();
		PathLengthInternal<Integer> intern = new PathLengthInternal<Integer>();
		IParseWork<Integer>[] operations = new IParseWork[] {
				height,
				kind ,
				depth ,
				extern ,
				intern
		};
		parser.parse(parent, ParseMethod.INFIX, operations);
		
		System.out.println(height.getTreeHeight());
		System.out.println(kind.getTreeKind());
		System.out.println(depth.getAvegareExternalDepth());
		System.out.println(extern.getExternalPathLength());
		System.out.println(intern.getInternalPathLength());
	}

}

