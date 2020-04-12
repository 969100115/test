package test.params;

import lombok.Data;

@Data
public class ProjectParams extends BaseParams {
    String name;
    String showPicture;
    String deleted;
    int projectId;
    int price;
    int duration;
    String type;
    String description;
    String detailPicture;

}
