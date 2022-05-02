package PGDAC_28_03_2022;
/*Create a class Item with following fields
i. Itemcode
ii. itemName
iii. itemCategory (A/B/C)
iv. UnitRate
Create a class customer with following fields
i. Name
ii. MobileNumber
Create a class Bill with following fields
1. Itemdetail of class type Item
2. QtyPurchased of each item
3. TotalAmount of eachItem
4. GrossAmount
5. 12%Tax on GrossAmount
6. Netamount
The Program should display Bill of Materials Purchased with all details.*/

import java.util.*;
class Item1{
	
	private String itemcode;
    private String itemname;
    private char itemcat;
    private float unitRate;
    private float qtypur;
    private float totamt;

  	public Item1(String itemcode,String itemname,char itemcat,float unitRate,float qtypur)
  	{
		this.itemcode=itemcode;
		this.itemcat=itemcat;
		this.itemname=itemname;
		this.unitRate=unitRate;
		this.qtypur=qtypur;
		this.totamt =this.unitRate*this.qtypur ;
    }
    public String getItemcode() {
		return itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public char getItemcat() {
		return itemcat;
	}
	public float getUnitrate() {
		return unitRate;
	}
	public float getQtypur() {
		return qtypur;
	}
	public float getTotamt() {
		return totamt;
	}
}
class Bill1 extends Item1
{
	public  Bill1(String itemcode, String itemname, char itemcat, float unitrate, float qtypur)
	{
		super(itemcode,itemname,itemcat,unitrate,qtypur);
	}
}

class Customer1
{
		private String name;
		private long mob;
		private  float grossamt;
		private float taxamt;
		private float netamt;
		private Bill1[] ob; //aggregration
		
		public Customer1 ( String name, long mob)
		{
			this.name=name;
			this.mob=mob;
			ob=new Bill1[2];
		}

		public void createbill()
		{
			for(int i=0; i<ob.length; ++i) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter Item Code ");
				String itemcode = scan.nextLine();
				scan.nextLine();
				System.out.println("Enter Item Name ");
				String itemname = scan.nextLine();
				System.out.println("Enter Item Category(A/B/C) ");
				char itemcat = scan.next().charAt(0);
				System.out.println("Enter Item Unit Rate ");
				float unitrate = scan.nextFloat();
				System.out.println("Enter Item Quantity ");
				float qtypur = scan.nextFloat();
				ob[i]=new Bill1(itemcode, itemname,itemcat,unitrate,qtypur);
				grossamt += ob[i].getTotamt();
				ob[i]=new Bill1(itemcode, itemname,itemcat,unitrate,qtypur);
				grossamt += ob[i].getTotamt();
			}
		}
		
		 public void displaybill()
		 {
		 	System.out.println("Payment Details");
		 	System.out.println("Customer Name : "+name); 
		 	System.out.println("Mob. Number: "+mob);
			 System.out.println("\n Itm_cat \t\t Itm_code \t\t Itm_Name \t\t Unit_Rate \t\t " +
					 "Qty_pur \t\t Gross \t\t");
		 	for(int i=0; i<ob.length; i++) {
				System.out.println("\n" + ob[i].getItemcat() + "\t\t\t" +
						ob[i].getItemcode() + "\t\t" +
						ob[i].getItemname() + "\t\t" +
						ob[i].getUnitrate() + "\t\t" +
						ob[i].getQtypur() + "\t\t" +
						ob[i].getTotamt());
			}
		 	System.out.println();
		 	System.out.println("Gross Amount : "+getGrossamt());
		 	System.out.println("Tax( 12% ) : "+getTaxamt());
		 	System.out.println("Net Amount : "+getNetamt());

		 }
		public float getGrossamt() {
			return grossamt;
		}
		public float getTaxamt() {
			taxamt=0.12f * grossamt;
			return(taxamt);
		}
		public float getNetamt() {
			return(grossamt + taxamt);
		}
}


public class BillA2 {

	public static void main(String args[]) {
		
		Scanner scan=new Scanner (System.in);
		System.out.println("Enter Customer Name ");
		String name=scan.nextLine();
		System.out.println("Enter Customer Mobile Number ");
		long mob=scan.nextLong();
		System.out.println("Enter Customer Name ");
		String name=scan.nextLine();
		System.out.println("Enter Customer Mobile Number ");
		long mob=scan.nextLong();
	
	    Customer1 c=new Customer1(name,mob);
	    c.createbill();
	    c.displaybill();
	}
}