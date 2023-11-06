package tobeto_spring_tutorial.business.services.abstracts;

import tobeto_spring_tutorial.data.requests.Employer.AddEmployerReq;
import tobeto_spring_tutorial.data.requests.Employer.DeleteEmployerReq;
import tobeto_spring_tutorial.data.requests.Employer.GetEmployerReq;
import tobeto_spring_tutorial.data.requests.Employer.UpdateEmployerReq;

public interface EmployerService {
    String add(AddEmployerReq addEmployerReq);
    String getAll();
    String get(GetEmployerReq getEmployerReq) throws Exception;
    String delete(DeleteEmployerReq deleteEmployerReq) throws Exception;
    String update(UpdateEmployerReq updateEmployerReq);
}
