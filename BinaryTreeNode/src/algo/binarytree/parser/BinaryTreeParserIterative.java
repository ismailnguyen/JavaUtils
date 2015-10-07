package algo.binarytree.parser;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IBinaryTreeParser;
import algo.binarytree.parser.interfaces.IParseWork;

public class BinaryTreeParserIterative<T> implements IBinaryTreeParser<T> {

	@Override
    public void parse(IBinaryTreeNode<T> iBinaryTreeNode, ParseMethod parseMethod, IParseWork<T>[] iParseWorks) {

        if(iBinaryTreeNode == null)
            return;
                
        if(parseMethod == ParseMethod.INFIX){
        	IBinaryTreeNode<T> current = iBinaryTreeNode.getLeftChild();
            while(current != null)
            {
            	iParseWorks[0].execute(current, 0, "");
            	current = current.getRightChild();
            }
        }else if(parseMethod == ParseMethod.PREFIX){
        	IBinaryTreeNode<T> current = iBinaryTreeNode.getLeftChild();
            while(current != null)
            {
            	current = current.getRightChild();
            	iParseWorks[0].execute(current, 0, ""); 	
            }
        }else if (parseMethod == ParseMethod.SUFFIX){
        	IBinaryTreeNode<T> current = iBinaryTreeNode.getRightChild();
            while(current != null)
            {
            	iParseWorks[0].execute(current, 0, "");
            	current = current.getLeftChild();
            }
        }
    }
}
