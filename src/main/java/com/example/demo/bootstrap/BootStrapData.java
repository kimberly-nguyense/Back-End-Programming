package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.dto.Customer;
import com.example.demo.entities.dto.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        if (customerRepository.count() > 1){
            return;
        }
        Division texas = divisionRepository.getById(42L);
        Customer kyle = new Customer("Kyle","Nguyen","235 Tootsie Ct","12698","(735)164-3781",texas);
        customerRepository.save(kyle);

        Division newYork = divisionRepository.getById(31L);
        Customer kevin = new Customer("Kevin","Vu","346 Alben St","76598","(276)126-3547",newYork);
        customerRepository.save(kevin);

        Division florida = divisionRepository.getById(9L);
        Customer stacey = new Customer("Stacey","Ho","21 Rolling Hills Rd","56756","(735)458-8335",florida);
        customerRepository.save(stacey);

        Division england = divisionRepository.getById(101L);
        Customer vex = new Customer("Vex","Tran","967 Uptown Ave","14758","(735)456-4568",england);
        customerRepository.save(vex);

        Division ontario = divisionRepository.getById(67L);
        Customer jorge = new Customer("Jorge","Hoang","227 Downtown Ave","89018","(735)111-4968",ontario);
        customerRepository.save(jorge);

    }
}
