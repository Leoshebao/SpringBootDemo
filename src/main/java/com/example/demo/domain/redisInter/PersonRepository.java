package com.example.demo.domain.redisInter;

import com.example.demo.domain.redisPo.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//    严格遵守spring命名规则
//    我们定义的接口继承了 Repository, 则该接口会被 IOC 容器识别为一个 Repository Bean，进而纳入到 IOC 容器中，进而可以在该接口中定义满足一定规范的方法。
//              Spring Data可以让我们只定义接口，只要遵循 Spring Data 的规范，就无需写实现类。与继承 Repository 等价的
//    一种方式，就是在持久层接口上使用 @RepositoryDefinition 注解，并为其指定 domainClass 和 idClass 属性。
//@RepositoryDefinition(domainClass = User.class, idClass = Long.class)

public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> findByLastname(String lastname);
    Page<Person> findPersonByLastname(String lastname, Pageable page);
    List<Person> findByFirstnameAndLastname(String firstname, String lastname);
    List<Person> findByAddress_City(String city);
    List<Person> findByFamilyList_Username(String username);
}

