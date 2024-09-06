import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Transaction 
{
   private String RenterID;
   private String CarID;
   private double TotalRent;
   
   public Transaction()
   {
	   RenterID="";
	   CarID="";
	   TotalRent=0.0;
   }
   
   public Transaction(String RenterID, String CarID, double TotalRent)
   {
	   this.RenterID=RenterID;
	   this.CarID=CarID;
	   this.TotalRent=TotalRent;
   }
   
   //setters
  public void setRenterID(String RenterID)
  {
	  this.RenterID=RenterID;
  }
  public void setCarID(String CarID)
  {
	  this.CarID=CarID;
  }
  public void setTotalRent(double TotalRent)
  {
	  this.TotalRent=TotalRent;
  }
   //getters
  public String getRenterID()
  {
	  return this.RenterID;
  }
  public String getCarID()
  {
	  return this.CarID;
  }
  public double getRent()
  {
	  return this.TotalRent;
  }
   
}
