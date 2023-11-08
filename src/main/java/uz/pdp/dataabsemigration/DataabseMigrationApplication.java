package uz.pdp.dataabsemigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
@EnableCaching
public class DataabseMigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataabseMigrationApplication.class, args);
    }

    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setCacheNames(Collections.singleton("student"));
        return cacheManager;
    }
}
