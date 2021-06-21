package cab_ride;

import java.util.*;
class rides
{
	private String driver;
	private String rider;
	private int driverRating;
	private int riderRating;
	public rides(String d, String r, int dr, int rr)
	{
		driver=d;
		rider=r;
		riderRating=rr;
		driverRating=dr;
	}
	public int getRiderRating()
	{
		return riderRating;
	}
	public int getDriverRating()
	{
		return driverRating;
	}
	public String getDriverName()
	{
		return driver;
	}
	public String getRiderName()
	{
		return rider;
	}
}

class driver
{
	private String name;
	private ArrayList<rides>ridesGiven =new ArrayList<rides>();
	
	public driver(String s)
	{
		name=s;
	}
	public void addRides(rides r)
	{
		
		this.ridesGiven.add(r);
	}
	public double getAvgRating()
	{
		double sum=0;
		for(rides r:ridesGiven)
		{
			sum+=r.getDriverRating();
		}
		double n=ridesGiven.size();
		double avg=sum/n;
		return avg;
	}
	public String getName()
	{
		return name;
	}
}


class rider
{
	private String name;
	private ArrayList<rides>ridesTaken=new ArrayList<rides>();
	private HashSet<String> blackListed = new HashSet<String>(); 
	public rider(String s)
	{
		name=s;
	}
	public void addRides(rides r)
	{
		if(r.getRiderRating()==1 || r.getDriverRating()==1)
		{
			blackListed.add(r.getDriverName());
		}
		this.ridesTaken.add(r);
	}
	public double getAvgRating()
	{
		double sum=0;
		for(rides r:ridesTaken)
		{
			sum+=r.getRiderRating();
		}
		double n=ridesTaken.size();
		double avg=sum/n;
		return avg;
	}
	
	public void print()
	{
		System.out.println(name);
		for(rides r:ridesTaken)
		{
			System.out.println(r.getDriverName()+ " "+r.getRiderRating());
		}
	}
	public Boolean checkBlaclisted(String name)
	{
		if(blackListed.contains(name))
		{
			return true;
		}
		return false;
	}
}
class process
{
	HashMap<String,driver> drivers=new HashMap<String,driver>();
	HashMap<String,rider>riders=new HashMap<String,rider>();
	public void addRides(rides r)
	{
		String dr=r.getDriverName();
		String rd=r.getRiderName();
		rider ride;
		driver drive;
		if(drivers.containsKey(dr))
		{
			drive=drivers.get(dr);
		}else
		{
			drive=new driver(dr);
			drivers.put(dr, drive);
		}
		if(riders.containsKey(rd))
		{
			ride=riders.get(rd);
		}else
		{
			ride=new rider(rd);
			riders.put(rd,ride);
		}
		drive.addRides(r);
		ride.addRides(r);
		System.out.println("done");
	}
	
	public void print()
	{
		  for(Map.Entry<String,rider> it:riders.entrySet()) {
	       	  String driverName=it.getKey();
	       	  System.out.println(driverName);
	    }
	}
	
	
	public ArrayList<String> getDriver(String str)
	{
		Double riderAvg=0.0;
		rider ride=null;
		if(riders.containsKey(str)) {
			ride = riders.get(str);
			riderAvg = ride.getAvgRating();
		}
		System.out.println("rider "+ riderAvg);
		  ArrayList<String> l = new ArrayList<String>();
		  double mx=0.0;
		  String var="none found";
		  for(Map.Entry<String,driver> it:drivers.entrySet()) {
		       	  String driverName=it.getKey();
		       	  driver driverObj= it.getValue();
		       	  double driverAvg=driverObj.getAvgRating();
		         	System.out.println(driverObj.getName()+" ->"+driverAvg );
		         	if(ride!= null && ride.checkBlaclisted(driverObj.getName()))
		       		  {
		       			  continue;
		       		  }
		       	  if(driverAvg>=riderAvg)
		       	  {
		       		  l.add(driverName);
		       	  }
		       	  if(driverAvg>mx)
		       	  {
		       		  mx=driverAvg;
		       		  var=driverObj.getName();
		       	  }
		  }
		  if(l.size()==0)
		  {
			  l.add(var);
		  }
		return l;
	}
}
public class company {
	public static void main(String args[])
 {

	process p=new process();
 	System.out.println("Input Number of Rides");
 	Scanner sc=new Scanner(System.in);
 	int numRides=sc.nextInt();
 	sc.nextLine();
 	System.out.println("input format for Rides:- "+" DriveName Click Enter "+" RiderName Clicke Enter "+" DriverRating Click Enter "+" RiderRating CLick Enter");
 	int k=1;
 	while(numRides>0)
 	{
 		System.out.println("Input urs ride "+ k);
 	   String d=sc.nextLine();
 	   String r=sc.nextLine();
 	     int dr=sc.nextInt();
 	    sc.nextLine();
 	     int rr=sc.nextInt();
 	    sc.nextLine();
 	   System.out.println(d+" "+r+" "+dr+" "+rr);
 	   rides rideObj=new rides(d,r,dr,rr);
 	  p.addRides(rideObj);
 	   numRides--;
 	   k++;
 	}
 	
 	//p.print();
	System.out.println("Input Rider Name to get Driver Name.....  or ...  Type Exit to quit");
	int ke=3;
	while(ke>1)
	{
		String rName=sc.nextLine();
		if(rName.equals("Exit"))
		{
			ke=0;
			break;
		}
		ArrayList<String>l=p.getDriver(rName);
		for(String s:l)
		{
			System.out.println(s);
		}
		System.out.println();
	}
	
	System.out.println("Thanks for using me");
	
 }

}
