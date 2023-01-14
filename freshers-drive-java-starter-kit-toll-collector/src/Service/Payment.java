package Service;

public class Payment {
	
	
	private static Integer fsatagPayment=0;
	private static Integer discount=0;
	private static Integer cashpayment=0;
	
	
	
	public static Integer getFsatagPayment() {
		return fsatagPayment;
	}
	public static void setFsatagPayment(Integer fsatagPayment) {
		Payment.fsatagPayment = fsatagPayment;
	}
	public static Integer getDiscount() {
		return discount;
	}
	public static void setDiscount(Integer discount) {
		Payment.discount = discount;
	}
	public static Integer getCashpayment() {
		return cashpayment;
	}
	public static void setCashpayment(Integer cashpayment) {
		Payment.cashpayment = cashpayment;
	}
	
	
	
	

}
