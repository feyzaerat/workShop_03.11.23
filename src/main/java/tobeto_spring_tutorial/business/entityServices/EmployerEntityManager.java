package tobeto_spring_tutorial.business.entityServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.entityServices.abstracts.EmployerEntityService;
import tobeto_spring_tutorial.data.entities.EmployerEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerEntityManager implements EmployerEntityService {
    @Override
    public EmployerEntity save(EmployerEntity employeeEntity) {
        return null;
    }

    @Override
    public EmployerEntity getById(int id) {
        return null;
    }

    @Override
    public List<EmployerEntity> getAllEntities() {
        return null;
    }

    @Override
    public EmployerEntity update(EmployerEntity employerEntity) {
        return null;
    }

    @Override
    public void delete(EmployerEntity employeeEntity) {

    }
}
