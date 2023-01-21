package com.theifedebegroup.operationalexcellence.dao;

import com.theifedebegroup.operationalexcellence.dto.EmpCertInOrder;
import com.theifedebegroup.operationalexcellence.entities.SnowCertification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICertificationRepository extends CrudRepository<SnowCertification, Long> {

    List<SnowCertification> findAll();

    @Query(nativeQuery = true, value = "SELECT snow_cert_id as certId, cert_name as certName FROM snow_certification ORDER BY cert_name asc")
    List<EmpCertInOrder> empCertInOrder();

}
