package com.solvd.app.tables;

import java.util.Objects;

public class Emails {
    private Users users_id;
    private EmailsStorage emailsStorage_id;

    public Emails() {}

    public Emails(Users users_id,EmailsStorage emailsStorage_id) {
        this.users_id = users_id;
        this.emailsStorage_id = emailsStorage_id;
    }

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public EmailsStorage getEmailsStorage_id() {
        return emailsStorage_id;
    }

    public void setEmailsStorage_id(EmailsStorage emailsStorage_id) {
        this.emailsStorage_id = emailsStorage_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emails emails = (Emails) o;
        return users_id.equals(emails.users_id) && emailsStorage_id.equals(emails.emailsStorage_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users_id, emailsStorage_id);
    }
}
