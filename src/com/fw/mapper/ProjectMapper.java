package com.fw.mapper;

import java.util.List;
import java.util.Map;

import com.fw.model.Project;
import com.fw.model.StuPro;

public interface ProjectMapper {

	void insertProject(Project project);

	int selectCountByEid(Integer eid);

	List<Project> selectByEid(Map<String, Object> params);

	Project selectByPid(int pid);

	void updateProject(Project project);

	int selectCount();

	List<Project> selectAll(Map<String, Object> params);

	int selectCountByPname(String pname);

	List<Project> selectByPname(Map<String, Object> params);

	StuPro selectBySidAndPid(Map<String, Object> params);

	void insertStuPro(StuPro sp);

	void updateStuPro(StuPro sp);

	int selectCountBySid(Integer sid);

	List<StuPro> selectBySid(Map<String, Object> params);

	List<StuPro> selectStuPro(int pid);

	void updateStuProPraise(Map<String, Object> params);

}
