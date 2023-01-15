package Model;

import java.util.Objects;

import emums.vehicle;

public class Vehicle {

	
	private vehicle v;
	private Integer amount;
	private Integer count;
	
	
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	
	public vehicle getV() {
		return v;
	}
	public void setV(vehicle v) {
		this.v = v;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	public Vehicle(vehicle v, Integer amount, Integer count) {
		super();
		this.v = v;
		this.amount = amount;
		this.count = count;
	}
	
	
	@Override
	public String toString() {
		return "Vehicle [v=" + v + ", amount=" + amount + ", count=" + count + "]";
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(v);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return v == other.v;
	}


	


	

	
	
	
}
