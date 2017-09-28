import java.util.Random;
// No other import statement is allowed


public class Maze
{
	// TO DO: Instance Variable
	private int width; 
	private int height;
	private boolean[][] southWall;
	private boolean[][] eastWall;	
	/**
	 * Constructor
	 * @param aWidth the number of chambers in each row
	 * @param aHeight the number of chamber in each column
	 */
	public Maze(int aWidth, int aHeight)
	{
		// TO DO: Constructor
		width = aWidth; 
		height = aHeight;
		southWall = new boolean[height][width];
		eastWall = new boolean[height][width]; 
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				southWall[i][j] = false; 
				eastWall[i][j] = false; 
			}
		}
		
		mazeRecursive(0, width, 0, height); 
	}
	private void mazeRecursive(int startWidth, int aWidth, int startHeight, int aHeight)
	{
		if(aWidth - startWidth <= 1 || aHeight - startHeight <= 1)
		{
			return; 
		}
		else 
		{
			Random rand = new Random(); 
			
			//Pick a random point
			int row = rand.nextInt(aHeight - 1 - startHeight) + startHeight;
			int column = rand.nextInt(aWidth  - 1 - startWidth) + startWidth;
			
			//Draw the walls
			for(int i = startWidth; i < aWidth; i++)
			{
				southWall[row][i] = true; 
			}
			for(int i = startHeight; i < aHeight; i++)
			{
				eastWall[i][column] = true; 
			}
			
			//removeWalls 
			removeWall(row, column, startWidth, aWidth, startHeight, aHeight); 
		    
			mazeRecursive(startWidth, column + 1, startHeight, row + 1); 
			mazeRecursive(column + 1, aWidth, startHeight, row + 1); 
			mazeRecursive(startWidth, column + 1, row + 1, aHeight); 
			mazeRecursive(column + 1, aWidth, row + 1, aHeight); 
		}
		
	}
	private void removeWall(int row, int column, int startWidth, int aWidth, int startHeight, int aHeight)
	{
		
		Random rand = new Random();
		//Pick a random wall to keep.
		int wall = rand.nextInt(4); 
		
		if(wall == 0)
		{
			//remove wall 1
			column++; 
			wall = rand.nextInt(aWidth - column) + column;
			southWall[row][wall] = false;
			column--; 
			
			//remove wall 2
			row++; 
			wall = rand.nextInt(aHeight - row) + row;
			eastWall[wall][column] = false;
			row--; 
			
			//remove wall 3 
			column++; 
			wall = rand.nextInt(column - startWidth) + startWidth; 
			southWall[row][wall] = false; 
			column--; 
			
		}
		else if(wall == 1)
		{
			//remove wall 0
			row++; 
			wall = rand.nextInt(row - startHeight) + startHeight; 
			eastWall[wall][column] = false; 
			row--; 
			
			//remove wall 2
			row++; 
			wall = rand.nextInt(aHeight - row) + row;
			eastWall[wall][column] = false;
			row--; 
			
			//remove wall 3 
			column++; 
			wall = rand.nextInt(column - startWidth) + startWidth; 
			southWall[row][wall] = false; 
			column--;
		}
		else if(wall == 2)
		{
			//remove wall 0
			row++; 
			wall = rand.nextInt(row - startHeight) + startHeight; 
			eastWall[wall][column] = false; 
			row--;
			
			//remove wall 1
			column++; 
			wall = rand.nextInt(aWidth - column) + column;
			southWall[row][wall] = false;
			column--;
			
			//remove wall 3 
			column++; 
			wall = rand.nextInt(column - startWidth) + startWidth; 
			southWall[row][wall] = false;
			column--;
			
		}
		else if(wall == 3)
		{
			//remove wall 0
			row++; 
			wall = rand.nextInt(row - startHeight) + startHeight; 
			eastWall[wall][column] = false; 
			row--;
			
			//remove wall 1
			column++; 
			wall = rand.nextInt(aWidth - column) + column;
			southWall[row][wall] = false;
			column--;
			
			//remove wall 2
			row++; 
			wall = rand.nextInt(aHeight - row) + row;
			eastWall[wall][column] = false;
			row--; 
		}
	}
	/**
	 * getWidth
	 * @return the width of this maze
	 */
	public int getWidth()
	{
		// TO DO
		return width; 
	}
	
	/**
	 * getHeight
	 * @return the height of this maze
	 */
	public int getHeight()
	{
		// TO DO
		return height; 
	}
	
	/**
	 * isNorthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a north wall. Otherwise, return false
	 */
	public boolean isNorthWall(int row, int column)
	{
		// TO DO
		if(row == 0)
		{
			return true;
		}
		return southWall[row - 1][column]; 
	}
	
	/**
	 * isEastWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain an east wall. Otherwise, return false
	 */
	public boolean isEastWall(int row, int column)
	{
		// TO DO
		if(column == width - 1)
		{
			return true; 
		}
		return eastWall[row][column]; 
	}
	
	/**
	 * isSouthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a south wall. Otherwise, return false
	 */
	public boolean isSouthWall(int row, int column)
	{
		// TO DO
		if(row == height -1)
		{
			return true;
		}
		return southWall[row][column]; 
	}
	
	/**
	 * isWestWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a west wall. Otherwise, return false
	 */
	public boolean isWestWall(int row, int column)
	{
		// TO DO
		if(column == 0)
		{
			return true;
		}
		
		return eastWall[row][column - 1]; 
	}
}
