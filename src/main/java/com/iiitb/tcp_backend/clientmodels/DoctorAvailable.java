package com.iiitb.tcp_backend.clientmodels;

public class DoctorAvailable {
    private int doctorId;
    private boolean status;

    public DoctorAvailable() {
    }

    public DoctorAvailable(int doctorId, boolean status) {
        this.doctorId = doctorId;
        this.status = status;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
