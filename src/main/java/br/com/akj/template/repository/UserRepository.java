package br.com.akj.template.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.akj.template.entity.UserEntity;

public interface UserRepository
    extends CrudRepository<UserEntity, Long>
{

}
