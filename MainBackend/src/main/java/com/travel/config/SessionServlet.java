package com.travel.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@WebServlet("/session")
//@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 1500)
public class SessionServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                String attributeName = req.getParameter("attributeName");
                String attributeValue = req.getParameter("attributeValue");
                req.getSession().setAttribute(attributeName, attributeValue);
                resp.sendRedirect(req.getContextPath() + "/");
        }

        private static final long serialVersionUID = 2878267318695777395L;
}

/*
public final User getUser() {

    RequestAttributes requestAttributes = RequestContextHolder
            .currentRequestAttributes();
    ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
    HttpServletRequest request = attributes.getRequest();
    HttpSession httpSession = request.getSession(true);

    Object userObject = httpSession.getAttribute("WEB_USER");
    if (userObject == null) {
        return null;
    }

    User user = (User) userObject;
    return user;
}

*/