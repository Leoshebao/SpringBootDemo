package com.example.demo.repository;

import com.example.demo.domain.Discuss;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface DiscussRepository extends JpaRepository<Discuss,Integer> {
//    查询author非空的Discuss评论信息
    public List<Discuss> findByAuthorNotNull();
//    通过文章id分页查询出Discuss评论信息。
    @Query("SELECT c FROM t_comment c WHERE c.aId = ?1")
    public List<Discuss> getDiscussPaged(Integer aid, Pageable pageable);
//    通过文章id分页查询出Discuss评论信息。该方法上方的@Query注解将nativeQuery属性设置为了true，用来编写原生SQL语句。
    @Query(value = "SELECT * FROM t_comment  WHERE  a_Id = ?1",nativeQuery = true)
    public List<Discuss> getDiscussPaged2(Integer aid,Pageable pageable);

//    根据评论id修改评论作者author
    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET  c.author = ?1 WHERE c.id = ?1")
    public int updateDiscuss(String author,Integer id);

//    根据评论id删除评论
    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE  c.id = ?1")
    public int deleteDiscuss(Integer id);


}
