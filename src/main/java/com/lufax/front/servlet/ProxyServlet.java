package com.lufax.front.servlet;

import com.lufax.front.service.ServiceLocator;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by frank on 15/6/5.
 */
@WebServlet(name = "serviceProxy" , urlPatterns = "/service/*" ,loadOnStartup = 0 )
public class ProxyServlet extends HttpServlet {

    private static final Properties p = new Properties() ;

    private static String host = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            p.load(getClass().getClassLoader().getResourceAsStream("appService.properties"));
            host = p.get("app.host").toString();
        } catch (IOException e) {
            log("init servlet failed",e);
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log("invoke do get method");
//        Object res = ServiceLocator.restyService((String)p.get("app.host")).get("/data/articles.json",request.getParameterMap());
        Object res = ServiceLocator.jerseyService(host).get("/data/article.json",request.getParameterMap());
        String jsonString = res.toString() ;
//        try {
//            if(res instanceof JSONArray){
//                jsonString = ((JSONArray)res).getJSONObject(0).toString();
//            } else {
//                jsonString = ((JSONResource)res).object().toString();
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        log("response " + jsonString);
        response.setContentType("application/json;charset=UTF-8");
//        response.setContentLength(jsonString.length());
        response.getWriter().print(jsonString);
    }



}


