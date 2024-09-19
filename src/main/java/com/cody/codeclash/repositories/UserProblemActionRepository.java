package com.cody.codeclash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cody.codeclash.entities.UserProblemAction;
import com.cody.codeclash.entities.UserProblemActionKey;

public interface UserProblemActionRepository extends JpaRepository<UserProblemAction, UserProblemActionKey> {

}
