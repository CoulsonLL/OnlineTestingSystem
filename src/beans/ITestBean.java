package beans;

import dao.WebsiteInfoDAO;
import service.ManagerService;
import service.StudentService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "iTestBean")
@RequestScoped
public class ITestBean {
    private long viewCount;
    private int StudentNum;
    private int ManagerNum;

    public long getViewCount() {
        WebsiteInfoDAO wdao = new WebsiteInfoDAO();
        viewCount = wdao.getViewCount();
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public int getStudentNum() {
        StudentService stuSer = new StudentService();
        StudentNum = stuSer.getStudentNum();
        return StudentNum;
    }

    public void setStudentNum(int studentNum) {
        StudentNum = studentNum;
    }

    public int getManagerNum() {
        ManagerService manSer = new ManagerService();
        ManagerNum = manSer.getManagerNum();
        return ManagerNum;
    }

    public void setManagerNum(int managerNum) {
        ManagerNum = managerNum;
    }
}
