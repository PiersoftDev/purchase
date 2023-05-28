package com.piersoft.purchase.persistence.repositories;

import com.piersoft.purchase.persistence.entities.MaterialIndentLine;
import com.piersoft.purchase.service.MaterialIndentLineService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin
public interface MaterialIndentLineRepository extends CrudRepository<MaterialIndentLine, Long> {

    @Transactional
    @Modifying
    @Query("update  MaterialIndentLine  set status = :status, subStatus = :subStatus WHERE orderId = :orderId")
    void updateMaterialIndentLineStatus(@Param("orderId") String orderId, @Param("status") String status, @Param("subStatus")String subStatus);

    @Query("select e  from MaterialIndentLine e  WHERE status != :status")
    List<MaterialIndentLine> fetchAllActiveMaterialIndentLines(@Param("status") String status);

    @Query("select e  from MaterialIndentLine e  WHERE orderId = :orderId")
    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForOrderId(String orderId);

    @Query("select e  from MaterialIndentLine e  WHERE projectId = :projectId and categoryId = :categoryId")
    List<MaterialIndentLine> fetchAllActiveMaterialIndentLinesForProjectCodeAndCategory(String projectId, String categoryId);

    @Transactional
    @Query("update  MaterialIndentLine  set status = :status, subStatus = :subStatus WHERE id = :lineId")
    void updateMaterialIndentLineStatusAndSubStatus(String lineId, String status, String subStatus);

    @Transactional
    @Query("update  MaterialIndentLine  set subStatus = :subStatus WHERE id = :lineId")
    void updateMaterialIndentLineSubStatus(String lineId, String subStatus);
}
