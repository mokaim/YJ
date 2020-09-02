package com.yeongjin.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yeongjin.domain.WriteDTO;

/**
 * Servlet implementation class TestServlet
 */

@WebServlet("/index/view1")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		WriteDTO writeDTO1 = new WriteDTO();
		WriteDTO writeDTO2 = new WriteDTO();
		WriteDTO writeDTO3 = new WriteDTO();
		
		writeDTO1.setTitle("one");
		writeDTO1.setContent("one Content");
		
		writeDTO2.setTitle("two");
		writeDTO2.setContent("two Content");
		
		writeDTO3.setTitle("three");
		writeDTO3.setContent("three Content");
		
		
		List<WriteDTO> placeList = Arrays.asList(writeDTO1, writeDTO2, writeDTO3);
		JSONArray jArray = new JSONArray();// 배열이 필요할때

		try {

			for (int i = 0; i < placeList.size(); i++)// 배열
			{
				JSONObject sObject = new JSONObject();// 배열 내에 들어갈 json
				sObject.put("title", placeList.get(i).getTitle());
				sObject.put("content", placeList.get(i).getContent());
				jArray.put(sObject);
			}
			
			/*
			 * obj.put("planName", "planA"); obj.put("id", "userID"); obj.put("item",
			 * jArray);// 배열을 넣음
			 */
			System.out.println(obj.toString());

		} catch (JSONException e) {
			e.printStackTrace();
		}

		/*
		 * String qq = "Hello world!!"; String name = "ma!!";
		 * 
		 String a = "{\"code\":\"" + name + "\" , \"msg\":\"" + qq + "\"}";
		 */

		response.getWriter().append(jArray.toString());	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
