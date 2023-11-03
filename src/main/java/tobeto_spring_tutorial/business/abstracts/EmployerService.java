package tobeto_spring_tutorial.business.abstracts;

import tobeto_spring_tutorial.requests.Employee.GetEmployeeReq;
import tobeto_spring_tutorial.requests.Employer.AddEmployerReq;
import tobeto_spring_tutorial.requests.Employer.DeleteEmployerReq;
import tobeto_spring_tutorial.requests.Employer.GetEmployerReq;
import tobeto_spring_tutorial.requests.Employer.UpdateEmployerReq;

public interface EmployerService {
    String add(AddEmployerReq addEmployerReq);
    String getAll();
    String get(GetEmployerReq getEmployerReq) throws Exception;
    String delete(DeleteEmployerReq deleteEmployerReq) throws Exception;
    String update(UpdateEmployerReq updateEmployerReq);
}
