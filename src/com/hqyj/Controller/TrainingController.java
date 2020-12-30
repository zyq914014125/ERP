package com.hqyj.Controller;

import com.hqyj.Dao.GradeDao;
import com.hqyj.Service.GradeService;
import com.hqyj.Service.SingleService;
import com.hqyj.Service.UserService;
import com.hqyj.entity.Grade;
import com.hqyj.entity.Single;
import com.hqyj.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/train")
public class TrainingController {
    @Autowired
    UserService userService;
    @Autowired
    GradeService gradeService;
    @Autowired
    SingleService singleService;
    @RequestMapping("/grade.do")
    public String grade(Model model){
       List<Grade> grades= gradeService.query();
       model.addAttribute("grades",grades);
        return "grade";
    }

    @RequestMapping("/test.do")
    public String test(HttpServletRequest request){
        List<Single> singleList= singleService.queryTest();
        request.getSession().setAttribute("singleList",singleList);
        request.setAttribute("singleList",singleList);
        return "exam";
    }

    /*
    * 成绩核查*/
    @RequestMapping("/submit.do")
    public String check(HttpServletRequest request){
        List<Single> singleList= (List<Single>) request.getSession().getAttribute("singleList");
        List<String> rightAnswers=new ArrayList<>();
        for (Single single : singleList) {
            rightAnswers.add(single.getAnswer());//往rightAnswers集合添加每一个正确得答案
        }
        Enumeration<String> parameterNames = request.getParameterNames();//获取请求所有的参数名
        int rightCount = 0;											//正确的题目数
        List<String> yourAnswers = new ArrayList<String>();			//你的答案集合
        while (parameterNames.hasMoreElements()) {					//当枚举有下一个元素时，进入循环
            String pName = parameterNames.nextElement();			//获取下一个枚举元素，作为参数名
            String yourAnswer = request.getParameter(pName);			//当前枚举元素所对应的参数值
            System.out.println(pName + " : " + yourAnswer);
            if (pName.startsWith("answer")) {						//如果当前参数名以answer开头，即单选框
                int index =  Integer.parseInt(pName.substring(6));	//通过字符串截取，把参数名所对应的下标截取出来
                String rightAnswer = rightAnswers.get(index);		//通过下标，访问正确答案集合，获取所对应题的正确答案
                if (rightAnswer.equals(yourAnswer)) {				//如果你的答案和正确答案相等
                    rightCount++;									//正确的题目数+1
                }
                yourAnswers.add(yourAnswer);						//把你的答案添加到你的答案集合中
            }
        }
        int score = rightCount * (100/rightAnswers.size());			//分数=正确数目 * 每道题的分值占比

        //获取登录用户的session ,并把成绩打入库中
        User user = (User)request.getSession().getAttribute("user");
        Grade grade = new Grade();
        grade.setUser_id(user.getUser_id());
        grade.setScore(score);
        gradeService.addGrade(grade);
        //返回结果集
        return "success";
    }
}
