//Sai Konduru 

public class LInfiniteInteger implements InfiniteIntegerInterface
{
	private Node firstNode;
	private Node lastNode;
	private int numberOfDigits;
	private boolean isNegative;
	
	/**
	 * Constructor: Constructs this infinite integer from a string
	 * representing an integer.
	 * @param s  a string represents an integer
	 */
	public LInfiniteInteger(String s)
	{
		//Check for empty String. 
		if(s.isEmpty())
		{
			numberOfDigits = 0; 
			firstNode = null; 
			lastNode = null; 
			isNegative = false; 
		}
		else 
		{
			//Take care of leading zeros. 
			StringBuilder sb = new StringBuilder(s); 
			if(s.charAt(0) == '-')
			{
				isNegative = true; 
				while(s.charAt(1) == '0')
				{
					s = sb.deleteCharAt(1).toString(); 
					if(s.isEmpty())
					{
						firstNode = new Node(null, 0, null); 
						lastNode = firstNode; 
						numberOfDigits = 1; 
						isNegative = false; 
						break; 
					}
				}
			}
			else
			{
				isNegative = false; 
				while(s.charAt(0) == '0')
				{
					s = sb.deleteCharAt(0).toString(); 
					if(s.isEmpty())
					{ 
						firstNode = new Node(null, 0, null); 
						lastNode = firstNode; 
						numberOfDigits = 1; 
						isNegative = false; 
						break; 
					}
				}
			}
			
			//Change string into Character Array representing integer. 
			char[] stringArray = s.toCharArray();  
			if(isNegative)
			{
				if(stringArray.length == 1)
				{ 
					firstNode = new Node(null, 0, null);
					lastNode = firstNode; 
				}
				else
				{
					//Ignore the first character when negative "-". 
					//Add to the linked list. 
					numberOfDigits = stringArray.length - 1; 
					for(int i = 1; i < stringArray.length; i++)
					{
						if(firstNode == null)
						{
							
							firstNode = new Node(null, Character.getNumericValue(stringArray[1]), null);
							lastNode = firstNode; 
						}
						else
						{
							Node newNode = new Node(lastNode, Character.getNumericValue(stringArray[i]), null); 
							lastNode.next = newNode; 
							lastNode = newNode;
						}
						 
					}
				}
				
			}
			else if(!isNegative)
			{ 
				if(stringArray.length == 0)
				{ 
					firstNode = new Node(null, 0, null);
					lastNode = firstNode; 
				}
				else 
				{
					//Don't ignore anything when positive
					//Add to the linked list. 
					numberOfDigits = stringArray.length; 
					for(int i = 0; i < stringArray.length; i++)
					{
						if(firstNode == null)
						{
							firstNode = new Node(null, Character.getNumericValue(stringArray[0]), null); 
							lastNode = firstNode;
						}
						else
						{
							Node newNode = new Node(lastNode, Character.getNumericValue(stringArray[i]), null);
							lastNode.next = newNode;
							lastNode = newNode;
						}
					}
				}
			}
		}
		
	}

