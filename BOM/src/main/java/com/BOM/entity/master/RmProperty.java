package com.BOM.entity.master;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DynamicInsert
@DynamicUpdate
public class RmProperty extends Auditable<Integer> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "rm_property_id")
    private RmProperty rmPropertyName;

    @ManyToOne
    @JoinColumn(name = "rmType_id")
    private RmType rmType;
}
