package com.pdf.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rm_bom", schema = "master")
public class RmBom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "to_rm_table_id_fn_key"), name = "to_rm_table_id")
    private RmTable toRmTable;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "from_rm_table_id_fn_key"), name = "from_rm_table_id")
    private RmTable fromRmTable;
}
