package com.example.app2;

public class User {

    private      int tel;                  //    手机号
    private     String username;           //    用户名
    private     String password;           //    密码

    public User(int tel, String username, String password) {
        this.tel = tel;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
