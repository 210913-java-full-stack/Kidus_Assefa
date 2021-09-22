package DAO;
import model.ToDoItem;
import java.sql.SQLException;
import java.util.List;

public interface ToDoCrud {
    //we will need a Connection

    //create
    //save object to database method
    public void save(ToDoItem row) throws SQLException;
    //read
    //query data from database, fill in empty model object
    public ToDoItem getItemByID(int id) throws SQLException;
    public List<ToDoItem> getAllItems() throws SQLException;
    //public ToDoItem getItemByKeyword(String keyword); //SELECT * FROM items WHERE message LIKE "%KEYWORD%"
    //update
    // we will use the save() method for updates
    //delete
    //remove by ID
    public void deleteByID(int id) throws SQLException;
}