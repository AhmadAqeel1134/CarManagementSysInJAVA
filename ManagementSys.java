
import java.util.ArrayList;
import java.util.List;

public class ManagementSys 
{ 
   private List<Car> Car_List;
   private List<Renter> Renter_List; 
   private List<Transaction> Trans_List;
   public ManagementSys()
   {
	   //management system is composed of class
	   Car_List=new ArrayList<>();
	   Renter_List=new ArrayList<>();
	   Trans_List=new ArrayList<>();
   }
   
   public List<Car> getCarList()
   {
	   return Car_List;
   }
   public void AddCarInList(Car carToAdd)
   {

	   for (Car carAvailable:Car_List)
	   {
		   if(carAvailable.getID().equalsIgnoreCase(carToAdd.getID()))
		   {
			   System.out.println("Car Id or Number Plate already exists");
			   return;
		   }
	   }
	   //unique car found;let us add it to the list
	   System.out.println("Successfully addedd the car");
		   Car_List.add(carToAdd);
		   return;

		  	   
   }
   
   public void SeeAvailableCars()
   {
	   if(!Car_List.isEmpty())
	   {
	   		System.out.println("Cars Available");

	   for(Car carAvailable: Car_List)
	   {
		   if(!carAvailable.getRentalStatus())
		   {
			   System.out.println("***********************************");
			   System.out.println("Car ID    : " + carAvailable.getID());
			   System.out.println("Car Brand : " + carAvailable.getBrand());
			   System.out.println("Car Model : " + carAvailable.getModel());
			   System.out.println("Year      : " + carAvailable.getYear());
			   System.out.println("Rental Fee: " + carAvailable.getRentalFee());
			   System.out.println("Plate No  : " + carAvailable.getNumPlate());
			   if(carAvailable.getRentalStatus())
			   System.out.println("Rental Status : Not Rented");
			   else
			   System.out.println("Rental Status : Rented");
				   
		   }
	   }
	   
	   }
	   else
	    System.out.println("No cars available");
	   return ;
   }
   
   public void AddRentersInList(Renter renterToAdd)
   {
	   for(Renter renter:Renter_List)
	   {
		   if(renter.getRenterID().equalsIgnoreCase(renterToAdd.getRenterID()))
		   {
			   System.out.println("Renter already exists");
			   return;
		   }
	   }
	   Renter_List.add(renterToAdd);
	   System.out.println("Successfully addedd the renter");
	   return ;
   }
   
   public void ShowAllRenters()
   {
	   if(!Renter_List.isEmpty())
	   {
	   System.out.println("Renters Record");
	   for(Renter renter:Renter_List)
	   {
		  System.out.println("********************************");
		  System.out.println("Renter ID : "+renter.getRenterID());
		  System.out.println("Name      : " + renter.getName());
		  System.out.println("Email     : " + renter.getEmail());
		  System.out.println("Phone No  : " + renter.getPhoneNum());
		  System.out.println("Address   : " + renter.getAddress());
	   }  
	   }
	   else
		   System.out.println("No Rentes present in list");
	   return;
   }
   
	   
   public Car addCarToRent(String carID, List<Car> Car_List)
   {
	   for(Car car:Car_List)
	   {
		   if(carID.equalsIgnoreCase(car.getID()) && !car.getRentalStatus())
		   {
			   //car should be added in rented list
			   car.setStatus(true);
			   return car;
		   }
	   }
	   System.out.println("Car with ID "+ carID+ " not found");
	   return null;
   }
	   
   public void SeeRentersAndCars()
   {
	   if(!Renter_List.isEmpty())
	   {
	   System.out.println("Renters Record");
	   for(Renter renter:Renter_List)
	   {
		  System.out.println("********************************");
		  System.out.println("Renter ID : "+renter.getRenterID());
		  System.out.println("Name      : " + renter.getName());
		  System.out.println("Cars Taken as Rent");
		  for(Car car:renter.getCarList())
		  {
			  System.out.println("Car ID    : " + car.getID());
			  System.out.println("Car Brand : " + car.getBrand());
			  System.out.println("Base Rent :" + car.getRentalFee());
		  }
	   }  
	   }
	   else
		   System.out.println("No Rentes present in list");
	   return;
   }
	   
 public void AddRentInTransactionRecord(String renterID,String carID,double disTravCost)
 {
	 boolean isRenter=false;
	 boolean isCar=false;
	 Car carToBeRented=null;
	 		 
	 for(Car car: Car_List)
	 {
		 if(car.getID().equalsIgnoreCase(carID))
		 {
			 isCar=true;
			 carToBeRented=car;
			 break;
		 }
	 }
	 for(Renter renter: Renter_List)
	 {
		 if(renter.getRenterID().equalsIgnoreCase(renterID))
		 {
			 isRenter=true;
			 break;
		 }
	 }
	 if(isRenter && isCar && carToBeRented!=null)
	 {
		 double totalRent=0;
		 if (carToBeRented instanceof CompactCar)
	            totalRent = ((CompactCar) carToBeRented).getRent(disTravCost);
	     else if (carToBeRented instanceof SUV)
	    	 totalRent = ((SUV) carToBeRented).getRent(disTravCost);
	     else if (carToBeRented instanceof LuxuryCar)
	    	 totalRent = ((LuxuryCar) carToBeRented).getRent(disTravCost);
		Transaction newTrans=new Transaction(renterID,carID,totalRent);
		Trans_List.add(newTrans);
	 }
	 else
	 {
		 if(!isCar)
		     System.out.println("Car with ID "+ carID + "not found\n");
		 if(!isRenter)
			 System.out.println("Renter with ID " + renterID+ "not found\n");
	 }
	 return ;
 }
 
 public void ShowTransRecords()
 {
	  if(!Trans_List.isEmpty())
		 {
		  for(Transaction trans: Trans_List)
			 {
			  System.out.println("Renter ID : "+trans.getRenterID());
			  System.out.println("Car ID    : "+trans.getCarID());
			  System.out.println("Total Rent: "+ trans.getRent());
			 }
		 }
	  else
			 System.out.println("No Transaction Record Found");
	  return ;
	 
 }
 
 public void manageInsurance(String carID, String renterID,double percent)
 {
	 Car myCar=null;
	 for(Car car:Car_List)
	 {
		if(car.getID().equalsIgnoreCase(carID))
		{
			myCar=car;
			break;
		}
	 }
	 
	 if(myCar==null)
	 {
		 System.out.println("Car with ID "+ carID +" not found");
		 return ;
	 }
	 if(myCar.getInsuranceStatus())
	 {
		 System.out.println("Car is insurable");
		 double totalCost=0;
		 for(Transaction trans: Trans_List)
		 {
			 if(trans.getCarID().equalsIgnoreCase(carID))
			 {
				 totalCost=trans.getRent();
				 break;
			 }
		 }
		 System.out.println("Car is insuranle, renter will pay original amount only : "+ totalCost);
		 
		 
	 }
	 else
	 {
		 System.out.println("Car is not insurable");
		 double totalCost=0;
		 for(Transaction trans: Trans_List)
		 {
			 if(trans.getCarID().equalsIgnoreCase(carID))
			 {
				 totalCost=trans.getRent();
				 break;
			 }
		 }
		 double damCost=((percent*totalCost)/100);
		double sum=totalCost+damCost;
		 System.out.println("Car is not insuranle , damaged cost : "+ damCost);
		 System.out.println("Original Cost : "+totalCost);
		 System.out.println("Cost After Damaged : " + sum);
		 
	 }
	 return ;
 }
 
  
}
