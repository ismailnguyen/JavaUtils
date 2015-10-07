package algo.binarytree.parser;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IBinaryTreeParser;
import algo.binarytree.parser.interfaces.IParseWork;

public class BinaryTreeParserRecursive<T> implements IBinaryTreeParser<T> {

    @Override
    public void parse(IBinaryTreeNode<T> iBinaryTreeNode, ParseMethod parseMethod, IParseWork<T>[] iParseWorks) {

        if(iBinaryTreeNode == null)
            return;

        if(parseMethod == ParseMethod.INFIX){
            parse(iBinaryTreeNode.getLeftChild(), parseMethod, iParseWorks);
            //iBinaryTreeNode.getValue();
            iParseWorks[0].execute(iBinaryTreeNode, 0, "");
            parse(iBinaryTreeNode.getRightChild(), parseMethod, iParseWorks);

        }else if(parseMethod == ParseMethod.PREFIX){
            parse(iBinaryTreeNode.getLeftChild(), parseMethod, iParseWorks);
            parse(iBinaryTreeNode.getRightChild(), parseMethod, iParseWorks);
            iParseWorks[0].execute(iBinaryTreeNode, 0, "");
            //iBinaryTreeNode.getValue();

        }else if (parseMethod == ParseMethod.SUFFIX){
            parse(iBinaryTreeNode.getRightChild(), parseMethod, iParseWorks);
            //iBinaryTreeNode.getValue();
            iParseWorks[0].execute(iBinaryTreeNode, 0, "");
            parse(iBinaryTreeNode.getLeftChild(), parseMethod, iParseWorks);
        }

    }
}
