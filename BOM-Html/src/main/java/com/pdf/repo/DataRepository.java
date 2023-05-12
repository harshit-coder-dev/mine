package com.pdf.repo;

import com.pdf.model.RmBom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository extends JpaRepository<RmBom, Integer> {
    @Query(value = "select * from public.rm_view limit 16", nativeQuery = true)
    List<Object[]> getDataList();
}
