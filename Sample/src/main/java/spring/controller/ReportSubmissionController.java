package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ReportSubmissionController {

	public String form() {
		return "report/submissionForm";
	}
	
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		return "report/submissionComplete";
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: "
				+ report.getOriginalFilename());
	}
	
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		return "report/submissioncomplete";
	}
	
	/*
	 * public String submitReport3(ReportCommand reportCommand) {
	 * printInfo(reportcommand.getStudentNumber(), reportcommand.getReport() ); }
	 */
}
