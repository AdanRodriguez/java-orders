package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController
{
    @Autowired
    private AgentService agentService;
    //GET http:localhost:2019/agents/agents -----working
    @GetMapping(value = "/agents", produces ={"application/json"})
    public ResponseEntity<?> listAllAgents()
    {
        List<Agent> myList = agentService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //DELETE http:localhost:2019/agents/agents/2 ---- working
    @DeleteMapping("/agents/{agentid}")
    public ResponseEntity<?> deleteAgentById(@PathVariable long agentid)
    {
        agentService.delete(agentid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
