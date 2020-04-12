package test.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * @author Wenbo
 * @date 2020/3/30 13:48
 * @Email 969****15@qq.com
 * @phone 176****7037
 */
@Data
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    String name;
    @Column(name = "showPicture")
    String showPicture;
    @Column(name = "deleted")
    boolean deleted = false;
    int price;
    int duration;
    String type;
    @Column(name = "description")
    String description;
    @Column(name = "detailPicture")
    String detailPicture;

}
