package com.emirhan.portfolio.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

    List<ContactInfo> findAllByVisibleTrue();
}
