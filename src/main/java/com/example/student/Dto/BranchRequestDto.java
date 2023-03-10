package com.example.student.Dto;


import com.example.student.Enum.BranchName;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BranchRequestDto {

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private String hodName;
    private String contactNo;
    private int grantFound;
}
