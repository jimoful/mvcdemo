package com.fw.service;

import org.springframework.transaction.annotation.Transactional;

import com.fw.model.Enterprise;
import com.fw.model.Student;
import com.fw.util.PageBean;

@Transactional
public interface EnterpriseService {

	Enterprise login(Enterprise enterprise) throws Exception;

	Enterprise getEnterpriseInfo(Integer eid) throws Exception;

	void updateEnterpriseInfo(Enterprise enterprise);

	void updateEnterprisePassword(Integer eid, String password,
                                  String newPassword) throws Exception;

	PageBean<Student> getFollowingStudentList(int page, Integer eid);

	PageBean<Student> getStudentList(int page, Integer eid);

	void followStudent(int eid, int sid);

	void unfollowStudent(int eid, int sid);

	PageBean<Enterprise> findAllEnterpriseList(int page);

	void updateEnterpriseInfoByAdmin(Enterprise enterprise);

	void addEnterprise(Enterprise enterprise);

	void register(Enterprise enterprise);

	PageBean<Enterprise> toVerifyEnterprise(int page);

	void verifyEnterprise(int eid);

	void deleteEnterprise(int eid);

	int ajaxCheckEmail(String email);

}
