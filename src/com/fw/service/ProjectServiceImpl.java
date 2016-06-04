package com.fw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fw.mapper.ProjectMapper;
import com.fw.model.Project;
import com.fw.model.StuPro;
import com.fw.util.PageBean;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public void addProject(Project project) {
		projectMapper.insertProject(project);
	}

	public PageBean<Project> findProjectListByEid(int page, Integer eid) {

		PageBean<Project> pageBean = new PageBean<Project>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = projectMapper.selectCountByEid(eid);
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
		params.put("eid", eid);

		List<Project> list = projectMapper.selectByEid(params);

		pageBean.setList(list);
		return pageBean;
	}

	public Project getProjectByPid(int pid) {
		return projectMapper.selectByPid(pid);
	}

	public void updateProject(Project project) {
		projectMapper.updateProject(project);
	}

	public PageBean<Project> findAllProjectList(int page) {
		PageBean<Project> pageBean = new PageBean<Project>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = projectMapper.selectCount();
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

		List<Project> list = projectMapper.selectAll(params);

		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Project> findProjectListByPname(int page, String pname) {
		PageBean<Project> pageBean = new PageBean<Project>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = projectMapper.selectCountByPname("%" + pname + "%");
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
		params.put("pname", "%" + pname + "%");

		List<Project> list = projectMapper.selectByPname(params);

		pageBean.setList(list);
		return pageBean;
	}

	public void uploadProjct(StuPro sp) {
		projectMapper.insertStuPro(sp);
	}

	public void uploadProjctPlus(StuPro sp) {
		projectMapper.updateStuPro(sp);
	}

	public StuPro getOldStuPro(Integer sid, int pid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sid", sid);
		params.put("pid", pid);
		StuPro sp = projectMapper.selectBySidAndPid(params);
		return sp;
	}

	public PageBean<StuPro> findMyProjectList(int page, Integer sid) {
		PageBean<StuPro> pageBean = new PageBean<StuPro>();
		pageBean.setCurPage(page);
		int limit = 5;
		pageBean.setLimit(limit);

		int allCount = projectMapper.selectCountBySid(sid);
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
		params.put("sid", sid);

		List<StuPro> list = projectMapper.selectBySid(params);

		pageBean.setList(list);
		return pageBean;
	}

	public List<StuPro> getStuProInfo(int pid) {
		return projectMapper.selectStuPro(pid);
	}

	public void praiseProject(int spid, String praise) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("spid", spid);
		params.put("praise", praise);
		projectMapper.updateStuProPraise(params);

	}

}
