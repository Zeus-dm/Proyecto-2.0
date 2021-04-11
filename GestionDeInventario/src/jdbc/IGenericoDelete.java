
package jdbc;

import domain.IGenerico;
import java.sql.SQLException;

public interface IGenericoDelete {
    public void delete(IGenerico generico) throws SQLException;
}
