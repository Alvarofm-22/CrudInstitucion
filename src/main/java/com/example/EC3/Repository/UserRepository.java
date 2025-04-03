package com.example.EC3.Repository;

import com.example.EC3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Metodo para obtener nuestro usuario
    @Query(value = "select * from user where user_name = ?1;", nativeQuery = true)
    User findByUserName(@Param("user_name") String userName);
}

