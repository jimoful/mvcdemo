package com.fw.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fw.model.Classes;
import com.fw.model.Enterprise;
import com.fw.model.Student;
import com.fw.util.PageBean;

@Transactional
public interface StudentService {

	public Student login(Student student) throws Exception;

	public Student getStudentInfo(Integer sid) throws Exception;

	public void updateStudentInfo(Student student) throws Exception;

	public void updateStudentPassword(Integer sid, String password,
                                      String newPassword) throws Exception;

	public PageBean<Enterprise> findEnterpriseList(int page, Integer sid)
			throws Exception;

	public PageBean<Enterprise> findFollowingEnterpriseList(int page,
                                                            Integer sid) throws Exception;

	public PageBean<Enterprise> findEnterpriseListByName(int page, String name,
                                                         Integer sid);

	public PageBean<Enterprise> findFollowingEnterpriseListByName(int page,
                                                                  String name, Integer sid);

	public void followEnterprise(int sid, int eid);

	public void unfollowEnterprise(int sid, int eid);

	public PageBean<Student> findAllStudentList(int page);

	public List<Classes> getAllClassesList();

	public void updateStudentInfoByAdmin(Student student);

	public void addStudent(Student student);

	public void deleteStudent(int sid);
}
