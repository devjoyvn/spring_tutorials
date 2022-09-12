package com.deft;

import com.deft.entity.User;
import com.deft.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaEntityLifecycleEventApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void newEntityEvent() {
        User user = new User();
        user.setUserName("Deft");
        user.setFirstName("Hai");
        user.setLastName("Nguyen");
        userRepository.save(user);
    }


    @Test
    public void updateEntity() {
        User user = new User();
        user.setUserName("Deft");
        user.setFirstName("Hai");
        user.setLastName("Nguyen");
        user = userRepository.save(user);

        user.setUserName("Deft change");
        userRepository.save(user);
    }


}
