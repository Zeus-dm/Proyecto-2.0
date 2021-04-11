
package jdbc;

import domain.IGenerico;
import java.sql.SQLException;

public interface IGenericoInsert {
    public void insert(IGenerico generico) throws SQLException;
}
