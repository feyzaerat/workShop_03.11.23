package com.example.workShop_0313;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    List<Order> inMemoryList = new ArrayList<>();

    @GetMapping
    public List<Order> get(){
        return inMemoryList;
    }

    @GetMapping("{id}")
    public Order getById(@PathVariable int id) {
        Order order1 = inMemoryList.stream().filter((o) -> o.getId() == id).findFirst().orElseThrow();
        return order1;
    }

    @PostMapping
    public void add(@RequestBody Order order){
        inMemoryList.add(order);
    }

    @PutMapping
    public void update(@RequestBody Order order){
        Order order2 = inMemoryList.stream().filter((o)->o.getId() == order.getId()).findFirst().orElseThrow();
        order2.setName(order.getName());
    }

    @PutMapping("{id}")
    public void update2(@PathVariable int id, @RequestBody Order order){
        Order order4 = inMemoryList.stream().filter((o)->o.getId()==id).findFirst().orElseThrow();
        order4.setName(order.getName());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Order order3 = inMemoryList.stream().filter((o)-> o.getId() == id).findFirst().orElseThrow();
        inMemoryList.remove(order3);
    }

}