	/**
	 * Constructor: Constructs this infinite integer from an integer.
	 * @param anInteger  an integer
	 */
	public LInfiniteInteger(int anInteger)
	{
		//Change to integer object and check a number was passed in. 
		Integer integer = new Integer(anInteger); 
		if(integer == null)
		{
			numberOfDigits = 0;
			firstNode = null; 
			lastNode = null; 
			isNegative = false; 
		}
		else 
		{
			//Change anInteger to string and do same as before. 
			String temp = Integer.toString(anInteger);
			 //Take care of leading zeros. 
			StringBuilder sb = new StringBuilder(temp); 
			if(temp.charAt(0) == '-')
			{
				isNegative = true; 
				while(temp.charAt(1) == '0')
				{
					temp = sb.deleteCharAt(1).toString();
					if(temp.isEmpty())
					{
						firstNode = new Node(null, 0, null); 
						lastNode = firstNode; 
						numberOfDigits = 1;
						isNegative = false; 
						break; 
					}
				}
				
			}
			else
			{
				isNegative = false; 
				while(temp.charAt(0) == '0')
				{
					temp = sb.deleteCharAt(0).toString(); 
					if(temp.isEmpty())
					{
						firstNode = new Node(null, 0, null); 
						lastNode = firstNode; 
						numberOfDigits = 1;
						isNegative = false; 
						break; 
					}
				}
				
			}
			
			char[] stringArray = temp.toCharArray();  
			if(isNegative)
			{
				if(stringArray.length == 1)
				{
					firstNode = new Node(null, 0, null);
					lastNode = firstNode; 
				}
				else 
				{
					numberOfDigits = stringArray.length - 1;  
					for(int i = 1; i < stringArray.length; i++)
					{
						if(firstNode == null)
						{
							firstNode = new Node(null, Character.getNumericValue(stringArray[1]), null);
							lastNode = firstNode; 
						}
						else
						{
							Node newNode = new Node(lastNode, Character.getNumericValue(stringArray[i]), null); 
							lastNode.next = newNode; 
							lastNode = newNode;
						}
					}
				}
				
			}
			else if(!isNegative)
			{
				if(stringArray.length == 0)
				{ 
					firstNode = new Node(null, 0, null);
					lastNode = firstNode; 
				}
				else 
				{
					numberOfDigits = stringArray.length;  
					for(int i = 0; i < stringArray.length; i++)
					{
						if(firstNode == null)
						{
							firstNode = new Node(null, Character.getNumericValue(stringArray[0]), null);
							lastNode = firstNode;
						}
						else
						{
							Node newNode = new Node(lastNode, Character.getNumericValue(stringArray[i]), null);
							lastNode.next = newNode;
							lastNode = newNode;
						} 
					}
				}
				
			}
		}
	}
	
	/**
	 * Gets the number of digits of this infinite integer.
	 * @return an integer representing the number of digits
	 * of this infinite integer.
	 */
	public int getNumberOfDigits()
	{
		//return Number of Digits. 
		return numberOfDigits; 
	}
	
	/**
	 * Checks whether this infinite integer is a negative number.
	 * @return true if this infinite integer is a negative number.
	 * Otherwise, return false.
	 */
	public boolean isNegative()
	{
		// return isNegative
		return isNegative; 
	}
	

	/**
	 * Calculates the result of this infinite integer plus anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to be added to this
	 * infinite integer.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer plus anInfiniteInteger
	 */
	
	 /** using 5 and 9 focus on the answer of 14 and 4 */
	public InfiniteIntegerInterface plus(final InfiniteIntegerInterface anInfiniteInteger)
	{		
		String infiniteInt = anInfiniteInteger.toString();
		char[] infiniteIntArray = anInfiniteInteger.toString().toCharArray();
		int[] thisInteger = toIntArray(); 
		int[] infiniteIntArrayInt;
		String result = ""; 
		
		//Make an array of ints representing anInfiniteInteger. 
		if(anInfiniteInteger.isNegative())
		{
			char[] tempArray = new char[infiniteIntArray.length - 1]; 
			for(int i = 1; i < infiniteIntArray.length; i++)
			{
				tempArray[i - 1] = infiniteIntArray[i]; 
			}
			infiniteIntArrayInt = toIntArray(tempArray);
		}
		else 
		{
			infiniteIntArrayInt = toIntArray(infiniteIntArray); 
		}
		
		//Find the number of digits in anInfiniteInteger and if its negative. 
		int numDigits = anInfiniteInteger.getNumberOfDigits(); 
		boolean infiniteIntNegative = anInfiniteInteger.isNegative(); 
		InfiniteIntegerInterface answer = null; 
		
		//Check for zero and return the number that is not zero. 
		if(infiniteInt.equals("0"))
		{
			return this; 
		}
		else if(toString().equals("0"))
		{
			return anInfiniteInteger; 
		}
		
		//Check signs 
		if(infiniteIntNegative)
		{
			if(isNegative)
			{
				result = add(thisInteger, numDigits, infiniteIntArrayInt); 
				result = "-" + result; 
				answer = new LInfiniteInteger(result); 
			}
			else if(!isNegative)
			{
				result = sub(thisInteger, numDigits, anInfiniteInteger);
				answer = new LInfiniteInteger(result); 
			}
		}
		else if(!infiniteIntNegative)
		{
			if(!isNegative)
			{
				result = add(thisInteger, numDigits, infiniteIntArrayInt); 
				answer = new LInfiniteInteger(result); 
			}
			else if(isNegative)
			{
				result = sub(thisInteger, numDigits, anInfiniteInteger); 
				answer = new LInfiniteInteger(result);  
			}
		}
		return answer; 
	}
	
