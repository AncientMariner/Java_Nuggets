package org.xander;

public class Employee {
  private Person person;
  
        // makes a defensive copy to protect against modifications by caller
        public Person getPerson() { return new Person(person); };
        
        public void printEmployeeDetail(Employee emp) {
          Person person = emp.getPerson();
          // this caller does not modify the object, so defensive copy was unnecessary
                System.out.println ("Employee's name: " + person.getName() + "; age: "  + person.getAge());     
        }

    /**
     * The method makes a copy to prevent modification of the original object by the caller.
     * If the compiler determines that the getPerson method is being invoked in a loop,
     * it will inline that method. In addition, through escape analysis, if the compiler determines
     * that the original object is never modified, it might optimize and eliminate the call to
     * make a copy.*/
}