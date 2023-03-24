package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "Select u From User u " +
            "Where(:keyword is null or lower(u.fullname) Like %:keyword% " +
            "or lower(u.email) Like %:keyword% )")
    List<User> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "Select u From User u " +
            "Where(:keyword is null or (lower(u.email) =:keyword and u.id != :id))")
    List<User> findByEmail(@Param("keyword") String keyword,@Param("id") int id);

    @Query(value = "Select u From User u " +
            "Where(:keyword is null or (lower(u.phone) =:keyword and u.id != :id))")
    List<User> findByPhone(@Param("keyword") String keyword,@Param("id") int id);
}