	//Turn the linked list into an int array. 
	private int[] toIntArray()
	{
		Node currentNode = firstNode;
		int[] result = new int[numberOfDigits];
		int index = 0; 
		while(currentNode != null)
		{
			result[index] = currentNode.data;  
			currentNode = currentNode.next;
			index++; 
		}
		
		return result; 
	}
	
	//Turn a character array into a int array. 
	private int[] toIntArray(char[] a)
	{
		int[] result = new int[a.length];
		if(a[0] == '-')
		{
			result = new int[a.length - 1];
			for(int i = 1; i < a.length; i++)
			{
				result[i-1] = Character.getNumericValue(a[i]);
			}
		}
		else
		{
			for(int i = 0; i < a.length; i++)
			{
				result[i] = Character.getNumericValue(a[i]);
			}
		}
		return result; 
	}
	
	//Change an int array to a string. 
	private String arrayToString(int[] a)
	{
		String result = ""; 
		for(int i = 0; i < a.length; i++)
		{
			result = result.concat(Integer.toString(a[i])); 
		}
		return result; 
	}
	private String add(int[] thisInteger, int numDigits, int[] infiniteIntArrayInt)
	{
		int temp = 0; 
		int numZeros = 0; 
		int thisIndex = thisInteger.length; 
		int[] result; 
		
		//Make a result array to fill in. 
		if(numberOfDigits > infiniteIntArrayInt.length)
		{
			result = new int[numberOfDigits + 1];
		}
		else
		{
			result = new int[infiniteIntArrayInt.length + 1]; 
		}
		int index = result.length; 
		String result1 = "";  
		
		//Add each number keeping track of carry. 
		while(thisIndex >=1  && numDigits >= 1)
		{
			numDigits--; 
			index--; 
			thisIndex--; 
			temp = infiniteIntArrayInt[numDigits] + thisInteger[thisIndex];
			if(temp >= 10)
			{
				result[index] += temp - 10; 
				result[index - 1] += 1;
			}
			else
			{
				result[index] += temp; 
			}
			if(result[index] >= 10)
			{
				result[index] -= 10; 
				result[index - 1] += 1;
			}
		}
		//Fill in remaining numbers. 
		if(numberOfDigits > infiniteIntArrayInt.length)
		{
			while(thisIndex >= 1)
			{
				thisIndex--; 
				temp = thisInteger[thisIndex];
				index--; 
				result[index] += temp; 
				if(result[index] >= 10)
				{
					result[index] -= 10; 
					result[index - 1] += 1;
				}
			}
		}
		else if(numberOfDigits < infiniteIntArrayInt.length)
		{
			numDigits--; 
			for(int i = numDigits; i >= 0; i--)
			{
				index--; 
				temp = infiniteIntArrayInt[i];
				result[index] += temp;  
				if(result[index] >= 10)
				{
					result[index] -= 10; 
					result[index - 1] += 1;
				}
			}
		} 
		result1 = arrayToString(result);
		return result1; 
	}
	private String sub(int[] thisInteger, int numDigits, InfiniteIntegerInterface anInfiniteInteger)
	{
		//Compare the positive infinite integer to see if answer is positive or negative. 
		int[] result; 
		int temp = 0; 
		String result1 = "";
		char[] tempCharArray = anInfiniteInteger.toString().toCharArray(); 
		int[] infiniteIntArrayInt = toIntArray(tempCharArray);
		//Create a result array with same size as biggest number. 
		if(numberOfDigits > anInfiniteInteger.getNumberOfDigits())
		{
			result = new int[numberOfDigits];
		}
		else
		{
			result = new int[anInfiniteInteger.getNumberOfDigits()]; 
		}
		int index = result.length; 
		int thisIndex = thisInteger.length; 
		int carry = 0; 
		boolean addNegative = false;  
		boolean isZero = false; 
 
		if(isNegative)
		{
			//Delete first char "-". 
			StringBuilder sb = new StringBuilder(toString()); 
			InfiniteIntegerInterface thisPositive = new LInfiniteInteger(sb.deleteCharAt(0).toString());
			
			//Compare the positive numbers. 
			if(thisPositive.compareTo(anInfiniteInteger) == 1)
			{ 
				//Keeping trap of carry sub tract two numbers. 
				while(thisIndex >= 1 && numDigits >= 1)
				{
					numDigits--;
					thisIndex--;
					index--; 
					temp = thisInteger[thisIndex] - infiniteIntArrayInt[numDigits]; 
					if(carry == -1)
					{
						temp = temp - 1; 
					}
					if(temp < 0)
					{
						temp += 10; 
						result[index] = temp;
						carry = -1; 
					}
					else{
						carry = 0; 
						result[index] = temp; 
					}
				}
				//Set booleans at end. 
				isZero = false; 
				addNegative = true; 
			}
			//Compare the positive numbers.
			else if(thisPositive.compareTo(anInfiniteInteger) == -1)
			{
				//Keeping trap of carry sub tract two numbers. 
				while(thisIndex >= 1 && numDigits >= 1)
				{
					numDigits--;
					thisIndex--;
					index--; 
					temp = infiniteIntArrayInt[numDigits] - thisInteger[thisIndex];
					if(carry == -1)
					{
						temp = temp - 1; 
					}
					if(temp < 0)
					{
						temp += 10; 
						result[index] = temp;
						carry = -1; 
					}
					else{
						carry = 0; 
						result[index] = temp; 
					}
				}
				//Set booleans at end.
				isZero = false; 
				addNegative = false; 
			}
			//Compare the positive numbers.
			//Same number oposite signs means answer is zero. 
			else{
				addNegative = false; 
				isZero = true;
				index = 0; 
				numDigits = 0; 				
				result[0] = 0; 
			}
		
		}
		else if(anInfiniteInteger.isNegative())
		{
			StringBuilder sb = new StringBuilder(anInfiniteInteger.toString());
			InfiniteIntegerInterface secondInfinite = new LInfiniteInteger(sb.deleteCharAt(0).toString());
			//Compare the positive numbers.
			if(this.compareTo(secondInfinite) == 1)
			{
				//Keeping trap of carry sub tract two numbers. 
				while(thisIndex >= 1 && numDigits >= 1)
				{
					numDigits--;
					thisIndex--;
					index--; 
					temp = thisInteger[thisIndex] - infiniteIntArrayInt[numDigits];
					if(carry == -1)
					{
						temp = temp - 1; 
					}
					if(temp < 0)
					{
						temp += 10; 
						result[index] = temp;
						carry = -1; 
					}
					else{
						carry = 0;
						result[index] = temp; 
					}
					
				}
				//Set booleans at end.
				isZero = false; 
				addNegative = false; 
			}
			//Compare the positive numbers.
			else if(this.compareTo(secondInfinite) == -1)
			{
				//Keeping trap of carry sub tract two numbers. 
				while(thisIndex >= 1 && numDigits >= 1)
				{
					numDigits--;
					thisIndex--;
					index--; 
					temp = infiniteIntArrayInt[numDigits] - thisInteger[thisIndex];
					if(carry == -1)
					{
						temp = temp - 1; 
					}
					if(temp < 0)
					{
						temp += 10; 
						result[index] = temp;
						carry = -1; 
					}
					else{
						carry = 0; 
						result[index] = temp; 
					}
					
				}
				//Set booleans at end.
				addNegative = true; 
				isZero = false; 
			}
			//Compare the positive numbers.
			//Same number oposite signs means answer is zero. 
			else{
				addNegative = false; 
				isZero = true; 
				index = 0; 
				numDigits = 0; 
				result[0] = 0; 
			}
		}
		if(!isZero)
		{
			//Fill in remaining numbers. 
			while(thisIndex >= 1)
			{
				thisIndex--;
				index--;
				temp = thisInteger[thisIndex]; 
				if(carry == -1)
				{
					temp = temp - 1;   
				} 
				if(temp < 0)
				{
					temp += 10; 
					result[index] = temp;
					carry = -1; 
				}
				else
				{
					carry = 0; 
					result[index] = temp;
				}
				
			}
			while(numDigits >= 1)
			{
				numDigits--; 
				index--; 
				if(carry == -1)
				{
					temp = infiniteIntArrayInt[numDigits] - 1;   
				}
				else
				{
					temp = infiniteIntArrayInt[numDigits]; 
				}
				if(temp < 0)
				{
					result[index] = temp + 10;
					carry = -1; 
				}
				else
				{
					carry = 0; 
					result[index] = temp;
				} 
			}
		}
		//Add negative as needed and return. 
		result1 = arrayToString(result);
		if(addNegative)
		{
			result1 = "-" + result1; 
		} 
		return result1;  
	}
	/**
	 * Calculates the result of this infinite integer subtracted by anInfiniteInteger
	 * @param anInfiniteInteger the infinite integer to subtract.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer subtracted by anInfiniteInteger
	 */
	public InfiniteIntegerInterface minus(final InfiniteIntegerInterface anInfiniteInteger)
	{
		InfiniteIntegerInterface answer; 
		//Check for zero and return apporpriate sign and number. 
		if(anInfiniteInteger.toString().equals("0"))
		{
			return this; 
		}
		if(toString().equals("0"))
		{
			if(anInfiniteInteger.isNegative())
			{
				StringBuilder sb = new StringBuilder(anInfiniteInteger.toString()); 
				InfiniteIntegerInterface temp = new LInfiniteInteger(sb.deleteCharAt(0).toString());
				return temp; 
			}
			else
			{
				String s = "-" + anInfiniteInteger.toString(); 
				InfiniteIntegerInterface temp = new LInfiniteInteger(s);
				return temp; 
			}
		}
		//Subtraction is same as add the negative of the last number. 
		//Change anInfiniteInteger to negative if its positive and vise versa.
		//Use plus method. 
		if(anInfiniteInteger.isNegative())
		{
			StringBuilder sb = new StringBuilder(anInfiniteInteger.toString()); 
			InfiniteIntegerInterface temp = new LInfiniteInteger(sb.deleteCharAt(0).toString());
			answer = plus(temp); 
		}
		else
		{
			String s = "-" + anInfiniteInteger.toString(); 
			InfiniteIntegerInterface temp = new LInfiniteInteger(s);
			answer = plus(temp); 
		}
		return answer; 
	}
	
