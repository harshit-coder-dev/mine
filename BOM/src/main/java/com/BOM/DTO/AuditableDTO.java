package com.BOM.DTO;

import com.BOM.utils.MyJsonDateDeserializer;
import com.BOM.utils.MyJsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AuditableDTO {

    Integer createdBy;
    Integer modifiedBy;

    //	@CreatedDate
//	@Temporal(TIMESTAMP)
    @JsonSerialize(using = MyJsonDateSerializer.class)
    @JsonDeserialize(using = MyJsonDateDeserializer.class)
    protected Date createdDate;

    //	@LastModifiedDate
//	@Temporal(TIMESTAMP)
    @JsonSerialize(using = MyJsonDateSerializer.class)
    @JsonDeserialize(using = MyJsonDateDeserializer.class)
    protected Date modifiedDate;
}
