package uz.pdp.databasemigration.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import uz.pdp.databasemigration.entity.User;
import uz.pdp.databasemigration.model.UserDto;
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}