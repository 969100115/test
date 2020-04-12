package test.bean;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author Wenbo
 * @date 2020/3/30 14:21
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "content")
public class Content {
    String name;
    String description;
    String picture;
    String place;
    String type;
}
