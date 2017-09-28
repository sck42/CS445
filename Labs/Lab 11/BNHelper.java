import java.util.ArrayList; 
public class BNHelper
{
	/**
	 * Return the reference to the left most node of
	 * a subtree rooted at rootNode.
	 * 
	 * @param rootNode  A root node of a subtree
	 * @return reference to the left most node
	 */
	public static <T> BinaryNodeInterface<T> getLeftMostNode(BinaryNodeInterface<T> rootNode)
	{
		// TO DO
		if(rootNode.isLeaf())
		{
			return rootNode;
		}
		else
		{
			if(rootNode != null)
			{
				if(rootNode.hasLeftChild())
				{
					return getLeftMostNode(rootNode.getLeftChild()); 
				}
			}
		}
		return rootNode; 
	}
	
	/**
	 * Return the reference to the right most node of
	 * a subtree rooted at rootNode.
	 * 
	 * @param rootNode  A root node of a subtree
	 * @return reference to the right most node
	 */
	public static <T> BinaryNodeInterface<T> getRightMostNode(BinaryNodeInterface<T> rootNode)
	{
		// TO DO
		if(rootNode.isLeaf())
		{
			return rootNode;
		}
		else
		{
			if(rootNode != null)
			{
				if(rootNode.hasRightChild())
				{
					return getRightMostNode(rootNode.getRightChild()); 
				}
			}
		}
		return rootNode;
	}
	
	/**
	 * Get the array of data associated with inorder traversal
	 * of a subtree rooted at rootNode. For this traversal,
	 * visit all nodes in the rootNode's left subtree first, then rootNode,
	 * and then all nodes in the rootNode's right subtree.
	 * 
	 * @param rootNode  A root node of a subtree
	 * @return an array
	 */
	public static <T> T[] getArrayInorderLeftFirst(BinaryNodeInterface<T> rootNode)
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[rootNode.getNumberOfNodes()];
		ArrayList<T> result1 = new ArrayList<T>(); 
		// TO DO
		getArrayInorderLeftFirst(rootNode, result1); 
		for(int i = 0; i < result1.size(); i++)
		{
			result[i] = result1.get(i); 
		}
		return result;
	}
	private static <T> void getArrayInorderLeftFirst(BinaryNodeInterface<T> rootNode, ArrayList<T> result1)
	{
		if(rootNode == null)
		{
			return; 
		}
		getArrayInorderLeftFirst(rootNode.getLeftChild(), result1); 
		result1.add(rootNode.getData());  
		getArrayInorderLeftFirst(rootNode.getRightChild(), result1);
	}
	/**
	 * Get the array of data associated with inorder traversal
	 * of a subtree rooted at rootNode. For this traversal,
	 * visit all nodes in the rootNode's right subtree first, then rootNode,
	 * and then all nodes in the rootNode's left subtree.
	 * 
	 * @param rootNode  A root node of a subtree
	 * @return an array
	 */
	public static <T> T[] getArrayInorderRightFirst(BinaryNodeInterface<T> rootNode)
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[rootNode.getNumberOfNodes()];
		ArrayList<T> result1 = new ArrayList<T>(); 
		// TO DO
		getArrayInorderRightFirst(rootNode, result1); 
		for(int i = 0; i < result1.size(); i++)
		{
			result[i] = result1.get(i); 
		}
		return result;
	}
	private static <T> void getArrayInorderRightFirst(BinaryNodeInterface<T> rootNode, ArrayList<T> result1)
	{
		if(rootNode == null)
		{
			return; 
		}
		getArrayInorderRightFirst(rootNode.getRightChild(), result1); 
		result1.add(rootNode.getData()); 
		getArrayInorderRightFirst(rootNode.getLeftChild(), result1); 
	}
	/**
	 * Get the reference to a node containing aData from a subtree
	 * rooted at rootNode.
	 * 
	 * @param rootNode  A root node of a subtree
	 * @param aData  The data to search for
	 * @return the reference to a node containing aData. If no such data
	 *         is found, return null.
	 */
	public static <T> BinaryNodeInterface<T> getReferenceTo(BinaryNodeInterface<T> rootNode, T aData)
	{
		// TO DO
		if(rootNode == null)
		{
			return null; 
		}
		if(aData == rootNode.getData())
			return rootNode;
		else 
		{
			BinaryNodeInterface<T> left = getReferenceTo(rootNode.getLeftChild(), aData);
			BinaryNodeInterface<T> right = getReferenceTo(rootNode.getRightChild(), aData); 
			if(left != null)
			{
				return left; 
			}
			else
			{
				return right; 
			}
		} 
	}	
}
