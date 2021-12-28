package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmergencyTest
 */
@WebServlet("/EmergencyTest/*")
public class EmergencyTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int fireStatus;
	// private int fireStatus1;
	private int gasStatus;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmergencyTest() {
		super();
		this.fireStatus = 0;
		// this.fireStatus1 = 0;
		this.gasStatus = 0;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.checkURL(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.checkURL(request, response);
	}

	private void checkURL(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();

		if (url.equals("/TestServer/EmergencyTest/sendData")) {
			this.sendData(request, response);
		} else if (url.equals("/TestServer/EmergencyTest/sendData1")) {
			this.sendData1(request, response);
		} else if (url.equals("/TestServer/EmergencyTest/getCurrentStatus")) {
			this.getCurrentStatus(request, response);
		}
	}

	private void getCurrentStatus(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().println(this.fireStatus);
			// response.getWriter().println(this.fireStatus1);

			
//			  JSONObject jsonObj = new JSONObject(); jsonObj.put("GAS", this.gasStatus);
//			  response.getWriter().println(jsonObj.toJSONString());
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(HttpServletRequest request, HttpServletResponse response) {
		// String mq5 = request.getParameter("MQ5");
		// String mq6 = request.getParameter("MQ6");
		String flame1 = request.getParameter("flame1");

		if (Integer.parseInt(flame1) == 0 /* && Integer.parseInt(mq5) > 400 */) {
			this.fireStatus = 0;
			System.out.println("찬혁 = " + flame1); // 아두이노 Com_3
		} else {
			this.fireStatus = 1;
		}
	}

	private void sendData1(HttpServletRequest request, HttpServletResponse response) {
		// String mq5 = request.getParameter("MQ5");
		// String mq6 = request.getParameter("MQ6");
		// String flame2 = request.getParameter("flame2");
		String flame3 = request.getParameter("flame3");

		if (Integer.parseInt(flame3) == 0 /* && Integer.parseInt(mq5) > 400 */) {
			this.fireStatus = 1;
			System.out.println("종오 = " + flame3);
		} else {
			this.fireStatus = 0;
		}
	}
}
