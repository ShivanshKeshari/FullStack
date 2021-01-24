
import java.util.*;
 
class Employee implements Comparable<Employee> {
 
    private String name;
    private int id;
    private int salary;
 
    public Employee(String name, int id, int Salary) {
        this.name = name;
        this.id = id;
	this.salary=salary;

    }
 
    @Override
    public String toString() {
        return "{" +
                       "name='" + name + '\'' +
                       ", id=" + id +" Salary="+salary+
                       '}';
    }
 
    public String getName() {
        return name;
    }
 
    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }
 
    @Override
    public int compareTo(Employee o) {
         if (this.id != o.getId()) {
            return this.id - o.getId();
        }
	else if(this.name!=o.getName())
	{return this.name.compareTo(o.getName());}
	else{return this.salary - o.getSalary();}
        
    }
}
 
class Campartor
{
    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                                            new Employee("Shivansh", 15,1000),
                                            new Employee("Sparsh", 10,2000),
                                            new Employee("Utkarsh", 10,500)
                                        ));
 
        Collections.sort(employees);
        System.out.println(employees);
    }
}