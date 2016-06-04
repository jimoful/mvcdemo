package com.fw.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fw.model.Project;
import com.fw.model.StuPro;
import com.fw.util.PageBean;

@Transactional
public interface ProjectService {

	void addProject(Project project);

	PageBean<Project> findProjectListByEid(int page, Integer eid);

	Project getProjectByPid(int pid);

	void updateProject(Project project);

	PageBean<Project> findAllProjectList(int page);

	PageBean<Project> findProjectListByPname(int page, String pname);

	void uploadProjct(StuPro sp);

	void uploadProjctPlus(StuPro sp);

	StuPro getOldStuPro(Integer sid, int pid);

	PageBean<StuPro> findMyProjectList(int page, Integer sid);

	List<StuPro> getStuProInfo(int pid);

	void praiseProject(int spid, String praise);

}
