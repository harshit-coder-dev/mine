package com.BOM.repo;

import com.BOM.entity.master.RmBom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RmBomRepo extends JpaRepository<RmBom,Integer> {
}
