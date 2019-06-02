package com.amarszalek.Library;

import lombok.Data;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LibraryApplication.class)
@RunWith(SpringRunner.class)
@Data
public abstract class AbstractTest {
    @LocalServerPort
    private int serverPort;
    private String baseUrl;

    @Before
    public void setUp() {
        baseUrl = "http://localhost:" + serverPort;
    }

}
