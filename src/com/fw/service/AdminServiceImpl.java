package com.fw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.mapper.AdminMapper;
import com.fw.model.Admin;
import com.fw.util.MyException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	public Admin login(Admin adm) throws Exception {
		Admin admin = adminMapper.selectByName(adm);
        System.out.println("admin");
        if (admin == null) {
			throw new MyException("邮箱不存在~");
		}
		admin = adminMapper.selectByNameAndPassword(adm);
		if (admin == null) {
			throw new MyException("密码错误~");
		}
		return admin;
	}

	public void updateAdminPassword(Integer aid, String password,
			String newPassword) throws Exception {
		Admin admin = new Admin();
		admin.setAid(aid);
		admin.setPassword(password);
		admin.setNewPassword(newPassword);

		String oldPassword = adminMapper.selectPassword(aid);
		if (!oldPassword.equals(password)) {
			throw new MyException("原密码输入错误~");
		}
		adminMapper.updatePassword(admin);
	}

}
