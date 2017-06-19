package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select s from Student s where s.userName = :userName")
	User findByUserName(@Param("userName") String userName);
	@Query("update user set roleid  = :roleid where username = :username")
	boolean changeUserRole(@Param("username") String username,@Param("roleid") int roleid);
	
}
