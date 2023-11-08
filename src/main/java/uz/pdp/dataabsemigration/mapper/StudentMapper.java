package uz.pdp.dataabsemigration.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import uz.pdp.dataabsemigration.dto.StudentDto;
import uz.pdp.dataabsemigration.entity.Student;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    Student toEntity(StudentDto blogDto);

    StudentDto toDto(Student blog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Student partialUpdate(StudentDto blogDto, @MappingTarget Student blog);
}