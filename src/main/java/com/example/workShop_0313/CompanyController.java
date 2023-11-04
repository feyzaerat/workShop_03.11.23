package com.example.workShop_0313;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/company")
public class CompanyController{

    List<Company> inMemoryList = new ArrayList<>();

     @GetMapping
    public List<Company> get() {
         return inMemoryList;
     }
     @GetMapping("{id}")
     public Company getById(@PathVariable int id) {
         Company company1 = inMemoryList.stream().filter((o) -> o.getId() == id).findFirst().orElseThrow();
          return company1;
     }
     @PostMapping
    public void add(@RequestBody Company company){
         inMemoryList.add(company);
    }
    @PutMapping
    public void update(@RequestBody Company company){
         Company company2 =inMemoryList.stream().filter((o) ->o.getId() == company.getId()).findFirst().orElseThrow();
         company2.setName(company.getName());
         company2.setUsername(company.getUsername());
     }
     @PutMapping("{id}")
    public void update2(@PathVariable int id, @RequestBody Company company){
         Company company3 = inMemoryList.stream().filter((o)->o.getId()==id).findFirst().orElseThrow();
         company3.setName(company.getName());
     }

     @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
         Company company4 = inMemoryList.stream().filter((o)->o.getId()==id).findFirst().orElseThrow();
         inMemoryList.remove(company4);
     }
}

