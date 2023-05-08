package com.piersoft.purchase.persistence.repositories;

import com.piersoft.purchase.persistence.entities.RequestForQuotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RFQRepository extends CrudRepository<RequestForQuotation, Long> {

    @Query("select e  from RequestForQuotation e  WHERE projectId = :projectCode and categoryId = :categoryId")
    List<RequestForQuotation> findAllByProjectCodeAndCategoryId(String projectCode, String categoryId);
}
