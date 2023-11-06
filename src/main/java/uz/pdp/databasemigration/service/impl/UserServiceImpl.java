package uz.pdp.databasemigration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import uz.pdp.databasemigration.entity.User;
import uz.pdp.databasemigration.even.CreateUserEvent;
import uz.pdp.databasemigration.even.UpdateUserEvent;
import uz.pdp.databasemigration.mapper.UserMapper;
import uz.pdp.databasemigration.model.UserDto;
import uz.pdp.databasemigration.repository.UserRepository;
import uz.pdp.databasemigration.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;
    @Override
    public User createUser(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        publisher.publishEvent(new CreateUserEvent(entity));
       return userRepository.save(entity);
//        return entity;
            }

    @Override
    public User updateUser(UserDto dto) {
        Optional<User> byId = userRepository.findById(dto.getId());
        if (byId.isEmpty()) {
          throw new RuntimeException("User not found ");
        }
        User user = byId.get();
        user.setName(dto.getName()!=null ? dto.getName() : user.getName());
        user.setAge(dto.getName()!=null ? dto.getAge() : user.getAge());
        publisher.publishEvent(new UpdateUserEvent(user));
        return    userRepository.save(user);
    }
}
