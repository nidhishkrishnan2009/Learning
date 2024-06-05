package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Java8Comparator {
    public static void main(String[] args) {
        Developer dev1 = new Developer("jordan", BigDecimal.valueOf(9999));
        Developer dev2 = new Developer("jack", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("jaden", BigDecimal.valueOf(10000));
        Developer dev4 = new Developer("ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("mkyong", BigDecimal.valueOf(1));
        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5);
        Comparator<Developer> comparator=Comparator.comparing(Developer::getSalary);
        BinaryOperator<Developer> maxSalary=BinaryOperator.maxBy(comparator);
        Developer result=null;
        for(Developer dev:list){
            if(result==null){
                result=dev;
            }
            else{
               result=maxSalary.apply(dev,result);
            }
        }

        System.out.println(result.toString());
    }
}


class Developer {

    String name;
    BigDecimal salary;

    public Developer(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public BigDecimal getSalary(){
        return this.salary;
    }

    //...
}