	/**
	 * Generates a string representing this infinite integer. If this infinite integer
	 * is a negative number a minus symbol should be in the front of numbers. For example,
	 * "-12345678901234567890". But if the infinite integer is a positive number, no symbol
	 * should be in the front of the numbers (e.g., "12345678901234567890").
	 * @return a string representing this infinite integer number.
	 */
	public String toString()
	{
		Node currentNode = firstNode; 
		String result = ""; 
		//Iterate through and add each number to the end of the string. 
		while(currentNode != null)
		{
			result = result.concat(Integer.toString(currentNode.data));
			currentNode = currentNode.next; 
		}
		
		//Add negative as needed. 
		if(isNegative)
		{
			result = "-" + result; 
		}
		
		return result; 
	}
	
	/**
	 * Compares this infinite integer with anInfiniteInteger
	 * @return either -1, 0, or 1 as follows:
	 * If this infinite integer is less than anInfiniteInteger, return -1.
	 * If this infinite integer is equal to anInfiniteInteger, return 0.
	 * If this infinite integer is greater than anInfiniteInteger, return 1.
	 */
	public int compareTo(InfiniteIntegerInterface anInfiniteInteger)
	{
		int numDigits = anInfiniteInteger.getNumberOfDigits();
		char[] infiniteIntArray = anInfiniteInteger.toString().toCharArray();
		int index = 0; 
		int result = 0; 
		//Check signs. 
		if(isNegative == anInfiniteInteger.isNegative())
		{
			//Check size.
			if(numDigits < numberOfDigits)
			{
				return 1; 
			}
			else if(numDigits > numberOfDigits)
			{
				return -1; 
			}
			//Check numbers. 
			else if(numDigits == numberOfDigits)
			{
				Node currentNode = firstNode; 
				while(currentNode != null)
				{
					if(currentNode.data < Character.getNumericValue(infiniteIntArray[index])) 
					{
						return -1;  
					}
					else if(currentNode.data > Character.getNumericValue(infiniteIntArray[index]))
					{
						return 1; 
					}
					result = 0; 
					index++;
					currentNode = currentNode.next; 
				} 
			} 
		}
		else if(!isNegative && anInfiniteInteger.isNegative())
		{
			return 1;
		}
		else if(isNegative && !anInfiniteInteger.isNegative())
		{
			return -1; 
		}
		return result; 
	}

