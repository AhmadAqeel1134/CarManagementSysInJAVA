public abstract class Car{
	 private String Car_ID;
	 private String Brand;
	 private String Model;
	 private int year;
	 private boolean rentalStatus;
	 private double rentalFee;
	 private String plateNumber;
	 
	 //Defining the constructors
	 public Car()
	 {
		 Car_ID="";
		 Brand="";
		 Model="";
		 year=0;
		 rentalStatus=false;
         rentalFee=0;
         plateNumber="";
	 }
	public Car(String Car_ID,String Brand,String Model,int year,boolean rentalStatus, double rentalFee,String plateNumber)
	{
		 this.Car_ID=Car_ID;
		 this.Brand=Brand;
		 this.Model=Model;
		 this.year=year;
		 this.rentalStatus=rentalStatus;
         this.rentalFee=rentalFee;
         this.plateNumber=plateNumber;
	}
	
	//Defining setters
	
	public void setID(String Car_ID)
	{
		Car_ID=Car_ID;
	}
	public void setBrand(String Brand)
	{
		this.Brand=Brand;
	}
	public void setModel(String Model)
	{
		this.Model=Model;
	}
	public void setYear(int year)
	{
		this.year=year;
	}
	public void setStatus(boolean rentalStatus)
	{
		this.rentalStatus=rentalStatus;
	}
	public void setRentalFee(double rentalFee)
	{
		this.rentalFee=rentalFee;
	}
    public void setPlateNum(String plateNumber)
    {
    	this.plateNumber=plateNumber;
    }
    
    //Defining getters
     public String getID()
     {
    	 return Car_ID;
     }
     public String getBrand()
     {
    	 return Brand;
     }
     public String getModel()
     {
    	 return Model;
     }
    public int getYear()
    {
    	return year;
    }
    public double getRentalFee()
    {
    	return rentalFee;
    }
    public boolean getRentalStatus()
    {
    	return rentalStatus;
    }
    public String getNumPlate()
    {
    	return plateNumber;
    }
   
    public abstract String getFeatures();
    public abstract double getRent(double disTravCost );
    public abstract boolean getInsuranceStatus();
    
}
 class CompactCar extends Car
 {
	 
	 public CompactCar()
	 {
		 super();
	 }
	 
	 public CompactCar(String Car_ID,String Brand,String Model,int year,boolean rentalStatus,double rentalFee,String plateNumber)
	 {
		 super(Car_ID,Brand,Model,year,rentalStatus,rentalFee,plateNumber);
	 }
	 
	 public String getFeatures()
	 {
		 return "Basic Features, Suitable for Short Distance Travel";
	 }
	 public double getRent(double disTravCost)
	 {
		 System.out.println("Hello " + this.getRentalFee());
		 return this.getRentalFee() + disTravCost;
	 }
	 public boolean getInsuranceStatus()
	 {
		 return false;
	 }
}
 
 class SUV extends Car
 {
	 public SUV()
	 {
		 super();
	 }
	 public SUV(String Car_ID,String Brand,String Model,int year,boolean rentalStatus,double rentalFee,String plateNumber)
	 {
		 super(Car_ID,Brand,Model,year,rentalStatus,rentalFee,plateNumber);
	 }
	
	 public String getFeatures()
	 {
		 return "Spacious, Suitable for family trips";
	 }
	 public double getRent(double disTravCost)
	 {
		 return this.getRentalFee() + disTravCost;
	 }
	 public boolean getInsuranceStatus()
	 {
		 return true;
	 }
 }
 class LuxuryCar extends Car
 {
	 public LuxuryCar()
	 {
		 super();
	 }
	 public LuxuryCar(String Car_ID,String Brand,String Model,int year,boolean rentalStatus,double rentalFee,String plateNumber)
	 {
		 super(Car_ID,Brand,Model,year,rentalStatus,rentalFee,plateNumber);
	 }
	 public String getFeatures()
	 {
		 return "High-end, Suitable for Special Occasions";
	 }
	 public double getRent(double disTravCost) 
	 {
		 final double lux_tax=1000;
		 System.out.println("Luxury Tax = " + lux_tax);
		 return this.getRentalFee() + disTravCost+lux_tax;
	 }
	 public boolean getInsuranceStatus()
	 {
		 return true;
	 }
 }

























