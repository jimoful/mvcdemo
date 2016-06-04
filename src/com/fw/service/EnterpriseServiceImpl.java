package com.fw.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.mapper.EnterpriseMapper;
import com.fw.model.Enterprise;
import com.fw.model.Student;
import com.fw.util.MyException;
import com.fw.util.PageBean;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private EnterpriseMapper enterpriseMapper;

	public void setEnterpriseMapper(EnterpriseMapper enterpriseMapper) {
		this.enterpriseMapper = enterpriseMapper;
	}

	public Enterprise login(Enterprise enterprise) throws Exception {

		Enterprise ent = enterpriseMapper.selectByEmail(enterprise);
		if (ent == null) {
			throw new MyException("邮箱不存在~");
		}

		int status = enterpriseMapper.selectStatus(enterprise);
		if (status == 0) {
			throw new MyException("您还未通过审核~");
		}

		ent = enterpriseMapper.selectByEmailAndPassword(enterprise);
		if (ent == null) {
			throw new MyException("密码错误~");
		}
		return ent;
	}

	public Enterprise getEnterpriseInfo(Integer eid) throws Exception {
		return enterpriseMapper.selectByEid(eid);
	}

	public void updateEnterpriseInfo(Enterprise enterprise) {
		enterpriseMapper.updateEnterprise(enterprise);
	}

	/**
	 * 修改企业密码
	 */
	public void updateEnterprisePassword(Integer eid, String password,
			String newPassword) throws Exception {
		Enterprise ent = new Enterprise();
		ent.setEid(eid);
		ent.setPassword(password);
		ent.setNewPassword(newPassword);

		String oldPassword = enterpriseMapper.selectPassword(eid);
		if (!oldPassword.equals(password)) {
			throw new MyException("原密码输入错误~");
		}
		enterpriseMapper.updatePassword(ent);

	}

	/**
	 * 得到关注学生列表
	 */
	public PageBean<Student> getFollowingStudentList(int page, Integer eid) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		List<Integer> sidList = enterpriseMapper.getFollowingSidList(eid);
		int allCount = sidList.size();
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
		params.put("ids", sidList);

		List<Student> list = new ArrayList<Student>();
		if (sidList.size() != 0) {
			list = enterpriseMapper.findFollowingStudentList(params);
		}

		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Student> getStudentList(int page, Integer eid) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		List<Integer> sidList = enterpriseMapper.getFollowingSidList(eid);
		sidList = enterpriseMapper.getSidList(sidList);
		int allCount = sidList.size();
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
		params.put("ids", sidList);

		List<Student> list = new ArrayList<Student>();
		if (sidList.size() != 0) {
			list = enterpriseMapper.findFollowingStudentList(params);
		}

		pageBean.setList(list);
		return pageBean;
	}

	public void followStudent(int eid, int sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eid", eid);
		map.put("sid", sid);
		enterpriseMapper.followStudent(map);
	}

	public void unfollowStudent(int eid, int sid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eid", eid);
		map.put("sid", sid);
		enterpriseMapper.unfollowStudent(map);
	}

	public PageBean<Enterprise> findAllEnterpriseList(int page) {
		PageBean<Enterprise> pageBean = new PageBean<Enterprise>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = enterpriseMapper.selectCount();
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

		List<Enterprise> list = enterpriseMapper.selectAll(params);

		pageBean.setList(list);
		return pageBean;
	}

	public void updateEnterpriseInfoByAdmin(Enterprise enterprise) {
		enterpriseMapper.updateEnterprise(enterprise);
	}

	public void addEnterprise(Enterprise enterprise) {
		enterpriseMapper.addEnterprise(enterprise);
	}

	public void register(Enterprise enterprise) {
		enterpriseMapper.insertEnterprise(enterprise);
	}

	public PageBean<Enterprise> toVerifyEnterprise(int page) {
		PageBean<Enterprise> pageBean = new PageBean<Enterprise>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = enterpriseMapper.selectCountByStatus();
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

		List<Enterprise> list = enterpriseMapper.selectAllByStatus(params);

		pageBean.setList(list);
		return pageBean;
	}

	public void verifyEnterprise(int eid) {
		enterpriseMapper.updateStatusToOne(eid);
	}

	public void deleteEnterprise(int eid) {
		// 删除_ent_stu中的记录
		// 删除_stu_ent中的记录
		// 删除_stu_pro中记录，和上传的项目
		// 删除_project中的记录，和上传的项目
		// 删除_enterprise中的记录

		enterpriseMapper.deleteStuEntBySid(eid);
		enterpriseMapper.deleteEntStuBySid(eid);

		List<Integer> pidList = enterpriseMapper.selectPidListByEid(eid);
		if (pidList != null && pidList.size() > 0) {
			List<String> submitPathList = enterpriseMapper
					.selectSubmitPathByPid(pidList);
			for (String s : submitPathList) {
				File file = new File("D:/Program Files/upload" + s);
				file.delete();
			}
			enterpriseMapper.deleteStuProByPid(pidList);

			List<String> attachmentList = enterpriseMapper
					.selectAttachmentByPid(pidList);

			for (String s : attachmentList) {
				File file = new File("D:/Program Files/upload" + s);
				file.delete();
			}

			enterpriseMapper.deleteProjectByPid(pidList);
		}

		enterpriseMapper.deleteByEid(eid);
	}

	public int ajaxCheckEmail(String email) {
		return enterpriseMapper.selectCountByEmail(email);

	}

}
