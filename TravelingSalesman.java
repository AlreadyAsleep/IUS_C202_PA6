
/**
 *
 * @author benheil
 * @since 06072017
 * @version PA6
 */
import java.util.*;
import java.io.*;
public class TravelingSalesman
{
    private int city = 0;
    Scanner stdin;
    private int[][] adjacency;
    int bestCost = Integer.MAX_VALUE;
    int count = 0;
    
    public void setCity(int i)
    {
        this.city = i;
        adjacency = new int[city ][city];
    }
    
    public int getCity()
    {	
        return city;
    }
    
    public void getFile()
    {
        File file;
        try
        {
            file = new File("src/tsp" + city + ".txt");
            stdin = new Scanner(file);
        }
        catch(Exception e)
        {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    public ArrayList<Integer> getListOfCities(int i)
    {
        ArrayList<Integer> a = new ArrayList<>();
        for(int j = 0; j < i  ; j++)	
        {
            a.add(j);	
        }	
        return a;
    }
    
    public void setMatrix(int[][] adjacency)
    {
        int value, i, j; 
        for (i = 0; i < city && stdin.hasNext(); i++) { 
            for (j = i; j < city && stdin.hasNext(); j++){ 
                if (i == j) { 
                    adjacency[i][j] = 0;
                }
                else {
                    value = stdin.nextInt();
                    adjacency[i][j] = value;
                    adjacency[j][i] = value;
                }
            }
        }
        this.adjacency = adjacency;
        stdin.close();
    }

    public void printMatrix()
    {
        for(int i = 0; i < adjacency.length; i++)
        {
            System.out.println();
            for(int j = 0; j < adjacency[i].length; j++)
            {
                System.out.print(adjacency[i][j] + "    ");
            }	
        }
    }
    
    
    public void findCheapestRoute()
    {
        //dec/ini all data containers
        Stack<Integer> pathStack = new Stack<>();
        boolean[] visitedCities = new boolean[city];
        int[] cities = new int[city];
        for(int i = 0; i < city; i++)
        {
            cities[i] = i;
            visitedCities[i] = false;
        }
        visitedCities[0] = true;
        pathStack.push(cities[0]);
        int closestCity = 0;//this is an index
        boolean minFlag = false;
        System.out.print(closestCity);
        int currentCity;
        int cost = 0;
        while(!pathStack.isEmpty())
        {
            int min = Integer.MAX_VALUE;
            currentCity = pathStack.peek();//starts at the top city on the stack
            for(int i = 1; i < cities.length; i++)
            {
                  if(adjacency[currentCity][i] > 0 && !visitedCities[i])//ensures no duplicate traveling
                  {
                      if(adjacency[currentCity][i] < min)//if this city has the lowest travel cost
                      {
                          min = adjacency[currentCity][i];
                          closestCity = i;//remember it's an index
                          minFlag = true;//will be true until all cities have been traveled to
                      }
                  }
            }
            if(minFlag)
            {
                cost += min;
                visitedCities[closestCity] = true;
                pathStack.push(closestCity);//adds the next closest city to the stack, so the next iteration will be with this city
                System.out.print(" -> " + pathStack.peek());
                minFlag = false;
                continue;
            }
            pathStack.pop();
        }
        System.out.println("\nCost: " +  cost);
    }
    
    public static void main(String[] args) 
    {
        int[][] arr;
        TravelingSalesman ts = new TravelingSalesman();
        ts.setCity(29);
        arr = new int[ts.getCity()][ts.getCity()];
        ts.getFile();
        ts.setMatrix(arr);
        System.out.println(ts.getCity() + " city matrix");
        ts.findCheapestRoute();
    }
    
}
