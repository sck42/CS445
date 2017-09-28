import java.util.ArrayList;
import javax.swing.JFrame;

public class MazeFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int width = 70;
		int height = 50;
		JFrame frame = new JFrame();
		Maze maze = new Maze(width, height);
		ArrayList<Pair<Integer,Integer>> solution = new ArrayList<Pair<Integer,Integer>>();
		MazeComponent mc = new MazeComponent(maze, solution);
		frame.setSize(800,800);
		frame.setTitle("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mc);
		frame.setVisible(true);
		int row = 0; 
		int column = 0; 
		solution.add(new Pair<Integer,Integer>(0,0));
		Thread.sleep(1000);
		solveMaze(solution, mc, maze, row, column, 0, 0);
		mc.repaint();
	}
	
	/** Solve Maze: recursively solve the maze
	 * 
	 * @param solution   : The array list solution is needed so that every recursive call,
	 *                     a new (or more) next position can be added or removed.
	 * @param mc         : This is the MazeComponent. We need that only for the purpose of
	 *                     animation. We need to call mc.repaint() every time a new position
	 *                     is added or removed. For example,
	 *                       :
	 *                     solution.add(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 *                     solution.remove(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 * @param maze       : The maze data structure to be solved. 
	 * @return a boolean value to previous call to tell the previous call whether a solution is
	 *         found.
	 * @throws InterruptedException: We need this because of our Thread.sleep(50);
	 */
	 public static boolean solveMaze(ArrayList<Pair<Integer,Integer>> solution, MazeComponent mc, Maze maze, int row, int column, int pr, int pc) throws InterruptedException
	{
		// TO DO
		if(row == maze.getHeight() - 1 && column == maze.getWidth() - 1)
		{
			return true; 
		}
		else 
		{
			if(!maze.isNorthWall(row, column) && row - 1 != pr)
			{
				Pair<Integer,Integer> point = new Pair<Integer,Integer>(row - 1,column);
				solution.add(point); 
				mc.repaint();
				Thread.sleep(50);
				boolean p = solveMaze(solution, mc, maze, row - 1, column, row, column); 
				if(p)
				{
					return true; 
				}
				solution.remove(point); 
				mc.repaint();
				Thread.sleep(50);
				
			}
			if(!maze.isEastWall(row, column) && column + 1 != pc)
			{
				Pair<Integer,Integer> point = new Pair<Integer,Integer>(row, column +1);
				solution.add(point);
				mc.repaint();
				Thread.sleep(50);
				boolean p = solveMaze(solution, mc, maze, row, column + 1, row, column); 
				if(p)
				{
					return true; 
				}
				solution.remove(point); 
				mc.repaint();
				Thread.sleep(50);
				
			}
			if(!maze.isSouthWall(row, column) && row + 1 != pr)
			{
				Pair<Integer,Integer> point = new Pair<Integer,Integer>(row + 1, column);
				solution.add(point); 
				mc.repaint();
				Thread.sleep(50);
				boolean p = solveMaze(solution, mc, maze, row + 1, column, row, column); 
				if(p)
				{
					return true; 
				}
				solution.remove(point); 
				mc.repaint();
				Thread.sleep(50);
				
			}
			if(!maze.isWestWall(row, column) && column - 1 != pc)
			{ 
				Pair<Integer,Integer> point = new Pair<Integer,Integer>(row, column - 1);
				solution.add(point); 
				mc.repaint();
				Thread.sleep(50);
				boolean p = solveMaze(solution, mc, maze, row, column - 1, row, column); 
				if(p)
				{
					return true; 
				}
				
				solution.remove(point); 
				mc.repaint();
				Thread.sleep(50);
				
			}
		}
		return false; 
		
	}
}
