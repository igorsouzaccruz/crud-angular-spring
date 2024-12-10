package com.loiane.crudspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.loiane.crudspring.enums.Category;
import com.loiane.crudspring.enums.validation.ValueOfEnum;
import com.loiane.crudspring.model.Lesson;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String name,
        @NotNull @Length(max = 10)  @ValueOfEnum(enumClass = Category.class) String category,
        @NotNull @NotEmpty @Valid List<LessonDTO> lessons){
}
