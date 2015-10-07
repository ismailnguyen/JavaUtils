package algo.binarytree.node;

import algo.binarytree.node.interfaces.IBinaryTreeNode;

public class BinaryTreeNode<V> implements IBinaryTreeNode<V>
{
	public BinaryTreeNode()
	{
		super();
	}
	
	public BinaryTreeNode(V value)
	{
		super();
		this.value = value;
	}
	
	private V value;
	private boolean hasValueChanged = false;

	@Override
	public void setValue(V value)
	{
		this.value = value;
		hasValueChanged = true;
	}

	@Override
	public V getValue()
	{
		hasValueChanged = false;
		return value;
	}

	@Override
	public boolean isValueChanged()
	{
		return hasValueChanged;
	}

	private IBinaryTreeNode<V> parent, left, right;

	@Override
	public void setParent(IBinaryTreeNode<V> parent)
	{
		this.parent = parent;
	}

	@Override
	public IBinaryTreeNode<V> getParent()
	{
		return parent;
	}

	@Override
	public IBinaryTreeNode<V> getGrandParent()
	{
		if (parent != null && parent.getParent() != null)
			return parent.getParent();
		return null;
	}

	@Override
	public void setLeftChild(IBinaryTreeNode<V> leftChild)
	{
		left = leftChild;
		if (leftChild != null)
			leftChild.setParent(this);
	}

	@Override
	public void setRightChild(IBinaryTreeNode<V> rightChild)
	{
		right = rightChild;
		if (rightChild != null)
			rightChild.setParent(this);
	}

	@Override
	public IBinaryTreeNode<V> getLeftChild()
	{
		return left;
	}

	@Override
	public IBinaryTreeNode<V> getRightChild()
	{
		return right;
	}

	@Override
	public IBinaryTreeNode<V> getUncle()
	{
		IBinaryTreeNode<V> grandParent = getGrandParent();
		
		if (grandParent != null)
		{
			if (parent.isLeftChild())
			{
				return grandParent.getRightChild();
			}
			return grandParent.getLeftChild();
		}
		return null;
	}

	@Override
	public int getLevel()
	{
		if (parent == null)
			return 0;
		return (parent.getLevel() + 1);
	}

	@Override
	public boolean isSimplePoint()
	{
		return ((left == null) ^ (right == null));
	}

	@Override
	public boolean isDoublePoint()
	{
		return ((left != null) && (right != null));
	}

	@Override
	public boolean isLeaf()
	{
		return ((left == null) && (right == null));
	}

	@Override
	public boolean isLeftChild()
	{
		if (parent != null)
			return (this == parent.getLeftChild());
		return false;
	}

	@Override
	public boolean isRightChild()
	{
		if (parent != null)
			return (this == parent.getRightChild());
		return false;
	}

	@Override
	public void rotateLeft()
	{
		if (right != null)
		{
			if (parent != null)
			{
				if (this.isRightChild())
					parent.setRightChild(right);
				else
					parent.setLeftChild(right);
			}
			
			IBinaryTreeNode<V> buffer = right.getLeftChild();
			right.setLeftChild(this);
			setRightChild(buffer);
		}
	}

	@Override
	public void rotateRight()
	{
		if (left != null)
		{
			if (parent != null)
			{
				if (this.isRightChild())
					parent.setRightChild(left);
				else
					parent.setLeftChild(left);
			}
			
			IBinaryTreeNode<V> buffer = left.getRightChild();
			left.setRightChild(this);
			setLeftChild(buffer);
		}
	}

	@Override
	public String getPath()
	{
		if (parent != null)
		{
			return (parent.getPath() + ((isLeftChild()) ? "0" : "1"));
		}
		return "";
	}
}