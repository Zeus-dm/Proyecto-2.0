
package jdbc;

import domain.IGenerico;
import java.sql.SQLException;

public interface IGenericoSelect {
    public IGenerico select(int id) throws SQLException;
}
