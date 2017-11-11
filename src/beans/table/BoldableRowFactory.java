package beans.table;

import javafx.scene.control.TableRow;

public class BoldableRowFactory<T extends AbstractTableItem> extends TableRow {


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
