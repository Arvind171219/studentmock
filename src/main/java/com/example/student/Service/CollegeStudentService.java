package com.example.student.Service;

import com.example.student.Dto.CollegeStudentRequestDto;
import com.example.student.Models.Branch;
import com.example.student.Models.CollegeStudent;
import com.example.student.Repository.BranchRepository;
import com.example.student.Repository.CollegeStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeStudentService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    CollegeStudentRepository collegeStudentRepository;

    // add Student in their respective branch

    public void addCollageStudent(CollegeStudentRequestDto collegeStudentRequestDto){
        Branch branch = branchRepository.findById(collegeStudentRequestDto.getBranch_id()).get();
        CollegeStudent collegeStudent = CollegeStudent.builder().name(collegeStudentRequestDto.getName()).rollNo(collegeStudentRequestDto.getRollNo())
                .branchName(branch.getBranchName()).marks(collegeStudentRequestDto.getMarks()).build();

        collegeStudent.setBranch(branch);
        branch.getCollegeStudentList().add(collegeStudent);
        collegeStudentRepository.save(collegeStudent);
        branchRepository.save(branch);
        System.out.println("StudentList" +branch.getCollegeStudentList().size());
    }

     // Api -2 List of Student roll -No of recent branch

    public List<String > findRollNumbersofMostrecentBranch(){
        Map<Integer,Integer> yearByBranch = new HashMap<>();

        yearByBranch.put(1,2022);
        yearByBranch.put(2,2021);
        yearByBranch.put(3,2020);
        yearByBranch.put(4,2019);
        yearByBranch.put(5,2018);
        int max=0;

        Branch branch = null;

        for(int id : yearByBranch.keySet()){
            if(yearByBranch.get(id)>max){
                max= yearByBranch.get(id);
                branch = branchRepository.findById(id).get();
            }
        }

        List<String> rollNoList = new ArrayList<>();

        assert branch!=null;
        for(CollegeStudent collegeStudent : branch.getCollegeStudentList()){
            rollNoList.add(collegeStudent.getRollNo());
        }
        return rollNoList;
    }
}
