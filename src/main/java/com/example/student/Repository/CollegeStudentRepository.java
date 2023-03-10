package com.example.student.Repository;

import com.example.student.Models.CollegeStudent;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmConfigParameterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CollegeStudentRepository extends JpaRepository<CollegeStudent,Integer> {
  List<CollegeStudent> findByBranchMarksGreaterThanEqual(Integer id, Integer marks);
}
