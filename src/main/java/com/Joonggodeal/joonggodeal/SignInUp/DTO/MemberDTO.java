package com.Joonggodeal.joonggodeal.SignInUp.DTO;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 사용자 DTO
 * *****************/
public class MemberDTO {
    private String userid; // 아이디
    private String pw; // 비밀번호
    private String name; // 이름
    private String phonenumber; // 전화번호
    private String nickname; // 닉네임
    private char gender; // 성별

    public MemberDTO(String userid, String pw, String name, String phonenumber, String nickname, char gender) {
        this.userid = userid;
        this.pw = pw;
        this.name = name;
        this.phonenumber = phonenumber;
        this.nickname = nickname;
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
