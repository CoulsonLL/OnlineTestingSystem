package beans;

import entity.CourseEntity;
import service.CourseService;
import util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SearchResultBean {
    private String test;
    private List<CourseEntity> list;

    public SearchResultBean() {
        test = (String) FacesUtil.getSession().getAttribute("search-word");
    }

    public List<CourseEntity> getList() {
        CourseService courSer = new CourseService();
        test = (String) FacesUtil.getSession().getAttribute("search-word");
        list = courSer.getCoursesByName(test);
        return list;
    }

    public void setList(List<CourseEntity> list) {
        this.list = list;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
