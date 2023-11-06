package uz.pdp.databasemigration.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import uz.pdp.databasemigration.entity.Blog;
import uz.pdp.databasemigration.model.BlogDto;
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BlogMapper {
    Blog toEntity(BlogDto blogDto);

    BlogDto toDto(Blog blog);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Blog partialUpdate(BlogDto blogDto, @MappingTarget Blog blog);
}