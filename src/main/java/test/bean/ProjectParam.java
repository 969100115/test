package test.bean;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "projectparams")
public class ProjectParam {
    @ApiModelProperty("orderid")
    @Column(name = "orderid")
    int orderid;

    @ApiModelProperty("param")
    @Column(name = "param")
    String param;

    @ApiModelProperty("value")
    @Column(name = "value")
    String value;

}
