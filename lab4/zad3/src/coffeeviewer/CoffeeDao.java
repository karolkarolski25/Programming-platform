/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeviewer;

/**
 *
 * @author karol
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CoffeeDao {

	private final NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() 
        {
            this.jdbc = new NamedParameterJdbcTemplate(DbUtilities
                    .getDataSource("jdbc:derby://localhost:1527/Lab3PP", "userq", "admin"));
	}

	/**
	 * Returns a list of all coffees.
	 *
	 * @return list of all coffees
	 */
	public List<Coffee> GetAllCoffees() {
		String sql = "SELECT cof_name, sup_id, price, sales, total FROM coffees";
		try {
                    return this.jdbc.query(sql, (rs, rowNum) -> new Coffee() {{
				setName(rs.getString("cof_name"));
				setSupplierId(rs.getInt("sup_id"));
				setPrice(rs.getBigDecimal("price"));
				setSales(rs.getInt("sales"));
				setTotal(rs.getInt("total"));
                    }});
		} catch (EmptyResultDataAccessException ex) {
			return new ArrayList<>();
		}
	}	
}