package com.emirhan.portfolio.workprocess;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkProcessRepository extends JpaRepository<WorkProcess, Long> {

    List<WorkProcess> findAllByOrderByStepNumberAsc();


}
