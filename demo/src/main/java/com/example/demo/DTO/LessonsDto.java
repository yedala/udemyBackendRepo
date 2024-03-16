package com.example.demo.DTO;

import com.example.demo.Models.Lessons;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class LessonsDto {
    private int id;
    private String lessonName;
    private String description;
    private String content;

    public static List<LessonsDto> convertEntityListToDto(List<Lessons> lessons){
        List<LessonsDto> lessonsDtos = new ArrayList<>();
        lessons.forEach(l -> {
            LessonsDto ldto = new LessonsDto();
            ldto.setLessonName(l.getLessonName());
            ldto.setId(l.getId());
            ldto.setDescription(l.getDescription());
            ldto.setContent(l.getContent());lessonsDtos.add(ldto);
       });
        return lessonsDtos;
    }
}
