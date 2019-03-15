package question1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeCollection {

    private List<Employee> employeeList;
    private Set<Integer> empIdSet = new HashSet<Integer>();

    public EmployeeCollection() {
        employeeList = new ArrayList<Employee>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    /**
     * Method to add employee to employeeList
     * 
     * @param empId
     * @param name
     * @param address
     * @return true if added successfully
     * @throws AssertionError if employee id is negative or zero, or name or address
     *                        is null
     */
    public boolean addEmployee(int id, String name, String address) {

        if (id > 0 && name != null && address != null) {
            if (!empIdSet.contains(id)) {
                Employee employee = new Employee(id, name, address);
                empIdSet.add(id);
                employeeList.add(employee);
                return true;
            } else
                return false;

        } else {
            MyLogFile.writeToFile("Invalid Input in addEmployee on: "+new Date());
            throw new AssertionError("Invalid input");
        }
    }

    /**
     * Method calls compare method of SortById class to sort employees on the basis
     * of id
     */

    public List<Employee> sortById() {
        Employee temp;
        for (int i = 0; i < employeeList.size(); ++i) {
            for (int j = i + 1; j < employeeList.size(); ++j) {
                if (employeeList.get(i).getId() > employeeList.get(j).getId()) {
                    temp = employeeList.get(i);
                    employeeList.set(i, employeeList.get(j));
                    employeeList.set(j, temp);
                }

            }
        }
        return employeeList;
    }

    /**
     * Method calls compare method of SortById class to sort employees on the basis
     * of name
     */

    public List<Employee> sortByName() {
        Employee temp;
        for (int i = 0; i < employeeList.size(); ++i) {
            for (int j = i + 1; j < employeeList.size(); ++j) {
                if (employeeList.get(i).getName().compareTo(employeeList.get(j).getName()) > 0) {
                    temp = employeeList.get(i);
                    employeeList.set(i, employeeList.get(j));
                    employeeList.set(j, temp);
                }
            }
        }
        return employeeList;
    }

    @Override
    public String toString() {
        return "EmployeeCollection [employeeList=" + employeeList + "]";
    }

}
