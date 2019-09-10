package com.qa.controllers;

import com.qa.models.League;
import com.qa.models.Team;
import com.qa.repository.LeaguesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LeaguesControllerTest {

    @InjectMocks
    private LeaguesController leaguesController;

    @Mock
    private LeaguesRepository leaguesRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllLeagues() {
        List<League> leaguesList = new ArrayList<>();
        League league = new League();
        league.setName("TestLeague");
        league.setFoundDate("TestFoundDate");
        leaguesList.add(league);
        when(leaguesRepository.findAll()).thenReturn(leaguesList);
        assertEquals(leaguesController.listAllLeagues().get(0).getName(), "TestLeague");
    }

    @Test
    public void testGetOneLeague(){
        League league = new League;
        league.setName("TestLeague");
        when(leaguesRepository.findOne(1L)).thenReturn(league);
        leaguesController.getLeague(1L);
    }

    @Test
    public void testDeleteOneLeague(){
        League league = new League();
        league.setName("TestLeague");
        leaguesRepository.findOne(1L);
        leaguesController.deleteLeague(1L);
        when(!leaguesRepository.exists(1L)).thenReturn(true);
    }

}
