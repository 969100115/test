package test.vo;

import lombok.Data;
import test.bean.Content;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectVO {
    int id;
    String name;
    String showPicture;
    String deleted;
    int price;
    int duration;
    String type;
    String description;
    String detailPicture;
    List<Content> contentList = new ArrayList<>();
}
