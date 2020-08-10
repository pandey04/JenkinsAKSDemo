package main.java;
import org.apache.log4j.Logger;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class FirstServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger=Logger.getLogger(FirstServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("userpass");  
	    System.out.println("username:::::::"+n);
	    logger.info("username entered : "+n);
	    System.out.println("password:::::::"+p);
	    logger.info("password entered : "+p);
	    ValidateCred v = new ValidateCred();
	    boolean result = v.validate(n,p);
	    
	    if(result)
	    {
		    if(LoginDao.validate(n, p)){ 
		    	logger.debug("Valid login credentials.. directing to second page");
		        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        System.out.println("Sorry username or password error");  
		        logger.debug("Incorrect Username or Password!");
		        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
		        rd.include(request,response);  
		    } 
	    }
	        
	    else
	    {
	    	System.out.println(" Username and Password does not meet the criteria..");
	   
	    }
	    out.close();  
	    }  

}
