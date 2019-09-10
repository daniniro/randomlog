package com.aduno.randomlog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomlogApplicationTest {

    @Test
    public void contextLoads() {
        RandomlogApplication.main(new String[0]);
        assertTrue("Test only SpringBoot to load configuration properly", true);
    }

}
