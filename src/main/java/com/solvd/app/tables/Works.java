package com.solvd.app.tables;

import java.util.Date;
import java.util.Objects;

public class Works {
    private Users users_id;
    private Jobs jobs_id;
    private Date start_date;

    public Works() {}

    public Works(Users users_id,Jobs jobs_id,Date start_date) {
        this.users_id = users_id;
        this.jobs_id = jobs_id;
        this.start_date = start_date;
    }

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public Jobs getJobs_id() {
        return jobs_id;
    }

    public void setJobs_id(Jobs jobs_id) {
        this.jobs_id = jobs_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Works works = (Works) o;
        return users_id.equals(works.users_id) && jobs_id.equals(works.jobs_id) && start_date.equals(works.start_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users_id, jobs_id, start_date);
    }
}
