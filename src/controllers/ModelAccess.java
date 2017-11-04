package controllers;

import beans.EmailBean;

public class ModelAccess {

    private EmailBean selectedMessage;






    public EmailBean getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(EmailBean selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
}
