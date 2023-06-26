package com.piersoft.purchase.service;

import com.piersoft.purchase.persistence.entities.ASN;

public interface ASNService {
    String createASN(ASN asn);

    ASN getASNDetails(Long asnId);
}
