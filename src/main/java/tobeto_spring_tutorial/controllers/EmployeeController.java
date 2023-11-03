package tobeto_spring_tutorial.controllers;

import org.springframework.web.bind.annotation.*;
import tobeto_spring_tutorial.business.abstracts.EmployeeService;
import tobeto_spring_tutorial.requests.Employee.AddEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.DeleteEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.GetEmployeeReq;
import tobeto_spring_tutorial.requests.Employee.UpdateEmployeeReq;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployee")
    public String get(@RequestBody GetEmployeeReq getEmployeeReq) throws Exception {
        return employeeService.get(getEmployeeReq);
    }

    @GetMapping("/getAllEmployee")
    public String getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/addEmployee")
    public String add(@RequestBody AddEmployeeReq addEmployeeReq) {
        return employeeService.add(addEmployeeReq);
    }

    @DeleteMapping("/deleteEmployee")
    public String delete(@RequestBody DeleteEmployeeReq deleteEmployeeReq) throws Exception {
        return employeeService.delete(deleteEmployeeReq);
    }

    @PutMapping("/updateEmployee")
    public String update(@RequestBody UpdateEmployeeReq updateEmployeeReq) {
        return employeeService.update(updateEmployeeReq);
    }

}
