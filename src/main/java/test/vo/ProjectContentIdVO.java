package test.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectContentIdVO {
    int id;
    String name;
    String showPicture;
    String deleted;
    int price;
    int duration;
    String type;
    String description;
    String detailPicture;
    List<Integer> contentIdList = new ArrayList<>();
}
