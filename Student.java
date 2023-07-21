package products;

public class Student {
	private int admno;
	private String name;
	private int feepaid;
	private int course;
	public  Student(int admno, String name, int feepaid, int course) {
		this.admno=admno;
		this.name=name;
		this.feepaid=feepaid;
		this.course=course;
	}
	public  Student(int admno ,String name,  int course) {
		this.admno=admno;
		this.name=name;
	this.course=course;
}
	public void payment(int amount ) {
		feepaid=feepaid+amount;
	
	}
public int getDue() {
	if (course==1)
	return 12000-feepaid;
	else 
		return 10000-feepaid;
	
}
public int getTotalFee() {
	if (course==1)
		return 12000;
	else
		return 10000;

}
public int getFeePaid() {
	return feepaid;
	 
} 
public String getCourseName() {
	if(course==1)
	{
		return "Java";
	}
	else
	
		return "Python";
	
}
}