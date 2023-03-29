package com.example.demo.repository;

import com.example.demo.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {
    @Query(value = "Select d From District d " +
            "Where(:keyword is null or d.pcode = :keyword )")
    List<District> findByPcode(@Param("keyword") int keyword);
}
