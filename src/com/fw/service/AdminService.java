package com.fw.service;

import org.springframework.transaction.annotation.Transactional;

import com.fw.model.Admin;

@Transactional
public interface AdminService {

	Admin login(Admin adm) throws Exception;

	void updateAdminPassword(Integer aid, String password, String newPassword)
			throws Exception;

}
