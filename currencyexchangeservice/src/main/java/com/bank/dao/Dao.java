package com.bank.dao;

import com.bank.entity.User;

public interface Dao <Entity, Id> {

    Entity findById(Id id);

    Entity save(Entity entity);

}
