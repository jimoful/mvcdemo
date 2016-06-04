package com.fw.mapper;

import java.util.List;
import java.util.Map;

import com.fw.model.Classes;
import com.fw.model.Enterprise;
import com.fw.model.Student;

public interface StudentMapper {

	public Student selectBySno(Student student) throws Exception;

	public Student selectBySnoAndPassword(Student student) throws Exception;

	public Student selectBySid(Student student) throws Exception;

	public void updateStudent(Student student) throws Exception;

	public int updatePassword(Student student) throws Exception;

	public String selectPassword(Integer sid) throws Exception;

	public List<Integer> getFollowingEidList(Integer sid);

	public List<Enterprise> findFollowingEnterpriseList(Map<String, Object> params);

	public List<Integer> getEidList(List<Integer> list);

	public List<Enterprise> findEnterpriseList(Map<String, Object> params);

	public List<Integer> getFollowingEidListByName(Map<String, Object> params);

	public List<Integer> getEidListByName(Map<String, Object> params);

	public void followEnterprise(Map<String, Object> map);

	public void unfollowEnterprise(Map<String, Object> map);

	public List<Student> selectAll(Map<String, Object> params);

	public int selectCount();

	public List<Classes> selectClasses();

	public void updateStudentByAdmin(Student student);

	public void addStudent(Student student);

	

	
	
	public void deleteStuEntBySid(int sid);

	public void deleteEntStuBySid(int sid);

	public List<String> selectSubmitPathBySid(int sid);

	public void deleteStuProBySid(int sid);

	public String selectResumeBySid(int sid);

	public void deleteBySid(int sid);
}
