package com.cody.codeclash.entities;

import java.util.Objects;

import com.cody.codeclash.entities.enums.Reaction;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;


@Entity
@Data
public class UserProblemAction {



    @EmbeddedId
    private UserProblemActionKey id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    private Problem problem;

    private Reaction reaction;

    private boolean saved;






    public class UserProblemActionKey implements java.io.Serializable {
        private Long user;
        private Long problem;


        public UserProblemActionKey(Long user, Long problem) {       
            this.user = user;
            this.problem = problem;
        }   

        @Override   
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserProblemActionKey that = (UserProblemActionKey) o;
            return user.equals(that.user) && problem.equals(that.problem);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(user, problem);
        }
    
        
    }

}
