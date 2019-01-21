package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetFeatures {
	public static void main(String[] args) {
		LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>();
		t.add(new Turtle(1));
		t.add(new Turtle(2));
		t.add(new Turtle(1));

		Iterator it = t.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().hashCode());
		}

		System.out.println("Set Size = " + t.size());
		
		EmployeeSet e1 = new EmployeeSet("Arun", "Kumar", 1);
		 
		EmployeeSet e2 = new EmployeeSet("Vijay", "Kumar", 2);
		
		EmployeeSet e3 = new EmployeeSet("Vijay", "Kumar", 3);
		
        Set<EmployeeSet> empSet = new HashSet<>(0);

        empSet.add(e1);

        empSet.add(e2);

        empSet.add(e3);

        System.out.println("Employee Set size: " + empSet.size());

        System.out.println(empSet);
	}
}

class EmployeeSet {

	private String firstName;

	private String lastName;

	private int empid;

	public EmployeeSet(String firstName, String lastName, int empid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empid = empid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;

		int result = 1;

		result = prime * result + empid;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		EmployeeSet other = (EmployeeSet) obj;

		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;

		return true;
	}
	
	@Override
    public String toString() {
           return "Employee [firstName=" + firstName + ", lastName=" + lastName
                        + ", empid=" + empid + "]";
    }
}