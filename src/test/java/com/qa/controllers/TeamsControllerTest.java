package com.qa.controllers;

import com.qa.models.Team;
import com.qa.repository.TeamsRepository;
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
public class TeamsControllerTest {

    @InjectMocks
    private TeamsController teamsController;

    @Mock
    private TeamsRepository teamsRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllTeams(){
        List<Team> teamsList = new ArrayList<>();
        Team team = new Team();
        team.setName("TestTeam");
        team.setLocation("TestLocation");
        team.setStadium("TestStadium");
        teamsList.add(team);
        when(teamsRepository.findAll()).thenReturn(teamsList);
        assertEquals(teamsController.listAllTeams().get(0).getName(),"TestTeam");
    }

    @Test
    public void testGetOneTeam(){
        Team team = new Team();
        team.setName("TestTeam");
        when(teamsRepository.findOne(1L)).thenReturn(team);
        teamsController.getTeam(1L);
    }

    @Test
    public void testDeleteOneTeam(){
        Team team = new Team();
        team.setName("TestTeam");
        teamsRepository.findOne(1L);
        teamsController.deleteTeam(1L);
        when(!teamsRepository.exists(1L)).thenReturn(true);
    }


}
