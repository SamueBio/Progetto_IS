package net.javaguides.springboot.model.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    @Query(value = "SELECT username FROM users WHERE username = :username", nativeQuery = true)
    List<String> checkUsername(@Param("username")String username);

    @Query(value = "SELECT password FROM users WHERE username = :username", nativeQuery = true)
    String checkUserPasswordByUsername(@Param("username") String username);

    @Query(value="SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User GetUserDetailsByUsername(@Param("username")String username);

    @Query("SELECT u.password FROM User u WHERE u.username = :username")
    String findPasswordByUsername(@Param("username") String username);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username AND u.password = :pswToCheck")
    boolean checkPassword(@Param("username") String username, @Param("pswToCheck") String pswToCheck);


}
