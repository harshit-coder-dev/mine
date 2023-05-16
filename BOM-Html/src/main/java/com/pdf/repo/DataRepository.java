package com.pdf.repo;

import com.pdf.model.RmBom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<RmBom, Integer> {
    @Query(value = "SELECT\r\n"
    		+ "    rmb.from_rm_table_id AS id,\r\n"
    		+ "    rmt.\"group\" AS ctg,\r\n"
    		+ "    rmt.name AS sctg,\r\n"
    		+ "    rmta.name AS quality,\r\n"
    		+ "    rmpv.name AS ptr,\r\n"
    		+ "    rmb.quantity AS qty,\r\n"
    		+ "    rmb.unit_of_measure AS uom,\r\n"
    		+ "    COALESCE((CAST(rmpv.name AS FLOAT ) * rmb.quantity), rmb.quantity) AS weight,\r\n"
    		+ "    rmpv1.name AS setting_method,\r\n"
    		+ "    rmpv2.name AS setting_type\r\n"
    		+ "FROM\r\n"
    		+ "    rm_bom rmb\r\n"
    		+ "    LEFT JOIN rm_table rmta ON rmb.to_rm_table_id = rmta.id\r\n"
    		+ "    LEFT JOIN rm_type rmt ON rmt.id = rmta.rm_type_id\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv ON rmpv.id = rmta.p4 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv1 ON rmpv1.id = rmta.p5 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv2 ON rmpv2.id = rmta.p6 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property rmp ON rmp.id = rmpv.rm_property_id\r\n"
    		+ "    LEFT JOIN rm_property rmp1 ON rmp1.id = rmpv1.rm_property_id\r\n"
    		+ "    LEFT JOIN rm_property rmp2 ON rmp2.id = rmpv2.rm_property_id\r\n"
    		+ "WHERE\r\n"
    		+ "    rmt.name IS NOT NULL and rmb.from_rm_table_id = :id and rmt.group != 'Process Type' " , nativeQuery = true)
    List<Object[]> getDataList(@Param("id") Integer id);	

    @Query(value = "SELECT\r\n"
    		+ "    rmb.from_rm_table_id AS id,\r\n"
    		+ "    rmt.\"group\" AS ctg,\r\n"
    		+ "    rmt.name AS sctg,\r\n"
    		+ "    rmta.name AS quality,\r\n"
    		+ "    rmpv.name AS ptr,\r\n"
    		+ "    rmb.quantity AS qty,\r\n"
    		+ "    rmb.unit_of_measure AS uom,\r\n"
    		+ "    COALESCE((CAST(rmpv.name AS FLOAT ) * rmb.quantity), rmb.quantity) AS weight,\r\n"
    		+ "    rmpv1.name AS setting_method,\r\n"
    		+ "    rmpv2.name AS setting_type\r\n"
    		+ "FROM\r\n"
    		+ "    rm_bom rmb\r\n"
    		+ "    LEFT JOIN rm_table rmta ON rmb.to_rm_table_id = rmta.id\r\n"
    		+ "    LEFT JOIN rm_type rmt ON rmt.id = rmta.rm_type_id\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv ON rmpv.id = rmta.p4 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv1 ON rmpv1.id = rmta.p5 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv2 ON rmpv2.id = rmta.p6 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property rmp ON rmp.id = rmpv.rm_property_id\r\n"
    		+ "    LEFT JOIN rm_property rmp1 ON rmp1.id = rmpv1.rm_property_id\r\n"
    		+ "    LEFT JOIN rm_property rmp2 ON rmp2.id = rmpv2.rm_property_id\r\n"
    		+ "WHERE\r\n"
    		+ "    rmt.name IS NOT NULL and rmb.from_rm_table_id = :id and rmt.group != 'Process Type' " ,nativeQuery = true)
    List<Object[]> getDataListFrom(@Param("id") Integer id);

    @Query(value = "SELECT\r\n"
    		+ "    rmb.from_rm_table_id AS id,\r\n"
    		+ "    rmt.\"group\" AS ctg,\r\n"
    		+ "    rmt.name AS sctg,\r\n"
    		+ "    rmta.name AS quality,\r\n"
    		+ "    rmpv.name AS ptr,\r\n"
    		+ "    rmb.quantity AS qty,\r\n"
    		+ "    rmb.unit_of_measure AS uom,\r\n"
    		+ "    COALESCE((CAST(rmpv.name AS FLOAT ) * rmb.quantity), rmb.quantity) AS weight,\r\n"
    		+ "    rmpv1.name AS setting_method,\r\n"
    		+ "    rmpv2.name AS setting_type\r\n"
    		+ "FROM\r\n"
    		+ "    rm_bom rmb\r\n"
    		+ "    LEFT JOIN rm_table rmta ON rmb.to_rm_table_id = rmta.id\r\n"
    		+ "    LEFT JOIN rm_type rmt ON rmt.id = rmta.rm_type_id\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv ON rmpv.id = rmta.p4 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv1 ON rmpv1.id = rmta.p5 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property_value rmpv2 ON rmpv2.id = rmta.p6 AND rmta.rm_type_id = 1\r\n"
    		+ "    LEFT JOIN rm_property rmp ON rmp.id = rmpv.rm_property_id\r\n"
    		+ "    LEFT JOIN rm_property rmp1 ON rmp1.id = rmpv1.rm_property_id\r\n"
    		+ "    LEFT JOIN rm_property rmp2 ON rmp2.id = rmpv2.rm_property_id\r\n"
    		+ "WHERE\r\n"
    		+ "    rmt.name IS NOT NULL and rmb.from_rm_table_id = :id and rmt.group = 'Process Type' ", nativeQuery = true)
    List<Object[]> getProcessData(@Param("id") Integer id);


}
