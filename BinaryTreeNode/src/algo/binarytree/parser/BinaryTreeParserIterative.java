package algo.binarytree.parser;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IBinaryTreeParser;
import algo.binarytree.parser.interfaces.IParseWork;

public class BinaryTreeParserIterative<T> implements IBinaryTreeParser<T> {

	@Override
    public void parse(IBinaryTreeNode<T> arg0, ParseMethod arg1, IParseWork<T>[] arg2) {
                
        if(arg0 == null || arg2 == null)
            return;
                
		IBinaryTreeNode<T> prev = null;
		IBinaryTreeNode<T> current = arg0;
		IBinaryTreeNode<T> next = null;
		
		if(arg1 == ParseMethod.INFIX){
			while(current!=null){
				if(prev==current.getParent()){
					prev = current ;
					next = current.getLeftChild();
				}
				if(next == null || prev == current.getLeftChild()){
					arg2[0].execute(current, 0, "");
					prev = current;
					next = current.getRightChild();
				}
				if(next == null || prev == current.getRightChild()){
					prev = current;
					next = current.getParent();
				}
				current = next;
			}
		}
		if(arg1 == ParseMethod.SUFFIX){
			while(current!=null){
				if(prev==current.getParent()){
					
					prev = current ;
					next = current.getLeftChild();
				}
				if(next == null || prev == current.getLeftChild()){
					
					prev = current;
					next = current.getRightChild();
				}
				if(next == null || prev == current.getRightChild()){
					arg2[0].execute(current, 0, "");
					prev = current;
					next = current.getParent();
				}
				current = next;
			}
		}
		if(arg1 == ParseMethod.PREFIX){
			while(current!=null){
				if(prev==current.getParent()){
					arg2[0].execute(current, 0, "");
					prev = current ;
					next = current.getLeftChild();
				}
				if(next == null || prev == current.getLeftChild()){
					
					prev = current;
					next = current.getRightChild();
				}
				if(next == null || prev == current.getRightChild()){
					
					prev = current;
					next = current.getParent();
				}
				current = next;
			}
		}
    }
}
