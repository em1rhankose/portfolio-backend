package com.emirhan.portfolio.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<FreelanceService,Long> {

    List<FreelanceService> findAllByOrderByOrderIndexAsc();

}
