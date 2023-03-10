package com.example.student.Models;


import com.example.student.Enum.BranchName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "branch")
public class Branch {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch_name")
    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private String contactNo;
    @Column(name = "grants")
    private int grants;

    private String hodName;
    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private List<CollegeStudent> collegeStudentList = new ArrayList<>();
}
