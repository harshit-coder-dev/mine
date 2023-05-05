package com.BOM.entity.master;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.BOM.utils.TableUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = TableUtils.TABLE_MST_RM_TYPE, schema = TableUtils.MST_SCHEMA)
public class RmType extends Auditable<Integer> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "UOM")
    private Integer uom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RmProperty> rmPropertySet;
}
