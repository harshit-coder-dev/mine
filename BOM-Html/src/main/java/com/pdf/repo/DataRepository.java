package com.pdf.repo;

import com.pdf.model.RmBom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<RmBom, Integer> {
    @Query(value = "SELECT * FROM public.rm_process_not", nativeQuery = true)
    List<Object[]> getDataList();

    @Query(value = "SELECT * FROM public.rm_view_from",nativeQuery = true)
    List<Object[]> getDataListFrom();

    @Query(value = "SELECT ctg,sctg,quality,qty,uom FROM public.rm_view WHERE ctg = 'Process Type'", nativeQuery = true)
    List<Object[]> getProcessData();


}
