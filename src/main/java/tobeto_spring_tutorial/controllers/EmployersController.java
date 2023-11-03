package tobeto_spring_tutorial.controllers;

import org.springframework.web.bind.annotation.*;
import tobeto_spring_tutorial.business.abstracts.EmployerService;
import tobeto_spring_tutorial.requests.Employer.AddEmployerReq;
import tobeto_spring_tutorial.requests.Employer.DeleteEmployerReq;
import tobeto_spring_tutorial.requests.Employer.GetEmployerReq;
import tobeto_spring_tutorial.requests.Employer.UpdateEmployerReq;

@RestController
@RequestMapping("api/employer")
public class EmployersController {

    private final EmployerService employerService;

    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getEmployer")
    public String get(@RequestBody GetEmployerReq getEmployerReq) throws Exception {
        return this.employerService.get(getEmployerReq);
    }

    @GetMapping("/getAllEmployers")
    public String getAll() {
        return employerService.getAll();
    }

    @PostMapping("/addEmployer")
    public String add(@RequestBody AddEmployerReq addEmployerReq){
        return this.employerService.add(addEmployerReq);
    }

    @DeleteMapping("/deleteEmployer")
    public String delete(@RequestBody DeleteEmployerReq deleteEmployerReq) throws Exception {
        return this.employerService.delete(deleteEmployerReq);
    }

    @PutMapping("/updateEmployer")
    public String update(@RequestBody UpdateEmployerReq updateEmployerReq){
        return employerService.update(updateEmployerReq);
    }

}
