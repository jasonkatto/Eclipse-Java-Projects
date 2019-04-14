


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormReader
 */
public class FormReader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	//to show the form field from HTML page  on the URL
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		
		
		
		
		//to print them to the console
				System.out.println(fname);
				System.out.println(lname);
				System.out.println(email);
				System.out.println(phone);
				System.out.println(age);
		
				
				//start validation input
		boolean check = true;
		
		String errorMessage= "<html>";
		
			//check if the phone is 10 digit in length	
		if(phone.length() !=10){		
				//to response to browser
				//we use response . getWriter(to access to web page)
			errorMessage = errorMessage + "<h1><font color= red>   Sorry invalid phone number (Too Long)</font></h1>";
           check= false;
		}
		
		Validation val = new Validation();
		
		
		//check if the phone has 10 digits in length
		if(val.checkNum(phone)==false){
			errorMessage = errorMessage + "  <h1><font color= red>   Sorry invalid phone number "	+ "(Not a valid Number)</font></h1>";
			  check= false;
		}
		
 
		//check if age is a number
		if(val.checkNum(age)==false){
			errorMessage = errorMessage +" <h1> <font color= red>   Sorry invalid age "
					+ "(Not a valid Number)</font></h1> ";
			  check= false;
		}
		
		
		//check email is valid
		if(email.contains("@") == false   || email.contains(".") == false){
			
			errorMessage = errorMessage + " <h1> <font color= red>   Sorry invalid Email "	+ "(Not a valid Number)</font></h1> ";
			 check= false;
		
		}
		errorMessage = errorMessage +"</html>";
		
		if(check == true ){
			response.getWriter().print("<html> <h1> Thanks For Registering! "+  fname   + "  " +  lname  + "</h1></html>");
		} else{
			response.getWriter().print(errorMessage);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

	}

}
