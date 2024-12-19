import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyzer {
    List<Employee> departmentList;
    Employee employee;


    public Analyzer(List<Employee> departmentList) {
        this.departmentList = departmentList;
    }

    //Count the number of employees that having been working at that department for more than n years
    public long moreThanYears(int years) {
        return departmentList.stream()
                .map(Employee::getYearsWorking)
                .filter(yearsWorking -> yearsWorking > years).count();
    }

    //Find the name of the employees that have a salary over n
    public void salaryOver(double n) {
        departmentList.stream()
                .map(Employee::getSalary)
                .sorted()
                .filter(salary -> salary > n)
                .forEach(System.out::println);
    }

    //Get the oldest n employees
    public void oldestEmployee(int n) {
        departmentList.stream()
                .map(Employee::getAge)
                .sorted()
                .skip(departmentList.size() - n)
                .forEach(System.out::println);
    }

    //Find the first employee older than n
    public void firstOlder(int n) {
        Optional<Employee> result = departmentList.stream()
                .filter(employee -> employee.getAge() > n)
                .findFirst();

        String name = result.isPresent() ? result.get().getName() : "No results";
        System.out.println(name);
    }

    //Find the average salary in a department
    public void averageSalary() {
        OptionalDouble result = departmentList.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        Double salary = result.isPresent() ? result.getAsDouble() : 0;
        System.out.println(salary);

    }

    //Finding common first names between the employees of two departments
    public void commonList(List<Employee> anotherList) {
        departmentList.stream().filter(employee -> anotherList.stream().anyMatch(employee1 -> employee1.getName().equals(employee.getName()))).map(Employee::getName).forEach(System.out::println);



    }
}
