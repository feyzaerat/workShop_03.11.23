package tobeto_spring_tutorial.business.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.services.abstracts.EmployerService;
import tobeto_spring_tutorial.data.entities.EmployerEntity;
import tobeto_spring_tutorial.data.requests.Employer.AddEmployerReq;
import tobeto_spring_tutorial.data.requests.Employer.DeleteEmployerReq;
import tobeto_spring_tutorial.data.requests.Employer.GetEmployerReq;
import tobeto_spring_tutorial.data.requests.Employer.UpdateEmployerReq;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {

    private List<EmployerEntity> employerEntities = new ArrayList<EmployerEntity>();

    private int lastId;

    @Override
    public String add(AddEmployerReq addEmployerReq) {
        EmployerEntity employerEntity = new EmployerEntity();
        idSetter();
        employerEntity.setId(lastId);
        employerEntity.setName(addEmployerReq.name());
        employerEntity.setEmailAddress(addEmployerReq.emailAddress());

        employerEntities.add(employerEntity);
        return "Müşteri eklendi: " + employerEntity.getName();
    }

    @Override
    public String getAll() {
        if (employerEntities.isEmpty()) {
            throw new RuntimeException("Liste boş");
        }

        return employerEntities.toString();
    }

    @Override
    public String get(GetEmployerReq getEmployerReq) throws Exception {
        EmployerEntity employerEntity = this.findById(getEmployerReq.id());

        if (employerEntity != null) {
            return employerEntity.toString();
        }
        throw new Exception("Böyle bir kullanıcı yok");
    }

    @Override
    public String delete(DeleteEmployerReq deleteEmployerReq) throws Exception {
        if (employerEntities.removeIf(employerEntity -> employerEntity.getId() == deleteEmployerReq.id())) {
            return "Kişi silindi";
        }

        throw new Exception("Böyle bir kullanıcı yok");
    }

    @Override
    public String update(UpdateEmployerReq updateEmployerReq) {
        EmployerEntity employerEntity = this.findById(updateEmployerReq.id());
        String deletedName = employerEntity.getName();


        employerEntity.setName(updateEmployerReq.newName());
        return "Kişi güncellendi : " + deletedName + " -> "+ employerEntity.getName();
    }

    public EmployerEntity findById(int id) {
        if (employerEntities.isEmpty()) {
            return null;
        }

        for (EmployerEntity employerEntity : employerEntities) {

            if (employerEntity.getId() == id) {
                return employerEntity;
            }
        }
        return null;
    }

    public void idSetter() {
        if (employerEntities.toArray().length > 0) {
            lastId++;
        }
    }
}
