package beans;

import javafx.beans.property.SimpleStringProperty;

public class EmailBean {


    private SimpleStringProperty subject;
    private SimpleStringProperty sender;
    private SimpleStringProperty size;


    /**
     * contructor
     * @param subject
     * @param sender
     * @param size
     */
    public EmailBean(String subject , String sender , String size){
        this.subject = new SimpleStringProperty(subject);
        this.sender = new SimpleStringProperty(sender);
        this.size = new SimpleStringProperty(size);
    }


    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public String getSender() {
        return sender.get();
    }

    public SimpleStringProperty senderProperty() {
        return sender;
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }
}
