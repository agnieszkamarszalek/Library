package com.amarszalek.Library;

import com.amarszalek.Library.domain.facades.BookFacade;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles(profiles = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = LibraryApplication.class)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-tests.properties")
public abstract class AbstractTest {
    @LocalServerPort
    private int serverPort;
    protected String baseUrl;
    @MockBean
    protected BookFacade bookFacade;
    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Before
    public void setUp() {
        baseUrl = "http://localhost:" + serverPort;
    }

}
