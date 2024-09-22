package ltweb.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String username;
	private String fullName;
	private String images;
	private int roleid;
	private String phone;
	private Date createDate;
	private String password;
	
	public UserModel() {
		super();
	}

	public UserModel(int id, String email, String username, String fullName, String password, String images, int roleid,
			String phone, Date createDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.images = images;
		this.roleid = roleid;
		this.phone = phone;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createdDate) {
		this.createDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", userName=" + username + ", fullName=" + fullName
				+ ", passWord=" + password + ", images=" + images + ", roleid=" + roleid + ", phone=" + phone
				+ ", createdDate=" + createDate + "]";
	}
	
	
}
