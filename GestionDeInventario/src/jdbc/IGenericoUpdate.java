
package jdbc;

import domain.IGenerico;
import java.sql.SQLException;

public interface IGenericoUpdate {
    public void update(IGenerico generico) throws SQLException;
}
