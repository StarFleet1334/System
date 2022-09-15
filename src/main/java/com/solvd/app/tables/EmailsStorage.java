package com.solvd.app.tables;

import java.util.Date;
import java.util.Objects;

public class EmailsStorage {
    private int id;
    private Users email_from_user;
    private Users email_to_user;
    private String text;
    private Date send_time;

    public EmailsStorage() {}

    public EmailsStorage(int id,Users from,Users to,String text,Date send_time) {
        this.id = id;
        this.email_from_user = from;
        this.email_to_user = to;
        this.text = text;
        this.send_time = send_time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getEmail_from_user() {
        return email_from_user;
    }

    public void setEmail_from_user(Users email_from_user) {
        this.email_from_user = email_from_user;
    }

    public Users getEmail_to_user() {
        return email_to_user;
    }

    public void setEmail_to_user(Users email_to_user) {
        this.email_to_user = email_to_user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailsStorage that = (EmailsStorage) o;
        return id == that.id && email_from_user.equals(that.email_from_user) && email_to_user.equals(that.email_to_user) && text.equals(that.text) && send_time.equals(that.send_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email_from_user, email_to_user, text, send_time);
    }
}
