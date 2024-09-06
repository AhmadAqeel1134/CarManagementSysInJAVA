import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class CarRentalSystemMainClass 
{
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		ManagementSys carManagementSys=new ManagementSys();
		System.out.println("Welcome To Car Management System");
        while(true)
        {
        System.out.println("1.) Add Cars in List");
        System.out.println("2.) Add Renters in List");
        System.out.println("3.) See Cars Available");
        System.out.println("4.) See All the Renters and Cars");
        System.out.println("5.) Set Total Rent");
        System.out.println("6.) Get Transaction Record");
        System.out.println("7.) Set Insurance Status");
         int userCh=scanner.nextInt();
         switch(userCh)
         {
         case 1:
         {
        	 System.out.println("Enter the Car Credentials");
 			System.out.println("Enter the Car ID");
 			String carId=scanner.next();
 			System.out.println("Enter the Car Brand");
 			String carBrand=scanner.next();
 			System.out.println("Enter the Car Model");
 			String carModel=scanner.next();
 			System.out.println("Enter the Year");
 			int year=scanner.nextInt();
 			System.out.println("Enter base renting fee");
 			double rentingFee=scanner.nextDouble();
 			System.out.println("Enter number plate");
 			String numPlate=scanner.next();
 			
 		System.out.println("Select the Car Category");
 		System.out.println("1.)Compact Car\n2.)SUV Car\n3.)Luxury Car");
 		int choice=scanner.nextInt();
 		switch(choice)
 		{
 		case 1:
 		     { 
 				CompactCar car=new CompactCar(carId,carBrand,carModel,year,false,rentingFee,numPlate);
 				carManagementSys.AddCarInList(car);
 		     }
 			break;
 		case 2:
 	      	{ 
 	      		SUV car=new SUV (carId,carBrand,carModel,year,false,rentingFee,numPlate);
 	      		carManagementSys.AddCarInList(car);
 		    }
 			break;
 		case 3:
 		    {
 			    LuxuryCar car=new LuxuryCar(carId,carBrand,carModel,year,false,rentingFee,numPlate);
 			   carManagementSys.AddCarInList(car);
 	     	}
 			break;
 			default:
 				System.out.println("Error:Invalid Choice\n TryAgain");
 		
 	   }
         }
         break;
         case 2:
         {
        	System.out.println("Enter the Renter Credentials");
  			System.out.println("Enter the Renter ID");
  			String renterId=scanner.next();
  			System.out.println("Enter the Renter Name ");
  			String renterName=scanner.next();
  			System.out.println("Enter the Renter Email");
  			String renterEmail=scanner.next();
  			System.out.println("Enter Phone Number");
  			long phoneNum=scanner.nextLong();
  			System.out.println("Enter the Renter Address");
  			String renterAddress=scanner.next();
  			System.out.println("Select the Renter Category");
  	 		System.out.println("1.)Regular Renter\n2.)Frequent Renter\n3.)Corporate Renter");
  	 		int choice=scanner.nextInt();
  	 		List<Car> rentedCars=new ArrayList<>();
  	 		while(true)
  	 		{
  	 		System.out.println("Select Cars of yours Choice.");
  	 		carManagementSys.SeeAvailableCars();
  	 		String carToRentId=scanner.next();
  	 		Car newCar=carManagementSys.addCarToRent(carToRentId,carManagementSys.getCarList());
  	 		if(newCar==null)
  	 		{
  	 			System.out.println("Unable to add car in Renter's List");
  	 		}
  	 		else
  	 		{
  	 			rentedCars.add(newCar);
  	 			System.out.println("Do you want to add another car (YES/NO)");
  	 			String ch=scanner.next();
  	 			if(ch.equalsIgnoreCase("YES"))
  	 					continue;
  	 			else
  	 				break;
  	 		}
  	 		
  	 		}
  	 		if(choice==1)
  	 		{
  	 			RegularRenter renter=new RegularRenter(renterId,renterName,renterEmail,rentedCars,phoneNum,renterAddress,false);
  	 			carManagementSys.AddRentersInList(renter);
  	 		}
  	 		else if(choice==2)
  	 		{
  	 			FrequentRenter renter=new FrequentRenter(renterId,renterName,renterEmail,rentedCars,phoneNum,renterAddress,false);
  	 			carManagementSys.AddRentersInList(renter);
  	 		}
  	 		else if (choice==3)
  	 		{
  	 			CorporateRenter renter=new CorporateRenter(renterId,renterName,renterEmail,rentedCars,phoneNum,renterAddress,false);
  	 			carManagementSys.AddRentersInList(renter);
  	 		}
         }
         break;
         case 3:
         {
        	   carManagementSys.SeeAvailableCars();
         }
         break;
         case 4:
         {
        	 carManagementSys.SeeRentersAndCars();
         }
         break;
         case 5:
         {
           System.out.println("Enter the renter ID  ");
       	   String renterID=scanner.next();
           System.out.println("Enter the car ID  ");
       	   String carID=scanner.next();
       	   System.out.println("Enter the car Type 1)CompactCar/2)SUVCar/3)LuxuryCar");
      	   String carType=scanner.next();
    	   System.out.println("Enter the distance traveled cost ");
   	       double disTravCost=scanner.nextDouble();
   	       carManagementSys.AddRentInTransactionRecord(renterID, carID, disTravCost);
         }
         break;
         case 6:
         {
        	 carManagementSys.ShowTransRecords();
         }
         break;
         case 7:
         {
        	System.out.println("Enter CarID : "); 
        	String carID=scanner.next();
        	System.out.println("Enter RenterID : ");
        	String renterID=scanner.next();
        	System.out.println("Enter Damage Cost Percentage : ");
        	double percent=scanner.nextDouble();
        	carManagementSys.manageInsurance(carID,renterID,percent);
         }
         break;
         default:
        	 System.out.println("Error: Invalid Choice");
         }
        }
	}
}
		
    