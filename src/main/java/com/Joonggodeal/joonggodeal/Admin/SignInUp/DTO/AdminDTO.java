package com.Joonggodeal.joonggodeal.Admin.SignInUp.DTO;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 사용자 DTO
 * *****************/
public class AdminDTO {
    private String userid; // 아이디
    private String pw; // 비밀번호
    private String name; // 이름
    private String email; // 이메일


    public AdminDTO(String userid, String pw, String name, String email) {
        this.userid = userid;
        this.pw = pw;
        this.name = name;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
