package com.theifedebegroup.operationalexcellence.services;

import com.theifedebegroup.operationalexcellence.dao.ICertificationRepository;
import com.theifedebegroup.operationalexcellence.dto.EmpCertInOrder;
import com.theifedebegroup.operationalexcellence.entities.SnowCertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    @Autowired
    ICertificationRepository certRepo;

    public List<SnowCertification> getAll(){
        return certRepo.findAll();
    }

    public SnowCertification save(SnowCertification certification) {
        return certRepo.save(certification);
    }

    public List<EmpCertInOrder> empCertInOrder(){
        return certRepo.empCertInOrder();
    }

}
