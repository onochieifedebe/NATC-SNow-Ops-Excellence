package com.theifedebegroup.operationalexcellence.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.theifedebegroup.operationalexcellence.dto.EmpInOrder;
import com.theifedebegroup.operationalexcellence.dto.EmployeeCertification;
import com.theifedebegroup.operationalexcellence.entities.SnowCertification;
import com.theifedebegroup.operationalexcellence.services.CertificationService;
import com.theifedebegroup.operationalexcellence.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/certifications"})
public class CertificationController {

    @Autowired
    CertificationService certService;

    @Autowired
    EmployeeService empService;

    @GetMapping({"/new"})
    public String displayCertificationForm(Model model) {
        SnowCertification certification = new SnowCertification();
        model.addAttribute("epicCert", certification);

        List<EmpInOrder> empInOrder = empService.empInOrder();
        model.addAttribute("allEmployees", empInOrder);

//    List<Employee> employees = empService.getAll();
//    model.addAttribute("allEmployees", employees);

        return "Certifications/new-certification";
    }

    @PostMapping({"/save"})
    public String addCertification(SnowCertification certification, Model model) {
        certService.save(certification);
        return "redirect:/certifications/new";
    }

    @GetMapping({""})
    public String displayAllCertifications(Model model) throws JsonProcessingException {
        List<SnowCertification> certifications = certService.getAll();
        model.addAttribute("certifications", certifications);


        List<EmployeeCertification> certificationEmployeeList = empService.employeeCertifications();
        model.addAttribute("certificationEmployeeList", certificationEmployeeList);



        return "Certifications/list-certifications";
    }
}
