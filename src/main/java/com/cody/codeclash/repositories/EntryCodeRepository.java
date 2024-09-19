package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cody.codeclash.entities.EntryCode;

@Repository
public interface EntryCodeRepository extends JpaRepository<EntryCode, Long> {

}
