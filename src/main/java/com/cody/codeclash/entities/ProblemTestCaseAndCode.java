package com.cody.codeclash.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class ProblemTestCaseAndCode {

    @Id
    private Long id;

    // Share the same ID as Problem
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    // Unidirectional One-to-Many relationship with EntryCode
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "problem_test_case_and_code_id") // Defines the foreign key in EntryCode table
    private List<EntryCode> entryCodes = new ArrayList<>();

    // Unidirectional One-to-Many relationship with TestCase
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "problem_test_case_and_code_id") // Defines the foreign key in TestCase table
    private List<TestCase> testCases = new ArrayList<>();

    public void addEntryCode(EntryCode entryCode) {
        entryCodes.add(entryCode);
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    public void removeEntryCode(EntryCode entryCode) {
        entryCodes.remove(entryCode);
    }

    public void removeTestCase(TestCase testCase) {
        testCases.remove(testCase);
    }

}
