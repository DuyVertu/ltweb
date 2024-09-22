package ltweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    // Phương thức thực hiện truy vấn và trả về một kết quả duy nhất
    public static <T> T queryForSingleResult(String query, Class<T> clazz, Object... params) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection(); // Giả sử bạn có một phương thức để lấy kết nối CSDL
            preparedStatement = connection.prepareStatement(query);
            
            // Thiết lập các tham số cho câu lệnh SQL
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            
            resultSet = preparedStatement.executeQuery();
            
            // Nếu có kết quả, tạo đối tượng theo class đã chỉ định
            if (resultSet.next()) {
                T result = clazz.getDeclaredConstructor().newInstance();
                // Ở đây bạn cần ánh xạ các cột của kết quả với các thuộc tính của đối tượng (có thể dùng Reflection)
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối, statement và result set
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return null;
    }

    // Phương thức cập nhật dữ liệu (INSERT/UPDATE/DELETE)
    public static void update(String query, Object... params) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = getConnection(); // Giả sử bạn có phương thức này
            preparedStatement = connection.prepareStatement(query);
            
            // Thiết lập các tham số cho câu lệnh SQL
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    // Giả sử bạn có một phương thức để lấy kết nối cơ sở dữ liệu
    private static Connection getConnection() throws SQLException {
        // Trả về đối tượng Connection (kết nối với CSDL)
        // Ví dụ: return DriverManager.getConnection(DB_URL, USER, PASS);
        return null; // Thay thế bằng code kết nối thật
    }
}
