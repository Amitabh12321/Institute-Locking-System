package com.example.InstituteLockingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "college_lock_status")
public class CollegeLockStatus extends LockParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "aishe_code", nullable = false)
    private String aisheCode;

    @Column(name = "survey_year",nullable = false)
    private Integer surveyYear;

    @Column(name = "basic_detail")
    private Boolean basicDetail;

    @Column(name = "address")
    private Boolean address;

    @Column(name = "econtact")
    private Boolean eContact;

    @Column(name = "vernacular_name")
    private Boolean vernacularName;

    @Column(name = "alternate_name")
    private Boolean alternateName;

    @Column(name = "list_of_department")
    private Boolean listOfDepartment;

    @Column(name = "list_of_faculty")
    private Boolean listOfFaculty;

    @Column(name = "regular_prog_through_department")
    private Boolean regularProgThroughDepartment;

    @Column(name = "regular_prog_other")
    private Boolean regularProgOther;

    @Column(name = "enroll_regular_prog_through_department")
    private Boolean enrollRegularProgThroughDepartment;

    @Column(name = "enroll_regular_prog_other")
    private Boolean enrollRegularProgOther;

    @Column(name = "enroll_regular_foreign_student_through_department")
    private Boolean enrollRegularForeignStudentThroughDepartment;

    @Column(name = "enroll_regular_foreign_student_through_other")
    private Boolean enrollRegularForeignStudentThroughOther;

    @Column(name = "exam_result_regular_through_department")
    private Boolean examResultRegularThroughDepartment;

    @Column(name = "exam_result_regular_through_other")
    private Boolean examResultRegularThroughOther;

    @Column(name = "placement_details")
    private Boolean placementDetails;

    @Column(name = "teaching_staff")
    private Boolean teachingStaff;

    @Column(name = "teaching_staff_econtact")
    private Boolean teachingStaffEcontact;

    @Column(name = "teaching_staff_vernacular_name")
    private Boolean teachingStaffVernacularName;

    @Column(name = "teaching_staff_sanctioned_strength")
    private Boolean teachingStaffSanctionedStrength;

    @Column(name = "non_teaching_staff_detail")
    private Boolean nonTeachingStaffDetail;

    @Column(name = "financial_info_income")
    private Boolean financialInfoIncome;

    @Column(name = "financial_info_expenditure")
    private Boolean financialInfoExpenditure;

    @Column(name = "infra")
    private Boolean infra;

    @Column(name = "scholarship")
    private Boolean scholarship;

    @Column(name = "fellowship")
    private Boolean fellowship;

    @Column(name = "education_loan")
    private Boolean educationLoan;

    @Column(name = "accreditation")
    private Boolean accreditation;

    @Column(name = "final_lock")
    private Boolean finalLock;

    @Column(name = "booleanfellowship")
    private Boolean booleanFellowship;


    @Override
    public String getInstitutionType() {
        return "College";
    }

    @Override
    public String getAisheCode() {
        return aisheCode;
    }

    @Override
    public Integer getSurveyYear() {
        return surveyYear;
    }

    @Override
    public Boolean getStatus() {
        return finalLock;
    }

    @Override
    public LockConstant getConstant() {

        return getConstant();
    }



}
