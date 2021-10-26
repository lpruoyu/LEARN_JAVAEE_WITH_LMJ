package com.mj.servlet;

import com.mj.bean.Contact;
import com.mj.bean.result.ContactPageResult;
import com.mj.beans.util.Beans;
import com.mj.service.ContactService;
import com.mj.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact/*")
public class ContactServlet extends BaseServlet {
    private static final ContactService service = new ContactServiceImpl();

    public void frontSave(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Contact contact = Beans.convert(request.getParameterMap(), Contact.class);
        if (service.save(contact)) {
            redirect( "contact/admin", request, response);
        } else {
            forwardError("保存留言信息失败", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ContactPageResult result = new ContactPageResult();
        BeanUtils.populate(result, request.getParameterMap());
        service.find(result);
        request.setAttribute("result", result);
        request.setAttribute("menu", "contact");
        forward("admin/contact.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        forward("front/contact.jsp", request, response);
    }
}
