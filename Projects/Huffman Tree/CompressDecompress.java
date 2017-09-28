//Sai Konduru 

/**
 * It is okay to use ArrayList class but you are not allowed to use any other
 * predefined class supplied by Java.
 */
import java.util.ArrayList;

public class CompressDecompress
{
	/**
	 * Get a string representing a Huffman tree where its root node is root
	 * @param root the root node of a Huffman tree
	 * @return a string representing a Huffman tree
	 */
	public static String getTreeString(final BinaryNodeInterface<Character> root)
	{
		// TO DO
		String result = ""; 
		if(root == null)
		{
			return ""; 
		}
		
		if(root.isLeaf())
		{
			result += "L" + root.getData(); 
		}
		else
		{
			result += "I";
			result += getTreeString(root.getLeftChild());
			result += getTreeString(root.getRightChild()); 
		}
		return result;	
			
	}

	/**
	 * Compress the message using Huffman tree represented by treeString
	 * @param root the root node of a Huffman tree
	 * @param message the message to be compressed
	 * @return a string representing compressed message.
	 */
	public static String compress(final BinaryNodeInterface<Character> root, final String message)
	{
		StringBuilder sb = new StringBuilder();
		
		// Create a list for all the characters and their bit strings
		ArrayList<Character> charList = new ArrayList<Character>();
		ArrayList<String> codeList = new ArrayList<String>();
		// Fill the lists
		compressHelper(root, "", charList, codeList);
		
		// Append each character's bit string
		for (int i = 0; i < message.length(); i++)
		{
			sb.append(codeList.get(charList.indexOf(message.charAt(i))));
		}
		
		return sb.toString();
	}
	private static void compressHelper(BinaryNodeInterface<Character> node, String currPath, ArrayList<Character> chars, ArrayList<String> codes)
	{
		if (node != null)
		{
			if (node.isLeaf())
			{
				chars.add(node.getData());
				codes.add(currPath);
			}
			compressHelper(node.getLeftChild(), currPath + "0", chars, codes);
			compressHelper(node.getRightChild(), currPath + "1", chars, codes);
		}
	}
	/**
	 * Decompress the message using Huffman tree represented by treeString
	 * @param treeString the string represents the Huffman tree of the
	 * compressed message
	 * @param message the compressed message to be decompressed
	 * @return a string representing decompressed message
	 */
	public static String decompress(final String treeString, final String message)
	{
		StringBuilder sb = new StringBuilder();
		
		// Create an array list of the chars in tree string
		ArrayList<Character> treeStringChars = new ArrayList<Character>();
		for (int i = 0; i < treeString.length(); i++)
		{
			treeStringChars.add(treeString.charAt(i));
		}
		
		BinaryNodeInterface<Character> rootNode = buildTree(treeStringChars);
		BinaryNodeInterface<Character> node = rootNode;
		
		for (int i = 0; i < message.length(); i++)
		{
			if (message.charAt(i) == '0') 
			{
				node = node.getLeftChild();
			}
			else 
			{
				node = node.getRightChild();
			}
			
			if (node.isLeaf())
			{
				// If there is a char at this node, append it to string builder
				sb.append(node.getData());
				// Reset current node to root
				node = rootNode;
			}
		}
		
		return sb.toString();
	}
	private static BinaryNode<Character> buildTree(ArrayList<Character> chars)
	{
		if (chars.isEmpty())
		{
			return null;
		}
		
		char c = chars.remove(0);
		if (c == 'L')
		{
			return new BinaryNode<Character>(chars.remove(0), null, null);
		}
		else
		{
			return new BinaryNode<Character>(null, buildTree(chars), buildTree(chars));
		}
	}

}
