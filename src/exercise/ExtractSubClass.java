package exercise;
public class ExtractSubClass { 
// todo: extract subclass PartsItem & LaborItem from JobItem
	class JobItem {
		  private int quantity;


		  public JobItem(int quantity) {
			this.quantity = quantity;
	
		  }
		  public int getTotalPrice() {
			return quantity * getUnitPrice();
		  }	
		  public int getQuantity() {
			return quantity;
		  }

	        public abstract int getUnitPrice();

		}
	
	
	class PartsItem extends JobItem {
		private int unitPrice;
		
		public PartsItem(int unitprice, int quantity) {
			this.unitPrice = unitPrice;
			super(quantity);
		}
		
		@Override
	    public int getUnitPrice() {
	        return unitPrice;
	      }
		
	}
	
	class LaborItem extends JobItem {
		private Employee employee;
		
		public LaborItem(Employee employee,int quantity) {
			super(quantity);
			this.employee = employee;
		
		}
		
		@Override
	    public int getUnitPrice() {
	        return employee.getRate();
	      }
		
	}

	class Employee {
	  private int rate;
	  
	  public Employee(int rate) {
		this.rate = rate;
	  }
	  public int getRate() {
		return rate;
	  }
	}
	
	public void action() {
		Employee kent = new Employee(50);
		JobItem j1 = new LaborItem(kent,5);
		JobItem j2 = new PartsItem(15, 10);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}