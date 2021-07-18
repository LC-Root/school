package lcc.com.boot.school.model.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import lcc.com.boot.school.model.user.model.Users;
 
 
public interface UsersRepository extends JpaRepository<Users, Integer> {
 
	@Query("from Users where name = ?1")
	List<Users> queryByNameUseHQL(String name);
	
	//个人推荐使用一下方式i写sql语句，因为在使用上边的方式的话，jpa会先将不标准的sql转化为标准的sql语句执行，相对内部操作过程会多一步骤
	@Query(value="select * from t_users where name = ?",nativeQuery=true)
	List<Users> queryByNameUseSQL(String name);
	
	@Query("update Users set name  = ?1 where id  = ?2")
	@Modifying //需要执行一个更新操作
	void updateUsersNameById(String name, Integer id);
}