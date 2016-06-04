package com.fw.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fw.model.Enterprise;
import com.fw.model.Project;
import com.fw.model.StuPro;
import com.fw.model.Student;
import com.fw.service.EnterpriseService;
import com.fw.service.ProjectService;
import com.fw.service.StudentService;
import com.fw.util.MyUtil;
import com.fw.util.PageBean;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ProjectService projectService;

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping("/login.do")
	public String login(Enterprise enterprise, HttpSession session, Model model)
			throws Exception {
		enterprise.setPassword(enterprise.getPassword());
		try {
			Enterprise ent = enterpriseService.login(enterprise);
			session.setAttribute("enterprise", ent);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());

			return "/index";
		}
		return "redirect:/enterprise/toHomePage.do";
	}

	@RequestMapping("/toHomePage.do")
	public String toHomePage() {
		return "/enterprise/enterpriseHomePage";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/enterprise/toIndex.do";
	}

	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "/index";
	}

	@RequestMapping("getEnterpriseInfo.do")
	public String getEnterpriseInfo(HttpSession session, Model model)
			throws Exception {
		Enterprise ent = (Enterprise) session.getAttribute("enterprise");
		Enterprise ent2 = enterpriseService.getEnterpriseInfo(ent.getEid());

		System.out.println(ent2 + "=====");
		model.addAttribute("enterprise", ent2);
		return "/enterprise/enterpriseInfo";
	}

	@RequestMapping("toUpdateEnterpriseInfo.do")
	public String toUpdateEnterpriseInfo(HttpSession session, Model model)
			throws Exception {
		Enterprise ent = (Enterprise) session.getAttribute("enterprise");
		Enterprise ent2 = enterpriseService.getEnterpriseInfo(ent.getEid());

		System.out.println(ent2 + "=====");
		model.addAttribute("enterprise", ent2);
		return "/enterprise/updateEnterpriseInfo";
	}

	@RequestMapping("updateEnterpriseInfo.do")
	public String updateEnterpriseInfo(Enterprise enterprise) throws Exception {
		enterpriseService.updateEnterpriseInfo(enterprise);
		return "redirect:/enterprise/getEnterpriseInfo.do";
	}

	@RequestMapping("toUpdateEnterprisePassword.do")
	public String toUpdateEnterprisePassword() {
		return "/enterprise/updateEnterprisePassword";
	}

	@RequestMapping("updateEnterprisePassword.do")
	public String updateEnterprisePassword(Enterprise enterprise, Model model) {

		enterprise.setPassword(MyUtil.md5(enterprise.getPassword()));
		enterprise.setNewPassword(MyUtil.md5(enterprise.getNewPassword()));

		try {
			enterpriseService.updateEnterprisePassword(enterprise.getEid(),
					enterprise.getPassword(), enterprise.getNewPassword());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());

			return "/enterprise/updateEnterprisePassword";
		}

		return "redirect:/enterprise/logout.do";
	}

	@RequestMapping("findStudentList.do")
	public String findStudentList(int page, HttpSession session, Model model) {
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		PageBean<Student> pageBean = enterpriseService.getStudentList(page,
				enterprise.getEid());
		model.addAttribute("pageBean", pageBean);
		return "/enterprise/studentList";
	}

	@RequestMapping("findFollowingStudentList.do")
	public String findFollowingStudentList(int page, HttpSession session,
			Model model) {
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		PageBean<Student> pageBean = enterpriseService.getFollowingStudentList(
				page, enterprise.getEid());
		model.addAttribute("pageBean", pageBean);
		return "/enterprise/followingStudentList";
	}

	@RequestMapping("followStudent.do")
	public String followStudent(int eid, int sid) {
		enterpriseService.followStudent(eid, sid);
		return "redirect:/enterprise/findStudentList.do?page=1";
	}

	@RequestMapping("unfollowStudent.do")
	public String unfollowStudent(int eid, int sid) {
		enterpriseService.unfollowStudent(eid, sid);
		return "redirect:/enterprise/findFollowingStudentList.do?page=1";
	}

	@RequestMapping("getStudentInfo.do")
	public String getStudentInfo(int sid, Model model) throws Exception {
		Student student = studentService.getStudentInfo(sid);
		model.addAttribute("student", student);
		return "/enterprise/studentInfo";
	}

	@RequestMapping("findProjectList.do")
	public String findProjectList(int page, HttpSession session, Model model) {
		Enterprise ent = (Enterprise) session.getAttribute("enterprise");
		PageBean<Project> pageBean = projectService.findProjectListByEid(page,
				ent.getEid());
		model.addAttribute("pageBean", pageBean);
		return "/enterprise/projectList";
	}

	@RequestMapping("toAddProject.do")
	public String toAddProject() {
		return "/enterprise/addProject";
	}

	@RequestMapping("addProject.do")
	public String addProject(Project project, MultipartFile file,
			HttpSession session) throws IOException {

		if (!file.isEmpty()) {
			String fileName = "/project/" + MyUtil.getUuid()
					+ MyUtil.getFileExtension(file.getOriginalFilename());
			project.setAttachment(fileName);

			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					"D:/Program Files/upload", fileName));

		}

		project.setPublishTime(MyUtil.formatDate(new Date()));
		project.setEnterprise((Enterprise) session.getAttribute("enterprise"));

		System.out.println(project);
		projectService.addProject(project);
		return "redirect:/enterprise/findProjectList.do?page=1";
	}

	@RequestMapping("toUpdateProject.do")
	public String toUpdateProject(int pid, Model model) {
		Project project = projectService.getProjectByPid(pid);
		model.addAttribute("project", project);
		return "/enterprise/updateProject";
	}

	@RequestMapping("updateProject.do")
	public String updateProject(Project project, MultipartFile file, Model model)
			throws IOException {

		if (!file.isEmpty()) {
			File oldFile = new File("D:/Program Files/upload"
					+ project.getAttachment());
			String fileName = "/project/" + MyUtil.getUuid()
					+ MyUtil.getFileExtension(file.getOriginalFilename());
			// 更新附件名
			project.setAttachment(fileName);
			// 删除旧文件，上传新文件
			oldFile.delete();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					"D:/Program Files/upload", fileName));

		}

		System.out.println(project);
		projectService.updateProject(project);

		model.addAttribute("pid", project.getPid());
		return "forward:/enterprise/getStuProInfo.do";
	}

	@RequestMapping("getStuProInfo.do")
	public String getStuProInfo(int pid, Model model) {
		List<StuPro> sps = projectService.getStuProInfo(pid);
		model.addAttribute("sps", sps);
		return "/enterprise/projectInfo";
	}

	@RequestMapping("praiseProject.do")
	public String praiseProject(int spid, int pid, String praise) {
		projectService.praiseProject(spid, praise);
		return "forward:/enterprise/getStuProInfo.do";
	}

	@RequestMapping("toRegisterEnterprise.do")
	public String toRegisterEnterprise() {
		return "/enterprise/enterpriseRegister";
	}

	@RequestMapping("register.do")
	public String register(Enterprise enterprise) {
		enterpriseService.register(enterprise);
		return "/enterprise/afterRegister";
	}

	@RequestMapping(value = "ajaxCheckEmail.do", produces = "text/html;charset=UTF-8")
	public @ResponseBody
	String ajaxCheckEmail(String email, HttpServletResponse response) {
		response.setContentType("text/plain;charset=UTF-8");
		int count = enterpriseService.ajaxCheckEmail(email);
		if (count > 0) {
			return "邮箱已被注册~";
		} else {
			return "";
		}
	}
}
