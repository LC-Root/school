package lcc.com.boot.school;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lcc.com.boot.school.model.user.RolesRepository;
import lcc.com.boot.school.model.user.UsersRepository;
import lcc.com.boot.school.model.user.model.Roles;
import lcc.com.boot.school.model.user.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class OneToMany {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private RolesRepository rolesRepository;
	
	/**
	 * 一对多关联关系的添加
	 */
	@Test
	public void testSave(){
		//创建一个用户
		/*Users users = new Users();
		users.setAddress("天津1");
		users.setAge(32);
		users.setName("小刚1");
		
		//一个角色
		Optional<Roles> roles = rolesRepository.findById(3);
		Roles roles2 = roles.get();
		
		//关联
		//roles2.getUsers().add(users);
		Roles roles3 = new Roles();
		roles3.getUsers().add(users);
		//roles3.setRoleid(-1);
		roles3.setRolename("sd");
		users.setRoles(roles3);*/
		
		//保存
		//this.rolesRepository.save(roles);
		//保存
		//this.usersRepository.save(users);
		this.rolesRepository.deleteById(2);
	}
}
