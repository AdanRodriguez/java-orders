package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repos.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService
{
    @Autowired
    private AgentRepo agentRepos;

    @Override
    public List<Agent> findAll()
    {
        List<Agent> rtnList = new ArrayList<>();
        agentRepos.findAll()
                  .iterator()
                  .forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Agent findById(long id) {
        return null;
    }

    @Override
    public Agent save(Agent agent) {
        return null;
    }

    @Override
    public Agent update(Agent agent, long id) {
        return null;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (agentRepos.findById(id).get().getCustomers().size() == 0)
        {
            agentRepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException("Agent is assigned to a customer");
        }
    }
}
