package com.example.superheroes.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.superheroes.entity.Superheroes;

/**
 * The interface Superheroes repository.
 */
@Repository
@Transactional
public interface SuperheroesRepository extends JpaRepository<Superheroes, Long>{

}
