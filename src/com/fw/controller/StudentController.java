package com.fw.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private EnterpriseService enterpriseService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	@RequestMapping("/login.do")
	public String login(Student student, HttpSession session, Model model) {
		System.out.println("login" + studentService);
		student.setPassword(student.getPassword());
		try {
			Student st = studentService.login(student);
			session.setAttribute("student", st);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());

			return "/index";
		}
		return "redirect:/student/toHomePage.do";
	}

	@RequestMapping("/toHomePage.do")
	public String toHomePage() {
		System.out.println("toHomePage" + "     ******   "+studentService);
		return "/student/studentHomePage";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/student/toIndex.do";
	}

	@RequestMapping("/toIndex.do")
	public String toIndex() {
		return "/index";
	}

	@RequestMapping("/getStudentInfo.do")
	public String getStudentInfo(HttpSession session, Model model)
			throws Exception {
		Student st = (Student) session.getAttribute("student");
		Student st2 = studentService.getStudentInfo(st.getSid());
		System.out.println(st2 + "=====");
		model.addAttribute("student", st2);
		return "/student/studentInfo";
	}

	@RequestMapping("/toUpdateStudentInfo.do")
	public String toUpdateStudentInfo(HttpSession session, Model model)
			throws Exception {
		Student st = (Student) session.getAttribute("student");
		Student st2 = studentService.getStudentInfo(st.getSid());
		model.addAttribute("student", st2);
		return "/student/updateStudentInfo";
	}

	@RequestMapping(value = "/updateStudentInfo.do", method = { RequestMethod.POST })
	public String updateStudentInfo(Student student, MultipartFile file,
			Model model) throws Exception {

		// 如果本次上传了简历
		if (!file.isEmpty()) {
			System.out.println();
			if (!("application/pdf".equals(file.getContentType()))) {
				model.addAttribute("errorMessage", "仅支持上传pdf格式的文件~");
				return "student/updateStudentInfo";
			}
			String fileName = "/resume/" + student.getSno() + "-"
					+ student.getName() + "-简历.pdf";
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					"D:/Program Files/upload", fileName));
			// 如果是第一次上传
			System.out.println("===" + student.getResume() == null + "===");
			System.out.println("===" + (student.getResume() == "") + "===");
			if (student.getResume() == null || student.getResume() == "") {
				student.setResume(fileName);
			}
		}
		System.out.println(student);
		studentService.updateStudentInfo(student);
		return "redirect:/student/getStudentInfo.do";
	}

	@RequestMapping("/toUpdateStudentPassword.do")
	public String toUpdateStudentPassword(Student student) throws Exception {

		return "/student/updateStudentPassword";
	}

	@RequestMapping("/updateStudentPassword.do")
	public String updateStudentPassword(Student student, HttpSession session,
			Model model) {
		student.setPassword(MyUtil.md5(student.getPassword()));
		student.setNewPassword(MyUtil.md5(student.getNewPassword()));

		try {
			Student st = (Student) session.getAttribute("student");
			studentService.updateStudentPassword(st.getSid(),
					student.getPassword(), student.getNewPassword());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());

			return "/student/updateStudentPassword";
		}

		return "redirect:/student/logout.do";
	}

	@RequestMapping("/findEnterpriseList.do")
	public String findEnterpriseList(int page, HttpSession session, Model model)
			throws Exception {
		Student st = (Student) session.getAttribute("student");
		PageBean<Enterprise> pageBean = studentService.findEnterpriseList(page,
				st.getSid());
		model.addAttribute("pageBean", pageBean);
		return "/student/enterpriseList";
	}

	@RequestMapping("/findEnterpriseListByName.do")
	public String findEnterpriseListByName(int page, String name,
			HttpSession session, Model model) throws Exception {
		System.out.println("-------" + name);
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		System.out.println("-------" + name);
		Student st = (Student) session.getAttribute("student");
		PageBean<Enterprise> pageBean = studentService
				.findEnterpriseListByName(page, name, st.getSid());
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("name", name);
		return "/student/enterpriseListByName";
	}

	@RequestMapping("/findFollowingEnterpriseList.do")
	public String findFollowingEnterpriseList(int page, HttpSession session,
			Model model) throws Exception {
		Student st = (Student) session.getAttribute("student");
		PageBean<Enterprise> pageBean = studentService
				.findFollowingEnterpriseList(page, st.getSid());
		model.addAttribute("pageBean", pageBean);
		return "/student/followingEnterpriseList";
	}

	@RequestMapping("/findFollowingEnterpriseListByName.do")
	public String findFollowingEnterpriseListByName(int page, String name,
			HttpSession session, Model model) throws Exception {
		System.out.println("-------" + name);
		name = new String(name.getBytes("iso-8859-1"), "utf-8");
		System.out.println("-------" + name);
		Student st = (Student) session.getAttribute("student");
		PageBean<Enterprise> pageBean = studentService
				.findFollowingEnterpriseListByName(page, name, st.getSid());
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("name", name);
		return "/student/followingEnterpriseListByName";
	}

	@RequestMapping("/followEnterprise.do")
	public String followEnterprise(int sid, int eid) throws Exception {
		studentService.followEnterprise(sid, eid);
		return "redirect:/student/findEnterpriseList.do?page=1";
	}

	@RequestMapping("/unfollowEnterprise.do")
	public String unfollowEnterprise(int sid, int eid) throws Exception {
		studentService.unfollowEnterprise(sid, eid);
		return "redirect:/student/findFollowingEnterpriseList.do?page=1";
	}

	@RequestMapping("/findAllProjectList.do")
	public String findAllProjectList(int page, Model model) throws Exception {
		PageBean<Project> pageBean = projectService.findAllProjectList(page);
		model.addAttribute("pageBean", pageBean);
		return "/student/projectList";
	}

	@RequestMapping("/findProjectListByPname.do")
	public String findProjectListByPname(String pname, int page, Model model)
			throws Exception {
		pname = new String(pname.getBytes("iso-8859-1"), "utf-8");
		PageBean<Project> pageBean = projectService.findProjectListByPname(
				page, pname);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pname", pname);

		return "/student/projectListByPname";
	}

	@RequestMapping("/findProjectListByEnterprise.do")
	public String findProjectListByEnterprise(int eid, int page, Model model)
			throws Exception {

		PageBean<Project> pageBean = projectService.findProjectListByEid(page,
				eid);

		Enterprise ent = enterpriseService.getEnterpriseInfo(eid);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("enterprise", ent);
		model.addAttribute("eid", eid);

		return "/student/projectListByEnterprise";
	}

	@RequestMapping("/uploadProject.do")
	public String uploadProject(int pid, HttpSession session, MultipartFile file)
			throws IOException {

		Student st = (Student) session.getAttribute("student");
		StuPro oldSp = projectService.getOldStuPro(st.getSid(), pid);

		String fileName = "/stupro/" + MyUtil.getUuid()
				+ MyUtil.getFileExtension(file.getOriginalFilename());

		StuPro sp = new StuPro();
		if (oldSp == null) {

			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					"D:/Program Files/upload", fileName));
			sp.setSubmitNumber(1);
			sp.setSubmitPath(fileName);
			sp.setSubmitTime(MyUtil.formatDate(new Date()));
			sp.setPraise("");
			sp.setStudent(new Student(st.getSid()));
			sp.setProject(new Project(pid));
			projectService.uploadProjct(sp);
		} else {

			File oldFile = new File("D:/Program Files/upload"
					+ oldSp.getSubmitPath());
			oldFile.delete();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					"D:/Program Files/upload", fileName));

			sp.setSubmitNumber(oldSp.getSubmitNumber() + 1);
			sp.setSubmitTime(MyUtil.formatDate(new Date()));
			sp.setSubmitPath(fileName);
			sp.setSpid(oldSp.getSpid());
			projectService.uploadProjctPlus(sp);

		}

		return "redirect:/student/findMyProjectList.do?page=1";
	}

	@RequestMapping("/findMyProjectList.do")
	public String findMyProjectList(int page, HttpSession session, Model model)
			throws Exception {

		Student st = (Student) session.getAttribute("student");
		PageBean<StuPro> pageBean = projectService.findMyProjectList(page,
				st.getSid());

		model.addAttribute("pageBean", pageBean);
		return "/student/myProjectList";
	}

}
