package com.eset.springappheroku3.dao;


import com.eset.springappheroku3.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends  MongoRepository<Customer, Integer>{
    Customer findById(int id);
}
