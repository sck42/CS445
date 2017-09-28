//Sai Konduru
public class FrequencyBag<T>
{
	//Instance Variables
	private Node firstNode; 
	private int numEntries; 
	
	/**
	 * Constructor
	 * Constructs an empty frequency bag.
	 */
	public FrequencyBag()
	{
		firstNode = null; 
		numEntries = 0; 
	}
	
	/**
	 * Adds new entry into this frequency bag.
	 * @param aData the data to be added into this frequency bag.
	 */
	public void add(T aData)
	{
		Node currentNode = firstNode; 
		int counter = 1; 
		boolean added = false; 
		
		while(currentNode != null && !added)
		{
			if(currentNode.data.equals(aData))
			{
				counter = currentNode.frequency; 
				counter++; 
				currentNode.frequency = counter; 
				numEntries++; 
				added = true;  
			}
			else
			{
				currentNode = currentNode.next;
			}
		}
		if(numEntries == 0 || !added)
		{
			Node newNode = new Node(aData, 1);
			newNode.next = firstNode;
			firstNode = newNode;
			numEntries++;
			added = true; 
		}
		counter = 0; 
	}
	
	/**
	 * Gets the number of occurrences of aData in this frequency bag.
	 * @param aData the data to be checked for its number of occurrences.
	 * @return the number of occurrences of aData in this frequency bag.
	 */
	public int getFrequencyOf(T aData)
	{
		int frequency = 0; 
		Node currentNode = firstNode; 
		while(currentNode != null)
		{
			if(currentNode.data.equals(aData))
			{
				return frequency = currentNode.frequency; 
			}
			else
			{
				currentNode = currentNode.next;
			}
		}
		return frequency; 
	}

	/**
	 * Gets the maximum number of occurrences in this frequency bag.
	 * @return the maximum number of occurrences of an entry in this
	 * frequency bag.
	 */
	public int getMaxFrequency()
	{
		int currentMax = 0; 
		Node currentNode = firstNode; 
		
		while(currentNode != null)
		{
			if(currentNode.frequency > currentMax)
			{
				currentMax = currentNode.frequency; 
			}
			currentNode = currentNode.next; 
		}
		
		return currentMax; 
	}
	
	/**
	 * Gets the probability of aData
	 * @param aData the specific data to get its probability.
	 * @return the probability of aData
	 */
	public double getProbabilityOf(T aData)
	{
		double percentage = ((double) getFrequencyOf(aData))/((double) size()); 
		return percentage; 
	}

	/**
	 * Empty this bag.
	 */
	public void clear()
	{
		firstNode = null; 
		numEntries = 0; 
	}
	
	/**
	 * Gets the number of entries in this bag.
	 * @return the number of entries in this bag.
	 */
	public int size()
	{
		int size = 0; 
		Node currentNode = firstNode; 
		while(currentNode != null)
		{
			size += currentNode.frequency;
			currentNode = currentNode.next; 
		}
		return size; 
	}
	
	private class Node 
	{
		//Instance Variables 
		private T data; 
		private int frequency; 
		private Node next; 
		
		//Constructor with out a nextNode. 
		private Node(T dataPortion, int numOccurrances)
		{
			data = dataPortion;
			frequency = numOccurrances;
			next = null; 
		}
		
		//Constructor with a nextNode. 
		private Node(T dataPortion, int numOccurrances, Node nextNode)
		{
			data = dataPortion;
			frequency = numOccurrances; 
			next = nextNode;
		}
	}
}
