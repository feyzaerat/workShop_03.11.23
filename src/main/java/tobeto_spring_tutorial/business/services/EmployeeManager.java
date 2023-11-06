package tobeto_spring_tutorial.business.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.services.abstracts.EmployeeService;
import tobeto_spring_tutorial.data.entities.EmployeeEntity;
import tobeto_spring_tutorial.data.requests.Employee.AddEmployeeReq;
import tobeto_spring_tutorial.data.requests.Employee.DeleteEmployeeReq;
import tobeto_spring_tutorial.data.requests.Employee.GetEmployeeReq;
import tobeto_spring_tutorial.data.requests.Employee.UpdateEmployeeReq;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private List<EmployeeEntity> employeeEntities = new ArrayList<EmployeeEntity>();
    private int lastId;

    @Override
    public String add(AddEmployeeReq addEmployeeReq) {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        idSetter();
        employeeEntity.setId(lastId);
        employeeEntity.setName(addEmployeeReq.name());
        employeeEntity.setEmailAddress(addEmployeeReq.emailAddress());

        employeeEntities.add(employeeEntity);
        return "Çalışan eklendi: " + employeeEntity.getName();
    }

    @Override
    public String get(GetEmployeeReq getEmployeeReq) throws Exception {
        EmployeeEntity employeeEntity = this.findById(getEmployeeReq.id());

        if(employeeEntity != null) {
            return employeeEntity.toString();
        }
        throw new Exception("Böyle bir kullanıcı yok");
    }

    @Override
    public String getAll() {
        if (employeeEntities.isEmpty()) {
            throw new RuntimeException("Liste boş");
        }

        return employeeEntities.toString();
    }

    @Override
    public String delete(DeleteEmployeeReq deleteEmployeeReq) throws Exception {

        if(employeeEntities.removeIf(employeeEntity -> employeeEntity.getId() == deleteEmployeeReq.id())){
            return "Kişi silindi";
        }

        throw new Exception("Böyle bir kullanıcı yok");
    }


    @Override
    public String update(UpdateEmployeeReq updateEmployeeReq) {
        EmployeeEntity employeeEntity = this.findById(updateEmployeeReq.id());
        String deletedName = employeeEntity.getName();

        employeeEntity.setName(updateEmployeeReq.newName());
        return "Kişi güncellendi : " + deletedName + " -> " + employeeEntity.getName();
    }


    public EmployeeEntity findById(int id) {
        if (employeeEntities.isEmpty()) {
            return null;
        }

        for (EmployeeEntity employeeEntity : employeeEntities) {

            if (employeeEntity.getId() == id) {
                return employeeEntity;
            }
        }
        return null;
    }

    public void idSetter() {
        if (employeeEntities.toArray().length > 0) {
            lastId++;
        }
    }

}
