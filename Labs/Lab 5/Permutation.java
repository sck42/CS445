//Sai Konduru 
import java.util.ArrayList;


public class Permutation
{
	public static ArrayList<ArrayList<Integer>> permutation(final ArrayList<Integer> list)
	{
		//BASE CASE
		if (list.size() == 0) 
		{
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			result.add(new ArrayList<Integer>());
			return result;
		}

		//Store first element 
		Integer firstElement = list.get(0);
		
		//Save list minus the firstElement in an ArrayList. 
		ArrayList<Integer> temp1 = new ArrayList<Integer>(); 
		for(int i = 1; i< list.size(); i++)
		{
			temp1.add(list.get(i)); 
		}
		
		//Recursion 
		ArrayList<ArrayList<Integer>> recursiveReturn = permutation(temp1);
		
		//Add first element back to the list. 
		ArrayList<ArrayList<Integer>> returnMe = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < recursiveReturn.size(); i++) 
		{
			for (int index = 0; index <= recursiveReturn.get(i).size(); index++) 
			{
				ArrayList<Integer> temp = new ArrayList<Integer>(recursiveReturn.get(i));
				temp.add(index, firstElement);
				returnMe.add(temp);
			}

		}
		
		return returnMe; 
	}

}
