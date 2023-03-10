package com.example.student.Service;

import com.example.student.Dto.BranchRequestDto;
import com.example.student.Models.Branch;
import com.example.student.Models.CollegeStudent;
import com.example.student.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    private CollegeStudentService collegeStudentService;

    @Autowired
    private BranchRepository branchRepository;


    // add branch Api

    public void addBranch(BranchRequestDto branchRequestDto){
        Branch branch = Branch.builder().branchName(branchRequestDto.getBranchName())
                        .hodName(branchRequestDto.getHodName())
                .contactNo(branchRequestDto.getContactNo())
                .grants(branchRequestDto.getGrantFound()).build();

        branchRepository.save(branch);
    }

    // Api getting hod contact


    public List<String > findContactNoofHODwithmaxpassingStudent(){
        List<Branch> allBranchList = branchRepository.findAll();
        int passStudentCount =Integer.MIN_VALUE;
        int id=0;

        for(Branch branch:allBranchList){
            List<CollegeStudent>  collegeStudentList = branch.getCollegeStudentList();
            int count=0;
            for(CollegeStudent collegeStudent: collegeStudentList){
                if(collegeStudent.getMarks()>=40) count++;
            }
            if(count>=passStudentCount){
                passStudentCount=count;
                id=branch.getId();
            }
        }
        Branch requiredBranch  = branchRepository.findById(id).get();
        List<String > contactNoList = new ArrayList<>();
        contactNoList.add(requiredBranch.getContactNo());
        return contactNoList;
    }

    // Api Implementing brant Associated with required branch

    public Integer findGrantGivenToDepartmentswithMaxPassingStudents(){
        List<Branch> allBranchList = branchRepository.findAll();
        int PassStudentCount = Integer.MIN_VALUE;
        int id=0;
        for(Branch branch : allBranchList){
            List<CollegeStudent> collegeStudentList=branch.getCollegeStudentList();
            int count=0;
            for(CollegeStudent collegeStudent : collegeStudentList){
                if(collegeStudent.getMarks()>=40) count++;
            }
            if(count>=PassStudentCount){
                PassStudentCount=count;
                id= branch.getId();
            }
        }
        Branch requiredBranch = branchRepository.findById(id).get();
        return requiredBranch.getGrants();
    }

}
