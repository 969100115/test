package test.dto;

import lombok.Data;

@Data
public class CommentSelectDTO extends BaseDTO {
    String type;
    int projectId;
}
