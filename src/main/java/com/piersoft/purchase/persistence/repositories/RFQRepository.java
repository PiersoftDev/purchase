package com.piersoft.purchase.persistence.repositories;

import com.piersoft.purchase.persistence.entities.RequestForQuotation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RFQRepository extends CrudRepository<RequestForQuotation, Long> {

    @Query("select e  from RequestForQuotation e  WHERE projectId = :projectCode and categoryId = :categoryId")
    List<RequestForQuotation> findAllByProjectCodeAndCategoryId(String projectCode, String categoryId);

    @Query("select e  from RequestForQuotation e  WHERE projectId = :projectCode and categoryId = :categoryId and status = 'DRAFT'")
    List<RequestForQuotation> findDraftedRFQsByProjectCodeAndCategoryId(String projectCode, String categoryId);

    List<RequestForQuotation> findByOrderByIdDesc();

    @Modifying
    @Transactional
    @Query("update RequestForQuotation e set e.status = 'APPROVED' where e.id = :rfqId")
    void approveRFQById(Long rfqId);
}
