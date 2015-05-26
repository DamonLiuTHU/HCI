package businesslogic.studentbl;

import java.util.ArrayList;

import vo.CreditVO;
import vo.courseselectionvo.CourseSelectionVO;
import businesslogic.courseselectionbl.SelectCourseInfo;
import businesslogic.creditbl.Credit;
import businesslogicservice.studentblservice.StudentBLService;



public class Student implements StudentBLService  {
	
//	RemoteDataFactory factory = new RemoteDataFactory();
	String grade ;
	
    String student_id=null;
	
	public Student(String studentNumber){
		this.student_id=studentNumber;
	 
	}
	
	public Student(int studetnumber){
		this.student_id = student_id+"";
	}
	
	public Student(){
		//只是用来提供使用，没有具体内容；
	}
	
	public Student(CourseSelectionVO sv){
		this.student_id=sv.getStudentNumber();
	}
	public String getStudentID(){
		return this.student_id;
	}




	
	
	/* （非 Javadoc）
	 * @see businesslogic.studentbl.StudentBLService#getScore(java.lang.String)
	 */
	@Override
	public String getScore(String course_id){
		
		String result = new SelectCourseInfo().getScore(student_id,course_id);
		
		return result;
	}

	
	/* （非 Javadoc）
	 * @see businesslogic.studentbl.StudentBLService#getGPA(vo.CreditVO)
	 */
	@Override
	public double getGPA(CreditVO cv) {
		// TODO 自动生成的方法存根
		// finished // useful	
		int semester = cv.getSemesterIndex();
		String studentnumber = cv.getStudentNumber();	
		double result= new Credit().getGPA(studentnumber, semester);
		return result;
	}

	/* （非 Javadoc）
	 * @see businesslogic.studentbl.StudentBLService#getAchievedCredits(vo.courseselectionvo.CourseSelectionVO)
	 */
	@Override
	public int getAchievedCredits(CourseSelectionVO sv) {
		// TODO 自动生成的方法存根
		Credit c=new Credit();
		String studentno= sv.getStudentNumber();
		int result = c.getTotalCredit(studentno);
		return result;
	}
	
	/* （非 Javadoc）
	 * @see businesslogic.studentbl.StudentBLService#getTotalCredit(java.lang.String)
	 */
	@Override
	public int getTotalCredit(String studentNo){
		Credit c= new Credit();
		return  c.getTotalCredit(studentNo);
	}


	/* （非 Javadoc）
	 * @see businesslogic.studentbl.StudentBLService#getGPA(java.lang.String)
	 */
	public double getGPA(String grade) {
		// TODO 自动生成的方法存根
		double result = 0;
		int totalcredit = 0;
		SelectCourseInfo mc = new SelectCourseInfo();
		ArrayList<String> courselit = mc.getAllMyCoursesInSelect(student_id);
		for(String course_id : courselit){
			
			String coursegrade = mc.getTheGradeWhenISelectedThisCourse(student_id, course_id);
			if(coursegrade.compareToIgnoreCase(grade)==0){	
				int  score = Integer.parseInt(getScore(course_id));
				int credit  = new CourseInfo().getCredit(course_id);
				if(score>= 60){
					result = result + score*credit;
					totalcredit += credit;
				}
			}else{
				
			}
		}
		
		if(totalcredit== 0){
			return 0;
		}else{
		 return result = result/totalcredit/20;
		}
		
//		return result;
	}

	/* （非 Javadoc）
	 * @see businesslogic.studentbl.StudentBLService#getTotalGPA()
	 */
	@Override
	public double getTotalGPA() {
		// TODO 自动生成的方法存根
		double result = 0;
		int totalcredit = 0;
		SelectCourseInfo mc = new SelectCourseInfo();
		ArrayList<String> courselit = mc.getAllMyCoursesInSelect(student_id);
		for(String course_id : courselit){
			
			int  score = Integer.parseInt(getScore(course_id));
				int credit  = new CourseInfo().getCredit(course_id);
				if(score>= 60){
					result = result + score*credit;
					totalcredit += credit;
				}
		
		}
		
		if(totalcredit== 0){
			return 0;
		}else{
		 return result = result/totalcredit/20;
		}
//		return result;
		
//		return 0;
	}
	
	
	
}
