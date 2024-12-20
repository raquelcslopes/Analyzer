import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String prayer = "Oh Lord, won't you buy me a trash Mercedes Benz\n" +
                "My friends all drive trash Porsches, I must make trash amends\n" +
                "Worked hard all my trash lifetime, no help from my trash friends\n" +
                "So Lord, won't you buy me a TRASH Mercedes Benz";

        //System.out.println(Arrays.stream(prayer.split("\\W+")).map(String::toUpperCase).filter(word -> !word.equals("TRASH")).reduce("", (partialString, word) -> partialString + " " + word));


        List<Employee> departmentList =Arrays.asList(
                new Employee("Ana",24, 1.200,2),
                new Employee("Mário", 19, 5.000,10),
                new Employee("Henrique", 31,2.100, 1),
                new Employee("Gabriel", 23, 6.700, 4));

        Analyzer analyzer = new Analyzer(departmentList);

        List<Employee> departmentList2 =Arrays.asList(
                new Employee("Mário",28, 1.200,2),
                new Employee("Gisela", 56, 5.000,10),
                new Employee("Henrique", 25,2.100, 1),
                new Employee("Edgar", 32, 6.700, 4));

        //System.out.println(analyzer.moreThanYears(6));

        //analyzer.salaryOver(2.000);

        //analyzer.oldestEmployee(2);
        //analyzer.firstOlder(20);
        System.out.println(analyzer.averageSalary());
        analyzer.commonList(departmentList2);

    }
}