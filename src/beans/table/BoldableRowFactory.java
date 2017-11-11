package beans.table;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableRow;

public class BoldableRowFactory<T extends AbstractTableItem> extends TableRow {


    private final SimpleBooleanProperty bold = new SimpleBooleanProperty();
    private T currentItem = null;


    public BoldableRowFactory(){
        super();

        bold.addListener((ObservableValue<? extends Boolean> observable, Boolean olValue, Boolean NewValue) ->{
            if(currentItem != null && currentItem==getItem()){
                updateItem(getItem(), isEmpty());
            }
        });


        
        itemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object olValue, Object NewValue) {
                bold.unbind();
                if (NewValue != null) {
                    bold.bind(((T)NewValue).getReadProperty());
                    currentItem = (T)NewValue;
                }
            }
        });
    }


    /**
     * overriden implementation of this METHOD
     * this method checks whether a given email is read or not , if it is read
     * the text is set to normal otherwise it is set to bold
     * method
     * @param item
     * @param empty
     */
    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item, empty);
        T newitem = (T)item;

        if(item != null && !newitem.isRead()){
            setStyle("-fx-font-weight: bold");
        }
        else {
            setStyle("");
        }
    }
}
