package tobeto_spring_tutorial.business;

import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.entities.baseEntites.Employee;
import tobeto_spring_tutorial.requests.Employee.AddEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.DeleteEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.GetEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.UpdateEmployeeReq;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManager implements tobeto_spring_tutorial.business.abstracts.EmployeeService {

    private List<Employee> employees = new ArrayList<Employee>();
    private int lastId;

    @Override
    public String add(AddEmployeeReq addEmployeeReq) {

        Employee employee = new Employee();
        idSetter();
        employee.setId(lastId);
        employee.setName(addEmployeeReq.name());
        employee.setEmailAddress(addEmployeeReq.emailAddress());

        employees.add(employee);
        return "Çalışan eklendi: " + employee.getName();
    }

    @Override
    public String get(GetEmployeeReq getEmployeeReq) throws Exception {
        Employee employee = this.findById(getEmployeeReq.id());

        if(employee != null) {
            return employee.toString();
        }
        throw new Exception("Böyle bir kullanıcı yok");
    }

    @Override
    public String getAll() {
        if (employees.isEmpty()) {
            throw new RuntimeException("Liste boş");
        }

        return employees.toString();
    }

    @Override
    public String delete(DeleteEmployeeReq deleteEmployeeReq) throws Exception {

        if(employees.removeIf(employee -> employee.getId() == deleteEmployeeReq.id())){
            return "Kişi silindi";
        }

        throw new Exception("Böyle bir kullanıcı yok");
    }


    @Override
    public String update(UpdateEmployeeReq updateEmployeeReq) {
        Employee employee = this.findById(updateEmployeeReq.id());
        String deletedName = employee.getName();

        employee.setName(updateEmployeeReq.newName());
        return "Kişi güncellendi : " + deletedName + " -> " + employee.getName();
    }


    public Employee findById(int id) {
        if (employees.isEmpty()) {
            return null;
        }

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void idSetter() {
        if (employees.toArray().length > 0) {
            lastId++;
        }
    }

}
