package com.solvd.app.models;

import java.util.Objects;

public class Calls {
    private Users users_id;
    private CallsStorage callsStorage_id;

    public Calls() {}

    public Calls(Users id,CallsStorage call_id) {
        this.users_id = id;
        this.callsStorage_id = call_id;
    }

    public Users getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Users users_id) {
        this.users_id = users_id;
    }

    public CallsStorage getCallsStorage_id() {
        return callsStorage_id;
    }

    public void setCallsStorage_id(CallsStorage callsStorage_id) {
        this.callsStorage_id = callsStorage_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calls calls = (Calls) o;
        return Objects.equals(users_id, calls.users_id) && Objects.equals(callsStorage_id, calls.callsStorage_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users_id, callsStorage_id);
    }
}
