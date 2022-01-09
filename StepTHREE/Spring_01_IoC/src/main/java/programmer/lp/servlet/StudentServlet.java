package programmer.lp.servlet;

import programmer.lp.service.StudentService;

public class StudentServlet {
    private StudentService service;
    public void setService(StudentService service) {
        this.service = service;
    }

    public void service() {
        if (service.remove(10)) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }
}

