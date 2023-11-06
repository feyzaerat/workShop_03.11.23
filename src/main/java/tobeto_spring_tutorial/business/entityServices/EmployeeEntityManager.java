package tobeto_spring_tutorial.business.entityServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.entityServices.abstracts.EmployeeEntityService;
import tobeto_spring_tutorial.data.entities.EmployeeEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeEntityManager implements EmployeeEntityService {
    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public EmployeeEntity getById(int id) {
        return null;
    }

    @Override
    public List<EmployeeEntity> getAllEntities() {
        return null;
    }

    @Override
    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public void delete(EmployeeEntity employeeEntity) {

    }
}
