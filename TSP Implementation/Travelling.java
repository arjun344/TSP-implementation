import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Stack;
import java.io.*;


class TSPNearestNeighbour
{
	private int numberOfNodes;
	private Stack<Integer> stack;

	public TSPNearestNeighbour()
	{
		stack=new Stack <Integer>();
	}

	public void tsp(int adjacencyMatrix[][])
	{
		numberOfNodes=4; //length of firstrow
		int[] pathArray=new int[numberOfNodes+1];
		int temp=0,count=1,k=1,param=0;;
		int[] visited=new int[numberOfNodes+1];	
		visited[1]=1;	//visited the source vertex
		stack.push(1);	//push the visited vertex to stack

		int element,distance=0,i;
		int min = Integer.MAX_VALUE;
		boolean minFlag=false;
		System.out.print(1+"----->");

		while(!stack.isEmpty())
		{
			element=stack.peek();	//get the preveiously visited node
			i=1;
			min=Integer.MAX_VALUE;

			while(i<=numberOfNodes) //check for nearest beighbour among all nodes
			{
				if(adjacencyMatrix[element][i]>=1 && visited[i]==0)
				{
					if(min>adjacencyMatrix[element][i])
					{
						min=adjacencyMatrix[element][i];
						distance=i;
						minFlag=true;
					}
				}

				i++;

			}

			if(count<numberOfNodes)
			{
				temp=temp+min;
				count++;
			}

			if(minFlag)
			{
				visited[distance]=1;
				stack.push(distance);
				System.out.print(distance+"----->");
				pathArray[k]=distance;
				param=pathArray[k];
				k++;
				minFlag=false;
				continue;
			}
			stack.pop();
		}

		System.out.println("1");
		System.out.println();
		System.out.print("The Sum Of The Path To Be Followed is : ");
		System.out.println(temp+adjacencyMatrix[param][1]);
		
	}



	public static void main(String... arg) throws IOException
	{
		int number_of_nodes;
		Scanner scanner=null;
		File file = new File("in.txt");
		Scanner scan = new Scanner(file);
		int [] input = new int [1765];
		int k=0,m=0;
		while(scan.hasNextInt())
		{
     		input[k++] = scan.nextInt();
		}
		try
		{
			scanner=new Scanner(System.in);
			number_of_nodes=4;
			int adjacency_Matrix[][]=new int[number_of_nodes+1][number_of_nodes+1];
			for(int i=1;i<=number_of_nodes;i++)
			{
				for(int j=1;j<=number_of_nodes;j++)
				{
					adjacency_Matrix[i][j]=input[m];
					m++;
				}
			}

			for(int i=1;i<=number_of_nodes;i++)
			{
				for(int j=1;j<=number_of_nodes;j++)
				{
					if(adjacency_Matrix[i][j]==1 && adjacency_Matrix[j][i]==0 )
					{
						adjacency_Matrix[j][i]=1;
					}

					if(adjacency_Matrix[i][j]==0 && i!=j)
					{
						adjacency_Matrix[i][j]=9999;
					}

					//System.out.print(adjacency_Matrix[i][j]+" ");
				}
				//System.out.println();
			}

			System.out.println("The Cities are Visited as Follows :");
			System.out.println();
			TSPNearestNeighbour tspNearestNeighbour=new TSPNearestNeighbour();
			tspNearestNeighbour.tsp(adjacency_Matrix);
			System.out.println();
			System.out.println();


		}catch(InputMismatchException inputMismatch)
		{
			System.out.println("Wrong Input format");
		}
		scanner.close();
	}


}