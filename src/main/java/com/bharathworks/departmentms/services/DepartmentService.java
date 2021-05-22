package com.bharathworks.departmentms.services;

import com.bharathworks.departmentms.entity.DepartmentEntity;
import com.bharathworks.departmentms.repository.DepartmentRepository;
import com.bharathworks.departmentms.vo.DepartmentDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private DepartmentEntity convertDtoToEntity(DepartmentDetailsDTO departmentDetailsDTO) {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentId(departmentDetailsDTO.getDepartmentId());
        departmentEntity.setDepartmentName(departmentDetailsDTO.getDepartmentName());
        return departmentEntity;
    }

    public DepartmentDetailsDTO saveDepartment(DepartmentDetailsDTO departmentDetailsDTO) {

        if (!ObjectUtils.isEmpty(departmentDetailsDTO)) {
            DepartmentEntity requestEntity = convertDtoToEntity(departmentDetailsDTO);
            DepartmentEntity entityFromDatabase = departmentRepository.findByDepartmentId(requestEntity.getDepartmentId());

            if (!ObjectUtils.isEmpty(entityFromDatabase)) {
                if (requestEntity.getDepartmentId().equals(entityFromDatabase.getDepartmentId())) {
                    entityFromDatabase.setDepartmentName(requestEntity.getDepartmentName());
                    departmentRepository.save(requestEntity);
                }
            }else{
                departmentRepository.save(requestEntity);
            }

        }
        return departmentDetailsDTO;
    }

    public DepartmentDetailsDTO getDepartmentDetails(Long departmentId) {

        DepartmentEntity entityFromDatabase= departmentRepository.findByDepartmentId(departmentId);
        DepartmentDetailsDTO departmentDetailsDTO= new DepartmentDetailsDTO();

        if (!ObjectUtils.isEmpty(entityFromDatabase)){
            departmentDetailsDTO.setDepartmentId(entityFromDatabase.getDepartmentId());
            departmentDetailsDTO.setDepartmentName(entityFromDatabase.getDepartmentName());
        }
        return  departmentDetailsDTO;


    }
}
