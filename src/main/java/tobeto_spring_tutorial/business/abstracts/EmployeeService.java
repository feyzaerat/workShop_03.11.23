package tobeto_spring_tutorial.business.abstracts;

import tobeto_spring_tutorial.requests.Employee.AddEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.DeleteEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.GetEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.UpdateEmployeeReq;

public interface EmployeeService {

    String add(AddEmployeeReq addEmployeeReq);
    String get(GetEmployeeReq getEmployeeReq) throws Exception;
    String getAll();

    String delete(DeleteEmployeeReq deleteEmployeeReq) throws Exception;
    String update(UpdateEmployeeReq updateEmployeeReq);
}
