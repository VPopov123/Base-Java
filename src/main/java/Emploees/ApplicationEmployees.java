package Emploees;

import Emploees.comporators.SortByAge;
import Emploees.comporators.SortByName;
import Emploees.comporators.SortByPay;
import Emploees.comporators.SortByWorkAge;
import jdk.dynalink.Operation;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ApplicationEmployees {
    public static void main(String[] args){
        //Create Employees
        Emploee first = Emploee.builder().name("Васька")
                                        .age(15)
                                        .pay(500)
                                        .workAge(40)
                                        .build();
        Emploee second = Emploee.builder().name("Олег")
                                        .age(100)
                                        .pay(1000000)
                                        .workAge(120)
                                        .build();
        Emploee third = Emploee.builder().name("Серёга")
                                        .age(200)
                                        .pay(15)
                                        .workAge(199)
                                        .build();

        List<Emploee> emploees = new ArrayList<Emploee>();
        emploees.add(first);
        emploees.add(second);
        emploees.add(third);

        //Create Comparators
        Comparator<Emploee> sortByAge = new SortByAge();
        Comparator<Emploee> sortByName = new SortByName();
        Comparator<Emploee> sortByPay = new SortByPay();
        Comparator<Emploee> sortByWorkAge = new SortByWorkAge();

        System.out.println("Sorted by name  :");
        emploees.sort(sortByName);
        for (var curr:emploees) {
            curr.print();
        }
        System.out.println("\n\n");

        System.out.println("Sorted by age  :");
        emploees.sort(sortByAge);
        for (var curr:emploees) {
            curr.print();
        }
        System.out.println("\n\n");

        System.out.println("Sorted by pay  :");
        emploees.sort(sortByPay);
        for (var curr:emploees) {
            curr.print();
        }
        System.out.println("\n\n");

        System.out.println("Sorted by work age  :");
        emploees.sort(sortByWorkAge);
        for (var curr:emploees) {
            curr.print();
        }
        System.out.println("\n\n");

        System.out.println("pay > 100k  :");
        for (var emp:emploees) {
            if(emp.getPay() > 100000) emp.print();
        }
        System.out.println("\n\n");

        System.out.println("emploee with max pay  :");
        Emploee emp = emploees.get(0);
        for (var curr:emploees) {
            if(curr.getPay() > emp.getPay()) emp = curr;
        }
        emp.print();
        System.out.println("\n\n");


        System.out.println("average pay  :");
        int aver = 0;
        for (var curr:emploees) {
            aver += curr.getPay();
        }
        aver /= emploees.size();
        System.out.println(aver);
        System.out.println("\n\n");

        System.out.println("pay sum  :");
        int sum = 0;
        for (var curr:emploees) {
            sum += curr.getPay();
        }
        System.out.println(sum);
        System.out.println("\n\n");

    }
}

