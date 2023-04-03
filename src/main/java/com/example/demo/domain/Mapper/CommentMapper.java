package com.example.demo.domain.Mapper;

import com.example.demo.domain.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public Comment findByid(Integer id);

    @Insert("INSERT INTO t_comment(content,author,a_id) values (#{content},#{author},#{aId})")
    public  int insertComment(Comment comment);

    @Update("UPDATE t_comment SET content=#{content},author=#{author} ,a_id=#{aId} WHERE id=#{id}")
    public int unpateComment(Comment comment);

    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteComment(Integer id);

}
