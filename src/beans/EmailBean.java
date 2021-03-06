package beans;

import beans.table.AbstractTableItem;
import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;
import java.util.Map;

public class EmailBean extends AbstractTableItem{


    public static Map<String , Integer> formattedValues = new HashMap<>();


    private SimpleStringProperty subject;
    private SimpleStringProperty sender;
    private SimpleStringProperty size;
    private String content;


    /**
     * contructor
     * @param subject
     * @param sender
     * @param size
     */
    public EmailBean(String subject , String sender , int size , String content , boolean isRead){
        super(isRead);
        this.subject = new SimpleStringProperty(subject);
        this.sender = new SimpleStringProperty(sender);
        this.size = new SimpleStringProperty(formatSize(size));
        this.content = content;
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


    /**
     * helper method that we use to format
     * the size of the email
     * @param size
     * @return
     */
    private String formatSize(int size){
        String returnValue;

        if(size <= 0){
            return  "0";
        }

        else if(size < 1024){
            returnValue = size + "B";
        }

        else if(size < 1048576){
            returnValue = size / 1024 + "kB";
        }

        else{
            returnValue = size / 1048576+ "MB";
        }

        formattedValues.put(returnValue , size);

        return  returnValue;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
