
package jdbc;

import domain.IGenerico;
import java.sql.SQLException;
import java.util.List;

public interface IGenericoSelectList {
    public List<IGenerico> select() throws SQLException;
}
