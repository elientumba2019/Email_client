package beans;

public class Singleton {


    private static Singleton instance;
    private EmailBean message;


    /**
     * private contristructor
     */
    private Singleton(){ }



    /**
     * returns an instanc of the singleton
     * @return
     */
    public static Singleton getInstance(){


        if(instance == null){
            instance = new Singleton();
        }


        return instance;
    }




    public EmailBean getMessage() {
        return message;
    }

    public void setMessage(EmailBean message) {
        this.message = message;
    }
}
