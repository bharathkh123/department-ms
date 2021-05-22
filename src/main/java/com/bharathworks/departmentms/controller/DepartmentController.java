package com.bharathworks.departmentms.controller;

import com.bharathworks.departmentms.entity.DepartmentEntity;
import com.bharathworks.departmentms.services.DepartmentService;
import com.bharathworks.departmentms.vo.DepartmentDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<DepartmentDetailsDTO> saveDepartment(@RequestBody DepartmentDetailsDTO departmentDetailsDTO){
        return ResponseEntity.ok().body(departmentService.saveDepartment(departmentDetailsDTO));
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDetailsDTO> getDepartmentDetails(@PathVariable("departmentId") Long departmentId){

        return ResponseEntity.ok().body(departmentService.getDepartmentDetails(departmentId));
    }

}
