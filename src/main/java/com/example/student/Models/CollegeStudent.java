package com.example.student.Models;

import com.example.student.Enum.BranchName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "college-student")
public class CollegeStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "rollNo",unique = true)
    private String rollNo;

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private int marks;

    @ManyToOne
    @JoinColumn
    private Branch branch;
}
