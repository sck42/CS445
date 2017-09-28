//Sai Konduru 

import javax.swing.JFrame;

public class THSolverFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int numberOfDiscs = 2;
		TowerOfHanoi towers = new TowerOfHanoi(numberOfDiscs);
		THComponent thc = new THComponent(towers);
		int startPole = 0; 
		int tempPole = 1; 
		int endPole = 2; 
		
		JFrame frame = new JFrame();
		frame.setTitle("Tower of Hanoi");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(thc);
		
		frame.setVisible(true);
		
		Thread.sleep(5000);
		
		solveTower(towers, thc, numberOfDiscs, startPole, tempPole, endPole);
		
		System.out.println("DONE!!!");
	}
	
	public static void solveTower(TowerOfHanoi towers, THComponent thc, int numberOfDiscs,int startPole, int tempPole, int endPole ) throws InterruptedException
	{
		// TO DO
		if(numberOfDiscs == 1)
		{
			towers.moveTopDisc(startPole, endPole);
			thc.repaint();
			Thread.sleep(100);
		}
		else 
		{
			solveTower(towers, thc, numberOfDiscs - 1, startPole, endPole, tempPole); 
			towers.moveTopDisc(startPole, endPole); 
			thc.repaint();
			Thread.sleep(100);
			solveTower(towers, thc, numberOfDiscs - 1, tempPole, startPole, endPole);
		}
	}
}
