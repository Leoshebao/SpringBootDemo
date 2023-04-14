package com.example.demo;

import com.example.demo.domain.redisInter.PersonRepository;
import com.example.demo.domain.redisPo.Address;
import com.example.demo.domain.redisPo.Family;
import com.example.demo.domain.redisPo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisTests {
    @Autowired
    private PersonRepository repository;
//准备redis数据
@Test
    public void savePerson(){
        Person person = new Person("张","有才");
        Person person2 = new Person("James","Harden");

        Address address = new Address("北京","China");
        person.setAddress(address);

        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲","张良");
        Family mom = new Family("母亲","李香君");
        list.add(dad);
        list.add(mom);
        person.setFamilyList(list);
    //    给Redi数据库添加数据
        Person save = repository.save(person);
        Person save2 = repository.save(person2);

        System.out.println(save);
        System.out.println(save2);
}
//查询redis数据
@Test
    public void selectPerson() {
        List<Person> list = repository.findByAddress_City("北京");
        System.out.println(list);
}
@Test
    public void updatePerson(){
    Person person = repository.findByFirstnameAndLastname("张","有才").get(0);
    person.setLastname("小明");
    Person unpate = repository.save(person);
    System.out.println(unpate);
}
@Test
    public void deleteperson(){
    Person person = repository.findByFirstnameAndLastname("张","小明").get(0);
    repository.delete(person);
}
}
