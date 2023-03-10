package com.example.student.Controllers;

import com.example.student.Dto.BranchRequestDto;
import com.example.student.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    // api to adding branch

    @PostMapping("/addBranch")
    public String addBranch(@RequestBody()BranchRequestDto branchRequestDto){
        branchService.addBranch(branchRequestDto);
        return "Successfuly added";
    }

    // Api -2 for getting HOD contact number

    @GetMapping("/gethod_contact_number")

    public ResponseEntity<List<String>> getContactnumbersofHodwithmaxmumPassingstudents(){
        List<String> contactNumber = branchService.findContactNoofHODwithmaxpassingStudent();
        return ResponseEntity.ok(contactNumber);
    }


    // Api-3 for getting brantAssociated with requied branch

    @GetMapping("/get_grant_of_recents_branc")

    public ResponseEntity<Integer> getGrantForDepartmentswithmaximumpassingStudent(){
        Integer grant = branchService.findGrantGivenToDepartmentswithMaxPassingStudents();
        return ResponseEntity.ok(grant);
    }
}
