package uz.pdp.dataabsemigration.serice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AuthUserRepositoryTest {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Test
    void testRepositoryMethod() {
        // Write your repository tests using authUserRepository
    }
}
