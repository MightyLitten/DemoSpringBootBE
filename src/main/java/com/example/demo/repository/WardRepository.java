package com.example.demo.repository;

import com.example.demo.entity.District;
import com.example.demo.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward,Integer> {
    @Query(value = "Select w From Ward w " +
            "Where(:keyword is null or w.dcode = :keyword )")
    List<Ward> findByDcode(@Param("keyword") int keyword);
}