	/**
	 * Calculates the result of this infinite integer multiplied by anInfiniteInteger
	 * @param anInfiniteInteger the multiplier.
	 * @return a NEW infinite integer representing the result of this
	 * infinite integer multiplied by anInfiniteInteger.
	 */
	public InfiniteIntegerInterface multiply(final InfiniteIntegerInterface anInfiniteInteger)
	{
		// TO DO
		
		//Fill an array of type InfiniteIntegerInterface using plus method. 
		InfiniteIntegerInterface[] array = new InfiniteIntegerInterface[10];
		array[0] = new LInfiniteInteger(0);
		array[1] = anInfiniteInteger;
		array[2] = array[1].plus(array[1]);
		array[3] = array[2].plus(array[1]); 
		array[4] = array[2].plus(array[2]);
		array[5] = array[3].plus(array[2]);
		array[6] = array[3].plus(array[3]);
		array[7] = array[4].plus(array[3]);
		array[8] = array[4].plus(array[4]);
		array[9] = array[4].plus(array[5]);
		int numZeros = 0;
		Node currentNode = lastNode;
		String temp = "";
		String result = ""; 
		InfiniteIntegerInterface toBeReturned = new LInfiniteInteger(result);
		
		//Check for zero and return zero if found. 
		if(toString().equals("0") || anInfiniteInteger.toString().equals("0"))
		{
			toBeReturned = new LInfiniteInteger(0); 
			return toBeReturned; 
		}
		
		//Run through linked list and find from the array a temp value. 
		while(currentNode != null)
		{
			temp = (array[currentNode.data].toString()); 
			
			//Add zeros to temp value as needed. 
			for(int i = 0; i < numZeros; i++)
			{
				temp = temp.concat("0"); 
			}
			numZeros++;
			
			//Add the temp value to answer. 
			InfiniteIntegerInterface temp1 = new LInfiniteInteger(temp); 
			toBeReturned = toBeReturned.plus(temp1); 			
			currentNode = currentNode.previous; 
		}
		//Check signs and return apporpriate sign. 
		if(isNegative == anInfiniteInteger.isNegative())
		{
			if(toBeReturned.isNegative())
			{
				StringBuilder sb = new StringBuilder(toBeReturned.toString());
				toBeReturned = new LInfiniteInteger(sb.deleteCharAt(0).toString()); 
			}
		}
		else
		{
			if(toBeReturned.isNegative() == false)
			{
				String s = "-" + toBeReturned.toString(); 
				toBeReturned = new LInfiniteInteger(s); 
			}
		}
		return toBeReturned; 
	}
	
	private class Node
	{
		private int data;
		private Node next;
		private Node previous;
		
		private Node(Node previousNode, int aData, Node nextNode)
		{
			previous = previousNode;
			data = aData;
			next = nextNode;
		}
		
		private Node(int aData)
		{
			this(null, aData, null);
		}
	}
}
