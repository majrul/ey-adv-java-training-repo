package com.training.dto;

public class Status {

    private boolean status;
    private String messageIfAny;

    public Status() {
	}
    
    public Status(boolean status, String messageIfAny) {
		this.status = status;
		this.messageIfAny = messageIfAny;
	}

	public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessageIfAny() {
        return messageIfAny;
    }

    public void setMessageIfAny(String messageIfAny) {
        this.messageIfAny = messageIfAny;
    }
}
