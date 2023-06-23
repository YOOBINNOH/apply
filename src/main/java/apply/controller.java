package apply;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller

public class controller {

    @PostMapping("apply")
    public String apply(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        String temp_career = request.getParameter("career");
        String temp_major = request.getParameter("major");

        // option 값에 따라 0,1 로 구별해주기

        Integer career = 0;
        Integer major = 0;

        if(temp_career.equals("yes")){
            career = 1;
        }
        else{
            career = 0;
        }

        if(temp_major.equals("yes")){
            major = 1;
        }
        else{
            major = 0;
        }
        String birth = request.getParameter("birth");


        String address = request.getParameter("address");
        String phone = request.getParameter("phone");


        try {
            ApplyDao applyDao = new ApplyDao(name,gender,birth,address,career,phone,email,major);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }


}
