//Sai Konduru 

import java.util.ArrayList; 
public class TowerOfHanoi
{
	// TO DO: Instance Variables
	private int numOfDiscs; 
	private ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>(3);  

	/* Construct the Towers of Hanoi (3 towers) with aNumDisc
	 * on the first tower. Each tower can be identified by an
	 * integer number (0 for the first tower, 1 for the second
	 * tower, and 2 for the third tower). Each disc can be identified
	 * by an integer number starting from 0 (for the smallest disc)
	 * and (aNumDisc - 1) for the largest disc.
	 */
	public TowerOfHanoi(int aNumDiscs)
	{
		// TO DO: Constructor
		numOfDiscs = aNumDiscs; 
		ArrayList<Integer> temp = new ArrayList<Integer>(); 
		ArrayList<Integer> temp1 = new ArrayList<Integer>(); 
		ArrayList<Integer> temp2 = new ArrayList<Integer>(); 
		for(int i = 0; i < numOfDiscs; i++)
		{
			aNumDiscs--; 
			temp.add(aNumDiscs); 
		}
		towers.add(temp);
		towers.add(temp1);
		towers.add(temp2);
	}
	
	/* Returns an array of integer representing the order of
	 * discs on the tower (from bottom up). The bottom disc should
	 * be the first element in the array and the top disc should be
	 * the last element of the array. The size of the array MUST
	 * be the number of discs on the tower. For example, suppose
	 * the tower 0 contains the following discs 0,1,4,6,7,8 (from top
	 * to bottom). This method should return the array [8,7,6,4,1,0]
	 * (from first to last). 
	 * @param tower the integer identify the tower number.
	 * @return an array of integer representing the order of discs.
	 */
	public int[] getArrayOfDiscs(int tower)
	{
		// TO DO
		int[] result = new int[towers.get(tower).size()]; 
		for(int i = 0; i < result.length; i++)
		{
			result[i] = towers.get(tower).get(i);
		}
		return result;  
	}
	
	/* Gets the total number of discs in this Towers of Hanoi
	 * @return the total number of discs in this Towers of Hanoi
	 */
	public int getNumberOfDiscs()
	{
		// TO DO
		return numOfDiscs; 
	}
	
	/* Gets the number of discs on a tower.
	 * @param tower the tower identifier (0, 1, or 2)
	 * @return the number of discs on the tower.
	 */
	public int getNumberOfDiscs(int tower)
	{
		// TO DO
		return towers.get(tower).size(); 
	}
	
	/* Moves the top disc from fromTower to toTower. Note that
	 * this operation has to follow the rule of the Tower of Hanoi
	 * puzzle. First fromTower must have at least one disc and second
	 * the top disc of toTower must not be smaller than the top disc
	 * of the fromTower.
	 * @param fromTower the source tower
	 * @param toTower the destination tower
	 * @return ture if successfully move the top disc from
	 *         fromTower to toTower.
	 */
	public boolean moveTopDisc(int fromTower, int toTower)
	{
		// TO DO
		
		if(towers.get(toTower).size() == 0)
		{
			towers.get(toTower).add(towers.get(fromTower).remove(getNumberOfDiscs(fromTower)-1)); 
			return true;
		}
		else if(towers.get(toTower).get(getNumberOfDiscs(toTower)-1) > towers.get(fromTower).get(getNumberOfDiscs(fromTower)-1))
		{
			towers.get(toTower).add(towers.get(fromTower).remove(getNumberOfDiscs(fromTower)-1)); 
			return true; 
		}
		return false; 
	}
}
