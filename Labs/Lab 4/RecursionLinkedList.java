
public class RecursionLinkedList
{
	private Node firstNode;
	private int numberOfEntries;
	private String s; 
	public RecursionLinkedList()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public void add(int aData)
	{
		if(numberOfEntries == 0)
		{
			firstNode = new Node(aData);
		}
		else
		{
			firstNode = new Node(aData, firstNode);
		}
		
		numberOfEntries++;
	}
	
	/**
	 * boolean contains(int aData)
	 * 
	 * See whether this RecursionLinkedList contains aData
	 * @param aData  a data to be located
	 * @return true if this RecursionLinkedList contains aData,
	 *         or false otherwise.
	 */
	public boolean contains(int aData)
	{
		// TO DO
		return containsHelp(aData, firstNode);
	}
	private boolean containsHelp(int aData, Node node)
	{
		if(node == null)
		{
			return false;
		}
		else if(node.data == aData)
		{
			return true;
		}
		else
		{
			return containsHelp(aData, node.next); 
		}
	}
	
	/**
	 * int getFrequencyOf(int aData)
	 * 
	 * Counts the number of times a given data appears in this
	 * RecursionLinkedList.
	 * 
	 * @param aData  the data to be counted
	 * @return the number of times aData appears in this RecursionLinkedList
	 */
	public int getFrequencyOf(int aData)
	{
		// TO DO
		return frequencyHelp(0, aData, firstNode); 
	}
	
	private int frequencyHelp(int frequency, int aData, Node node)
	{
		if(node == null)
		{
			return frequency; 
		}
		else if(node.data == aData)
		{
			frequency++; 
			return frequencyHelp(frequency, aData, node.next); 
		}
		else
		{
			return frequencyHelp(frequency, aData, node.next); 
		}
	}
	
	/**
	 * String toString()
	 * 
	 * Return a string representation of this RecursionLinkedList. For example,
	 * if this RecursionLinkedList contains 1, 2, 3, 5, 2 and 3 from the first
	 * index to the last index, the returned string should be
	 * "[1,2,3,5,2,3]"
	 * @return the string representation of this RecursionLinkedList.
	 */
	public String toString()
	{
		// TO DO 
		StringBuilder sb = new StringBuilder("["); 
		return toStringHelper(firstNode, sb); 
	}
	
	private String toStringHelper(Node node, StringBuilder sb)
	{
		if(node == null)
		{
			sb.replace(sb.length()-1, sb.length(), "]");
			s = sb.toString();
			return s; 
		}
		else
		{
			sb.append(node.data + ","); 
			return toStringHelper(node.next, sb); 
		}
	}
	
	/**
	 * int getIndexOf(int aData)
	 * 
	 * Return the index of the first aData where the first index of
	 * the first item in this RecursionLinkedList is 0.
	 * 
	 * @param aData  the data to be located
	 * @return the index of the first aData.
	 */
	public int getIndexOf(int aData)
	{
		// TO DO
		return indexOfHelp(0, firstNode, aData);  
	}
	private int indexOfHelp(int index, Node node, int aData)
	{
		if(node == null)
		{
			return -1; 
		}
		else if(node.data == aData)
		{
			return index; 
		}
		else 
		{
			index++; 
			return indexOfHelp(index, node.next, aData); 
		}
	}	
	
	private class Node
	{
		private int data;
		private Node next;
		
		private Node(int aData, Node nextNode)
		{
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(aData, null);
		}
	}
}
