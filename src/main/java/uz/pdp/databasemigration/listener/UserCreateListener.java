package uz.pdp.databasemigration.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import uz.pdp.databasemigration.entity.User;
import uz.pdp.databasemigration.even.CreateUserEvent;
import uz.pdp.databasemigration.even.UpdateUserEvent;
import uz.pdp.databasemigration.repository.UserRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@EnableAsync
public class UserCreateListener {


    @EventListener
    @Async
    public void createUserListener(CreateUserEvent event){
        User user = event.getUser();
        user.setCreatedAt(LocalDateTime.now());

    }

    @EventListener
    public void updateUserListener(UpdateUserEvent event){
        User user = event.getUser();
        user.setUpdatedAt(LocalDateTime.now());

    }
}
