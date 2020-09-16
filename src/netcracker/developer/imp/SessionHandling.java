package netcracker.developer.imp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SessionHandling.java: This program Consists of session management Which can be called as functions to incorporate sessions and manage sessions.
 *
 * @author lavp0616
 */
public class SessionHandling {

    /**
     * This Method sessionForLoginGet is Called to check if whether a logged in user is trying to login again or a new user is trying to login.
     * If logged in user tries to login again without logout then it will show warning and retrieve the
     *s
     * @param request
     * @param response
     * @param session
     * @return
     */
    public static int sessionForLoginGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        /**
         * 1:admin
         * 2:member
         * 3:login
         */
        if (session != null) {
            String sessionId = (String) session.getAttribute("sessionId");
            if (!session.getId().equals(sessionId)) {
                return 3;
            } else {
                String user = (String) session.getAttribute("role");
                if (user.equals("admin")) {
                    return 1;
                } else if (user.equals("member")) {
                    return 2;
                } else {
                    return 3;
                }
            }
        } else {

            return 3;
        }
    }
}

	

