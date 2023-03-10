package com.example.student.Controllers;

import com.example.student.Dto.CollegeStudentRequestDto;
import com.example.student.Service.CollegeStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collage_Syudent")
public class CollegeStudentController {


    @Autowired
    private CollegeStudentService collegeStudentService;

    @PostMapping("/add_student")

    public String addStudent(@RequestBody()CollegeStudentRequestDto collegeStudentRequestDto){
        collegeStudentService.addCollageStudent(collegeStudentRequestDto);
        return "Successfuly Added";
    }

    @GetMapping("/recent_branch_ri=oll_number")
    public ResponseEntity<List<String>> getRollNumberofStudentInMostRecentsBrabnch(){
        List<String> rollNumber = collegeStudentService.findRollNumbersofMostrecentBranch();
        return ResponseEntity.ok(rollNumber);
    }

}
