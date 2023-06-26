package com.piersoft.purchase.persistence.repositories;

import com.piersoft.purchase.persistence.entities.ASN;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ASNRepository extends CrudRepository<ASN, Long> {
}
