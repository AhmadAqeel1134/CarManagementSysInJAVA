
import java.util.List;
import java.util.ArrayList;
public abstract class Renter
{
   private String Renter_ID;
   private String Name;
   private String Email;
   private List<Car> rentedCars;
   private long PhoneNum;
   private String address;
   private boolean hasReturn;
   
   //defining constructors
   public Renter()
   {
	   Renter_ID=""; 
	   Name="";
	   Email="";
	   rentedCars=new ArrayList<>();
	   PhoneNum=0;
	   address="";
	   hasReturn =false;
   }
   public Renter(String Renter_ID,String Name, String Email,List<Car>rentedCar,long PhoneNum,String address,boolean hasReturn) 
   {
	   this.Renter_ID=Renter_ID;
	   this.Name=Name;
	   this.Email=Email;
	   this.rentedCars=rentedCar;
	   this.PhoneNum=PhoneNum;
	   this.address=address;
	   this.hasReturn =hasReturn;
   }
   
   //defining setters
   public void setRenterID(String Renter_ID)
   {
	   this.Renter_ID=Renter_ID;
   }
   public void setName(String Name)
   {
	   this.Name=Name;
   }
   public void setEmail(String Email)
   {
	   this.Email=Email;
   }
   public void setRentedCar(List<Car> rentedCars)
   {
	   this.rentedCars=rentedCars;
   }
 
   public void setPhoneNum(long PhoneNum)
   {
	   this.PhoneNum=PhoneNum;
   }
   public void setAddress(String address)
   {
	   this.address=address;
   }
   public void setReturnStatus(boolean hasReturn)
   {
	    this.hasReturn=hasReturn;
   }
   
   //defining getters
   public String getRenterID()
   {
	   return Renter_ID;
   }
   public String getName()
   {
	   return Name;
   }
   public String getEmail()
   {
	   return Email;
   }
   public List<Car> getCarList()
   {
	   return rentedCars;
   }
   public long getPhoneNum()
   {
	   return PhoneNum;
   }
   public String getAddress()
   {
	   return address;
   }
   public boolean getReturnStatus()
   {
	   return hasReturn;
   }
   public abstract String getFeatures();
}
class RegularRenter extends Renter
{
   public RegularRenter()
   {
	   super();
   }
   public RegularRenter(String Renter_ID,String Name, String Email,List<Car>rentedCar, long PhoneNum,String address,boolean hasReturn)
   {
	   super(Renter_ID,Name,Email,rentedCar,PhoneNum,address,hasReturn);
   }
   public String getFeatures()
   {
	   return "Standard Return Rates";
   }
   
}



class FrequentRenter extends Renter
{
   public FrequentRenter()
   {
	   super();
   }
   public FrequentRenter(String Renter_ID,String Name, String Email,List<Car>rentedCar, long PhoneNum,String address,boolean hasReturn)
   {
	   super(Renter_ID,Name,Email,rentedCar,PhoneNum,address,hasReturn);
   }
   public String getFeatures()
   {
	   return "Loyalty Program with discounted rates";
   }
   
}


class CorporateRenter extends Renter
{
   public CorporateRenter()
   {
	   super();
   }
   public CorporateRenter(String Renter_ID,String Name, String Email,List<Car>rentedCar, long PhoneNum,String address,boolean hasReturn)
   {
	   super(Renter_ID,Name,Email,rentedCar,PhoneNum,address,hasReturn);
   }
   public String getFeatures()
   {
	   return "Special rates for corporate clients";
   }
   
}

