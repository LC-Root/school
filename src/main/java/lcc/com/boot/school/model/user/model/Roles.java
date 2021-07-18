package lcc.com.boot.school.model.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_roles")
public class Roles {
 
	@Id
      //id设置为自增长
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid")
	private Integer roleid;
	
	@Column(name="rolename")
	private String rolename;
	
	//这里的roles是users实体类中的 roles实体类起的名字，要一一对应
	@OneToMany(mappedBy="roles", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Users> users = new HashSet<>();
	
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
}
