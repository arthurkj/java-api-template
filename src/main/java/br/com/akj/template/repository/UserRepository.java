package br.com.akj.template.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.akj.template.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);
}
