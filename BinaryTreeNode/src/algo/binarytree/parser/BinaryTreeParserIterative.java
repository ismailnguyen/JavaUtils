package algo.binarytree.parser;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.stack.LinkedStack;
import algo.stack.exception.StackEmptyException;
import algo.binarytree.parser.interfaces.IBinaryTreeParser;
import algo.binarytree.parser.interfaces.IParseWork;

public class BinaryTreeParserIterative<T> implements IBinaryTreeParser<T> {

	@Override
    public void parse(IBinaryTreeNode<T> arg0, ParseMethod arg1, IParseWork<T>[] arg2) {

        if(arg0 == null)
            return;
                
        LinkedStack<IBinaryTreeNode<T>> stack = new LinkedStack<IBinaryTreeNode<T>>();
        IBinaryTreeNode<T> current = arg0;
        boolean done = false;
        
        while(!done)
        {
        	if(current != null)
        	{
        		stack.push(current);
        		current = current.getLeftChild();
        	}
        	else
        	{
        		if(stack.isEmpty())
        		{
        			done = true;
        		}
        		else
        		{
        			try
        			{
						current = stack.peek();
						System.out.println(stack.pop());
					}
        			catch (StackEmptyException e)
        			{
						e.printStackTrace();
					}
        			
        			current = current.getRightChild();
        		}
        	}
        }
    }
}
