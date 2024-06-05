package com.learning.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
   private String name;
   private int age;
   private Address address;


   @Data
   @AllArgsConstructor
   static class Address{
      private String street;
      private int zipCode;
      private Department department;
   }

   @Data
   @AllArgsConstructor
   static class Department{
      private String deptName;
      private String managerName;
   }
}
