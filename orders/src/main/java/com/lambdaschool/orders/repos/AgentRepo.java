package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepo extends CrudRepository<Agent, Long>
{
}
