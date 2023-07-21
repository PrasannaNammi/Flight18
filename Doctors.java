package products;

abstract class Doctor {
	protected String name;

	public Doctor(String name) {
		this.name = name;
	}

	void print() {
		System.out.println(name);
	}

	public String getName() {
		return this.name = name;

	}

	void setName(String name) {
		this.name = name;
	}

	abstract int getPay();
}

class ResidentDoctor extends Doctor {
	private int salary;

	public ResidentDoctor(String name, int salary) {
		super(name);
		this.salary = salary;
	}

	@Override
	void print() {
		super.print();
		System.out.println(this.salary);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int getPay() {
		return this.salary = salary;
	}
}

class ConsultantDoctor extends Doctor {
	private int visits;
	private int rate;

	public ConsultantDoctor(String name, int visits, int rate) {
		super(name);
		this.visits = visits;
		this.rate = rate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	void print() {
		super.print();
		System.out.println(this.visits);
		System.out.println(this.rate);
	}

	@Override
	int getPay() {
		return visits * rate;
	}
}

public class Doctors {
}
