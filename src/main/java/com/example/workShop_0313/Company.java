package com.example.workShop_0313;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Company{

     private int id;
     private String name;
     private String username;


}
