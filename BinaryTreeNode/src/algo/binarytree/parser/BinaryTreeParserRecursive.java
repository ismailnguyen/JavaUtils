package algo.binarytree.parser;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IBinaryTreeParser;
import algo.binarytree.parser.interfaces.IParseWork;

public class BinaryTreeParserRecursive<T> implements IBinaryTreeParser<T> {

    @Override
    public void parse(IBinaryTreeNode<T> arg0, ParseMethod arg1, IParseWork<T>[] arg2) {

        if(arg0 == null)
            return;

        if(arg1 == ParseMethod.INFIX)
        {
            parse(arg0.getLeftChild(), arg1, arg2);
            arg2[0].execute(arg0, 0, "");
            parse(arg0.getRightChild(), arg1, arg2);
        }
        else if(arg1 == ParseMethod.PREFIX){
        	arg2[0].execute(arg0, 0, "");
            parse(arg0.getLeftChild(), arg1, arg2);
            parse(arg0.getRightChild(), arg1, arg2);
        }
        else if (arg1 == ParseMethod.SUFFIX)
        {
        	parse(arg0.getLeftChild(), arg1, arg2);
        	parse(arg0.getRightChild(), arg1, arg2);
            arg2[0].execute(arg0, 0, "");
        }
    }
}
