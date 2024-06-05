package com.learning.test;

import com.learning.util.TestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestCommonUtil {
    public static void main(String[] args) {
//        TestUtil util=new TestUtil();
//        util.printHello();
       // findLast2Elements();
      //  optionalTest();
//        if(!"".equals(null)){
//            System.out.println("test");
//        }
        //System.out.println(TestEnum.NIDISH.getValue());
        Long test=null;
        System.out.println(String.valueOf(test.toString()));
    }

    public static void findLast2Elements(){
        List<String> list=List.of("abc","xyz","lmn","qws");
        List<String> newList=list.stream().skip(list.size()-2).collect(Collectors.toList());
        System.out.println(newList.get(0));
        System.out.println(newList.size());
        String lastElem=list.stream().reduce((prev,current)->current).orElse(null);
        System.out.println(String.format("%s#",lastElem));
    }

    public static void optionalTest(){
        List<Employee> employeeList1=null;
        List<Employee> employeeList=new ArrayList<>();
        Employee e1= new Employee("Nidish",32,null);
        Employee e2=new Employee("Naija",29,null);
        e1.setAddress(new Employee.Address("components",1234,new Employee.Department(null,"abc")));
        employeeList.add(e1);
        employeeList.add(e2);
//        Optional.ofNullable(employeeList1).ifPresent(e->{
//            System.out.println(e);
//        });

        Optional<String> deptName=Optional.ofNullable(e1).map(e->e.getAddress()).map(a->a.getDepartment()).map(d->d.getDeptName());
        deptName.ifPresent(dept->{
            System.out.println(dept);
        });
    }
}
