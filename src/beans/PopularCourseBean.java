package beans;

import entity.CourseEntity;
import service.CourseService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PopularCourseBean {
    private List courses;
    private CourseEntity course1;
    private CourseEntity course2;
    private CourseEntity course3;
    private CourseEntity course4;
    private CourseEntity course5;

    private String image1;
    private String title1;
    private String description1;

    private String image2;
    private String title2;
    private String description2;

    private String image3;
    private String title3;
    private String description3;

    private String image4;
    private String title4;
    private String description4;

    private String image5;
    private String title5;
    private String description5;

    public PopularCourseBean() {
        CourseService CouSer = new CourseService();
        courses = CouSer.getCoursesOrderedByPopularity();
        course1 = (CourseEntity) courses.get(0);
        course2 = (CourseEntity) courses.get(1);
        course3 = (CourseEntity) courses.get(2);
        course4 = (CourseEntity) courses.get(3);
        course5 = (CourseEntity) courses.get(4);
    }
    public String course1(){
        title1 = course1.getcName();
        return title1;
    }
    public String course2(){
        title2 = course2.getcName();
        return title2;
    }
    public String course3(){
        title3 = course3.getcName();
        return title3;
    }
    public String course4(){
        title4 = course4.getcName();
        return title4;
    }
    public String course5(){
        title5 = course5.getcName();
        return title5;
    }

    public String getImage1() {
        image1 = course1.getPicture();
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getTitle1() {
        title1 = course1.getcName();
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getDescription1() {
        description1 = course1.getcDetail();
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getImage2() {
        image2 = course2.getPicture();
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getTitle2() {
        title2 = course2.getcName();
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getDescription2() {
        description2 = course2.getcDetail();
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getImage3() {
        image3 = course3.getPicture();
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getTitle3() {
        title3 = course3.getcName();
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getDescription3() {
        description3 = course3.getcDetail();
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getImage4() {
        image4 = course4.getPicture();
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getTitle4() {
        title4 = course4.getcName();
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    public String getDescription4() {
        description4 = course4.getcDetail();
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getImage5() {
        image5 = course5.getPicture();
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getTitle5() {
        title5 = course5.getcName();
        return title5;
    }

    public void setTitle5(String title5) {
        this.title5 = title5;
    }

    public String getDescription5() {
        description5 = course5.getcDetail();
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
    }
}
