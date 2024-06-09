package vod.web.rest.dto;

import lombok.Data;

@Data
public class LessonDTO {
    private String subjectName;
    private int teacherId;
    private int ECTS;
}
