package lcc.com.boot.school.model.user.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="t_users")
public class Users {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="address")
	private String address;
	
	//下边这个注解中写的是关系，只要在一边配置，另一边详细写就好
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn:维护外键，用户与角色是多对一的关系
	@JoinColumn(name="roles_id")
	private Roles roles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
 
}
