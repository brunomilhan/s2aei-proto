package web.devInt.s2aei.web.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import devInt.s2aei.util.Logger;
import web.devInt.s2aei.web.SessionBean;

public class SessionUtil {

		public static SessionBean getSessionBean() {
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext external = context.getExternalContext();
			HttpSession session = (HttpSession) external.getSession(true);

			SessionBean sessionBean = (SessionBean) session.getAttribute("sessionBean");
			Logger.log(Logger.DBG, Logger.SESSION_UTIL, "Obteve SessionBean");
			return sessionBean;
		}
	}

