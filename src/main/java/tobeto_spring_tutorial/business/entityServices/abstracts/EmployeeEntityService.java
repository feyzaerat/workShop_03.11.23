package tobeto_spring_tutorial.business.entityServices.abstracts;

import tobeto_spring_tutorial.data.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeEntityService {

    EmployeeEntity save(EmployeeEntity employeeEntity);

    EmployeeEntity getById(int id);

    List<EmployeeEntity> getAllEntities();

    EmployeeEntity update(EmployeeEntity employeeEntity);

    void delete(EmployeeEntity employeeEntity);
}
