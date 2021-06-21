package leaderboard;

import java.util.*;
class Player
{
	private String name;
	Player(String n)
	{
		name=n;
	}
	public String getName() {
		return name;
	}
}

class Team
{
	private String teamName;
	private int numberOfPlayer;
	private int totalPoints;
	private ArrayList<Player>players;
	Team (String n, int num,int points, ArrayList<Player>p)
	{
		totalPoints=points;
		teamName=n;
		numberOfPlayer=num;
		players=p;
	}
	public String getTeamName()
	{
		return teamName;
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	public int getTotalPoints()
	{
		return totalPoints;
	}
}

class Cricket
{
	private int numberOfTeam;
	private ArrayList<Team> teams;
	Cricket(int num, ArrayList<Team> t)
	{
		numberOfTeam=num;
		teams=t;
	}
	public String maxPoints()
	{
		int mx=Integer.MIN_VALUE;
		String team="";
		
		for(Team t:teams)
		{
			String n= t.getTeamName();
		    int p=t.getTotalPoints();
		    if(p>mx)
		    {
		    	mx=p;
		    	team=n;
		    }
		}
		return team;
	}
}
public class Demo {
public static void main(String args[])
{
	int tNum;
	Scanner obj=new Scanner(System.in);
	System.out.println("Input Number of Team");
	tNum= obj.nextInt();
	obj.nextLine();
	int x=tNum;
	ArrayList<Team> tl=new ArrayList<Team>();
	int marker=1;
	while(x>0) {
		System.out.println("Input name of team " + marker);
		String tName=obj.nextLine();
		System.out.println("Input number of players in team "+ tName);
		int pNum= obj.nextInt();
		obj.nextLine();
		System.out.println("Input name of "+ pNum + " players");
		ArrayList<Player> pl=new ArrayList<Player>();
		for(int i=0;i<pNum;i++)
		{
			String pName=obj.nextLine();
			Player p =new Player(pName);
			pl.add(p);
		}
		System.out.println("Input  of total points of team");
		
		int tPoints=obj.nextInt();
		obj.nextLine();
		Team t= new Team(tName,pNum,tPoints,pl);
		tl.add(t);
		x--;
		marker++;
	}
	Cricket ck=new Cricket(tNum,tl);
	System.out.println(ck.maxPoints());
}
}
