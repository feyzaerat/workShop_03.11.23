package tobeto_spring_tutorial.business.entityServices.abstracts;

import tobeto_spring_tutorial.data.entities.EmployerEntity;

import java.util.List;

public interface EmployerEntityService {
    EmployerEntity save(EmployerEntity employeeEntity);

    EmployerEntity getById(int id);

    List<EmployerEntity> getAllEntities();

    EmployerEntity update(EmployerEntity employerEntity);

    void delete(EmployerEntity employeeEntity);
}
