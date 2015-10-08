package algo.binarytree.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import algo.binarytree.node.interfaces.IBinaryTreeNode;
import algo.binarytree.parser.interfaces.IBinaryTreeParser;
import algo.binarytree.parser.interfaces.IBinaryTreeParser.ParseMethod;
import algo.binarytree.parser.interfaces.IParseWork;
import algo.binarytree.util.interfaces.IBinaryTreePrinterWriter;

public class BinaryTreePrinterAscii<T> implements IBinaryTreePrinterWriter<T, Writer>{
	
	int height = 0;
	int level = 0;
	ArrayList<IBinaryTreeNode<T>> nodes = new ArrayList<IBinaryTreeNode<T>>();

	@Override
	public void print(IBinaryTreeNode<T> node, Writer writer,
			IBinaryTreeParser<T> parser) {

		IParseWork<T> operations[] = new IParseWork[] {this};
		parser.parse(node, ParseMethod.INFIX, operations);
		
		try {
			for (int i = 0; i <= this.height; i++) {
				System.out.println(i);
				for (int j = 0; j < nodes.size(); j++) {
					if (nodes.get(j).getLevel() == i) {
						if(this.nodes.get(j).getParent() == null) writer.write(nodes.get(j).getValue().toString());
						else if(this.nodes.get(j).isLeftChild())  writer.write(nodes.get(j).getValue().toString());
						else if(this.nodes.get(j).isRightChild()) writer.write(nodes.get(j).getValue().toString());
					}
				}
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(IBinaryTreeNode<T> node, int level, String path) {
		//System.out.print(path);
		nodes.add(node);
		if (height < level) {
			height = level;
		}
	}

	public void parseWork(IBinaryTreeNode<T> node, IParseWork<T>[] work){
		for (int i = 0; i < work.length; i++) {
			work[i].execute(node, node.getLevel(), node.getPath());
		}
	}

}
