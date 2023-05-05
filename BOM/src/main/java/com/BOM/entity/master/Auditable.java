package com.BOM.entity.master;

import com.BOM.utils.MyJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected U createdBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @JsonSerialize(using = MyJsonDateSerializer.class)
    protected Date createdDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    protected U modifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "modified_date")
    @JsonSerialize(using = MyJsonDateSerializer.class)
    protected Date modifiedDate;
}
