package beans;

import beans.EmailBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class SampleData {



    private final ObservableList<EmailBean> Inbox = FXCollections.observableArrayList(
            new EmailBean("Hello from Sefu!!!","aaa@yahoo.com", 5500000, "<html>Hello from Sefu!!!<h3>lorem ipsum + <br> </h3></html>" , false),
            new EmailBean("Hello from Barosanu","bbb@yahoo.com", 200, "<html>Hello from Barosanu<h3>lorem ipsum + <br> </h3></html>" , true),
            new EmailBean("Hello from Sefu!!!asdas","ccc@yahoo.com", 10, "<html>Hello from Sefu!!!asdas<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("Hello from Barosanuasdasas","ddd@yahoo.com", 6300, "<html>Hello from Barosanuasdasas<h3>lorem ipsum + <br> </h3></html>", true)
    );
    private final ObservableList<EmailBean> Sent = FXCollections.observableArrayList(
            new EmailBean("Hi! long time, no see","example@yahoo.com", 22, "<html>Hi! long time, no see<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("Hi! Check this!!","example@yahoo.com", 200, "<html>You are the best<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("Where are my money???","example@yahoo.com", 10, "<html>You ask me???<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("Escape plans","example@yahoo.com",6300, "<html>Basement and then tun to the left<h3>lorem ipsum + <br> </h3></html>", true)
    );
    private final ObservableList<EmailBean> Spam = FXCollections.observableArrayList(
            new EmailBean("You won't belive this: click and see!!!","serious@company.com", 22000000, "<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("Like and share if you care!!","book@face.com", 200, "<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, "<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You got a virus!","safe@brousing.com",6300, "<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You won't belive this: click and see!!!","serious@company.com", 22000000, "<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("Like and share if you care!!","book@face.com", 200, "<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", false),
            new EmailBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, "<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You got a virus!","safe@brousing.com",6300, "<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You won't belive this: click and see!!!","serious@company.com", 22000000, "<html>You are smart<h3>lorem ipsum + <br> </h3></html>", false),
            new EmailBean("Like and share if you care!!","book@face.com", 200, "<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, "<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
            new EmailBean("You got a virus!","safe@brousing.com",6300, "<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true)
    );



    //map for email folders
    //ways of accesing list based on their names
    public Map<String , ObservableList<EmailBean>> emailFolder = new HashMap<>();



    /**
     * samples data class contructors
     */
    public SampleData(){
        emailFolder.put("Inbox" , Inbox);
        emailFolder.put("Sent" , Sent);
        emailFolder.put("Spam" , Spam);
    }
}
