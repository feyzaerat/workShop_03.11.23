package tobeto_spring_tutorial.business;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tobeto_spring_tutorial.entities.baseEntites.Employer;
import tobeto_spring_tutorial.requests.Employer.AddEmployerReq;
import tobeto_spring_tutorial.requests.Employer.DeleteEmployerReq;
import tobeto_spring_tutorial.requests.Employer.GetEmployerReq;
import tobeto_spring_tutorial.requests.Employer.UpdateEmployerReq;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements tobeto_spring_tutorial.business.abstracts.EmployerService {

    private List<Employer> employers = new ArrayList<Employer>();

    private int lastId;

    @Override
    public String add(AddEmployerReq addEmployerReq) {
        Employer employer = new Employer();
        idSetter();
        employer.setId(lastId);
        employer.setName(addEmployerReq.name());
        employer.setEmailAddress(addEmployerReq.emailAddress());

        employers.add(employer);
        return "Müşteri eklendi: " + employer.getName();
    }

    @Override
    public String getAll() {
        if (employers.isEmpty()) {
            throw new RuntimeException("Liste boş");
        }

        return employers.toString();
    }

    @Override
    public String get(GetEmployerReq getEmployerReq) throws Exception {
        Employer employer = this.findById(getEmployerReq.id());

        if (employer != null) {
            return employer.toString();
        }
        throw new Exception("Böyle bir kullanıcı yok");
    }

    @Override
    public String delete(DeleteEmployerReq deleteEmployerReq) throws Exception {
        if (employers.removeIf(employer -> employer.getId() == deleteEmployerReq.id())) {
            return "Kişi silindi";
        }

        throw new Exception("Böyle bir kullanıcı yok");
    }

    @Override
    public String update(UpdateEmployerReq updateEmployerReq) {
        Employer employer = this.findById(updateEmployerReq.id());
        String deletedName = employer.getName();


        employer.setName(updateEmployerReq.newName());
        return "Kişi güncellendi : " + deletedName + " -> "+ employer.getName();
    }

    public Employer findById(int id) {
        if (employers.isEmpty()) {
            return null;
        }

        for (Employer employer : employers) {

            if (employer.getId() == id) {
                return employer;
            }
        }
        return null;
    }

    public void idSetter() {
        if (employers.toArray().length > 0) {
            lastId++;
        }
    }
}
