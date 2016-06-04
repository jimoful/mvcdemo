package com.fw.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.mapper.StudentMapper;
import com.fw.model.Classes;
import com.fw.model.Enterprise;
import com.fw.model.Student;
import com.fw.util.MyException;
import com.fw.util.PageBean;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public Student login(Student student) throws Exception {
		Student st = studentMapper.selectBySno(student);
		if (st == null) {
			throw new MyException("学号不存在~");
		}
		st = studentMapper.selectBySnoAndPassword(student);
		if (st == null) {
			throw new MyException("密码错误~");
		}
		return st;
	}

	public Student getStudentInfo(Integer sid) throws Exception {
		Student st = studentMapper.selectBySid(new Student(sid));
		return st;
	}

	public void updateStudentInfo(Student student) throws Exception {

		studentMapper.updateStudent(student);
	}

	public void updateStudentPassword(Integer sid, String password,
			String newPassword) throws Exception {
		Student st = new Student();
		st.setSid(sid);
		st.setPassword(password);
		st.setNewPassword(newPassword);

		String oldPassword = studentMapper.selectPassword(sid);
		if (!oldPassword.equals(password)) {
			throw new MyException("原密码输入错误~");
		}
		studentMapper.updatePassword(st);

	}

	public PageBean<Enterprise> findEnterpriseList(int page, Integer sid)
			throws Exception {

		PageBean<Enterprise> pageBean = new PageBean<Enterprise>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		List<Integer> eidList = studentMapper.getFollowingEidList(sid);
		eidList = studentMapper.getEidList(eidList);
		int allCount = eidList.size();
		int allPage = 0;

		if (allCount <= limit) {
			allPage = 1;
		} else if (allCount / pageBean.getLimit() == 0) {
			allPage = allCount / limit;
		} else {
			allPage = allCount / limit + 1;
		}
		pageBean.setAllPage(allPage);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("begin", (page - 1) * limit);
		params.put("limit", limit);
		params.put("ids", eidList);

		List<Enterprise> list = new ArrayList<Enterprise>();
		if (eidList.size() != 0) {
			list = studentMapper.findEnterpriseList(params);
		}

		pageBean.setList(list);
		return pageBean;

	}

	public PageBean<Enterprise> findFollowingEnterpriseList(int page,
			Integer sid) throws Exception {
		PageBean<Enterprise> pageBean = new PageBean<Enterprise>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		List<Integer> eidList = studentMapper.getFollowingEidList(sid);
		int allCount = eidList.size();
		int allPage = 0;

		if (allCount <= limit) {
			allPage = 1;
		} else if (allCount / pageBean.getLimit() == 0) {
			allPage = allCount / limit;
		} else {
			allPage = allCount / limit + 1;
		}
		pageBean.setAllPage(allPage);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("begin", (page - 1) * limit);
		params.put("limit", limit);
		params.put("ids", eidList);

		List<Enterprise> list = new ArrayList<Enterprise>();
		if (eidList.size() != 0) {
			list = studentMapper.findFollowingEnterpriseList(params);
		}

		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Enterprise> findEnterpriseListByName(int page, String name,
			Integer sid) {
		PageBean<Enterprise> pageBean = new PageBean<Enterprise>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		List<Integer> eidList = studentMapper.getFollowingEidList(sid);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", eidList);
		params.put("name", "%" + name + "%");
		eidList = studentMapper.getEidListByName(params);

		int allCount = eidList.size();
		int allPage = 0;

		if (allCount <= limit) {
			allPage = 1;
		} else if (allCount / pageBean.getLimit() == 0) {
			allPage = allCount / limit;
		} else {
			allPage = allCount / limit + 1;
		}
		pageBean.setAllPage(allPage);

		params = new HashMap<String, Object>();
		params.put("begin", (page - 1) * limit);
		params.put("limit", limit);
		params.put("ids", eidList);

		List<Enterprise> list = new ArrayList<Enterprise>();
		if (eidList.size() != 0) {
			list = studentMapper.findEnterpriseList(params);
		}

		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Enterprise> findFollowingEnterpriseListByName(int page,
			String name, Integer sid) {

		PageBean<Enterprise> pageBean = new PageBean<Enterprise>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sid", sid);
		params.put("name", "%" + name + "%");
		List<Integer> eidList = studentMapper.getFollowingEidListByName(params);
		int allCount = eidList.size();
		int allPage = 0;

		if (allCount <= limit) {
			allPage = 1;
		} else if (allCount / pageBean.getLimit() == 0) {
			allPage = allCount / limit;
		} else {
			allPage = allCount / limit + 1;
		}
		pageBean.setAllPage(allPage);

		params = new HashMap<String, Object>();
		params.put("begin", (page - 1) * limit);
		params.put("limit", limit);
		params.put("ids", eidList);

		List<Enterprise> list = new ArrayList<Enterprise>();
		if (eidList.size() != 0) {
			list = studentMapper.findFollowingEnterpriseList(params);
		}

		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 关注企业
	 */
	public void followEnterprise(int sid, int eid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("eid", eid);
		studentMapper.followEnterprise(map);
	}

	/**
	 * 取消关注企业
	 */
	public void unfollowEnterprise(int sid, int eid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("eid", eid);
		studentMapper.unfollowEnterprise(map);
	}

	public PageBean<Student> findAllStudentList(int page) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = studentMapper.selectCount();
		int allPage = 0;

		if (allCount <= limit) {
			allPage = 1;
		} else if (allCount / pageBean.getLimit() == 0) {
			allPage = allCount / limit;
		} else {
			allPage = allCount / limit + 1;
		}
		pageBean.setAllPage(allPage);

		Map<String, Object> params = new HashMap<String, Object>();
		params = new HashMap<String, Object>();
		params.put("begin", (page - 1) * limit);
		params.put("limit", limit);

		List<Student> list = studentMapper.selectAll(params);

		pageBean.setList(list);
		return pageBean;
	}

	public List<Classes> getAllClassesList() {
		return studentMapper.selectClasses();
	}

	public void updateStudentInfoByAdmin(Student student) {
		studentMapper.updateStudentByAdmin(student);
	}

	public void addStudent(Student student) {
		studentMapper.addStudent(student);
	}

	public void deleteStudent(int sid) {
		// 删除_stu_ent中的记录
		// 删除_ent_stu中的记录
		// 删除_stu_pro中的记录，和上传的项目
		// 删除_student中的记录，和上传的简历
		studentMapper.deleteStuEntBySid(sid);
		studentMapper.deleteEntStuBySid(sid);
		List<String> submitPathList = studentMapper.selectSubmitPathBySid(sid);
		for (String s : submitPathList) {
			File file = new File("D:/Program Files/upload" + s);
			file.delete();
		}
		studentMapper.deleteStuProBySid(sid);
		String resume = studentMapper.selectResumeBySid(sid);
		if (resume != null && !resume.equals("")) {
			File file = new File("D:/Program Files/upload" + resume);
			file.delete();
		}
		studentMapper.deleteBySid(sid);
	}
}
