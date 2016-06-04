package com.fw.mapper;

import java.util.List;
import java.util.Map;

import com.fw.model.Enterprise;
import com.fw.model.Student;

public interface EnterpriseMapper {

	Enterprise selectByEmail(Enterprise enterprise);

	Enterprise selectByEmailAndPassword(Enterprise enterprise);

	Enterprise selectByEid(Integer eid);

	void updateEnterprise(Enterprise enterprise);

	String selectPassword(Integer eid);

	void updatePassword(Enterprise ent);

	List<Integer> getFollowingSidList(Integer eid);

	List<Student> findFollowingStudentList(Map<String, Object> params);

	List<Integer> getSidList(List<Integer> sidList);

	void followStudent(Map<String, Object> map);

	void unfollowStudent(Map<String, Object> map);

	List<Enterprise> selectAll(Map<String, Object> params);

	int selectCount();

	void addEnterprise(Enterprise enterprise);

	void insertEnterprise(Enterprise enterprise);

	int selectStatus(Enterprise enterprise);

	int selectCountByStatus();

	List<Enterprise> selectAllByStatus(Map<String, Object> params);

	void updateStatusToOne(int eid);

	
	
	
	void deleteStuEntBySid(int eid);

	void deleteEntStuBySid(int eid);

	List<Integer> selectPidListByEid(int eid);

	List<String> selectSubmitPathByPid(List<Integer> pidList);

	void deleteStuProByPid(List<Integer> pidList);

	List<String> selectAttachmentByPid(List<Integer> pidList);

	void deleteByEid(int eid);

	void deleteProjectByPid(List<Integer> pidList);

	int selectCountByEmail(String email);

}
