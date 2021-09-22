package DAO;
import model.ToDoItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ToDoItemDAO implements ToDoCrud{
    private Connection conn;

    public ToDoItemDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void save(ToDoItem row) throws SQLException {
        String sql = "SELECT * FROM to_do_items WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, row.getId());

        ResultSet rs = pstmt.executeQuery();


        if(rs.next()) {
            //UPDATE - item already exists in table
            String updateStatement = "UPDATE to_do_items SET message = ?, complete = ? WHERE id = ?";
            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
            preparedUpdateStatement.setString(1, row.getMessage());
            preparedUpdateStatement.setBoolean(2, row.isComplete());
            preparedUpdateStatement.setInt(3, row.getId());

            preparedUpdateStatement.executeUpdate();

        } else {
            //INSERT - Item doesn't already exist in table
            String insertStatement = "INSERT INTO to_do_items (message, complete) VALUES (?, ?)";
            PreparedStatement preparedInsertStatement = conn.prepareStatement(insertStatement);
            preparedInsertStatement.setString(1, row.getMessage());
            preparedInsertStatement.setBoolean(2, row.isComplete());

            preparedInsertStatement.executeUpdate();

        }



    }

    @Override
    public ToDoItem getItemByID(int id) {
        return null;
    }

    @Override
    public List<ToDoItem> getAllItems() {
        return null;
    }

    @Override
    public void deleteByID(int id) {

    }
}